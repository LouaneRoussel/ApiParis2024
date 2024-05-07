package bts.sio.api.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "championnat")

public class Championnat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "lieu")
    private String lieu;

    @Column(name = "dateChampionnat")
    private Integer dateChampionnat;

}
