package local.ndaqfacts.controller;


import local.ndaqfacts.entity.Snapshot;
import local.ndaqfacts.service.ISnapshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("data")
public class SnapshotController {

    @Autowired
    private ISnapshotService snapshotService;

    @GetMapping("row/{id}")
    public ResponseEntity<Snapshot> getRow(@PathVariable("epochtimestamp") long epochTimeStamp) {
        Snapshot snapshot = snapshotService.getSnapshotByEpochTimeStamp(epochTimeStamp);
        return new ResponseEntity<Snapshot>(snapshot, HttpStatus.OK);
    }
    @GetMapping("rows")
    public ResponseEntity<List<Snapshot>> getAllRows() {
        List<Snapshot> list = snapshotService.getAllSnapshots();
        //list.remove(list.size() - 1);
        return new ResponseEntity<List<Snapshot>>(list, HttpStatus.OK);
    }

//    @GetMapping("rows")
//    public ResponseEntity<String> getAllRows() {
//        return new ResponseEntity<>("bla", HttpStatus.OK);
//    }

    @PostMapping("row")
    public ResponseEntity<Void> addRow(@RequestBody Snapshot snapshot, UriComponentsBuilder builder) {
        boolean flag = snapshotService.addSnapshot(snapshot);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/row/{epochtimestamp}").buildAndExpand(snapshot.getEpochTimeStamp()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
//    @PutMapping("article")
//    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
//        articleService.updateArticle(article);
//        return new ResponseEntity<Article>(article, HttpStatus.OK);
//    }
    @DeleteMapping("row/deleteTime-{epochtimestamp}")
    public ResponseEntity<Void> deleteRowByEpochTimestamp(@PathVariable("epochtimestamp") long epochTimeStamp) {
        snapshotService.deleteSnapshotByEpochTimeStamp(epochTimeStamp);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
