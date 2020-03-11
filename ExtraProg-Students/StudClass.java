class Student
	{
		String name,usn,type,addr;
		int age;
		
		Student(String n, int a, String u, String t, String ad)
			{
				name=n;
				usn=u;
				age=a;
				type=t;
				addr=ad;
			}
		public String toString()
			{
				return "Name:"+name+"\nAge:"+age+"\nUSN:"+usn+"\nType:"+type+"\nAddress:"+addr;
			}
	}

class UGStudent extends Student
	{
		int creds,sem;
		
		UGStudent(String n, int a, String u, String t, int c, int s, String ad)
			{
				super(n,a,u,t,ad);
				creds=c;
				sem=s;
			}
		public void check() throws CreditException
			{
				try
					{
						if(type.equalsIgnoreCase("regular") || type.equalsIgnoreCase("ChangeOfBranch") && creds<200)
							throw new CreditException(creds);
						else if(type.equalsIgnoreCase("diploma") && creds<150)
							throw new CreditException(creds);
					}
				catch(CreditException e)
					{
						System.out.println(e);
					}
			}
		public String toString()
			{
				super.toString();
				return "Sem:"+sem+"\nCredits:"+creds;
			}
	}

class PGStudent extends Student
	{
		int creds,sem;
	
		PGStudent(String n, int a, String u, String t, int c, int s, String ad)
			{
				super(n,a,u,t,ad);
				creds=c;
				sem=s;
			}
		public void check() throws CreditException
			{
				try
					{
						if(type.equalsIgnoreCase("regular") || type.equalsIgnoreCase("ChangeOfBranch") && creds<200)
							throw new CreditException(creds);
						else if(type.equalsIgnoreCase("diploma") && creds<150)
							throw new CreditException(creds);
					}
				catch(CreditException e)
					{
						System.out.println(e);
					}
			}
		public String toString()
			{
				super.toString();
				return "Sem:"+sem+"\nCredits:"+creds;
			}
	}

public class StudClass
	{
		public static void main(String[]args) throws CreditException
			{
				UGStudent s1=new UGStudent("Yash",18,"1MS19IM055","ChangeOfBranch",200,2,"Bangalore");
				PGStudent s2=new PGStudent("Diya",20,"1MS17IS041","Regular",150,5,"Bahrain");
				s1.check();
				s2.check();
			}
	}
