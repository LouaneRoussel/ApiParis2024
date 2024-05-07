package bts.sio.api.service;

import lombok.Data;
import bts.sio.api.model.Medaille;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bts.sio.api.repository.MedailleRepository;

import java.util.Optional;
@Data
@Service
public class MedailleService {
    @Autowired
    private MedailleRepository medailleRepository;

    public Optional<Medaille> getMedaille(final Long id) {
        return medailleRepository.findById(id);
    }

    public Iterable<Medaille> getMedailles() {
        return medailleRepository.findAll();
    }

    public void deleteMedaille(final Long id) {
        medailleRepository.deleteById(id);
    }

    public Medaille saveMedaille(Medaille medaille) {
        Medaille savedMedaille = medailleRepository.save(medaille);
        return savedMedaille;
    }
}
