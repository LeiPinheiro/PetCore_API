package com.petcore.petcore_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcore.petcore_api.models.Pet;
import com.petcore.petcore_api.models.PetSexEnum;
import com.petcore.petcore_api.services.PetService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

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
@Tag(name = "Pets", description = "Endpoints relacionados aos pets cadastrados")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pet")
    @Operation(summary = "Lista todos os pets", description = "Retorna uma lista com todos os pets cadastrados no sistema.")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/pet/{id}")
    @Operation(summary = "Busca um pet pelo ID", description = "Retorna um pet específico baseado no ID fornecido.")
    public Pet getPetById(
            @Parameter(description = "ID do pet", example = "1") @PathVariable Integer id) {
        return petService.getPetById(id);
    }

    @GetMapping("/pet/name/{name}")
    @Operation(summary = "Busca pets pelo nome", description = "Retorna uma lista de pets que possuem o nome especificado.")
    public List<Pet> getPetByName(
            @Parameter(description = "Nome do pet", example = "Rex") @PathVariable String name) {
        return petService.getPetByName(name);
    }

    @GetMapping("/pet/sex/{sex}")
    @Operation(summary = "Busca pets pelo sexo", description = "Retorna uma lista de pets filtrados pelo sexo (Macho/Fêmea).")
    public List<Pet> getPetBySex(
            @Parameter(description = "Sexo do pet", example = "MALE") @PathVariable PetSexEnum sex) {
        return petService.getPetBySex(sex);
    }

    @GetMapping("/pet/race/{race}")
    @Operation(summary = "Busca pets pela raça", description = "Retorna uma lista de pets de uma raça específica.")
    public List<Pet> getPetByRace(
            @Parameter(description = "Raça do pet", example = "Labrador") @PathVariable String race) {
        return petService.getPetByRace(race);
    }

    @GetMapping("/pet/age/{age}")
    @Operation(summary = "Busca pets pela idade", description = "Retorna uma lista de pets com a idade informada.")
    public List<Pet> getPetByAge(
            @Parameter(description = "Idade do pet em anos", example = "3") @PathVariable Integer age) {
        return petService.getPetByAge(age);
    }

    @GetMapping("/pet/owner/{owner}")
    @Operation(summary = "Busca pets pelo nome do dono", description = "Retorna uma lista de pets pertencentes a um determinado dono.")
    public List<Pet> getPetByOwner(
            @Parameter(description = "Nome do dono do pet", example = "João Silva") @PathVariable String owner) {
        return petService.getPetByOwner(owner);
    }

    @GetMapping("/pet/type/{type}")
    @Operation(summary = "Busca pets pelo tipo", description = "Retorna uma lista de pets do tipo informado (Cachorro, Gato, etc.).")
    public List<Pet> getPetByType(
            @Parameter(description = "Tipo do pet", example = "Cachorro") @PathVariable String type) {
        return petService.getPetByType(type);
    }

    @PostMapping("/pet")
    @Operation(summary = "Cadastra um novo pet", description = "Adiciona um novo pet ao sistema com os dados fornecidos no corpo da requisição.")
    public Pet addPet(
            @Parameter(description = "Objeto JSON com os dados do pet a ser cadastrado") @RequestBody Pet pet) {
        return petService.addPet(pet);
    }

    @DeleteMapping("/pet/{id}")
    @Operation(summary = "Deleta um pet pelo ID", description = "Remove um pet do sistema baseado no ID fornecido.")
    public ResponseEntity<String> deletePet(
            @Parameter(description = "ID do pet a ser removido", example = "1") @PathVariable Integer id) {
        String response = petService.deletePet(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/pet/{id}")
    @Operation(summary = "Atualiza informações de um pet", description = "Atualiza os dados de um pet existente com as informações fornecidas no corpo da requisição.")
    public Pet updatePet(
            @Parameter(description = "Objeto JSON contendo os novos dados do pet") @RequestBody Pet pet,
            @Parameter(description = "ID do pet a ser atualizado", example = "1") @PathVariable Integer id) {
        return petService.updatePetInfo(id, pet);
    }
}
