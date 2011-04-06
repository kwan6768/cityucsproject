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
 * StageUI is used to be the user interface to interact with user.
 * @version Release 1.08 1 Apr 2011
 * @author Steven Li, Ben Chan, Ken Leung
 */
public class StageUI extends JFrame {
	/**
	 * stageController indicate the control class to control the main menu
	 */
	private StageController stageController;
	
	/**  
     * 	stageBuffer Store the image and output.
     */
	private Image stageBuffer;
	
	/**  
     * stageBackg Store the image and output.
     */
	private Graphics stageBackg;
	
	/**  
     * serifFont120 Store font size(120), type(Serif) and style(bold).
     */
	private Font serifFont120 = new Font("Serif", Font.BOLD, 120);
	
	/**  
     * serifFont40 Store font size(40), type(Serif) and style(bold).
     */
	private Font serifFont40 = new Font("Serif", Font.BOLD, 40);
	
	/**
	 * Constructs stage user interface
	 * @param stageController Indicate the object of control class of stage
	 */
	public StageUI(StageController stageController) {
		this.stageController = stageController;
		
		setTitle("Picoss Game");
	    setSize(1024, 768);
	    
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
	    				stageController.process(e.getX(), e.getY());
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
		
		if (stageBuffer == null) {
			FontMetrics fm;
			int w;
			
			stageBuffer = createImage(d.width, d.height);
			stageBackg = stageBuffer.getGraphics();
			

			stageBackg.setColor(Color.yellow);
			stageBackg.setFont(serifFont120);
			fm = stageBackg.getFontMetrics();
			
			w = fm.stringWidth("Stage Selection");
			stageBackg.drawString("Stage Selection", d.width/2 - w/2, 300);
			
			stageBackg.setFont(serifFont40);
			fm = stageBackg.getFontMetrics();
			
		    w = fm.stringWidth("5 X 5");
		    stageBackg.drawString("5 X 5", d.width/2 - w/2, 490);
		    stageBackg.drawRect(300, 450, d.width - 600, 50);
		    
		    w = fm.stringWidth("10 X 10");
		    stageBackg.drawString("10 X 10", d.width/2 - w/2, 550);
		    stageBackg.drawRect(300, 510, d.width - 600, 50);
		    
		    w = fm.stringWidth("15 X 15");
		    stageBackg.drawString("15 X 15", d.width/2 - w/2, 610);
		    stageBackg.drawRect(300, 570, d.width - 600, 50);
		}
		g.drawImage(stageBuffer, 0, 0, null);	    
	}
	
	/**
	 * Display the error message due to incorrect answer 
	 */
	public void displayError() {
		if (stageBuffer != null) {
			stageBackg.setFont(serifFont40);
			stageBackg.setColor(Color.yellow);
			stageBackg.drawString("Error : answer is not correct format", 20, 100);
		}
	}
	
}
