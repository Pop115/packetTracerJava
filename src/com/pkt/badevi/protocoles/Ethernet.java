package com.pkt.badevi.protocoles;

public class Ethernet extends Message{
	
	
	public Ethernet(String MACDest, String MACSrc, String message){
		this.toSend = true; //Quand on crée le message il est forcément à envoyer
		this.MACDest = MACDest;
		this.MACSrc = MACSrc;
		this.message = message;
	}

	public String getMACDest() {
		return MACDest;
	}

	public void setMACDest(String mACDest) {
		MACDest = mACDest;
	}

	public String getMACSrc() {
		return MACSrc;
	}

	public void setMACSrc(String mACSrc) {
		MACSrc = mACSrc;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
