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
 * TutoUI is used to be the user interface to interact with user.
 * @version Release 1.08 1 Apr 2011
 * @author Steven Li, Ken Leung
 */
public class TutoUI extends JFrame {
	/**
	 * tutoController indicate the control class to control the main menu
	 */
	private TutoController tutoController;
	
	/**  
     * 	tutoBuffer Store the image and output.
     */
	private Image tutoBuffer;
	
	/**  
     * tutoBackg Store the image and output.
     */
	private Graphics tutoBackg;
	
	/**  
     * serifFont180 Store font size(40), type(Serif) and style(bold).
     */
	private Font serifFont40 = new Font("Serif", Font.BOLD, 40);
	
	/**  
     * serifFont30 Store font size(30), type(Serif) and style(bold).
     */
	private Font serifFont30 = new Font("Serif", Font.BOLD, 30);
	
	public TutoUI(TutoController tutoController) {
		this.tutoController = tutoController;
		
		setTitle("Picoss Game");
	    setSize(1024, 768);
	    
	    setBackground(new Color(0x999999));
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
	    				tutoController.process(e.getX(), e.getY());
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
		
		if (tutoBuffer == null) {
			int w;
			int h;
			int cellStartX = 700;
			int cellStartY = 300;
			int cellSize = 100;
			int cellCols = 3;
			int cellRows = 3;
			
			
			tutoBuffer = createImage(d.width, d.height);
			tutoBackg = tutoBuffer.getGraphics();
			FontMetrics fm = tutoBackg.getFontMetrics();
			
			// display chess
			tutoBackg.setColor(getBackground());
			tutoBackg.fillRect(0, 0, d.width, d.height);
			tutoBackg.setColor(Color.gray);
			tutoBackg.fillRect(cellStartX + 1, cellStartY + 1, cellSize * cellCols - 1, cellSize * cellRows - 1);
		    
			tutoBackg.setColor(getBackground());
		    for (int x = 1; x < cellCols; x++) {
		    	tutoBackg.drawLine(cellStartX + x * cellSize - 1, cellStartY + 1, cellStartX + x * cellSize - 1, cellStartY + cellSize * d.height - 1);
		    }
		      
		    for (int y = 1; y < cellRows; y++) {
		    	tutoBackg.drawLine(cellStartX + 1, cellStartY + y * cellSize - 1, cellStartX + cellSize * d.width - 1, cellStartY + y * cellSize - 1);
		    }
		    
		    
		    // left tips cells
		    tutoBackg.setColor(Color.yellow);
		    tutoBackg.setFont(serifFont40);
		    
		    w = fm.stringWidth("1");
	    	h = fm.getAscent();
		    tutoBackg.drawString(String.valueOf("1"), (int)(cellStartX - 1 * cellSize + 0.5 * cellSize - w/2), (int)(cellStartY + (1-0.5) * cellSize + h/2));
		    tutoBackg.drawString(String.valueOf("1"), (int)(cellStartX - 2 * cellSize + 0.5 * cellSize - w/2), (int)(cellStartY + (1-0.5) * cellSize + h/2));
		    tutoBackg.drawString(String.valueOf("1"), (int)(cellStartX - 1 * cellSize + 0.5 * cellSize - w/2), (int)(cellStartY + (2-0.5) * cellSize + h/2));
		    tutoBackg.drawString(String.valueOf("1"), (int)(cellStartX - 2 * cellSize + 0.5 * cellSize - w/2), (int)(cellStartY + (2-0.5) * cellSize + h/2));
		    tutoBackg.drawString(String.valueOf("1"), (int)(cellStartX - 1 * cellSize + 0.5 * cellSize - w/2), (int)(cellStartY + (3-0.5) * cellSize + h/2));
		    tutoBackg.drawString(String.valueOf("1"), (int)(cellStartX - 2 * cellSize + 0.5 * cellSize - w/2), (int)(cellStartY + (3-0.5) * cellSize + h/2));
		    
		    // top tips cells
		    tutoBackg.setColor(Color.yellow);
		    tutoBackg.drawString(String.valueOf("3"), (int)(cellStartX + (1-0.5) * cellSize - w/2), (int)(cellStartY - 1 * cellSize + 0.5 * cellSize + h/2));
		    tutoBackg.drawString(String.valueOf("0"), (int)(cellStartX + (2-0.5) * cellSize - w/2), (int)(cellStartY - 1 * cellSize + 0.5 * cellSize + h/2));
		    tutoBackg.drawString(String.valueOf("3"), (int)(cellStartX + (3-0.5) * cellSize - w/2), (int)(cellStartY - 1 * cellSize + 0.5 * cellSize + h/2));
		    
		    // display text
		    tutoBackg.setColor(Color.yellow);
			tutoBackg.setFont(serifFont30);
			fm = tutoBackg.getFontMetrics();
			
			//w = fm.stringWidth("Tutorial");
			// left tips text
			tutoBackg.drawString("There are 2 areas in this row filled", 30, 300);
			tutoBackg.drawString("with color.The filled area length", 30, 330);
			tutoBackg.drawString("are '1' and '1' at least one blank", 30, 360);
			tutoBackg.drawString(" area is used separate the 2 filled area", 30, 390);
			tutoBackg.drawString("===>", 450, 350);
			
			// top tips cells
			tutoBackg.drawString("There are 1 area in this column filled", 500, 70);
			tutoBackg.drawString("with color.The filled area length", 500, 100);
			tutoBackg.drawString("are '1' and '1' at least one blank", 500, 130);
			tutoBackg.drawString(" area is used separate the 2 filled area", 500, 160);
			tutoBackg.drawString("||", 753, 190);
			tutoBackg.drawString("\\/", 750, 220);
			
			// display back
			tutoBackg.setFont(serifFont40);
			w = fm.stringWidth("BACK");
			tutoBackg.drawString("BACK", d.width/2 - w/2, 680);
			tutoBackg.drawRect(300, 640, d.width - 600, 50);
			
			
		}
		g.drawImage(tutoBuffer, 0, 0, null);	    
	}
}
