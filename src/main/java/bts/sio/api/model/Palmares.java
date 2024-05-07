package bts.sio.api.model;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "Palmares")
public class Palmares {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;

    @ManyToOne
    @JoinColumn(name = "medaille_id")
    private Medaille medaille;

    @Column(name = "annee")
    private Integer annee;

    @ManyToOne
    @JoinColumn(name = "ville_id")
    private Ville ville;

    @ManyToOne
    @JoinColumn(name = "championnat_id")
    private Championnat championnat;



}
