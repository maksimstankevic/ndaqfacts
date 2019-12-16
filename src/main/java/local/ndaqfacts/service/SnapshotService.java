package local.ndaqfacts.service;

import local.ndaqfacts.entity.Snapshot;
import local.ndaqfacts.repository.SnapshotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SnapshotService implements ISnapshotService {

    @Autowired
    private SnapshotRepository snapshotRepository;
    @Override
    public Snapshot getSnapshotById(long trackingEntryId) {
        Snapshot obj = snapshotRepository.findById(trackingEntryId).get();
        return obj;
    }
    @Override
    public Snapshot getSnapshotByEpochTimeStamp(long trackingEntryTimeStamp) {
        Snapshot obj = snapshotRepository.findByEpochTimeStamp(trackingEntryTimeStamp);
        return obj;
    }
    @Override
    public List<Snapshot> getAllSnapshots(){
        List<Snapshot> list = new ArrayList<>();
        snapshotRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
    @Override
    public synchronized boolean addSnapshot(Snapshot snapshot){
        Snapshot obj = snapshotRepository.findByEpochTimeStamp(snapshot.getEpochTimeStamp());
        if (obj != null) {
            return false;
        } else {
            snapshotRepository.save(snapshot);
            return true;
        }
    }
    @Override
    public void deleteSnapshotByEpochTimeStamp(long timeStamp) {
        snapshotRepository.delete(getSnapshotByEpochTimeStamp(timeStamp));
    }

}
