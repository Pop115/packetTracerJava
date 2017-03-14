package com.pkt.badevi;

import com.pkt.badevi.components.Ordinateur;
import com.pkt.badevi.graphics.Fenetre;

public class Main {

	public static void main(String[] args) {
		
		Fenetre fenetre = new Fenetre();
		
		NetworkManager networkManager = new NetworkManager();
		Ordinateur pc1 = new Ordinateur("192.168.0.2","192.168.0.3");
		Ordinateur pc2 = new Ordinateur("192.168.0.4","192.168.0.5");
		
		
		pc1.connectTo(pc1.getPorts().get(0), pc2.getPorts().get(0));
		pc1.connectTo(pc1.getPorts().get(1), pc2.getPorts().get(1));

		networkManager.addMachine(pc1);
		networkManager.addMachine(pc2);
		
		pc2.sendEthernetTo(pc1.getPorts().get(0).getAdresseMAC());

		int i = 0;
		while(i < 100000){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			if(i==200){
				pc1.sendEthernetTo(pc2.getPorts().get(0).getAdresseMAC());
			}
			networkManager.update();
			fenetre.update();
			i++;
		}
	}

}
