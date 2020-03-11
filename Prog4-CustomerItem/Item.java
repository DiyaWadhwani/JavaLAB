import java.util.*;

public class Item
	{
		String id;
		String name;
		int cost;
		
		public Item(String i, String n, int c)
			{
				id=i;
				name=n;
				cost=c;
			}
		public String toString()
			{
				return "Item Details:\nID:"+id+"\nName:"+name+"\nCost:"+cost;
			}
	}
