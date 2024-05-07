package bts.sio.api.controller;
import bts.sio.api.model.*;
import bts.sio.api.service.ChampionnatService;
import bts.sio.api.service.PalmaresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController

public class PalmaresController {
    @Autowired
    private PalmaresService palmaresService;
    @PostMapping("/palmares")
    public Palmares createChampionnat(@RequestBody Palmares palmares) {
        return palmaresService.savePalmares(palmares);
    }
    @GetMapping("/palmares/{id}")
    public Palmares getPalmares(@PathVariable("id") final Long id) {
        Optional<Palmares> palmares = palmaresService.getPalmares(id);
        if(palmares.isPresent()) {
            return palmares.get();
        } else {
            return null;
        }
    }
    @GetMapping("/palmaress")
    public Iterable<Palmares> getPalmaress() {
        return palmaresService.getLesPalmares();
    }
    @PutMapping("/palmares/{id}")
    public Palmares updatePalmares(@PathVariable("id") final Long id, @RequestBody Palmares palmares) {
        Optional<Palmares> c = palmaresService.getPalmares(id);
        if(c.isPresent()) {
            Palmares currentPalmares = c.get();

            Integer annee = palmares.getAnnee();
            if (annee != null) {
                currentPalmares.setAnnee(annee);;
            }

            Ville ville = palmares.getVille();
            if (ville != null) {
                currentPalmares.setVille(ville);;
            }

            Athlete athlete = palmares.getAthlete();
            if (athlete != null) {
                currentPalmares.setAthlete(athlete);;
            }

            Medaille medaille = palmares.getMedaille();
            if (medaille != null){
                currentPalmares.setMedaille(medaille);
            }

            Championnat championnat = palmares.getChampionnat();
            if (championnat != null) {
                currentPalmares.setChampionnat(championnat);
            }


            palmaresService.savePalmares(currentPalmares);
            return currentPalmares;
        } else {
            return null;

        }
    }
    @DeleteMapping("/palmares/{id}")
    public void deletePalmares(@PathVariable("id") final Long id) {
        palmaresService.deletePalmares(id);
    }
}
