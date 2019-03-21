package Lindco.Task;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Filehandler {

	public void fileWritter(String fileInput)
	{
		PrintWriter writer;
		try {
			writer = new PrintWriter("Lindco.json", "UTF-8");
			writer.println(fileInput);
			writer.close();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Date addMonths(String dateAsString, int nbMonths) throws ParseException {
		String format = "dd-MM-yyyy" ;
		SimpleDateFormat sdf = new SimpleDateFormat(format) ;
		Date dateAsObj = sdf.parse(dateAsString) ;
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateAsObj);
		cal.add(Calendar.MONTH, nbMonths);
		Date dateAsObjAfterAMonth = cal.getTime() ;
		return dateAsObjAfterAMonth ;

	}	

}
