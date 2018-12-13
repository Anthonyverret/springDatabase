package com.wildcodeschool.quete.database.springDatabase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wilder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
		
	private String power;
	
	@Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + 
                ", power =" + power + "]";
    }         

	public Wilder() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Wilder(String firstName, String power) {
        this.firstName = firstName;
        this.power = power;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	
	
}
