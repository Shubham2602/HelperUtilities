package DateTimeRelated;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class DateChanger 
{
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	
	public String datechange()
	{
		StringTokenizer st = new StringTokenizer(dateFormat.format(date)," ");
		return st.nextToken();
	}
	
	public static void main(String args[])
	{
		DateChanger dateChanger = new DateChanger();
		System.out.println(dateChanger.datechange());
	}
}
