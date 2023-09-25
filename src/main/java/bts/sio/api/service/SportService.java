package bts.sio.api.service;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bts.sio.api.model.Sport;
import java.util.Optional;
import bts.sio.api.repository.SportRepository;
@Data
@Service
public class SportService {
    @Autowired
    private SportRepository SportRepository;

    public Optional<Sport> getSport(final Long id) {
        return SportRepository.findById(id);
    }

    public Iterable<Sport> getLesSports() {
        return SportRepository.findAll();
    }
    public void deleteSport(final Long id) {
        SportRepository.deleteById(id);
    }
    public Sport saveSport(Sport sport) {
        return SportRepository.save(sport);
    }
}
