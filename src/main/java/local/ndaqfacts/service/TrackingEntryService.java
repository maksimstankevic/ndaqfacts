package local.ndaqfacts.service;

import local.ndaqfacts.entity.TrackingEntry;
import local.ndaqfacts.repository.TrackingEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackingEntryService implements ITrackingEntryService{

    @Autowired
    private TrackingEntryRepository trackingEntryRepository;
    @Override
    public TrackingEntry getTrackingEntryById(long trackingEntryId) {
        TrackingEntry obj = trackingEntryRepository.findById(trackingEntryId).get();
        return obj;
    }
    @Override
    public TrackingEntry getTrackingEntryByTimeStamp(long trackingEntryTimeStamp) {
        TrackingEntry obj = trackingEntryRepository.findByTimeStamp(trackingEntryTimeStamp);
        return obj;
    }
    @Override
    public List<TrackingEntry> getAllTrackingEntries(){
        List<TrackingEntry> list = new ArrayList<>();
        trackingEntryRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
    @Override
    public synchronized boolean addTrackingEntry(TrackingEntry trackingEntry){
        TrackingEntry obj = trackingEntryRepository.findByTimeStamp(trackingEntry.getTimeStamp());
        if (obj != null) {
            return false;
        } else {
            trackingEntryRepository.save(trackingEntry);
            return true;
        }
    }
    @Override
    public void deleteTrackingEntryByTimeStamp(long timeStamp) {
        trackingEntryRepository.delete(getTrackingEntryByTimeStamp(timeStamp));
    }
    @Override
    public void deleteTrackingEntryById(long id) {
        trackingEntryRepository.delete(getTrackingEntryById(id));
    }

}
