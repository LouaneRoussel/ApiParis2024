package bts.sio.api.service;
import bts.sio.api.model.Athlete;
import bts.sio.api.model.Palmares;
import bts.sio.api.repository.PalmaresRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service

public class PalmaresService {
    @Autowired
    private PalmaresRepository palmaresRepository;



    public Optional<Palmares> getPalmares(final Long id) {
        return palmaresRepository.findById(id);
    }

    public Iterable<Palmares> getLesPalmares() {
        return palmaresRepository.findAll();
    }

    public void deletePalmares(final Long id) {
        palmaresRepository.deleteById(id);
    }

    public Palmares savePalmares(Palmares palmares) {
        Palmares savedPalmares = palmaresRepository.save(palmares);
        return savedPalmares;
    }
}
