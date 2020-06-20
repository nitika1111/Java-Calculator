package CalcApp;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Calc {
	//create frame and panel
	private static JFrame f;
	private static JPanel pNum;
	private static JPanel pText;
	public  static JPanel pRadio;
	public  static JPanel pOper;
	
	//create a Textbox
	static JTextArea text;

	//create all Common buttons to appear on calc screen 
	static JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bdot,be,bc; 
	//JRadioButton rbC,rbS;
	
	//create Operand and Operator vars
	static String opd1, opd2, opr;
	Container pane;
	
	public Calc() {
		f= new JFrame("My Calculator");
		f.setLayout(new GridBagLayout());
		pane = f.getContentPane();
		pNum= new JPanel();
		pText= new JPanel();
		pRadio= new JPanel();
		pOper= new JPanel();
		text= new JTextArea(2,5);
				
		
		//Create all Common Buttons
		createButtons();
		
		/*
		 * ButtonGroup bg= new ButtonGroup(); bg.add(rbC); bg.add(rbS);
		 */
		
		//Add Panels to frame
		addPanelsToPane();
		
		//Add components to JPanel
		addButtonsToPanel();
		
		//set Panel Configuration 
		setPOperConfig();
		setPNumConfig();
		setPTextConfig();
		setPRadioConfig();
		
		//Initialize Operands and Operators
		opd1= opd2= opr= "";
		
		
		// Set textarea config
		setTextareaConfig();
		
		//call go
		go();
		//set frame properties
		//f.setPreferredSize(new Dimension(500,650));				
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		f.pack();
		f.setVisible(true);
		 
	}
	private void go() {
		
	}
	private void addPanelsToPane() {
		//Container pane= f.getContentPane();
		GridBagConstraints c= new GridBagConstraints();
		
		//Common for all Panels
		c.fill= GridBagConstraints.HORIZONTAL;
		
		//For PText
		c.gridx= 0;
		c.gridy= 0;
		c.gridheight=2;
		c.gridwidth=5;
		pane.add(pText,c);
		
		//For PNum
		c.gridx= 0;
		c.gridy= 2;
		c.gridheight=4;
		c.gridwidth=3;
		pane.add(pNum,c);
		
		//For PRadio
		c.gridx= 3;
		c.gridy= 2;
		c.gridheight=1;
		c.gridwidth=2;
		pane.add(pRadio,c);		
			
	    //For POper 
		c.gridx= 3; 
		c.gridy= 3; 
		c.gridheight=3; 
		c.gridwidth=2;
		pane.add(pOper,c);
		 
	}
	private void addButtonsToPanel() {
		GridBagConstraints c= new GridBagConstraints();
		c.fill= GridBagConstraints.HORIZONTAL;
		pText.setLayout(new GridBagLayout());
		pText.add(text);
		
		//pNum
		pNum.setLayout(new GridBagLayout());
		c.gridx=0;
		c.gridy=0;
		pNum.add(b1,c);
		c.gridx=1;
		c.gridy=0;
		pNum.add(b2,c);
		c.gridx=2;
		c.gridy=0;
		pNum.add(b3,c);
		c.gridx=0;
		c.gridy=1;
		pNum.add(b4,c);
		c.gridx=1;
		c.gridy=1;
		pNum.add(b5,c);
		c.gridx=2;
		c.gridy=1;
		pNum.add(b6,c);
		c.gridx=0;
		c.gridy=2;
		pNum.add(b7,c);
		c.gridx=1;
		c.gridy=2;
		pNum.add(b8,c);
		c.gridx=2;
		c.gridy=2;
		pNum.add(b9,c);
		c.gridx=0;
		c.gridy=3;
		pNum.add(bdot,c);
		c.gridx=1;
		c.gridy=3;
		pNum.add(b0,c);
		c.gridx=2;
		c.gridy=3;
		pNum.add(be,c);
		
		pRadio.setLayout(new GridBagLayout());
		//pNum.add(bc);
		
		/*
		 * pRadio.setLayout(new GridBagLayout()); pRadio.add(rbC); pRadio.add(rbS);
		 */	}
	public JPanel getPOper() {
		return this.pOper;
	}
	public void setPOper(ArrayList<JButton> bList ) {
			System.out.println("At start of setOper()");
			//For POper
			GridBagConstraints c= new GridBagConstraints(); 
			pOper.setLayout(new GridBagLayout());
			c.fill= GridBagConstraints.HORIZONTAL;
			c.ipadx=3;
			c.ipady=3;
			c.gridx= 0;
			c.gridy= 0;
			pOper.add(bList.get(0),c);
			
			c.gridx= 1;
			c.gridy= 0;
			pOper.add(bList.get(1),c);
			
			c.gridx= 0;
			c.gridy= 1;
			pOper.add(bList.get(2),c);
			
			c.gridx= 1;
			c.gridy= 1;
			pOper.add(bList.get(3),c);
			
			c.gridx= 0;
			c.gridy= 2;
			pOper.add(bList.get(4),c);
			
			c.gridx= 1;
			c.gridy= 2;
			pOper.add(bList.get(5),c);		
			System.out.println("At end of setOper()");
		
	}
	
	private void setPOperConfig() {
		//pOper.setBackground(Color.LIGHT_GRAY);
		//Border pOperborder= BorderFactory.createLineBorder(Color.BLACK, 2);
		//pOper.setBorder(pOperborder);	
	}
	private void setPNumConfig() {
		//pNum.setBackground(Color.LIGHT_GRAY);
		//Border pNumborder= BorderFactory.createLineBorder(Color.BLACK, 2);
		//pNum.setBorder(pNumborder);
	}
	private void setPRadioConfig() {
		//pRadio.setBackground(Color.LIGHT_GRAY);
		//Border pRadioborder= BorderFactory.createLineBorder(Color.BLACK, 2);
		//pRadio.setBorder(pRadioborder);
	}
	private void setPTextConfig() {
		//pText.setBackground(Color.LIGHT_GRAY);
		//Border pTextborder= BorderFactory.createLineBorder(Color.BLACK, 2);
		//pText.setBorder(pTextborder);
	}
	private void createButtons() {
		b0= new JButton("0");
		b1= new JButton("1");
		b2= new JButton("2");
		b3= new JButton("3");
		b4= new JButton("4");
		b5= new JButton("5");
		b6= new JButton("6");
		b7= new JButton("7");
		b8= new JButton("8");
		b9= new JButton("9");
		bdot= new JButton(".");
		be= new JButton("=");
		bc= new JButton("Del");
		
		/*
		 * rbC= new JRadioButton("Classic",true); rbS= new JRadioButton("Scientific");
		 */	}
	
	private void setTextareaConfig() {
		text.setBackground(Color.DARK_GRAY);
		Font tfont= new Font("arial", Font.BOLD, 20);
		text.setFont(tfont);
		text.setEditable(false);
		text.setForeground(Color.WHITE);
		text.setLineWrap(true);
		//text.setPreferredSize(new Dimension(2,200));
	}	
}
