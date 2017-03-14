package com.pkt.badevi;

import java.util.Random;

public class Utils {

	static String MACchar = "0123456789ABCDEF";
	static Random r = new Random();
	//5E:FF:56:A2:AF:15
	
	public static String randomMAC(){
		String MAC = "";
		for (int j = 0; j < 6; j++){
			for (int i = 0; i < 2; i++) {
		        MAC = MAC+(MACchar.charAt(r.nextInt(MACchar.length())));
		    }
			MAC = MAC+":";
		}
		MAC = MAC.substring(0, 17);
		return MAC;
	}
	
	
	
	
	
	
}
