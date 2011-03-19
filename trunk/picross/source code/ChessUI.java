/*
 * @(#)Cell.java        Release 1.04 2011/3/6
 *
 * 
 */
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
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;
import javax.swing.JFrame;

/**
 *  
        
ChessUI is used to be the interface to interact with user.
 *
 * @version      
        
Release 1.04 6 Mar 2011
 * @author          
        
Ben Chan, Steven Li, Ken Leung
 */


public class ChessUI extends JFrame {
	
  /**  
    
	chessController indicate the control class to control the game.*/
	private ChessController chessController;
	
	/**  
    
	chessBuffer Store the image and output.*/
	private Image chessBuffer;
	
	/**  
    
	chessBackg Store the image and output.*/
	private Graphics chessBackg;
	
	/**  
    
	cellCols Indicate the number of column of the game board.*/
	private int cellCols;
	
    /**  
    
	cellRows Indicate the number of row of the game board.*/
	private int cellRows;
	
    /**  
    
	cellSize Indicate the size of each cell which used for painting.*/
	private int cellSize;
	
    /**  
    
	cellStartX Indicate the starting X axis point to draw cell.*/
	private int cellStartX;
	
    /**  
    
	cellStartY Indicate the starting Y axis point to draw cell.*/
	private int cellStartY;
	
    /**  
    
	menuX Indicate the starting X axis point to draw the menu.*/
	private int menuX;
	
	/**  
    
	serifFont Store font size, type and style.*/
	private static Font serifFont = new Font("Serif", Font.BOLD, 40);
	///////////////////////////////////////////
	
	private boolean bStart = false;
	
	 /** 
     * 
     Construct a game screen UI.
     
     @param cellRows Indicate the number of row of the game board.
     @param cellCols Indicate the number of column of the game board.
     @param ans Indicate the answer of the question.
     @param cellSize Indicate the size of each cell which used for painting.  
     */
	public ChessUI(int cellRows, int cellCols, int cellSize, int[][] ans) {
		setTitle("Picoss Game");
	    setSize(1024, 768);
	    
		this.cellCols = cellCols;
		this.cellRows = cellRows;
		this.cellSize = cellSize;
		
		cellStartX = (int)Math.ceil((double)cellCols / 2.0) * cellSize;
		cellStartY = (int)Math.ceil((double)cellRows / 2.0) * cellSize;
		menuX = cellStartX + cellCols * cellSize;
		
		chessController = new ChessController(cellRows, cellCols, ans, cellSize, this);
		
		setBackground(new Color(0x999999));
		
		setVisible(true);
	}

	 /** 
     * 
     Set up actionListener to get action from mouse
    
     */
	public void getCmd() {
		
		addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent we ) {
				System.exit( 0 );
			}
		} );
		
		addMouseListener(
	    	new MouseAdapter() {
	    		/*
	    		public void mouseReleased(MouseEvent e) {
	    			//draw(e.getX(), e.getY());
	    		}
	        	*/
	    		public void mousePressed(MouseEvent e) {
	    			Dimension d = getSize();
	    			
	    			switch(e.getModifiers()) {
	    			case InputEvent.BUTTON1_MASK:	// left click
	    				chessController.process(e.getX(), e.getY(), d, cellRows, cellCols, cellStartX, cellStartY, cellSize, menuX, "LEFT");
	    				break;
	    			case InputEvent.BUTTON3_MASK:	// right click
	    				chessController.process(e.getX(), e.getY(), d, cellRows, cellCols, cellStartX, cellStartY, cellSize, menuX, "RIGHT");
	    				break;
	    			}
	    		}
	    	});

		    addMouseMotionListener(new MouseMotionAdapter() {
		    	public void mouseDragged(MouseEvent e) {
		    		if (bStart) {
			    		Dimension d = getSize();
			    		
			    		switch(e.getModifiers()) {
			    			case InputEvent.BUTTON1_MASK:	// left click
			    				chessController.process(e.getX(), e.getY(), d, cellRows, cellCols, cellStartX, cellStartY, cellSize, menuX, "LEFT_DRAG");
			    				break;
			    	      
			    			case InputEvent.BUTTON3_MASK:	// right click
			    				chessController.process(e.getX(), e.getY(), d, cellRows, cellCols, cellStartX, cellStartY, cellSize, menuX, "RIGHT");
			    				break;
			    		}	
		    		} else {
		    			bStart = true;
		    		}
		    	}
		    });
	}
	
	 /** 
     * 
     Show the tips cell on the screen
     */
	public void displayTipsCells() {
		Enumeration e;
		TipsCell c;
	    int w;
	    int h;
	    
	    FontMetrics fm = chessBackg.getFontMetrics();
	    
	    // draw left tips cells
		e = chessController.getLeftTipsCells().elements();
		
	    while ( e.hasMoreElements() ) {
	    	c = (TipsCell)e.nextElement();
	    	String strTips = String.valueOf(c.getTipsNum());
	    	w = fm.stringWidth(strTips);
	    	h = fm.getAscent();
	    	int row = c.getRow();
	    	int col = c.getCol();
	    	chessBackg.drawString(String.valueOf(strTips), (int)(cellStartX - col * cellSize + 0.5 * cellSize - w/2), (int)(cellStartY + (row-0.5) * cellSize + h/2));
	    }
	    
	    // draw top tips cells
	    e = chessController.getTopTipsCells().elements();
	    
	    while ( e.hasMoreElements() ) {
	    	c = (TipsCell)e.nextElement();
	    	String strTips = String.valueOf(c.getTipsNum());
	    	w = fm.stringWidth(strTips);
	    	h = fm.getAscent();
	    	int row = c.getRow();
	    	int col = c.getCol();
	    	chessBackg.drawString(String.valueOf(strTips), (int)(cellStartX + (col-0.5) * cellSize - w/2), (int)(cellStartY - row * cellSize + 0.5 * cellSize + h/2));
	    }
	}
	
	/**
	 * Display the screen of the state
	 * @param state game state
	 * @param cells all cells inside the chess
	 */
	public void display(String state, Cell cells[][]) {
		
		if (state == "CLICK_CELLS") {	// draw selected cell
			for ( int row=0; row<cellRows; row++) {
		    	for ( int col=0; col<cellCols; col++ ) {
		    		if (cells[row][col].IsLeftSelect()) {			// left-clicked cells
		    			chessBackg.setColor(Color.yellow);
		    			chessBackg.fillRect(cellStartX + col * cellSize, cellStartY + row * cellSize, cellSize - 1, cellSize - 1);
		    		} else if (cells[row][col].IsRightSelect()) {	// right-clicked cells
		    			chessBackg.setColor(Color.yellow);
		    			chessBackg.drawLine(cellStartX + col * cellSize, cellStartY + row * cellSize, cellStartX + col * cellSize + cellSize - 2, cellStartY + row * cellSize + cellSize - 2);
		    			chessBackg.drawLine(cellStartX + col * cellSize, cellStartY + row * cellSize + cellSize - 2, cellStartX + col * cellSize + cellSize - 2, cellStartY + row * cellSize);
		    		} else {	// not click
		    			chessBackg.setColor(Color.gray);
		    			chessBackg.fillRect(cellStartX + col * cellSize, cellStartY + row * cellSize, cellSize - 1, cellSize - 1);
		    		}
		    	}
		    }
		}
		else if (state == "RESTART") {	// display restarted game, set the selected cells to "not selected"
			chessBackg.setColor(Color.gray);
			for ( int row=0; row<cellRows; row++) {
		    	for ( int col=0; col<cellCols; col++ ) {
		    		if (cells[row][col].IsLeftSelect() || cells[row][col].IsRightSelect()) {
		    			chessBackg.fillRect(cellStartX + col * cellSize, cellStartY + row * cellSize, cellSize - 1, cellSize - 1);
		    		}
		    	}
		    }
			chessBackg.setColor(getBackground());
			chessBackg.fillRect(0, 0, 150, 100);
		}
	}
	
	/**
	 * Display the screen of the state
	 * @param state game state
	 */
	public void display(String state) {
		if (state == "CLEAR") {		// display clear game, draw a "CLEAR" text at the upper left con
			chessBackg.setColor(Color.yellow);
			chessBackg.setFont(serifFont);
			chessBackg.drawString("CLEAR", 10, 100);
		} else if (state == "GAME_OVER") {
			chessBackg.setColor(Color.yellow);
			chessBackg.setFont(serifFont);
			chessBackg.drawString("GAME", 10, 70);
			chessBackg.drawString("OVER", 10, 100);
		}
	}
	
	/*
	public void display(String state, int hp) {
		if (state == "PLAYER_HP") {
			chessBackg.setColor(getBackground());
			chessBackg.fillRect(850, 70, 120, 35);
			
			chessBackg.setColor(Color.yellow);
			chessBackg.setFont(serifFont);
			chessBackg.drawString("HP : " + String.valueOf(hp), 850, 100);
			
			
		}
	}
	*/
	
	 /** 
     * Paint the elements on the screen
     */
	public void paint(Graphics g) {
		Dimension d = getSize();
		
		if (chessBuffer == null) {	
			chessBuffer = createImage(d.width, d.height);
			chessBackg = chessBuffer.getGraphics();
			chessBackg.setColor(getBackground());
			chessBackg.fillRect(0, 0, d.width, d.height);
			chessBackg.setColor(Color.gray);
			chessBackg.fillRect(cellStartX + 1, cellStartY + 1, cellSize * cellCols - 1, cellSize * cellRows - 1);
		    
			chessBackg.setColor(getBackground());
		    for (int x = 1; x < cellCols; x++) {
		    	chessBackg.drawLine(cellStartX + x * cellSize - 1, cellStartY + 1, cellStartX + x * cellSize - 1, cellStartY + cellSize * d.height - 1);
		    }
		      
		    for (int y = 1; y < cellRows; y++) {
		    	chessBackg.drawLine(cellStartX + 1, cellStartY + y * cellSize - 1, cellStartX + cellSize * d.width - 1, cellStartY + y * cellSize - 1);
		    }
		    
		    // draw left tips cells
		    chessBackg.setColor(Color.yellow);
		    
		    chessBackg.setFont(serifFont);
		    FontMetrics fm = chessBackg.getFontMetrics();
		    
		    // display left and top tips cells
		    displayTipsCells();
		    
		    // right windows - menu UI
		    int w;
		    
		    w = fm.stringWidth("RESTART");
		    chessBackg.drawString("RESTART", menuX/2 + d.width/2 - w/2, 560);
		    chessBackg.drawRect(menuX + 20, 520, d.width - menuX - 40, 50);
		    
		    w = fm.stringWidth("PAUSE");
		    chessBackg.drawString("PAUSE", menuX/2 + d.width/2 - w/2, 630);
		    chessBackg.drawRect(menuX + 20, 590, d.width - menuX - 40, 50);
		    
		    w = fm.stringWidth("QUIT");
		    chessBackg.drawString("QUIT", menuX/2 + d.width/2 - w/2, 700);
		    chessBackg.drawRect(menuX + 20, 660, d.width - menuX - 40, 50);
		}
		
		
		g.drawImage(chessBuffer, 0, 0, null);
		g.setColor(Color.yellow);
		g.setFont(serifFont);
		g.drawString("HP : " + String.valueOf(chessController.getHp()), 850, 100);
		//chessController.process();
		/*
		g.setColor(Color.yellow);
	    if (chessController.isClear()) {
	    	g.setFont(serifFont);
	    	g.drawString("CLEAR", 0, 50);
	    }
	    */
	    
	}
}
