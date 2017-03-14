package com.pkt.badevi.graphics;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class PanelMain extends JPanel{
	Panel panel = new Panel();
	PanelComponents panelComponents = new PanelComponents();
	PanelMenu panelMenu = new PanelMenu();

	public PanelMain(){
		super(new BorderLayout());
		
		JPanel subPanel = new JPanel();
		
		subPanel.add(panelMenu);
		subPanel.add(panelComponents);

		
		this.add(subPanel, BorderLayout.PAGE_START);
		this.add(panel, BorderLayout.CENTER);

	}
	
	public void update(){
		panel.repaint();
		
	}

}
