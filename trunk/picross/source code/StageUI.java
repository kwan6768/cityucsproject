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
     * serifFont180 Store font size(180), type(Serif) and style(bold).
     */
	private Font serifFont180 = new Font("Serif", Font.BOLD, 180);
	
	/**  
     * serifFont40 Store font size(40), type(Serif) and style(bold).
     */
	private Font serifFont40 = new Font("Serif", Font.BOLD, 40);
	
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
			stageBackg.setFont(serifFont180);
			fm = stageBackg.getFontMetrics();
			
			w = fm.stringWidth("Tutorial");
			stageBackg.drawString("Stage Selection", d.width/2 - w/2, 300);
		}
		g.drawImage(stageBuffer, 0, 0, null);	    
	}
}