package bts.sio.api.controller;
import bts.sio.api.model.Championnat;
import bts.sio.api.model.Palmares;
import bts.sio.api.service.ChampionnatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

public class ChampionnatPalmares {
    @Autowired
    private ChampionnatService championnatService;

    @PostMapping("/championnat")
    public Championnat createChampionnat(@RequestBody Championnat championnat) {
        return championnatService.saveChampionnat(championnat);
    }

    @GetMapping("/championnat/{id}")
    public Championnat getChampionnat(@PathVariable("id") final Long id) {
        Optional<Championnat> championnat = championnatService.getChampionnat(id);
        if(championnat.isPresent()) {
            return championnat.get();
        } else {
            return null;
        }
    }

    @GetMapping("/championnats")
    public Iterable<Championnat> getChampionnats() {

        return championnatService.getChampionnats();
    }

    @PutMapping("/championnat/{id}")
    public Championnat updateChampionnat(@PathVariable("id") final Long id, @RequestBody Championnat championnat) {
        Optional<Championnat> c = championnatService.getChampionnat(id);
        if(c.isPresent()) {
            Championnat currentChampionnat = c.get();

            String libelle = championnat.getLibelle();
            if (libelle != null) {
                currentChampionnat.setLibelle(libelle);;
            }

            String lieu = championnat.getLieu();
            if (lieu != null) {
                currentChampionnat.setLieu(lieu);;
            }

            Integer dateChampionnat = championnat.getDateChampionnat();
            if (championnat != null) {
                currentChampionnat.setDateChampionnat(dateChampionnat);;
            }

            championnatService.saveChampionnat(currentChampionnat);
            return currentChampionnat;
        } else {
            return null;

        }
    }

    @DeleteMapping("/championnat/{id}")
    public void deleteChampionnat(@PathVariable("id") final Long id) {

        championnatService.deleteChampionnat(id);
    }
}

