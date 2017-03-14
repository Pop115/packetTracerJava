package com.pkt.badevi.graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class PanelMenu extends JPanel{
	
	public PanelMenu(){
		JButton fichierButton = new JButton("Fichier");
		JButton optionsButton = new JButton("Options");
		
		JToolBar toolBar = new JToolBar();
		toolBar.add(fichierButton);
		toolBar.add(optionsButton);
		toolBar.setFloatable(false);
		this.add(toolBar);
	}

}
