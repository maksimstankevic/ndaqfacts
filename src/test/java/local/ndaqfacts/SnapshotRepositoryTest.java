package local.ndaqfacts;

import local.ndaqfacts.entity.Snapshot;
import local.ndaqfacts.repository.SnapshotRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static java.math.BigDecimal.valueOf;


@RunWith(SpringRunner.class)
@SpringBootTest

public class SnapshotRepositoryTest {

    @Autowired
    private SnapshotRepository snapshotRepository;

    @Test
    public void whenFindingSnapshotByEpochTimeStamp_thenCorrect() {
        snapshotRepository.save(new Snapshot(1576506827474L, BigDecimal.valueOf(104.52), 1575469800895L, BigDecimal.valueOf(104.48), 1575406800633L, BigDecimal.valueOf(106.63),
                BigDecimal.valueOf(104.31), BigDecimal.valueOf(105.52), "3:58:59 PM", 1575493139200L, BigDecimal.valueOf(105.63), BigDecimal.valueOf(75.48), "R", 1575469800000L));
        assertThat(snapshotRepository.findById(1576506827474L)).isInstanceOf(Optional.class);
    }


//    private long epochTimeStamp;
//    private BigDecimal open; //104.52
//    private long openTime; //1575469800895
//    private BigDecimal close; //104.48
//    private long closeTime; //1575406800633
//    private BigDecimal high; //105.63
//    private BigDecimal low; //104.31
//    private BigDecimal latestPrice; //105.37
//    private String latestTime; //"3:58:59 PM"
//    private long latestUpdate; //1575493139200
//    private BigDecimal week52High; //105.63
//    private BigDecimal week52Low; //75.4888
//    private String systemEvent; //"R"
//    private long systemEventTimeStamp; //1575469800000



//    @Test
//    public void whenFindingAllCustomers_thenCorrect() {
//        snapshotRepository.save(new Snapshot(70L, 2L, 99.99, 23L));
//        snapshotRepository.save(new Snapshot(71L, 3L, 101.99, 77L));
//        assertThat(snapshotRepository.findAll()).isInstanceOf(List.class);
//    }
//
//    @Test
//    public void whenSavingCustomer_thenCorrect() {
//        snapshotRepository.save(new Snapshot(55L, 4L, 102.00, 88L));
//        Snapshot snapshot = snapshotRepository.findById(23L).orElseGet(()
//                -> new Snapshot(66L, 5L, 103.76, 99L));
//        assertThat(snapshot.getLatestPrice()).isEqualTo(55.33);
//    }

}