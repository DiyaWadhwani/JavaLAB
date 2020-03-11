import java.util.*;

public class Library
	{
		static HashMap<Integer,Book> lib=new HashMap<Integer,Book>();
		
		public static void main(String[]args)
			{
				lib.put(1, new Book("DBMS","Robert","Pearson",999.25));
				lib.put(2, new Book("Java","Capaldi","Blue Bird",1450.99));
				lib.put(4, new Book("DIP","Gabaldi","Pearson",865.55));
				lib.put(3, new Book("Falling Snow","Jane","Blue Bird",1350.65));
				Object[] libsort=lib.values().toArray();
				Arrays.sort(libsort);
				System.out.println("** Sorted list **");
				for(Object b:libsort)
					System.out.println(b+"\n");
				Scanner sc=new Scanner(System.in);
				while(true)
					{
						System.out.println("Search by:\n1.Title\n2.Author\n3.Publisher\n4.Price\nEnter your choice OR Enter 9 to go to next menu");
						int ch=sc.nextInt();
						switch(ch)
							{
								case 1: searchTitle();
										break;
								case 2: searchAuthor();
										break;
								case 3: searchPublisher();
										break;
								case 4: searchPrice();
										break;
								case 9: while(true)
											{
												System.out.println("a)Edit Publisher\nb)Exit\nEnter your choice :");
												char c=sc.next().charAt(0);
												switch(c)
													{
														case 'a': editPublisher();
																	break;
														case 'b': System.exit(0);
														default: System.out.println("Enter valid choice");
																	break;
													}
											}
								default: System.out.println("Enter valid choice !");
							}
					}
			}
		
		public static void searchTitle()
			{
				Scanner s=new Scanner(System.in);
				System.out.println("Enter Book Title:");
				String t=s.nextLine();
				Set<Map.Entry<Integer,Book>> booklist=lib.entrySet();
				for(Map.Entry<Integer,Book> x:booklist)
					{
						Book book=x.getValue();
						if(book.title.contains(t))
							System.out.println(book+"\n");
					}
			}
		
		public static void searchAuthor()
			{
				Scanner s=new Scanner(System.in);
				System.out.println("Enter Author Name:");
				String a=s.nextLine();
				Set<Map.Entry<Integer,Book>> booklist=lib.entrySet();
				for(Map.Entry<Integer,Book> x:booklist)
					{
						Book book=x.getValue();
						if(book.author.contains(a))
							System.out.println(book+"\n");
					}
			}
		
		public static void searchPublisher()
			{
				Scanner s=new Scanner(System.in);
				System.out.println("Enter Publisher Name:");
				String p=s.nextLine();
				Set<Map.Entry<Integer,Book>> booklist=lib.entrySet();
				for(Map.Entry<Integer,Book> x:booklist)
					{
						Book book=x.getValue();
						if(book.publisher.contains(p))
							System.out.println(book+"\n");
					}
			}
		
		public static void searchPrice()
			{
				Scanner s=new Scanner(System.in);
				System.out.println("Enter price:");
				double p=s.nextDouble();
				Set<Map.Entry<Integer,Book>> booklist=lib.entrySet();
				for(Map.Entry<Integer,Book> x:booklist)
					{
						Book book=x.getValue();
						if(book.price==p)
							System.out.println(book+"\n");
					}
			}
		
		public static void editPublisher()
			{
				Scanner s=new Scanner(System.in);
				System.out.println("Enter Title of Book :");
				String t=s.nextLine();
				Set<Map.Entry<Integer,Book>> booklist=lib.entrySet();
				for(Map.Entry<Integer,Book> x:booklist)
					{
						Book book=x.getValue();
						int bid=x.getKey();
						if(book.title.equals(t))
							{
								System.out.println("Enter new Publisher Name:");
								String p=s.nextLine();
								book.publisher=p;
								lib.put(bid,book);
								System.out.println("Updated:\n"+book+"\n");
							}
					}
			}
	}