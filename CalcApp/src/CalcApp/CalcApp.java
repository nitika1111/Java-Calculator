package CalcApp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class CalcApp{
	public static JRadioButton rbC = new JRadioButton("Classic",true);
	public static JRadioButton rbS = new JRadioButton("Scientific");
	public static char calcType='C';
	public ClassicSciCalc csCal;
	
	public CalcApp() {
		csCal = new ClassicSciCalc(calcType);
	}
	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
		CalcApp Cal= new CalcApp();
	}
}
