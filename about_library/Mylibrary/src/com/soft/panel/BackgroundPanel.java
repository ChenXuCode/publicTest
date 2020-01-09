package com.soft.panel;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
	private Image image;
	/**
	 * This is the default constructor
	 */
	public BackgroundPanel() {
		setOpaque(false);  //²»Í¸Ã÷¶È
		setLayout(null);
		//super();
		//initialize();
	}
	public BackgroundPanel(String fileurl)
	{
		this();
		URL url=getClass().getResource(fileurl);
		image =new ImageIcon(url).getImage();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
		if (g!=null) {
			g.drawImage(image,0,0,this);
			
		}
		super.paintComponent(g);
	}
}
