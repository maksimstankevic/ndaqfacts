package local.ndaqfacts.controller;


import local.ndaqfacts.entity.TrackingEntry;
import local.ndaqfacts.service.ITrackingEntryService;
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
public class TrackingEntryController {

    @Autowired
    private ITrackingEntryService trackingEntryService;

    @GetMapping("row/{id}")
    public ResponseEntity<TrackingEntry> getRow(@PathVariable("id") long id) {
        TrackingEntry trackingEntry = trackingEntryService.getTrackingEntryById(id);
        return new ResponseEntity<TrackingEntry>(trackingEntry, HttpStatus.OK);
    }
    @GetMapping("rows")
    public ResponseEntity<List<TrackingEntry>> getAllRows() {
        List<TrackingEntry> list = trackingEntryService.getAllTrackingEntries();
        return new ResponseEntity<List<TrackingEntry>>(list, HttpStatus.OK);
    }
    @PostMapping("row")
    public ResponseEntity<Void> addRow(@RequestBody TrackingEntry trackingEntry, UriComponentsBuilder builder) {
        boolean flag = trackingEntryService.addTrackingEntry(trackingEntry);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/row/{id}").buildAndExpand(trackingEntry.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
//    @PutMapping("article")
//    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
//        articleService.updateArticle(article);
//        return new ResponseEntity<Article>(article, HttpStatus.OK);
//    }
    @DeleteMapping("row/deleteTime-{timestamp}")
    public ResponseEntity<Void> deleteRowByTimestamp(@PathVariable("timestamp") long timeStamp) {
        trackingEntryService.deleteTrackingEntryByTimeStamp(timeStamp);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("row/deleteId-{id}")
    public ResponseEntity<Void> deleteRowById(@PathVariable("id") long id) {
        trackingEntryService.deleteTrackingEntryById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
