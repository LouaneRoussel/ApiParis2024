package bts.sio.api.service;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bts.sio.api.model.Epreuve;
import java.util.Optional;
import bts.sio.api.repository.EpreuveRepository;
@Data
@Service
public class EpreuveService {
    @Autowired
    private EpreuveRepository EpreuveRepository;

    public Optional<Epreuve> getEpreuve(final Long id) {
        return EpreuveRepository.findById(id);
    }

    public Iterable<Epreuve> getLesEpreuves() {
        return EpreuveRepository.findAll();
    }

    public void deleteEpreuve(final Long id) {
        EpreuveRepository.deleteById(id);
    }

    public Epreuve saveEpreuve(Epreuve epreuve) {
        return EpreuveRepository.save(epreuve);
    }
}