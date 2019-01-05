package ui;

import javax.swing.*;
import java.awt.*;
import lib.*;

public class SeedBank extends JPanel{
	SeedBank(){
		this.setSize(446, 87);
		this.setOpaque(true);
		this.setLayout(null);
		
		card[0] = new JLabel(Resource.card_norbeen);
		card[0].setLocation(80, 7);
		card[0].setSize(52, 70);
		this.add(card[0]);
		
		card[1] = new JLabel(Resource.card_icebeen);
		card[1].setLocation(140, 7);
		card[1].setSize(52, 70);
		this.add(card[1]);
		
		card[2] = new JLabel(Resource.card_sunflower);
		card[2].setLocation(200, 7);
		card[2].setSize(52, 70);
		this.add(card[2]);
		
		card[3] = new JLabel(Resource.card_potato);
		card[3].setLocation(260, 7);
		card[3].setSize(52, 70);
		this.add(card[3]);
		
		sunlight.setLocation(18, 64);
		sunlight.setSize(43, 17);
		this.add(sunlight);
		
		shovel.setLocation(356, 0);
		shovel.setSize(90, 87);
		this.add(shovel);
	}
	
	JLabel[] card = new JLabel[4];
	Shovel shovel = new Shovel();
	JLabel sunlight = new JLabel();
	
	public void paintComponent(Graphics g)
    {  
        super.paintComponents(g);  
        g.drawImage((new ImageIcon("resource/images/interface/SeedBank.png")).getImage(),0,0,this.getWidth(),this.getHeight(),this);
    }
	
}
