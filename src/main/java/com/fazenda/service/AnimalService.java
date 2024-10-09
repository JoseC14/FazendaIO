package com.fazenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fazenda.model.Animal;
import com.fazenda.model.Farmer;
import com.fazenda.repository.AnimalRepository;
import com.fazenda.repository.FarmerRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private FarmerRepository farmerRepository;
	
	public List<Animal> listAllByFarmer(String cpf)
	{
	    Optional<Farmer> farmer = farmerRepository.findById(cpf);
		return animalRepository.findByFarmer(farmer.get());
	}
	
	public Animal save(Animal animal)
	{
		return animalRepository.save(animal);
	}
	
	public Optional<Animal> searchById(Long id)
	{
		return animalRepository.findById(id);
	}
	
	public void delete(Long id)
	{
		animalRepository.deleteById(id);
	}
	
}
