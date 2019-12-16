package local.ndaqfacts.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "snapshots")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class Snapshot {
    @Id
    private long epochTimeStamp;
    private BigDecimal open; //104.52
    private long openTime; //1575469800895
    private BigDecimal close; //104.48
    private long closeTime; //1575406800633
    private BigDecimal high; //105.63
    private BigDecimal low; //104.31
    private BigDecimal latestPrice; //105.37
    private String latestTime; //"3:58:59 PM"
    private long latestUpdate; //1575493139200
    private BigDecimal week52High; //105.63
    private BigDecimal week52Low; //75.4888
    private String systemEvent; //"R"
    private long systemEventTimeStamp; //1575469800000


}
