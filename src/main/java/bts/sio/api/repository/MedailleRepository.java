package bts.sio.api.repository;

import bts.sio.api.model.Medaille;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedailleRepository extends CrudRepository<Medaille, Long> {
}
