package com.petcore.petcore_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.petcore.petcore_api.exceptions.NotFoundException;
import com.petcore.petcore_api.models.Pet;
import com.petcore.petcore_api.models.PetSexEnum;
import com.petcore.petcore_api.repositories.PetRepository;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet getPetById(Integer id) {
        return findPetById(id);
    }

    public List<Pet> getPetByName(String name) {
        return petRepository.findByName(name);
    }

    public List<Pet> getPetBySex(PetSexEnum sex) {
        return petRepository.findBySex(sex);
    }

    public List<Pet> getPetByRace(String race) {
        return petRepository.findByRace(race);
    }

    public List<Pet> getPetByAge(Integer age) {
        return petRepository.findByAge(age);
    }

    public List<Pet> getPetByOwner(String owner) {
        return petRepository.findByOwner(owner);
    }

    public List<Pet> getPetByType(String type) {
        return petRepository.findByType(type);
    }

    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
    }

    public String deletePet(Integer id) {
        Pet pet = findPetById(id);
        petRepository.delete(pet);
        return "Pet with id " + id + " deleted from database";
    }

    public Pet updatePetInfo(Integer id, Pet updatedPet) {
        Pet pet = findPetById(id);
        updatePetFields(pet, updatedPet);
        return petRepository.save(pet);
    }

    private Pet findPetById(Integer id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pet with id " + id + " not found"));
    }

    private void updatePetFields(Pet pet, Pet updatedPet) {
        Optional.ofNullable(updatedPet.getName()).ifPresent(pet::setName);
        Optional.ofNullable(updatedPet.getType()).ifPresent(pet::setType);
        Optional.ofNullable(updatedPet.getSex()).ifPresent(pet::setSex);
        Optional.ofNullable(updatedPet.getAge()).ifPresent(pet::setAge);
        Optional.ofNullable(updatedPet.getWeight()).ifPresent(pet::setWeight);
        Optional.ofNullable(updatedPet.getRace()).ifPresent(pet::setRace);
        Optional.ofNullable(updatedPet.getOwner()).ifPresent(pet::setOwner);
    }
}
