package bts.sio.api.repository;


import bts.sio.api.model.Athlete;
import bts.sio.api.model.Championnat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionnatRepository extends CrudRepository<Championnat, Long> {


}
