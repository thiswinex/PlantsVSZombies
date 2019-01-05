package ui;

import javax.swing.*;

import plants.Plants.P_TYPE;

public abstract class Plants_ui extends JLabel{

	protected P_TYPE type;
	protected int x_pos;
	protected int y_pos;
	
	public Plants_ui(Icon icon) {
		super(icon);
	}
	
	//public abstract void paintComponent(Graphics g);
	
}
