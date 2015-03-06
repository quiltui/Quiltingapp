package com.example.quiltingapp;

public class temppic {
	private String Name;	
	private String Pic;
	
	temppic(){
		Name = null;
		Pic = null;
	}
	
	temppic(String N, String P){
		Name = new String(N);
		Pic = new String(P);
	}
	
	String setName(String x){
		Name = new String(x);
		return Name;
	}
	
	String setPic(String x){
		Pic = new String(x);
		return Pic;
	}
	
	String getName(){
		return Name;
	}
	
	String getPic(){
		return Pic;
	}
}
