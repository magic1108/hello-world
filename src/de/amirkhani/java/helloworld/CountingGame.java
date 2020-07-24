package de.amirkhani.java.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;



public class CountingGame {
	
	private LinkedList<Integer> members = null;
	private int membersCount = 0;
	
	public CountingGame(int mc) throws IOException {
		this.membersCount = mc;
		System.out.println("Vorbereitung...[" + init(membersCount)+ "]");
		System.out.println("Starten? Y/N");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String input = "";
		try {
			input = in.readLine();
			System.out.println(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    if(input.equals("Y")) {
	    	LinkedList<Integer> list = run(members);
	    	if(list.size() > 2) {
	    		System.out.println("Erste Schleife zu ende. Weiter? Y/N");
	    		input = in.readLine();
	    	}
	    	
	    	System.out.print("Ergebniss anzeigen? Y/N");
	    	input = in.readLine();
	    	
	    	if(input.equals("Y"))
	    		System.out.println(getLastMembers());	    	
	    		
	    }
	    else
	    	System.out.println("Tschüss...");
	}
	
	private final String init(int membersCount) {
		
		members = new LinkedList<Integer>();
		for(int i=1; i<= membersCount; i++) {
			System.out.println("Füge Teilnehmer " + i + " hinzu.");
			members.add(i-1, i);
		}		
		return "OK";
	}
	
	public final LinkedList<Integer> run(LinkedList<Integer> members) {
		Iterator<Integer> iterator = members.iterator();
		int nextInRow = 3;
		
		LinkedList<Integer> toRemove = new LinkedList<Integer>();
		
		while(iterator.hasNext()) {
			toRemove.add(nextInRow);
			nextInRow = nextInRow + 3;
			if(nextInRow > membersCount) {
				System.out.println("Schleife zu Ende.");
				for(int i=0; i<toRemove.size(); i++)
					members.remove(i);
				break;
			}
		}		
		return members;		
	}
	
	public final String getLastMembers() {
		
		Iterator it = members.iterator();
		String lastMembers = "";
		
		System.out.println("Rest: " + members.size());
		
		for(int i=0; it.hasNext(); i++)	
			lastMembers = lastMembers + members.get(i) + " - ";
		
		return lastMembers;
	}

}
