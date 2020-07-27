package de.amirkhani.java.helloworld;

import java.util.Iterator;
import java.util.LinkedList;

public class CountingGame {
	
	private int nextInRow;
	private LinkedList<String> memberNames = null;
	
	public CountingGame(){
		init();
		
	}
	
	private final void init() {
		memberNames = new LinkedList<String> ();
		nextInRow = 0;
	}
	
	public final void run(int membersCount, int offSet) {
		memberNames = getMemberNameList(membersCount);
		
		while(memberNames.size() > offSet -1) {
			memberNames = runLoop(memberNames, offSet);
		}
		
		String lastMembers = getLastMembers(memberNames);
		System.out.println("die Letzten: " + lastMembers);
	}
	
	private final LinkedList<String> runLoop(LinkedList<String> list, int offSet) {
		Iterator<String> it = list.iterator();
		nextInRow = offSet;		
		int membersCount = list.size();
		
		LinkedList<Integer> toRemove = new LinkedList<Integer>();
		
		while(it.hasNext()) {
			
			toRemove.add(nextInRow);
			nextInRow = nextInRow + offSet;
						
			if(nextInRow > membersCount) {
				System.out.println("Schleife zu Ende.");
				
				for(int i=0; i<toRemove.size(); i++) {
					System.out.println("Entferne " + memberNames.get(toRemove.get(i).intValue()));
					memberNames.remove(toRemove.get(i).intValue());
				}
				
				if(membersCount < 0)
					nextInRow = nextInRow * (-1);
				break;
			}			
		}		
		return memberNames;		
	}
	
	private final LinkedList<String> getMemberNameList(int membersCount){		
		
		// Teilnehmer in die members Liste mit fiktive Namen hinzufügen
		for(int i=0; i<membersCount; i++) {
			memberNames.add(i, "Teilnehmer " + i);
		}
		System.out.println(memberNames.size() + " Teilnehmer hinzugefügt.");
		return memberNames;
	}

	
	private final String getLastMembers(LinkedList<String> members) {
		
		Iterator it = members.iterator();
		String lastMembers = "";
		
		System.out.println("Rest: " + members.size());
		
		for(int i=0; it.hasNext(); i++)	
			lastMembers = lastMembers + it.next() + " - ";
		
		return lastMembers;
	}

}
