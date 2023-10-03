package com.first;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private int roll;
private String name;
private int fees;
private String course;
private String trainer;
private String section;


public String getSection() {
	return section;
}
public void setSection(String section) {
	this.section = section;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getRoll() {
	return roll;
}
public void setRoll(int roll) {
	this.roll = roll;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getFees() {
	return fees;
}
public void setFees(int fees) {
	this.fees = fees;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getTrainer() {
	return trainer;
}
public void setTrainer(String trainer) {
	this.trainer = trainer;
}



}
