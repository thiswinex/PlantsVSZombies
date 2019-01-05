package ui;

import javax.swing.*;
import zombies.Zombies.Z_TYPE;
import java.awt.*;

public abstract class Zombies_ui extends JLabel{

	protected Z_TYPE type;
	protected int x_pos;
	protected int y_pos;
	protected ImageIcon icon;
	
	public Zombies_ui(ImageIcon icon) {
		this.icon = icon;
		//super.setIcon(icon);
		setOpaque(false);
	}
	
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//Image image = icon.getImage();
		//image = image.
		g.drawImage(icon.getImage(), -63, -20, 166, 144, null);
	}
}
