package local.ndaqfacts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class TrackingEntryRepositoryTest {

    @Autowired
    private TrackingEntryRepository trackingEntryRepository;

    @Test
    public void whenFindingTrackingEntryById_thenCorrect() {
        trackingEntryRepository.save(new TrackingEntry(1L, 1L, 55.33, 22L));
        assertThat(trackingEntryRepository.findById(8L)).isInstanceOf(Optional.class);
    }

    @Test
    public void whenFindingAllCustomers_thenCorrect() {
        trackingEntryRepository.save(new TrackingEntry(70L, 2L, 99.99, 23L));
        trackingEntryRepository.save(new TrackingEntry(71L, 3L, 101.99, 77L));
        assertThat(trackingEntryRepository.findAll()).isInstanceOf(List.class);
    }

    @Test
    public void whenSavingCustomer_thenCorrect() {
        trackingEntryRepository.save(new TrackingEntry(55L, 4L, 102.00, 88L));
        TrackingEntry trackingEntry = trackingEntryRepository.findById(23L).orElseGet(()
                -> new TrackingEntry(66L, 5L, 103.76, 99L));
        assertThat(trackingEntry.getLatestPrice()).isEqualTo(55.33);
    }

}