import java.util.*;
import java.time.*;

public class RecieveClass
	{
		static HashMap<Long,String> contacts=new HashMap<Long,String>();
		static ArrayList<MissedCall> missed=new ArrayList<MissedCall>();
		static Scanner sc=new Scanner(System.in);
		static long del=0;
		
		public static void main(String[] args)
			{
				contacts.put((long)9845198809l,"SoniMasi");
				contacts.put((long)7022375151l,"Yashu");
				contacts.put((long)9900750507l,"Ronax");
				contacts.put((long)7022769406l,"Deeeyah");
				contacts.put((long)702235419l,"Mama");
				contacts.put((long)977760546l,"unknown");
				while(true)
					{
						System.out.println("\n1.Send call\n2.Delete from contacts\n3.Display\n4.Exit\nEnter your choice:");
						int ch=sc.nextInt();
						switch(ch)
							{
								case 1: simulateMissedCall();
										break;
								case 2: deleteContact();
										break;
								case 3: displayCallList();
										break;
								case 4: System.exit(0);
								default: System.out.println("Enter valid choice !!");
										break;
							}
					}
			}
		
		static void simulateMissedCall()
			{	
				System.out.println("Enter number :");
				long num=sc.nextLong();
				LocalTime now=java.time.LocalTime.now();
				String n;
				if(missed.size()<10)
					{
						if(contacts.containsKey(num))
							n=contacts.get(num);
							//missed.add(new MissedCall(contacts.get(num),now,num));
						else
							n="Private Caller";
							//missed.add(new MissedCall("Private caller",now,num));
						MissedCall m=new MissedCall(n,now,num);
						missed.add(m);
					}
				else
					{
						missed.remove(0);
						if(contacts.containsKey(num))
							n=contacts.get(num);
							//missed.add(new MissedCall(contacts.get(num),now,num));
						else
							n="Private Caller";
							//missed.add(new MissedCall("Private caller",now,num));
						MissedCall m=new MissedCall(n,now,num);
						missed.add(m);
					}
			}
		
		static void deleteContact()
			{
				System.out.println("Enter number to delete :");
				long pno=sc.nextLong();
				if(contacts.containsKey(pno))
					contacts.remove(pno);
			}
		
		static void displayCallList()
			{
				for(MissedCall obj:missed)
					{
						System.out.println(obj.phnum);
						System.out.println("\na)Display next\nb)Delete call\nc)Display Details\nd)Exit\nEnter your choice:");
						char op=sc.next().charAt(0);
						switch(op)
							{
								case 'a': continue;
								case 'b': System.out.println(obj.phnum+" is deleted");
											deleteCall(obj);
											break;
								case 'c': System.out.println(obj);
											break;
								case 'd': System.exit(0);
								default: System.out.println("Enter valid choice !");
							}
						System.out.println("\n");
					}
			}
		
		static void deleteCall(MissedCall obj)
			{
				if(missed.contains(obj))
					missed.remove(obj);
			}
	}
