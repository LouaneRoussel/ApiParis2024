package bts.sio.api.service;

import bts.sio.api.model.Championnat;
import bts.sio.api.repository.ChampionnatRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ChampionnatService {
    @Autowired
    private ChampionnatRepository championnatRepository;

    public Optional<Championnat> getChampionnat(final Long id) {
        return championnatRepository.findById(id);
    }

    public Iterable<Championnat> getChampionnats() {
        return championnatRepository.findAll();
    }

    public void deleteChampionnat(final Long id) {
        championnatRepository.deleteById(id);
    }

    public Championnat saveChampionnat(Championnat championnat) {
        Championnat savedChampionnat = championnatRepository.save(championnat);
        return savedChampionnat;
    }
}

