package ui;

import javax.swing.*;
import java.awt.*;

public class WelcomeWindow extends JPanel{
	public WelcomeWindow() {
		this.background_image = (new ImageIcon("resource/images/interface/MainStart.png")).getImage();
		this.setOpaque(true);
	}

	Image background_image;
	
	public void paintComponent(Graphics g)
    {  
        super.paintComponents(g);  
        g.drawImage(background_image,0,0,this.getWidth(),this.getHeight(),this);
    }
}
