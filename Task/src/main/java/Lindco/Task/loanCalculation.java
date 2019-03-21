package Lindco.Task;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class loanCalculation {

	public void loanCalculator(float loanAmount, float nominalInterestRate, float duration, String startDate) throws ParseException
	{
		String fileInput = "";
		int daysInMonth = 30;
		int daysInYear = 360;
		float remainingOutstandingPrincipal = loanAmount;
		float annuityPaymentAmount;
		float principal;
		float interest;
		float initialOutstandingPrincipal = loanAmount;
		float nominalRate = nominalInterestRate;
		float annuity = (initialOutstandingPrincipal / duration) * (1 + nominalRate);
		Boolean setcomma = false;
		Filehandler FH = new Filehandler();
		DateFormat dateFm = new SimpleDateFormat("dd-MM-yyyy");
		Date dateInc = dateFm.parse(startDate);
		SimpleDateFormat printFm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		String formattedDate = printFm.format(dateInc);

		do
		{	
			initialOutstandingPrincipal = remainingOutstandingPrincipal;
			interest = (nominalRate * daysInMonth * initialOutstandingPrincipal) / daysInYear;
			principal = annuity - interest;
			annuityPaymentAmount = principal + interest;
			remainingOutstandingPrincipal -= principal;

			if(remainingOutstandingPrincipal<0)
				break;

			if (setcomma)
			{
				fileInput = fileInput + ",";
				fileInput = fileInput + "\n";
			}
			setcomma = true;
			fileInput += "{";
			fileInput += "\n\"borrowerPaymentAmount:\" : " + "\""+ annuityPaymentAmount + "\"";
			fileInput += "\n\"Date\" : " + "\"" + formattedDate + "\"";
			fileInput += "\n\"initialOutstandingPrincipal\" : " + "\"" + initialOutstandingPrincipal + "\"";
			fileInput += "\n\"interest\" : " + "\"" + interest + "\"";
			fileInput += "\n\"principal\" : " + "\"" + principal + "\"";
			fileInput += "\n\"remainingOutstandingPrincipal\" : " + "\"" + remainingOutstandingPrincipal + "\"";	
			fileInput += "\n}";
			dateInc = FH.addMonths(startDate, 01);
			startDate = dateFm.format(dateInc);
			formattedDate = printFm.format(dateInc);
		} while (remainingOutstandingPrincipal - annuityPaymentAmount > 0);

		FH.fileWritter(fileInput);
	}

	
}
