package com.pkt.badevi.components;

import java.util.ArrayList;

public class Ordinateur extends Machine{
	
	public Ordinateur(String adresseIP1, String adresseIP2){
		super();
		ArrayList<Port> portsPC = new ArrayList<Port>();
		portsPC.add(new Port(adresseIP1));
		portsPC.add(new Port(adresseIP2));
		this.setPorts(portsPC);
		
	}

}
