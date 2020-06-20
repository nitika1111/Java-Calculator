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

public class ClassicCalc extends Calc implements ActionListener{
	
	JButton ba,bs,bm,bd,bbo,bbc;
	ArrayList<JButton> bList= new ArrayList<JButton>();
	
	public ClassicCalc() {
		//Create Buttons for Classic Operations
		createButtons();
		ButtonGroup bg= new ButtonGroup();
		bg.add(CalcApp.rbC);
		bg.add(CalcApp.rbS);

		//add components to Panel
		addButtonsToPanel();		
		
		
		//Call go() method for action listener
		go();
	}
	private void createButtons() {
		/*
		 * rbC= new JRadioButton("Classic",true); rbS= new JRadioButton("Scientific");
		 */

		ba= new JButton("+");
		bs= new JButton("-");
		bm= new JButton("*");
		bd= new JButton("/");
		bbo= new JButton("(");
		bbc= new JButton(")");
	}
	private void addButtonsToPanel() {
		pRadio.add(CalcApp.rbC);
		pRadio.add(CalcApp.rbS);

		
		bList.add(ba);
		bList.add(bs);
		bList.add(bm);
		bList.add(bd);
		bList.add(bbo);
		bList.add(bbc);
		
		setPOper(bList);
		
	} 
	//go() method
	
	private void go() { //add action calls on button click
		
		  b0.addActionListener(this); b1.addActionListener(this);
		  b2.addActionListener(this); b3.addActionListener(this);
		  b4.addActionListener(this); b5.addActionListener(this);
		  b6.addActionListener(this); b7.addActionListener(this);
		  b8.addActionListener(this); b9.addActionListener(this);
		  bdot.addActionListener(this); ba.addActionListener(this);
		  bs.addActionListener(this); bm.addActionListener(this);
		  bd.addActionListener(this); be.addActionListener(this);
		  bc.addActionListener(this);
		 
			 
	  }
	 
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

}
