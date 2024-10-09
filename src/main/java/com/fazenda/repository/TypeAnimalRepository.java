package com.fazenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fazenda.model.typeAnimal.TypeAnimal;
import com.fazenda.model.Farmer;
import java.util.List;


public interface TypeAnimalRepository extends JpaRepository<TypeAnimal, Long> {
	List<TypeAnimal> findByFarmer(Farmer farmer);
}
