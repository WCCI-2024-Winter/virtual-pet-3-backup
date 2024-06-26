package org.wecancodeit.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wecancodeit.Models.AdopterModel;
import org.wecancodeit.Services.AdopterService;

import jakarta.annotation.Resource;

/**
 * Controller class that models the mapping of the adopter services and
 * repository
 */
@RestController
@RequestMapping("/api/v1/adopters/")
public class AdopterController {

    @Resource
    private final AdopterService adopterService;

    /**
     * Parameterized Constructor
     * 
     * @param adopterService adopter services
     */
    public AdopterController(AdopterService adopterService) {
        this.adopterService = adopterService;
    }

    /**
     * Method to map getting all adopters
     * 
     * @return all adopters
     */
    @GetMapping
    public Iterable<AdopterModel> getAllAdopters() {
        return adopterService.findAll();
    }

    /**
     * Method to get a adopter by id
     * 
     * @param id adopter id
     * 
     * @return adopter
     */
    @GetMapping("{id}")
    public AdopterModel getAdopter(@PathVariable Long id) {
        return adopterService.findById(id);
    }

    /**
     * Method to get adopters by name and zip
     * 
     * @param name name of adopter
     * @param zip  zip of adopter
     * 
     * @return list of adopters within filter requirements
     */
    @GetMapping("{name}/{zip}")
    public Iterable<AdopterModel> getByNameZip(@PathVariable String name, @PathVariable String zip) {
        return adopterService.findByNameZip(name, zip);
    }

    /**
     * Method to get adopters by preferred pet type and zip
     * 
     * @param preferredPetType adopter's preferred pet type
     * @param zip              adopter's zip
     * 
     * @return list of adopters within filter requirements
     */
    @GetMapping("{preferredPetType}/{zip}")
    public Iterable<AdopterModel> findByPreferredPetTypeZip(@PathVariable String preferredPetType,
            @PathVariable String zip) {
        return adopterService.findByPreferredPetTypeZip(preferredPetType, zip);
    }

    /**
     * Method to delete a adopter
     * 
     * @param id adopter id
     * 
     * @return if the deletion of the adopter was successful
     */
    @DeleteMapping("{id}")
    public boolean deleteAdopter(@PathVariable Long id) {
        return adopterService.deleteAdopter(id);
    }

    /**
     * Method to add a adopter
     * 
     * @param adopterModel adopter to add
     * 
     * @return adopter added
     */
    @PostMapping
    public AdopterModel addAdopter(@RequestBody AdopterModel adopterModel) {
        return adopterService.saveAdopter(adopterModel);
    }

    /**
     * Method to update a adopter
     * 
     * @param adopterModel adopter to update
     * 
     * @return adopter updated
     */
    @PutMapping
    public AdopterModel saveAdopter(@RequestBody AdopterModel adopterModel) {
        return adopterService.saveAdopter(adopterModel);
    }
}
