package com.petcore.petcore_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcore.petcore_api.models.Pet;
import com.petcore.petcore_api.models.PetSexEnum;
import com.petcore.petcore_api.services.PetService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    // Get all pets
    @GetMapping("/pet")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    // Get pet by id
    @GetMapping("/pet/{id}")
    public Pet getPetById(@PathVariable Integer id) {
        return petService.getPetById(id);
    }

    // Get pet by name
    @GetMapping("/pet/name/{name}")
    public List<Pet> getPetByName(@PathVariable String name) {
        return petService.getPetByName(name);
    }

    // Get pet by sex
    @GetMapping("/pet/sex/{sex}")
    public List<Pet> getPetBySex(@PathVariable PetSexEnum sex) {
        return petService.getPetBySex(sex);
    }

    // Get pet by race
    @GetMapping("/pet/race/{race}")
    public List<Pet> getPetByRace(@PathVariable String race) {
        return petService.getPetByRace(race);
    }

    // Get pet by age
    @GetMapping("/pet/age/{age}")
    public List<Pet> getPetByAge(@PathVariable Integer age) {
        return petService.getPetByAge(age);
    }

    // Get pet by owner
    @GetMapping("/pet/owner/{owner}")
    public List<Pet> getPetByOwner(@PathVariable String owner) {
        return petService.getPetByOwner(owner);
    }

    // Get pet by type
    @GetMapping("/pet/type/{type}")
    public List<Pet> getPetByType(@PathVariable String type) {
        return petService.getPetByType(type);
    }

    // Add pet
    @PostMapping("/pet")
    public Pet addPet(@RequestBody Pet pet) {
        return petService.addPet(pet);
    }

    // Delete pet by id
    @DeleteMapping("/pet/{id}")
    public ResponseEntity<String> deletePet(@PathVariable Integer id) {
        String response = petService.deletePet(id);
        return ResponseEntity.ok(response);
    }

    // Update pet information
    @PatchMapping("/pet/{id}")
    public Pet updatePet(@RequestBody Pet pet, @PathVariable Integer id) {
        return petService.updatePetInfo(id, pet);
    }
}
