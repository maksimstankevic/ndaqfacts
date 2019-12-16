package local.ndaqfacts.service;

import local.ndaqfacts.entity.Snapshot;

import java.util.List;

public interface ISnapshotService {
    List<Snapshot> getAllSnapshots();
    Snapshot getSnapshotById(long trackingEntryId);
    Snapshot getSnapshotByEpochTimeStamp(long trackingEntryTimeStamp);
    boolean addSnapshot(Snapshot entry);
    void deleteSnapshotByEpochTimeStamp(long trackingTimeStamp);
}
