package bts.sio.api.service;
import bts.sio.api.model.Athlete;
import bts.sio.api.model.Pays;
import bts.sio.api.repository.AthleteRepository;
import bts.sio.api.repository.PaysRepository;
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

    public Iterable<Sport> getLesSport() {
        return SportRepository.findAll();
    }
}
