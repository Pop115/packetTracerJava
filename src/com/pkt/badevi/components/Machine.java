package com.pkt.badevi.components;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import com.pkt.badevi.protocoles.Ethernet;
import com.pkt.badevi.protocoles.Message;

public abstract class  Machine  {

	ArrayList<Port> ports = new ArrayList<Port>();
	ArrayList<Message> receivedMessages = new ArrayList<Message>();
	ArrayList<Message> sendMessages = new ArrayList<Message>();
	//ArrayList<Message> messages = new ArrayList<Message>();
	
	public Machine(){
		
	}
	
	public void update(){
		if(!(receivedMessages.isEmpty())){
				for(Message message : receivedMessages){
					if(!message.toSend){
						if(message.getClass() == Ethernet.class){
							Ethernet messageEthernet = (Ethernet)message;
							System.out.println("Message: "+messageEthernet.getMessage());
							System.out.println("Source: "+messageEthernet.getMACSrc() );
							System.out.println("Destination: "+messageEthernet.getMACDest());
						}
					}
				}
				receivedMessages.clear();
		}
	}
	
	public void printConnection(){
		for(Port port : ports){
			System.out.println("Le port d'adresse "+port.adresseIP+" est connecté à "+port.getPortConnected().getAdresseIP());
		}
	}
	
	
	/*
	 * Envoie une "trame Ethernet" à l'adresse MAC spécifiée
	 */
	
	public void sendEthernetTo(String MACDest){
		System.out.println("Envoi de message à "+MACDest+"...");
		boolean destFound = false;
		Port portUsed = null; //Le port à utiliser pour envoyer le message
		for(Port port : this.getPorts()){
			if(port.getPortConnected()!=null){
				if(port.getPortConnected().getAdresseMAC() == MACDest){
					portUsed = port;
					destFound = true;
					break;
				}
			}
		}
		if(destFound){
			sendMessages.add(new Ethernet(MACDest, portUsed.getAdresseMAC(), "Hello"));
			System.out.println("Message envoyé");
		}else{
			System.out.println("Impossible d'envoyer le message à "+MACDest);

		}


	}
	

	
	/*
	 * port1 est le port du pc qu'on veut connecter
	 * port2 est le port du pc auquel on veut se connecter
	 */
	public void connectTo(Port port1, Port port2){
		port1.setPortConnected(port2);		
		port2.setPortConnected(port1);
	}

	public ArrayList<Port> getPorts() {
		return ports;
	}

	public void setPorts(ArrayList<Port> ports) {
		this.ports = ports;
	}

	public ArrayList<Message> getReceivedMessages() {
		return receivedMessages;
	}

	public void setReceivedMessages(ArrayList<Message> receivedMessages) {
		this.receivedMessages = receivedMessages;
	}

	public ArrayList<Message> getSendMessages() {
		return sendMessages;
	}

	public void setSendMessages(ArrayList<Message> sendMessages) {
		this.sendMessages = sendMessages;
	}

	public void addReceivedMessage(Message message){
		this.receivedMessages.add(message);
	}
	
	
}
