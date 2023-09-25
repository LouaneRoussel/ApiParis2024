package bts.sio.api.controller;
import bts.sio.api.model.Athlete;
import bts.sio.api.model.Pays;
import bts.sio.api.model.Epreuve_Athlete;
import bts.sio.api.service.Epreuve_AthleteService;
import bts.sio.api.service.AthleteService;
import bts.sio.api.service.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import bts.sio.api.model.Olympiade;

import java.util.Optional;

@RestController
public class Epreuve_AthleteController {

    @Autowired
    private Epreuve_AthleteService Epreuve_AthleteService;

    @PostMapping("/epreuve_Athlete")
    public Epreuve_Athlete createEpreuve_Athlete(@RequestBody Epreuve_Athlete epreuve_Athlete) {
        return Epreuve_AthleteService.saveEpreuve_Athlete(epreuve_Athlete);
    }
    @GetMapping("/epreuve_Athlete")
    public Iterable<Epreuve_Athlete> getEpreuve_Athlete() {
        return Epreuve_AthleteService.getLesEpreuve_Athlete();
    }

    @PutMapping("/epreuve_Athlete/{id}")
    public Epreuve_Athlete updateEpreuve_Athlete(@PathVariable("id") final Long id, @RequestBody Epreuve_Athlete epreuve_Athlete) {
        Optional<Epreuve_Athlete> e = Epreuve_AthleteService.getEpreuve_Athlete(id);
        if(e.isPresent()) {
            Epreuve_Athlete currentEpreuve_Athlete = e.get();


            String place = epreuve_Athlete.getPlace();
            if(place != null) {
                currentEpreuve_Athlete.setPlace(place);
            }
            Epreuve_AthleteService.saveEpreuve_Athlete(currentEpreuve_Athlete);
            return currentEpreuve_Athlete;
        } else {
            return null;
        }
    }
    /**
     * Delete - Delete an epreuve
     * @param id - The id of the epreuve to delete
     */
    @DeleteMapping("/epreuve/{id}")
    public void deleteEpreuve_Athlete(@PathVariable("id") final Long id) {
        Epreuve_AthleteService.deleteEpreuve_Athlete(id);
    }
}