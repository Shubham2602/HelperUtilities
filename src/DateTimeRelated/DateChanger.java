package DateTimeRelated;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class DateChanger 
{
	DateFormat dateFormat;
	Date date = new Date();
	
	public String datechange()
	{
		dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		StringTokenizer st = new StringTokenizer(dateFormat.format(date)," ");
		return st.nextToken();
	}
	
	public String getDateAsString(String format)
	{
		String dateAsString="";
		dateFormat = new SimpleDateFormat(format);
		dateAsString = dateFormat.format(date);
	
		return dateAsString;
	}
	
	public static void main(String args[])
	{
		DateChanger dateChanger = new DateChanger();
		System.out.println(dateChanger.datechange());
		System.out.println(dateChanger.getDateAsString("dd-MM-yy"));
		System.out.println(dateChanger.getDateAsString("HH:mm:ss"));
	}
}
