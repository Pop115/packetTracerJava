
package com.pkt.badevi.protocoles;

public abstract class Message {
	protected String MACDest;
	protected String MACSrc;
	protected String message;
	
	/*
	 * Si True, le message est à envoyer
	 * Si False, le message est reçu
	 */
	public boolean toSend;
	
	
	

}
