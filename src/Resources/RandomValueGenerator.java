package Resources;

import java.util.Random;

public class RandomValueGenerator 
{
	public long generate(int digits)
	{
		Random random = new Random();
		long val = 0;
		for(int i=0;i<digits;i++)
		{
			
			val = (long) (val + Math.pow(10, i)*random.nextInt(9));
		}
		return val;
	}
}
