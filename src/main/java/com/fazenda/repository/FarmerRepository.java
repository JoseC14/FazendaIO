package com.fazenda.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fazenda.model.Farmer;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, String> {

	
}
