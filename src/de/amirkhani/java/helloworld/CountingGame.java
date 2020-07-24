package de.amirkhani.java.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;



public class CountingGame {
	
	private LinkedList<Integer> members = null;
	
	public CountingGame(int membersCount) throws IOException {
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
	    	int startPoint = -1;
	    		do{
	    			System.out.println("Startpunkt eingeben (1-" + members.size() + ":");
	    			input = in.readLine();
	    			System.out.println("Anzahl Teilnehmer: " + input);
	    			startPoint = Integer.getInteger(input);
	    		}while(startPoint < 1 || startPoint > members.size());
	    		
	    	run(startPoint);
	    	
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
		for(int i=0; i<= membersCount; i++) {
			members.add(i, i);
		}		
		return "OK";
	}
	
	public final void run(int from) {
		Iterator<Integer> iterator = members.iterator();
		int nextInRow = from+3;
		
		while (iterator.hasNext()) {
			if(nextInRow > members.size()) {
				System.out.println("Ende erreicht!");
				break;
			}else {
				System.out.println("Entferne " + nextInRow);
				members.remove(nextInRow);
				nextInRow = nextInRow+3;
			}
        }
		
	}
	
	public final String getLastMembers() {
		
		Iterator it = members.iterator();
		String lastMembers = null;
		
		
		for(int i=0; it.hasNext(); i++)	
			lastMembers = lastMembers + members.get(i) + " - ";
		
		return lastMembers;
	}

}
