package bts.sio.api.repository;

import bts.sio.api.model.Athlete;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends CrudRepository<Athlete, Long> {

    @Query("SELECT a FROM Athlete a WHERE a.nom LIKE concat('%' , :recherche , '%') or a.prenom LIKE concat('%' , :recherche , '%')")
    Iterable<Athlete> findByRecherche(String recherche);

}