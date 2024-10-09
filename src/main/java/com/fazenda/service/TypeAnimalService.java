package com.fazenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fazenda.model.Farmer;
import com.fazenda.model.typeAnimal.TypeAnimal;
import com.fazenda.repository.FarmerRepository;
import com.fazenda.repository.TypeAnimalRepository;

@Service
public class TypeAnimalService {

	@Autowired
	private TypeAnimalRepository typeAnimalRepository;
	
	@Autowired
	private FarmerRepository farmerRepository;
	
	
	public List<TypeAnimal> listAllByFarmer(String cpf)
	{
		Optional<Farmer> farmer = farmerRepository.findById(cpf);
		return typeAnimalRepository.findByFarmer(farmer.get());
	}
	
	public TypeAnimal save(TypeAnimal typeAnimal)
	{
		return typeAnimalRepository.save(typeAnimal);
	}
	
	public Optional<TypeAnimal> searchById(Long id)
	{
		return typeAnimalRepository.findById(id);
	}
	
	public void delete(Long id)
	{
		typeAnimalRepository.deleteById(id);
	}
}
