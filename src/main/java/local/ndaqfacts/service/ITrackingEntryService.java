package local.ndaqfacts.service;

import local.ndaqfacts.entity.TrackingEntry;

import java.util.List;

public interface ITrackingEntryService {
    List<TrackingEntry> getAllTrackingEntries();
    TrackingEntry getTrackingEntryById(long trackingEntryId);
    TrackingEntry getTrackingEntryByTimeStamp(long trackingEntryTimeStamp);
    boolean addTrackingEntry(TrackingEntry entry);
    void deleteTrackingEntryByTimeStamp(long trackingTimeStamp);
    void deleteTrackingEntryById(long id);
}
