package bts.sio.api.controller;
import bts.sio.api.model.Athlete;
import bts.sio.api.model.Pays;
import bts.sio.api.model.Epreuve;
import bts.sio.api.service.EpreuveService;
import bts.sio.api.service.AthleteService;
import bts.sio.api.service.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import bts.sio.api.model.Olympiade;

import java.util.Optional;

@RestController
public class EpreuveController {

    @Autowired
    private EpreuveService EpreuveService;

    @PostMapping("/Epreuve")
    public Epreuve createEpreuve(@RequestBody Epreuve epreuve) {
        return EpreuveService.saveEpreuve(epreuve);
    }
    @GetMapping("/Epreuve")
    public Iterable<Epreuve> getEpreuves() {
        return EpreuveService.getLesEpreuves();
    }

    @PutMapping("/Epreuve/{id}")
    public Epreuve updateEpreuve(@PathVariable("id") final Long id, @RequestBody Epreuve epreuve) {
        Optional<Epreuve> e = EpreuveService.getEpreuve(id);
        if(e.isPresent()) {
            Epreuve currentEpreuve = e.get();

            String nom = epreuve.getNom();
            if(nom != null) {
                currentEpreuve.setNom(nom);
            }
            String type = epreuve.getType();
            if(type != null) {
                currentEpreuve.setType(type);
            }
            String description = epreuve.getDescription();
            if(description != null) {
                currentEpreuve.setDescription(description);
            }
            EpreuveService.saveEpreuve(currentEpreuve);
            return currentEpreuve;
        } else {
            return null;
        }
    }
    /**
     * Delete - Delete an epreuve
     * @param id - The id of the epreuve to delete
     */
    @DeleteMapping("/epreuve/{id}")
    public void deleteEpreuve(@PathVariable("id") final Long id) {
        EpreuveService.deleteEpreuve(id);
    }
}
