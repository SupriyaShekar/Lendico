package Lindco.Task;
import Lindco.Task.loanCalculation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class payload {

	public static void main(String[] args) throws ParseException {

		float loanAmount;
		float nominalInterestRate;
		float duration;
		String startDate;

		loanAmount = Float.parseFloat(JOptionPane.showInputDialog( " Enter Loan Amount " ));
		nominalInterestRate = Float.parseFloat(JOptionPane.showInputDialog( " Enter nominalInterest " ));
		duration = Float.parseFloat(JOptionPane.showInputDialog( " Enter duration " ));
		startDate = JOptionPane.showInputDialog( " Enter startDate in dd-mm-yyyy" );
		
		loanCalculation LC = new loanCalculation();
		LC.loanCalculator(loanAmount, nominalInterestRate, duration, startDate);
		
		JOptionPane.showMessageDialog(null, "File Generated");
	}
	
}


