package CalcApp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

public class SciCalc extends Calc implements ActionListener{
	
	JButton bsin,bcosec,bcos,bsec,btan,bcot;
	ArrayList<JButton> bList= new ArrayList<JButton>();
	
	public SciCalc() {
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
		bsin= new JButton("Sin");
		bcosec= new JButton("Cosec");
		bcos= new JButton("Cos");
		bsec= new JButton("Sec");
		btan= new JButton("Tan");
		bcot= new JButton("Cot");
	}
	private void addButtonsToPanel() {
		pRadio.add(CalcApp.rbC);
		pRadio.add(CalcApp.rbS);

		bList.add(bsin);
		bList.add(bcosec);
		bList.add(bcos);
		bList.add(bsec);
		bList.add(btan);
		bList.add(bcot);
		
		setPOper(bList);
		
	} 
	//go() method
	private void go() {
		//add action calls on button click
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bdot.addActionListener(this);
		be.addActionListener(this);
		bsin.addActionListener(this);
		bsec.addActionListener(this);
		bcos.addActionListener(this);
		bcosec.addActionListener(this);
		btan.addActionListener(this);		
		bcot.addActionListener(this);
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
