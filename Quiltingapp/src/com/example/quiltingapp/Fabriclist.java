package com.example.quiltingapp;


public class Fabriclist {

	private int ID;
	private int Amount;
	private String Name;
	private String PColor;
	private String SColor1;
	private String SColor2;
	private String SColor3;
	private String Style;	
	private String Store;
	private String Pic;
	private String Notes;
	private float Price;
	
	Fabriclist(){
		ID = 0;
		Amount = 0;
		Name = null;
		PColor = null;
		SColor1 = null;
		SColor2 = null;
		SColor3 = null;
		Style = null;
		Store = null;
		Pic = null;
		Notes = null;
		Price = 0.0f;
		
		return;
	}
	
	Fabriclist(int id, int amt, String N, String PC, 
			String SC1, String SC2, String SC3, String sty, 
			String place, String img, float P, String note){
		ID = id;
		Amount = amt;
		Name = new String(N);
		PColor = new String(PC);
		SColor1 = new String(SC1);
		SColor2 = new String(SC2);
		SColor3 = new String(SC3);
		Style = new String(sty);
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
	
	String setPColor(String x){
		PColor = new String(x);
		return PColor;
	}
	
	String setSColor1(String x){
		SColor1 = new String(x);
		return SColor1;
	}
	
	String setSColor2(String x){
		SColor2 = new String(x);
		return SColor2;
	}
	
	String setSColor3(String x){
		SColor3 = new String(x);
		return SColor3;
	}
	
	String setStyle(String x){
		Style = new String(x);
		return Style;
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
	
	String getPColor(){
		return PColor;
	}
	
	String getSColor1(){
		return SColor1;
	}
	
	String getSColor2(){
		return SColor2;
	}
	
	String getSColor3(){
		return SColor3;
	}
	
	String getStyle(){
		return Style;
	}
	
	String getStore(){
		return Store;
	}
	
	String getPic(){
		return Pic;
	}
}
