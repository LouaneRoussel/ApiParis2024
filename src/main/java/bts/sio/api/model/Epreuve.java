package bts.sio.api.model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "epreuve")
public class Epreuve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nom")
    private String nom;

    @Column(name="type")
    private String type;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "sport_id")
    private Sport sport;





}
