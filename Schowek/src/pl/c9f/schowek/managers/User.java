package pl.c9f.schowek.managers;

public class User {
	private final String name;
	private int koxy;  
	private int refy; 
	private int perly; 
	private int strzaly; 
	public User(String name){
		this.name = name;
		this.koxy = 0;
		this.refy = 0;
		this.perly = 0;
		this.strzaly = 0;
		UserManager.users.add(this);
	}  
	public String getName(){
		return this.name;
	}  
	public int getKoxy(){
		return this.koxy;
	} 
	public int getRefy(){
		return this.refy;
	}  
	public int getPerly(){
		return this.perly;
	}  
	public int getStrzaly(){
		return this.strzaly;
	}  
	public void setKoxy(int newint){
		this.koxy = newint;
	}
	public void setRefy(int newint){
		this.refy = newint;
	}
	public void setPerly(int newint){
		this.perly = newint;
	}
	public void setStrzaly(int newint){
		this.strzaly = newint;
	}
}
