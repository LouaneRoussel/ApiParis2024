package bts.sio.api.repository;

import bts.sio.api.model.Palmares;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PalmaresRepository extends CrudRepository<Palmares, Long> {
}
