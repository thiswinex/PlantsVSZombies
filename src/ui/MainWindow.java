package ui;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;


public class MainWindow extends JFrame{
	public MainWindow() {
        super("MainWindow");

        setSize(800, 600);
        setUndecorated(true); //取消了标题和边框
        //TODO 坐标计算问题
        
        background.add(welcome, "welcome");
        background.add(field, "field");
        
        layout.show(background, "welcome");
        
        mListener_welcome mlistener_welcome = new mListener_welcome();
        mListener_welcome mlistener_menu = new mListener_welcome();
        
        welcome.addMouseListener(mlistener_welcome);
        menu.addMouseListener(mlistener_menu);
        
        music_thread.f = new File("resource/audio/Faster.wav");
        music_thread.start();
        
        this.setContentPane(background);
        setVisible(true); 
	}
	
	public CardLayout layout = new CardLayout();
	public JPanel background = new JPanel(layout);
	public WelcomeWindow welcome = new WelcomeWindow();
	public MenuWindow menu = new MenuWindow();
	public Field field = new Field();
	
	public MusicThread music_thread = new MusicThread();
	private class MusicThread extends Thread{
		public File f;
		public AudioClip aau;
		public void run() {
			try {
				URI uri = f.toURI();
				URL url;
				url = uri.toURL();
				aau = Applet.newAudioClip(url);
				aau.play();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}
	

	private class mListener_welcome implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			if((x>249 && y>545) && (x<549 && y<574)) {
				layout.next(background);
				music_thread.aau.stop();
				music_thread.f = (new File("resource/audio/Grasswalk.wav"));
				music_thread.run();
				
				field.beginGame();
			}
		}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
	}
	
	private class mListener_menu implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			if((x>249 && y>545) && (x<549 && y<574)) {
				layout.next(background);
			}
		}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
	}
	
	public static void main(String[] args) { 
		MainWindow w = new MainWindow();
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
