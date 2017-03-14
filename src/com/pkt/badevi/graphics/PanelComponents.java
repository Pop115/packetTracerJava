package com.pkt.badevi.graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class PanelComponents extends JPanel{
	
	public PanelComponents(){
		JButton ordiButton = new JButton("Ordinateur");
		JButton cableButton = new JButton("Cable");
		
		JToolBar toolBar = new JToolBar();
		toolBar.add(ordiButton);
		toolBar.add(cableButton);
		toolBar.setFloatable(false);
		this.add(toolBar);
	}

}
