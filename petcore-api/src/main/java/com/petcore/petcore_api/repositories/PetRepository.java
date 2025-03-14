package com.petcore.petcore_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petcore.petcore_api.models.Pet;
import com.petcore.petcore_api.models.PetSexEnum;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
    List<Pet> findByName(String name);

    List<Pet> findBySex(PetSexEnum sex);

    List<Pet> findByRace(String race);

    List<Pet> findByAge(Integer age);

    List<Pet> findByOwner(String owner);

    List<Pet> findByType(String type);

}
