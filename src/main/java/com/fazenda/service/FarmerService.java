package com.fazenda.service;


import com.fazenda.model.Farmer;
import com.fazenda.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmerService {
	
	@Autowired
	private FarmerRepository farmerRepository;
	
	public List<Farmer> listAll()
	{
		return farmerRepository.findAll();
	}
	
	public Optional<Farmer> searchByCpf(String cpf)
	{
		return farmerRepository.findById(cpf);
	}
	
	public Farmer save(Farmer farmer)
	{
		return farmerRepository.save(farmer);
	}
	
	public void delete(String cpf)
	{
		farmerRepository.deleteById(cpf);
	}
	
}
