package com.example.quiltingapp;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FabricOpenHelper extends SQLiteOpenHelper{

	private static final int DATABASE_VERSION = 2;
	private static final String DATABASE_NAME = "MQC";
	private static final String CREATE_FABRIC_TABLE = 	
			"CREATE TABLE Fabricstats (" +
			"ID INT PRIMARY KEY NOT NULL," +
			"NAME TEXT NOT NULL," +
			"PCOLOR TEXT," +
			"SCOLOR1 TEXT," +
			"SCOLOR2 TEXT," +
			"SCOLOR3 TEXT," +
			"STYLE TEXT," +
			"PRICE REAL," +
			"STORE TEXT," +
			"AMOUNT INT," +
			"NOTES TEST," +
			"PICTURE TEXT);";
	private static final String CREATE_SUPPLY_TABLE = 	
			"CREATE TABLE Supplystats (" +
			"ID INT PRIMARY KEY NOT NULL," +
			"NAME TEXT NOT NULL," +
			"PRICE REAL," +
			"STORE TEXT," +
			"AMOUNT INT," +
			"NOTES TEST," +
			"PICTURE TEXT);";
	FabricOpenHelper(Context thecontext){
		super(thecontext, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db){
		db.execSQL(CREATE_FABRIC_TABLE);
		db.execSQL(CREATE_SUPPLY_TABLE);
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		arg0.execSQL("DROP TABLE IF EXISTS " + CREATE_FABRIC_TABLE);
		arg0.execSQL("DROP TABLE IF EXISTS " + CREATE_SUPPLY_TABLE);
		onCreate(arg0);		
	}
	
	public void addFabric(Fabriclist fab){
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues thedata = new ContentValues();
		thedata.put("ID", fab.getID());
		thedata.put("NAME", fab.getName());
		thedata.put("PCOLOR", fab.getPColor());
		thedata.put("SCOLOR1", fab.getSColor1());
		thedata.put("SCOLOR2", fab.getSColor2());
		thedata.put("SCOLOR3", fab.getSColor3());
		thedata.put("STYLE", fab.getStyle());
		thedata.put("PRICE", fab.getPrice());
		thedata.put("STORE", fab.getStore());
		thedata.put("AMOUNT", fab.getAmount());
		thedata.put("NOTES", fab.getNotes());
		thedata.put("PICTURE", fab.getPic());
		
		db.insert(CREATE_FABRIC_TABLE, null, thedata);
		db.close();
	}
	
//	public Fabriclist getFabric(int id){
//
//	}
	
	public List<Fabriclist> getAllFabric(){
		
	}
	
	public int getFabricCount(){
		
	}
	
	public int updateFabric(Fabriclist fab){
		
	}
	
//	public void deleteFabric(Fabriclist fab){
	//	
//	}
	
	public List<Fabriclist> queryFabric(String query){
		
	}
	
	public void addSupply(Supplylist supply){
		
	}
	
//	public Supplylist getSupply(int id){
	//	
//	}
	
	public List<Supplylist> getAllSupply(){
		
	}
	
	public int getSupplyCount(){
		
	}
	
	public int updateSupply(Supplylist supply){
		
	}
	
//	public void deleteSupply(Supplylist supply){
//		
//	}
	
	public List<Supplylist> querySupply(String query){
		
	}
}
