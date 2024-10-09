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

import com.fazenda.model.typeAnimal.TypeAnimal;
import com.fazenda.service.TypeAnimalService;

@RestController
@RequestMapping("/typeanimals")
public class TypeAnimalController {
	@Autowired
	private TypeAnimalService typeAnimalService;
	
	
	@GetMapping
	public List<TypeAnimal> listAllByFarmer(@RequestParam String cpf)
	{
		return typeAnimalService.listAllByFarmer(cpf);
	}
	
	
	@PostMapping
	public TypeAnimal save( @RequestBody TypeAnimal typeAnimal)
	{
		return typeAnimalService.save(typeAnimal);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TypeAnimal> update(@PathVariable Long id, @RequestBody TypeAnimal typeAnimalUpdated)
	{
		Optional<TypeAnimal> TypeAnimalExistence = typeAnimalService.searchById(id);
		
		if(TypeAnimalExistence.isPresent())
		{
			TypeAnimal typeAnimal = TypeAnimalExistence.get();
			typeAnimal.setType(typeAnimalUpdated.getType());
			typeAnimalService.save(typeAnimal);
			return ResponseEntity.ok(typeAnimal);
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id)
	{
		Optional<TypeAnimal> typeAnimal = typeAnimalService.searchById(id);
		if(typeAnimal.isPresent())
		{
			typeAnimalService.delete(id);
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
