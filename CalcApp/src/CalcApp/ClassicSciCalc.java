package CalcApp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;

public class ClassicSciCalc extends Calc{
	
	JButton ba,bs,bm,bd,bbo,bbc;
	JButton bsin,bcosec,bcos,bsec,btan,bcot;

	ArrayList<JButton> bList= new ArrayList<JButton>();
	
	public ClassicSciCalc(char calcType) {
		//Create Buttons for Classic Operations
		createButtons();
		ButtonGroup bg= new ButtonGroup();
		bg.add(CalcApp.rbC);
		bg.add(CalcApp.rbS);

		//add components to Panel
		pRadio.add(CalcApp.rbC);
		pRadio.add(CalcApp.rbS);

		addClassicButtonsToPanel(); 

		/*
		 * if(calcType=='C') addClassicButtonsToPanel(); else if (calcType=='S')
		 * addSciButtonsToPanel();
		 */		 
		
		//Call go() method for action listener
		go();
	}
	void createButtons() {
		// Classic Buttons
		ba= new JButton("+");
		bs= new JButton("-");
		bm= new JButton("*");
		bd= new JButton("/");
		bbo= new JButton("(");
		bbc= new JButton(")");
		
		//Scientific Buttons
		bsin= new JButton("Sin");
		bcosec= new JButton("Cosec");
		bcos= new JButton("Cos");
		bsec= new JButton("Sec");
		btan= new JButton("Tan");
		bcot= new JButton("Cot");

	}
	void addClassicButtonsToPanel() {
		System.out.println("in addClassicButtonsToPanel");
		bList.add(ba);
		bList.add(bs);
		bList.add(bm);
		bList.add(bd);
		bList.add(bbo);
		bList.add(bbc);
		setPOper(bList);
	} 
	void addSciButtonsToPanel() {
		System.out.println("in addSciButtonsToPanel");
		bList.add(bsin);
		bList.add(bcosec);
		bList.add(bcos);
		bList.add(bsec);
		bList.add(btan);
		bList.add(bcot);
		setPOper(bList);		
	} 
	//go() method
	
	private void go() { //add action calls on button click
		ActionListener RListener = new RadioListener();
		CalcApp.rbC.addActionListener(RListener);
		CalcApp.rbS.addActionListener(RListener);
		
		
		ActionListener CListener = new ClassicListener();
		ActionListener SListener = new SciListener();
		
		b0.addActionListener(CListener); b1.addActionListener(CListener);
		b2.addActionListener(CListener); b3.addActionListener(CListener);
		b4.addActionListener(CListener); b5.addActionListener(CListener);
		b6.addActionListener(CListener); b7.addActionListener(CListener);
		b8.addActionListener(CListener); b9.addActionListener(CListener);
		bdot.addActionListener(CListener); ba.addActionListener(CListener);
		bs.addActionListener(CListener); bm.addActionListener(CListener);
		bd.addActionListener(CListener); be.addActionListener(CListener);
		bc.addActionListener(CListener); bsin.addActionListener(CListener);
		bsec.addActionListener(SListener); bcos.addActionListener(SListener);
		bcosec.addActionListener(SListener); btan.addActionListener(SListener);		
		bcot.addActionListener(SListener);
	  }
	
	class RadioListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Classic")) {
				//ClassicCalc cCal = new ClassicCalc();
				System.out.println("In if of Radiolistener");
				addClassicButtonsToPanel();
				}
			else if (e.getActionCommand().equals("Scientific")) {
				//SciCalc sCal = new SciCalc();
				System.out.println("In else of Radiolistener");
				addSciButtonsToPanel();
				}
		}
	}
	class ClassicListener implements ActionListener{
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		//Store value of button pressed 
		String c= e.getActionCommand();
		Double res=0.0;
		// check if button pressed is Operand or Operator or EqualTo
		if((c.charAt(0)>='0'&&c.charAt(0)<='9')||c.charAt(0)=='.') {
			//Operand Entered
			if(opr.equals("")) {
				opd1+=c;
			}
			else 
				opd2+=c;
			text.setText(opd1+opr+opd2);
		}
		else if(c.charAt(0)=='+' ||c.charAt(0)=='-'||c.charAt(0)=='*'||c.charAt(0)=='/') {
			//Operator Entered
			eval(c,res);
		}
		else if(c.charAt(0)=='=') {
			//EqualTo Entered
			if(opr=="+") {
				res= Double.parseDouble(opd1) + Double.parseDouble(opd2);
				//text.setText(res+"");
				opd1= Double.toString(res);
				opd2= "";
				opr= "";
				text.setText(opd1+opr+opd2);
			}
			else if(opr=="-") {
				res= Double.parseDouble(opd1) - Double.parseDouble(opd2);
				//text.setText(res+"");
				opd1= Double.toString(res);
				opd2= "";
				opr= "";
				text.setText(opd1+opr+opd2);
			}
			else if(opr=="*") {
				res= Double.parseDouble(opd1) * Double.parseDouble(opd2);
				//text.setText(res+"");
				opd1= Double.toString(res);
				opd2= "";
				opr= "";
				text.setText(opd1+opr+opd2);
			}
			else if(opr=="/") {
				res= Double.parseDouble(opd1) / Double.parseDouble(opd2);
				text.setText(res+"");
				opd1= Double.toString(res);
				opd2= "";
				opr= "";
				text.setText(opd1+opr+opd2);
			}
		}
		else {
			opd1=opd2=opr="";
			text.setText("");
		}		
	}
	}
	
	public void eval(String c,Double res) {
		if(opd1.equals("")) {
			text.setText(opd1+opr+opd2);
		}
		else if(opd2.equals("")) {
			opr=c; 
			text.setText(opd1+opr+opd2);
		}
		else {
			if(opr=="+") {
				res= Double.parseDouble(opd1) + Double.parseDouble(opd2);
				opd1= res+"";
				opd2= "";
				opr=c;
				text.setText(opd1+opr+opd2);
				
			}
			else if(opr=="-") {
				res= Double.parseDouble(opd1) - Double.parseDouble(opd2);
				opd1= res+"";
				opd2= "";
				opr=c;
				text.setText(opd1+opr+opd2);
			}
			else if(opr=="*") {
				res= Double.parseDouble(opd1) * Double.parseDouble(opd2);
				opd1= res+"";
				opd2= "";
				opr=c;
				text.setText(opd1+opr+opd2);
			}
			else if(opr=="/") {
				res= Double.parseDouble(opd1) / Double.parseDouble(opd2);
				opd1= res+"";
				opd2= "";
				opr=c;
				text.setText(opd1+opr+opd2);			
			}
		}
		
	}
	
	class SciListener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		//Store value of button pressed 
		String c= e.getActionCommand();
		Double res=0.0;
		// check if button pressed is Operand or Operator or EqualTo
		if((c.charAt(0)>='0'&&c.charAt(0)<='9')||c.charAt(0)=='.') {
			//Operand Entered
			if(opr.equals("")) {
				//opd1+=c; // Do nothing if opr not selected
			}
			else 
				opd2+=c;
			text.setText(opr+opd2);
		}
		else if(c.equals("Sin") ||c.equals("Cos")||c.equals("Tan")||c.equals("Cosec")||c.equals("Sec")||c.equals("Cot")){
			//Operator Entered
			opr=c;
			opd2="";
			text.setText(opr);
		}
		else if(c.charAt(0)=='=') {
			//System.out.println("In = Condition");	
			//EqualTo Entered
			if(!opd2.equals("")) {
			if(opr.equals("Sin")) {
				res= Math.sin(Double.parseDouble(opd2));
				text.setText(Double.toString(res));
				opd2= "";
				opr= "";
			}
			else if(opr=="Cos") {
				res= Math.cos(Double.parseDouble(opd2));
				text.setText(Double.toString(res));
				opd2= "";
				opr= "";
			}
			else if(opr=="Tan") {
				res= Math.tan(Double.parseDouble(opd2));
				text.setText(Double.toString(res));
				opd2= "";
				opr= "";
			}
			else if(opr=="Cosec") {
				res= 1/ Math.sin(Double.parseDouble(opd2));
				text.setText(Double.toString(res));
				opd2= "";
				opr= "";
			}
			else if(opr=="Sec") {
				res= 1/Math.cos(Double.parseDouble(opd2));
				text.setText(Double.toString(res));
				opd2= "";
				opr= "";
			}
			else if(opr=="Cot") {
				res= 1/Math.tan(Double.parseDouble(opd2));
				text.setText(Double.toString(res));
				opd2= "";
				opr= "";
			}
		}
		else {
			opd1=opd2=opr="";
			text.setText("");
		}
		}
	}	
}
}
