package bts.sio.api.model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Epreuve_Athlete")
public class Epreuve_Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "epreuve_id")
    private Epreuve epreuve_id;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete Athlete_id;

    @Column(name="place")
    private String place;


}
