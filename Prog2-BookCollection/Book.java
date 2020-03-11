public class Book implements Comparable <Book>
	{
		String title,author,publisher;
		double price;
		
		Book(String t, String a, String pub, double pr)
			{
				title=t;
				author=a;
				publisher=pub;
				price=pr;
			}
		
		public String toString()
			{
				return "Title : "+title+"\nAuthor : "+author+"\nPublisher : "+publisher+"\nPrice : Rs."+price;
			}
		
		public int compareTo(Book bk)
			{
				return (int)(this.price-bk.price);
			}
	}
