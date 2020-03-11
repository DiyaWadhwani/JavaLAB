import java.util.*;

public class CreditException extends Exception
	{
		int msg;
		
		CreditException(int creds)
			{
				msg=creds;
			}
		public String toString()
			{
				return "Credits less than "+msg;
			}
	}
