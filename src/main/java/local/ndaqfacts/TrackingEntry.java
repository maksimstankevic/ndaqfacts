package local.ndaqfacts;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tracking")
public class TrackingEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int timeStamp;

    private double latestPrice;

    private int latestUpdate;
}
