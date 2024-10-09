package com.fazenda.controller;

import com.fazenda.model.Farmer;
import com.fazenda.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/farmer")
public class FarmerController {

	@Autowired
	private FarmerService farmerService;
	
	@GetMapping
	public List<Farmer> listAll()
	{
		return farmerService.listAll();	
	}
	
	
	@GetMapping("/{cpf}")
	public ResponseEntity<Farmer> searchById(@PathVariable String cpf)
	{
		Optional<Farmer> farmer = farmerService.searchByCpf(cpf);
		
		if(farmer.isPresent())
		{
			return ResponseEntity.ok(farmer.get());
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public Farmer save(@RequestBody Farmer farmer)
	{
		return farmerService.save(farmer);
	}
	
	@PutMapping("/{cpf}")
	public ResponseEntity<Farmer> update(@PathVariable String cpf, @RequestBody Farmer farmerUpdated)
	{
		Optional<Farmer> farmerExistence = farmerService.searchByCpf(cpf);
		if(farmerExistence.isPresent())
		{
			Farmer farmer = farmerExistence.get();
			farmer.setNome(farmerUpdated.getNome());
			farmer.setEmail(farmerUpdated.getEmail());
			farmerService.save(farmer);
			return ResponseEntity.ok(farmer);
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{cpf}")
	public ResponseEntity<Void> delete(@PathVariable String cpf)
	{
		Optional<Farmer> farmer = farmerService.searchByCpf(cpf);
		
		if(farmer.isPresent())
		{
			farmerService.delete(cpf);
			return ResponseEntity.noContent().build();
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
}
