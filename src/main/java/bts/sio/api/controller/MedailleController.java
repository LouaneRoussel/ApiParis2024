package bts.sio.api.controller;
import bts.sio.api.model.Medaille;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import bts.sio.api.service.MedailleService;

import java.util.Optional;

@RestController

public class MedailleController {
    @Autowired
    private MedailleService medailleService;

    /**
     * Create - Add a new medaille
     *
     * @param medaille An object medaille
     * @return The medaille object saved
     */
    @PostMapping("/medaille")
    public Medaille createMedaille(@RequestBody Medaille medaille) {
        return medailleService.saveMedaille(medaille);

    }
    /**
     * Read - Get one medaille
     * @param id The id of the medaille
     * @return An Medaille object full filled
     */
    @GetMapping("/medaille/{id}")
    public Medaille getMedaille(@PathVariable("id") final Long id) {
        Optional<Medaille> medaille = medailleService.getMedaille(id);
        if(medaille.isPresent()) {
            return medaille.get();
        } else {
            return null;
        }
    }
    /**
     * Read - Get all medaille
     * @return - An Iterable object of Medaille full filled
     */
    @GetMapping("/medailles")
    public Iterable<Medaille> getMedailles() {
        return medailleService.getMedailles();
    }

    /**
     * Update - Update an existing medaille
     * @param id - The id of the medaille to update
     * @param medaille - The medaille object updated
     * @return
     */

    @PutMapping("/medaille/{id}")
    public Medaille updateMedaille(@PathVariable("id") final Long id, @RequestBody Medaille medaille) {
        Optional<Medaille> e = medailleService.getMedaille(id);
        if(e.isPresent()) {
            Medaille currentMedaille = e.get();

            String libelle = medaille.getLibelle();
            if(libelle != null) {
                currentMedaille.setLibelle(libelle);
            }
            medailleService.saveMedaille(currentMedaille);
            return currentMedaille;
        } else {
            return null;
        }
    }


    /**
     * Delete - Delete an medaille
     * @param id - The id of the medaille to delete
     */
    @DeleteMapping("/medaille/{id}")
    public void deleteMedaille(@PathVariable("id") final Long id) {
        medailleService.deleteMedaille(id);
    }
}
