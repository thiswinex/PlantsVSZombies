package ui;

import javax.swing.*;
import java.awt.*;

public class MenuWindow extends JPanel{
	public MenuWindow() {
		this.background_image = (new ImageIcon("resource/images/interface/Surface.png")).getImage();
		this.setOpaque(true);
	}
	
	Image background_image;
	
	public void paintComponent(Graphics g)
    {  
        super.paintComponents(g);  
        g.drawImage(background_image,0,0,this.getWidth(),this.getHeight(),this);
    }
}
