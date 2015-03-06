package com.example.quiltingapp;

public class Supplylist {
	private int ID;
	private int Amount;
	private String Name;	
	private String Store;
	private String Pic;
	private String Notes;
	private float Price;
	
	Supplylist(){
		ID = 0;
		Amount = 0;
		Name = null;
		Store = null;
		Pic = null;
		Notes = null;
		Price = 0.0f;
		
		return;
	}
	
	Supplylist(int id, int amt, String N, String place, String img, float P, String note){
		ID = id;
		Amount = amt;
		Name = new String(N);
		Store = new String(place);
		Pic = new String(img);
		Notes = new String(note);
		Price = P;
		
		return;
	}
	
	int setID(int x){
		ID = x;
		return ID;
	}
	
	int setAmount(int x){
		Amount = x;
		return Amount;
	}
	
	float setPrice(float x){
		Price = x;
		return Price;
	}
	
	String setNotes(String x){
		Notes = new String(x);
		return Notes;
	}
	
	String setName(String x){
		Name = new String(x);
		return Name;
	}
	
	String setStore(String x){
		Store = new String(x);
		return Store;
	}
	
	String setPic(String x){
		Pic = new String(x);
		return Pic;
	}
	
	int getID(){
		return ID;
	}
	
	int getAmount(){
		return Amount;
	}
	
	float getPrice(){
		return Price;
	}
	
	String getName(){
		return Name;
	}
	
	String getNotes(){
		return Notes;
	}
	
	String getStore(){
		return Store;
	}
	
	String getPic(){
		return Pic;
	}
}
