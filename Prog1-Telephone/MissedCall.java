import java.time.*;

public class MissedCall
	{
		String name;
		LocalTime time;
		long phnum;
		
		MissedCall(String n, LocalTime t, long num)
			{
				time=t;
				name=n;
				phnum=num;
			}
		
		public String toString()
			{
				return "Missed Call Details\nName: "+name+"\nPhone number: "+phnum+"\nTime: "+time;
			}
	}
