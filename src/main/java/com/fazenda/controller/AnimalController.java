package com.fazenda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fazenda.model.Animal;
import com.fazenda.service.AnimalService;

@RestController
@RequestMapping("/animals")
public class AnimalController {
	
	
	@Autowired
	AnimalService animalService;
	
	@GetMapping
	public List<Animal> listAllByFarmer(@RequestParam String cpf)
	{
		return animalService.listAllByFarmer(cpf);
	}
	
	@PostMapping
	public Animal save(@RequestBody Animal animal)
	{
		
		if(animal.getFarmer().equals(null))
		{
			System.out.println("Field farmer is null");
		}
		
		if(animal.getTypeAnimal().equals(null))
		{
			System.out.println("Field TypeAnimal is null");
		}
		
		return animalService.save(animal);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Animal> update(@PathVariable Long id, @RequestBody Animal animalUpdated)
	{
		Optional<Animal> animalExistence = animalService.searchById(id);
		if(animalExistence.isPresent())
		{
			Animal animal = animalExistence.get();
			animal.setName(animalUpdated.getName());
			animal.setBirthDate(animalUpdated.getBirthDate());
			animalService.save(animal);
			return ResponseEntity.ok(animal);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id)
	{
		Optional<Animal> animal = animalService.searchById(id);
		
		if(animal.isPresent())
		{
			animalService.delete(id);
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
