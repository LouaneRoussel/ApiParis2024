package bts.sio.api.controller;
import bts.sio.api.model.Athlete;
import bts.sio.api.model.Pays;
import bts.sio.api.model.Sport;
import bts.sio.api.model.Epreuve;
import bts.sio.api.service.EpreuveService;
import bts.sio.api.service.AthleteService;
import bts.sio.api.service.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import bts.sio.api.model.Olympiade;

import java.time.LocalDate;
import java.util.Optional;

@RestController
public class EpreuveController {

    @Autowired
    private EpreuveService epreuveService;

    @PostMapping("/epreuve")
    public Epreuve createEpreuve(@RequestBody Epreuve epreuve) { return epreuveService.saveEpreuve(epreuve);}


    @GetMapping("/epreuve/{id}")
    public Epreuve getSport(@PathVariable("id")final Long id){
        Optional<Epreuve> epreuve = epreuveService.getEpreuve(id);
        if(epreuve.isPresent()) {
            return epreuve.get();
        } else {
            return null;
        }
    }

    @GetMapping("/epreuves")
    public Iterable<Epreuve> getEpreuves() { return epreuveService.getEpreuves();}

    @PutMapping("/epreuve/{id}")
    public Epreuve updateEpreuve(@PathVariable("id") final Long id, @RequestBody Epreuve epreuve) {
        Optional<Epreuve> e = epreuveService.getEpreuve(id);
        if(e.isPresent()) {
            Epreuve currentEpreuve = e.get();

            String libelle = epreuve.getLibelle();
            if(libelle != null) {
                currentEpreuve.setLibelle(libelle);
            }

            LocalDate dateDebut = epreuve.getDateDebut();
            if(dateDebut != null){
                currentEpreuve.setDateDebut(dateDebut);
            }

            LocalDate dateFin = epreuve.getDateFin();
            if(dateFin != null){
                currentEpreuve.setDateFin(dateFin);
            }

            Sport sport_id = epreuve.getSport();
            if(sport_id != null){
                currentEpreuve.setSport(sport_id);
            }

            epreuveService.saveEpreuve(currentEpreuve);
            return currentEpreuve;
        } else {
            return null;
        }
    }
    @DeleteMapping("/epreuve/{id}")
    public void deleteEpreuve(@PathVariable("id") final Long id) {
        epreuveService.deleteEpreuve(id);
    }

}

