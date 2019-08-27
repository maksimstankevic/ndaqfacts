package local.ndaqfacts.repository;

import local.ndaqfacts.entity.TrackingEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingEntryRepository extends CrudRepository<TrackingEntry, Long> {
    TrackingEntry findByTimeStamp(long timeStamp);
    TrackingEntry findByLatestPriceAndTimeStamp(double price, long timeStamp);
}
