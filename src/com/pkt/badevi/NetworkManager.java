package com.pkt.badevi;

import java.util.ArrayList;

import com.pkt.badevi.components.Machine;
import com.pkt.badevi.components.Port;
import com.pkt.badevi.protocoles.Ethernet;
import com.pkt.badevi.protocoles.Message;

public class NetworkManager {
	
	ArrayList<Machine> machines = new ArrayList<Machine>();
	
	public NetworkManager(){
		
	}
	
	public void addMachine(Machine machine){
		machines.add(machine);
	}
	
	public void deleteMachine(Machine machine){
		machines.remove(machine);
	}
	
	public void update(){
		//Pour chaque machine
		for(Machine machine : machines){
			//On regarde si elle a des messages
			if(!(machine.getSendMessages().isEmpty())){
				//Pour chaque message
				for(Message message : machine.getSendMessages()){
					//S'il faut l'envoyer
					if(message.toSend == true){
						//Si le message est une trame Ethernet
						if(message.getClass() == Ethernet.class){
							sendEthernet((Ethernet)message);
						}
					}
				}
			}
			try{
				Thread.sleep(20);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			machine.update();

		}
	}
	
	public void sendEthernet(Ethernet messageEthernet){
		String MACDest = messageEthernet.getMACDest();
		Machine machineDest = this.getMachineByPortMAC(MACDest, machines);
		messageEthernet.toSend = false;
		machineDest.addReceivedMessage(messageEthernet);
	}
		
	
	public Machine getMachineByPortMAC(String MAC, ArrayList<Machine> machines){
		for (Machine machine : machines){
			for(Port port : machine.getPorts()){
				if(port.getAdresseMAC() == MAC){
					return machine;
				}
			}
		}
		return null;
	}
	

	

}
