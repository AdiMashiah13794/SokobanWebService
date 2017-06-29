package com.example.db;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="SokobanSolutions")
public class SokobanSolution implements Serializable {

	@Id
	private String name;
	private String solution;

	public String getName() {
		return name;
	}
	public String getSolution() {
		return solution;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}

	public SokobanSolution(String name, String solution) {
		super();
		this.name = name;
		this.solution = solution;
	}
	public SokobanSolution() {
		// TODO Auto-generated constructor stub
	}




@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}



}
