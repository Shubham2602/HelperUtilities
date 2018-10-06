package AnytoPOJO;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JSONtoPOJO 
{

	public void jsonString(Employee employee) throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		
		employee = mapper.readValue(new File("employee.json"),
				Employee.class);
		
		
	}
}
