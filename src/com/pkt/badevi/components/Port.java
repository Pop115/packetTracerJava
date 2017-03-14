package com.pkt.badevi.components;

import com.pkt.badevi.Utils;

public class Port{
	
	protected String adresseIP = "";
	protected String adresseMAC = "";
	
	protected Port portConnected;
	
	public Port(String adresseIP){
		this.adresseIP = adresseIP;
		this.adresseMAC = Utils.randomMAC();
	}
	
	public Port(String adresseIP, String adresseMAC){
		this.adresseIP = adresseIP;
		this.adresseMAC = adresseMAC;
	}

	public String getAdresseIP() {
		return adresseIP;
	}

	public void setAdresseIP(String adresseIP) {
		this.adresseIP = adresseIP;
	}

	public String getAdresseMAC() {
		return adresseMAC;
	}

	public void setAdresseMAC(String adresseMAC) {
		this.adresseMAC = adresseMAC;
	}

	public Port getPortConnected() {
		return portConnected;
	}

	protected void setPortConnected(Port portConnected) {
		this.portConnected = portConnected;
	}
	
	
	
	
	
	
}