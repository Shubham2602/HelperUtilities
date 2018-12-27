import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import DateTimeRelated.DateAsYouLike;
import Resources.DBCOnn;

public class PranayRunner 
{
	public static void main(String args[])throws Exception
	{
		List<String> mainlist = new ArrayList<String>();
		
		//part1 and part2
		DBCOnn db = new DBCOnn();
		String statement = db.connect("select st from statement where uniq=''");
		//part3
		String debit = db.connect("select blah from blah where uniq=''");
		//part4
		String amount = db.connect("select blamount from blamount where uniq=''");
		
		StringBuffer stringBuffer = new StringBuffer();
			
			DateAsYouLike dt = new DateAsYouLike();
			Map<String,String> map = dt.statementFragmenter(statement);
			
			stringBuffer.append(map.get("yymmdd"));
			stringBuffer.append(map.get("mmdd"));
			stringBuffer.append(debit);
			stringBuffer.append(amount);
	
			String finalStr = stringBuffer.toString();
			
			mainlist.add(finalStr);

	}
		
}
