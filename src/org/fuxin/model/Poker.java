package org.fuxin.model;

public class Poker {
	private int id;
	private String name;
	private int num;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Poker(int id, String name, int num) {
		super();
		this.id = id;
		this.name = name;
		this.num = num;
	}
	public Poker()
	{
		
	}

}
