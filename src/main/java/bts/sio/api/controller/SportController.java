package bts.sio.api.controller;
import bts.sio.api.model.Athlete;
import bts.sio.api.model.Pays;
import bts.sio.api.model.Sport;
import bts.sio.api.service.SportService;
import bts.sio.api.service.AthleteService;
import bts.sio.api.service.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import bts.sio.api.model.Olympiade;

import java.util.Optional;

@RestController
public class SportController {

    @Autowired
    private SportService sportService;

    @PostMapping("/sport")
    public Sport createSport(@RequestBody Sport sport) {
        return sportService.saveSport(sport);
    }
    @GetMapping("/sports")
    public Iterable<Sport> getSports() {
        return sportService.getLesSports();
    }

    @DeleteMapping("/sport/{id}")
    public void deleteSport(@PathVariable("id") final Long id) {
        sportService.deleteSport(id);
    }
    @PutMapping("/sport/{id}")
    public Sport updatesport(@PathVariable("id") final Long id, @RequestBody Sport sport) {
        Optional<Sport> e = sportService.getSport(id);
        if(e.isPresent()) {
            Sport currentsport = e.get();

            String nom = sport.getNom();
            if(nom != null) {
                currentsport.setNom(nom);
            }
            String descriptif = sport.getDescriptif();
            if(descriptif != null) {
                currentsport.setDescriptif(descriptif);;
            }
            Olympiade olympiade = sport.getOlympiade();
            if(olympiade != null) {
                currentsport.setOlympiade(olympiade);
                ;
            }
            sportService.saveSport(currentsport);
            return currentsport;
        } else {
            return null;
        }
    }
}