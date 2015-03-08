package com.example.quiltingapp;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
		List<Fabriclist> AllFabs = new ArrayList<Fabriclist>();
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor acursor = db.rawQuery("SELECT * FROM " + CREATE_FABRIC_TABLE, null);
		
		if(acursor.moveToFirst()){
			do{
				Fabriclist onefab = new Fabriclist();
				onefab.setID(Integer.parseInt(acursor.getString(0)));
				onefab.setName(acursor.getString(1));
				onefab.setPColor(acursor.getString(2));
				onefab.setSColor1(acursor.getString(3));
				onefab.setSColor2(acursor.getString(4));
				onefab.setSColor3(acursor.getString(5));
				onefab.setStyle(acursor.getString(6));
				onefab.setPrice(Float.parseFloat(acursor.getString(7)));
				onefab.setStore(acursor.getString(8));
				onefab.setAmount(Integer.parseInt(acursor.getString(9)));
				onefab.setNotes(acursor.getString(10));
				onefab.setPic(acursor.getString(11));
				
				AllFabs.add(onefab);
			}while(acursor.moveToNext());
		}
		return AllFabs;
	}
	
	public int getFabricCount(){
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor acursor = db.rawQuery("SELECT * FROM " + CREATE_FABRIC_TABLE, null);
		acursor.close();
		
		return acursor.getCount();
	}
	
	public void updateFabric(Fabriclist fab){
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
		
		db.update(CREATE_FABRIC_TABLE, thedata, "ID = ?", new String[] {String.valueOf(fab.getID())});
		db.close();
	}
	
//	public void deleteFabric(Fabriclist fab){
	//	
//	}
	
	public List<Fabriclist> queryFabric(String query){
		List<Fabriclist> AllFabs = new ArrayList<Fabriclist>();
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor acursor = db.rawQuery(query, null);
		
		if(acursor.moveToFirst()){
			do{
				Fabriclist onefab = new Fabriclist();
				onefab.setID(Integer.parseInt(acursor.getString(0)));
				onefab.setName(acursor.getString(1));
				onefab.setPColor(acursor.getString(2));
				onefab.setSColor1(acursor.getString(3));
				onefab.setSColor2(acursor.getString(4));
				onefab.setSColor3(acursor.getString(5));
				onefab.setStyle(acursor.getString(6));
				onefab.setPrice(Float.parseFloat(acursor.getString(7)));
				onefab.setStore(acursor.getString(8));
				onefab.setAmount(Integer.parseInt(acursor.getString(9)));
				onefab.setNotes(acursor.getString(10));
				onefab.setPic(acursor.getString(11));
				
				AllFabs.add(onefab);
			}while(acursor.moveToNext());
		}
		return AllFabs;
	}
	
	public void addSupply(Supplylist supply){
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues thedata = new ContentValues();
		thedata.put("ID", supply.getID());
		thedata.put("NAME", supply.getName());
		thedata.put("PRICE", supply.getPrice());
		thedata.put("STORE", supply.getStore());
		thedata.put("AMOUNT", supply.getAmount());
		thedata.put("NOTES", supply.getNotes());
		thedata.put("PICTURE", supply.getPic());
		
		db.insert(CREATE_SUPPLY_TABLE, null, thedata);
		db.close();
	}
	
//	public Supplylist getSupply(int id){
	//	
//	}
	
	public List<Supplylist> getAllSupply(){
		List<Supplylist> AllSup = new ArrayList<Supplylist>();
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor acursor = db.rawQuery("SELECT * FROM " + CREATE_SUPPLY_TABLE, null);
		
		if(acursor.moveToFirst()){
			do{
				Supplylist oneSup = new Supplylist();
				oneSup.setID(Integer.parseInt(acursor.getString(0)));
				oneSup.setName(acursor.getString(1));
				oneSup.setPrice(Float.parseFloat(acursor.getString(2)));
				oneSup.setStore(acursor.getString(3));
				oneSup.setAmount(Integer.parseInt(acursor.getString(4)));
				oneSup.setNotes(acursor.getString(5));
				oneSup.setPic(acursor.getString(6));
				
				AllSup.add(oneSup);
			}while(acursor.moveToNext());
		}
		return AllSup;
	}
	
	public int getSupplyCount(){
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor acursor = db.rawQuery("SELECT * FROM " + CREATE_SUPPLY_TABLE, null);
		acursor.close();
		
		return acursor.getCount();
	}
	
	public void updateSupply(Supplylist supply){
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues thedata = new ContentValues();
		thedata.put("ID", supply.getID());
		thedata.put("NAME", supply.getName());
		thedata.put("PRICE", supply.getPrice());
		thedata.put("STORE", supply.getStore());
		thedata.put("AMOUNT", supply.getAmount());
		thedata.put("NOTES", supply.getNotes());
		thedata.put("PICTURE", supply.getPic());
		
		db.update(CREATE_SUPPLY_TABLE, thedata, "ID = ?", new String[] {String.valueOf(supply.getID())});
		db.close();
	}
	
//	public void deleteSupply(Supplylist supply){
//		
//	}
	
	public List<Supplylist> querySupply(String query){
		List<Supplylist> AllSup = new ArrayList<Supplylist>();
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor acursor = db.rawQuery(query, null);
		
		if(acursor.moveToFirst()){
			do{
				Supplylist oneSup = new Supplylist();
				oneSup.setID(Integer.parseInt(acursor.getString(0)));
				oneSup.setName(acursor.getString(1));
				oneSup.setPrice(Float.parseFloat(acursor.getString(2)));
				oneSup.setStore(acursor.getString(3));
				oneSup.setAmount(Integer.parseInt(acursor.getString(4)));
				oneSup.setNotes(acursor.getString(5));
				oneSup.setPic(acursor.getString(6));
				
				AllSup.add(oneSup);
			}while(acursor.moveToNext());
		}
		return AllSup;
	}
}
