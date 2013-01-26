package de.dc.hska.seminararbeit.bean;

import javafx.beans.property.SimpleStringProperty;

public class Student {
	private final SimpleStringProperty vorname = new SimpleStringProperty("");
	private final SimpleStringProperty nachname = new SimpleStringProperty("");
	private final SimpleStringProperty email = new SimpleStringProperty("");
	private final SimpleStringProperty matrikel = new SimpleStringProperty("");
	
	public Student() {
		this("", "", "", "");
	}
	
	public Student(String vorname, String nachname, String email, String matrikel) {
		setEmail(email);
		setMatrikel(matrikel);
		setNachname(nachname);
		setVorname(vorname);
	}
	
	public String getVorname() {
		return vorname.get();
	}
	public String getNachname() {
		return nachname.get();
	}
	public String getEmail() {
		return email.get();
	}
	public String getMatrikel() {
		return matrikel.get();
	}
	public void setVorname(String vorname){
		this.vorname.set(vorname);
	}
	public void setNachname(String nachName){
		this.nachname.set(nachName);
	}
	public void setEmail(String email){
		this.email.set(email);
	}
	public void setMatrikel(String matrikel){
		this.matrikel.set(matrikel);
	}
}