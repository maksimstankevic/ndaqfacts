package local.ndaqfacts.repository;

import local.ndaqfacts.entity.Snapshot;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnapshotRepository extends PagingAndSortingRepository<Snapshot, Long> {
    Snapshot findByEpochTimeStamp(long timeStamp);
    Snapshot findByLatestPriceAndEpochTimeStamp(double price, long timeStamp);
}
