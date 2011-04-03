package picross;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 * MainMenuUI is used to be the user interface to interact with user.
 * @version Release 1.07 23 Mar 2011
 * @author Steven Li
 */
public class MainMenuUI extends JFrame{
	/**
	 * mainMenuController indicate the control class to control the main menu
	 */
	private MainMenuController mainMenuController;
	
	/**  
     * 	menuBuffer Store the image and output.
     */
	private Image menuBuffer;
	
	/**  
     * menuBackg Store the image and output.
     */
	private Graphics menuBackg;
	
	/**  
     * serifFont180 Store font size(180), type(Serif) and style(bold).
     */
	private Font serifFont180 = new Font("Serif", Font.BOLD, 180);
	
	/**  
     * serifFont40 Store font size(40), type(Serif) and style(bold).
     */
	private Font serifFont40 = new Font("Serif", Font.BOLD, 40);
	
	
	/**
	 * Construct a main menu screen
	 */
	public MainMenuUI(){
		setTitle("Picoss Game");
	    setSize(1024, 768);
	    
	    mainMenuController = new MainMenuController(this);
	    
	    setBackground(Color.gray);
		setVisible(true);
	}
	
	/** 
     * Set up actionListener to get action from mouse
     */
	public void getCmd() {
		addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent we ) {
				System.exit( 0 );
			}
		} );
		
		addMouseListener(
	    	new MouseAdapter() {
	    		public void mousePressed(MouseEvent e) {
	    			switch(e.getModifiers()) {
	    			case InputEvent.BUTTON1_MASK:	// left click
	    				mainMenuController.process(e.getX(), e.getY());
	    				break;
	    			case InputEvent.BUTTON3_MASK:	// right click
	    				break;
	    			}
	    		}
	    	});
	}
	
	/** 
     * Paint the elements on the screen
     */
	public void paint(Graphics g) {
		Dimension d = getSize();
		
		if (menuBuffer == null) {
			FontMetrics fm;
			int w;
			
			menuBuffer = createImage(d.width, d.height);
			menuBackg = menuBuffer.getGraphics();
			

			menuBackg.setColor(Color.yellow);
			menuBackg.setFont(serifFont180);
			fm = menuBackg.getFontMetrics();
			
			w = fm.stringWidth("PICROSS");
			menuBackg.drawString("PICROSS", d.width/2 - w/2, 300);
			
			menuBackg.setFont(serifFont40);
			fm = menuBackg.getFontMetrics();
			
		    w = fm.stringWidth("START GAME");
		    menuBackg.drawString("START GAME", d.width/2 - w/2, 490);
		    menuBackg.drawRect(300, 450, d.width - 600, 50);
		    
		    w = fm.stringWidth("TUTORIAL");
		    menuBackg.drawString("TUTORIAL", d.width/2 - w/2, 550);
		    menuBackg.drawRect(300, 510, d.width - 600, 50);
		    
		    w = fm.stringWidth("QUIT");
		    menuBackg.drawString("QUIT", d.width/2 - w/2, 610);
		    menuBackg.drawRect(300, 570, d.width - 600, 50);
		}
		g.drawImage(menuBuffer, 0, 0, null);	    
	}
	
	/**
     * main() for Picross game. Start the game and initiate MainMenuUI
     */
	public static void main(String args[]) {
		MainMenuUI mainMenuUI = new MainMenuUI();
		mainMenuUI.getCmd();
	}
}
