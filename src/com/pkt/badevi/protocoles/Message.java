
package com.pkt.badevi.protocoles;

public abstract class Message {
	protected String MACDest;
	protected String MACSrc;
	protected String message;
	
	/*
	 * Si True, le message est � envoyer
	 * Si False, le message est re�u
	 */
	public boolean toSend;
	
	
	

}
