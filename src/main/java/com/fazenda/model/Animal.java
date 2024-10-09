package com.fazenda.model;
import java.util.Date;

import com.fazenda.model.typeAnimal.TypeAnimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Animal {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String name;
		
		private Date birthDate;
		
		@ManyToOne
		@JoinColumn(name= "farmer_id", nullable = false)
		private Farmer farmer;
		
		@ManyToOne
		@JoinColumn(name="type_id", nullable = false)
		private TypeAnimal typeAnimal;
		
		
		public Animal()
		{
			
		}
		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public Date getBirthDate() {
			return birthDate;
		}



		public void setBirthDate(Date birthDate) {
			this.birthDate = birthDate;
		}



		public Farmer getFarmer() {
			return farmer;
		}



		public void setFarmer(Farmer farmer) {
			this.farmer = farmer;
		}
		
		public TypeAnimal getTypeAnimal() {
			return typeAnimal;
		}
		public void setTypeAnimal(TypeAnimal typeAnimal) {
			this.typeAnimal = typeAnimal;
		}

		


		
}
