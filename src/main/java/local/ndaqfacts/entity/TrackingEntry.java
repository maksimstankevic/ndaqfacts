package local.ndaqfacts.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tracking")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class TrackingEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    private long timeStamp;

    private double latestPrice;

    private long latestUpdate;
}
