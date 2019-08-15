package local.ndaqfacts;

import local.ndaqfacts.TrackingEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingEntryRepository extends CrudRepository<TrackingEntry, Long> {}
