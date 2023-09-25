package bts.sio.api.service;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bts.sio.api.model.Epreuve_Athlete;
import java.util.Optional;
import bts.sio.api.repository.Epreuve_AthleteRepository;
@Data
@Service
public class Epreuve_AthleteService {
    @Autowired
    private Epreuve_AthleteRepository Epreuve_AthleteRepository;

    public Optional<Epreuve_Athlete> getEpreuve_Athlete(final Long id) {
        return Epreuve_AthleteRepository.findById(id);
    }

    public Iterable<Epreuve_Athlete> getLesEpreuve_Athlete() {
        return Epreuve_AthleteRepository.findAll();
    }

    public void deleteEpreuve_Athlete(final Long id) {
        Epreuve_AthleteRepository.deleteById(id);
    }

    public Epreuve_Athlete saveEpreuve_Athlete(Epreuve_Athlete Epreuve_Athlete) {
        return Epreuve_AthleteRepository.save(Epreuve_Athlete);
    }
}
