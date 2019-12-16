package local.ndaqfacts.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "asks")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor

public class Asks {


    @Id
    private long epochTimeStamp;

    private BigDecimal price; //105.37
    private int size; //6
    private long timeStamp; //1575493139200

    @ManyToOne
    @JoinColumn(name = "snapshot_epochTimeStamp")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Snapshot snapshot;


}
