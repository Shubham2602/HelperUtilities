package DateTimeRelated;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class DateChanger 
{
	public String datechange()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		StringTokenizer st = new StringTokenizer(dateFormat.format(date)," ");
		return st.nextToken();
	}
}
