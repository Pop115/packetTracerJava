package com.pkt.badevi.graphics;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	PanelMain panelMain = new PanelMain();

	public Fenetre(){
		
		this.setContentPane(panelMain);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Packet Tracer RT Java");
		this.setSize(400, 400);
		this.setVisible(true);
	}
	
	public void update(){
		panelMain.update();
	}

}
