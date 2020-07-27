package de.amirkhani.java.helloworld;

import java.util.LinkedList;

public class CountingGame2 {

	private int maxMembers = 10000;
	private int offset = 3;
	private int counter = 0;
	
	private LinkedList<String> nameList = null;
	
	public CountingGame2() {
		// TODO Auto-generated constructor stub
	}
	
	public final void run() {
		setNameList();
		
		//while(nameList.size() > offset-1)
			runLoop();
		//getLastMemberNames();
		
	}
	
	//Liste mit Namen füllen
	public final void setNameList() {
		nameList = new LinkedList<String> ();
		for(int i=0; i<maxMembers; i++) {
			String name = "Teilnehmer " + (i+1);
			System.out.println("setze " + name + " an Platz [" + i + "]");
			nameList.add(name);
		}
	}
	
	private final void runLoop() {
		System.out.println("Counter " + counter);
		
		while(counter < maxMembers) {			
			counter = counter+offset-1;
			if(counter >= maxMembers) {
				counter = counter - maxMembers;
			}
			String name = nameList.get(counter);
			deleteNameFromList(name);			
		}
		
	}
	
	//Teilnehmer entfernen
	public final void deleteNameFromList(String name) {
		System.out.println("entferne " + name);
		nameList.remove(name);
		maxMembers = nameList.size();
		System.out.println("noch " + maxMembers + " übrig");
	}
	
	public final void getLastMemberNames() {
		for(int i=0; i<nameList.size(); i++)
			System.out.println(nameList.get(i) + " übrig");
	}

}
