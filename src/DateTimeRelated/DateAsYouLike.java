package DateTimeRelated;

import java.util.HashMap;
import java.util.Map;

public class DateAsYouLike 
{
	public Map<String,String> statementFragmenter(String statement)
	{
		int start=0;
		for(int i=0;i<statement.length();i++)
		{
			int ascii = statement.charAt(i);
			if(ascii>=48 && ascii<=57)
			{
				start = i;
				break;
			}
		}
		
		String yymmdd = statement.substring(start+2, start+8);
		String mmdd = statement.substring(start+8,start+12);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("yymmdd", yymmdd);
		map.put("mmdd", mmdd);
		
		return map;
	}
}
