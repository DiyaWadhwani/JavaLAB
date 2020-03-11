import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckOut extends JFrame implements ActionListener
	{
		String username="heyitsme", password="xyz123";
		JLabel custphl,custidl,custphnuml,itemidl,itemqtyl,itemnamel,totpricel;;
		JTextField custphf,itemidf,itemqtyf;
		JTextArea custida,custphnuma,itemnamea,totpricea;
		JButton go,check,pay;
		JFrame cart;
		double price;
		Integer[] discount= {0,10,20,50};
		HashMap<Long,String> customers=new HashMap<Long,String>();
		ArrayList<Item> items=new ArrayList<Item>();
		
		CheckOut()
			{
				super("Checkout");
				while(true)
					{
						String uname=JOptionPane.showInputDialog(this,"Enter username","Login",JOptionPane.INFORMATION_MESSAGE);
						if(uname.equals(username))
							{
								String pass=JOptionPane.showInputDialog(this,"Enter password","Login",JOptionPane.INFORMATION_MESSAGE);
								if(pass.equals(password))
									break;
								else
									JOptionPane.showMessageDialog(this,"Invalid Password","Login Failed",JOptionPane.ERROR_MESSAGE);
							}
						else
							JOptionPane.showMessageDialog(this,"Invalid Username","Login Failed",JOptionPane.ERROR_MESSAGE);
					}
				custphl=new JLabel("Enter phone number:");
				custphf=new JTextField(20);
				go=new JButton("GO");
				add(custphl);
				add(custphf);
				add(go);
				go.addActionListener(this);
				
				cart=new JFrame("Cart");
				
				customers.put((long)7022769406L,"Diya2399");
				customers.put((long)7022375151L,"Yash2201");
				customers.put((long)9845198809L,"Soni2164");
				customers.put((long)9900750507L,"Ronak0699");
				
				items.add(new Item("i01","Lamp",299));
				items.add(new Item("i02","Wall Clock",499));
				items.add(new Item("i03","Curtains",999));
				
				custidl=new JLabel("Customer id");
				custida=new JTextArea(20,2);
				custphnuml=new JLabel("Phone number");
				custphnuma=new JTextArea(20,2);
				itemidl=new JLabel("Enter item id");
				itemidf=new JTextField(20);
				itemqtyl=new JLabel("Enter item quantity");
				itemqtyf=new JTextField(20);
				itemnamel=new JLabel("Item name");
				itemnamea=new JTextArea(20,2);
				totpricel=new JLabel("Total Price");
				totpricea=new JTextArea(20,2);
				
				check=new JButton("CHECK");
				pay=new JButton("PAY");
				check.addActionListener(this);
				pay.addActionListener(this);
				
				cart.add(custidl);
				cart.add(custida);
				custida.setEnabled(false);
				cart.add(custphnuml);
				cart.add(custphnuma);
				custphnuma.setEnabled(false);
				cart.add(itemidl);
				cart.add(itemidf);
				cart.add(itemqtyl);
				cart.add(itemqtyf);
				cart.add(itemnamel);
				cart.add(itemnamea);
				itemnamea.setEnabled(false);
				cart.add(totpricel);
				cart.add(totpricea);
				totpricea.setEnabled(false);
				cart.add(check);
				cart.add(pay);
				pay.setEnabled(false);	
				
				cart.setSize(800,800);
				cart.setLayout(new GridLayout(15,2));
			}
		
		public static void main(String[]args)
			{
				CheckOut app=new CheckOut();
				app.setVisible(true);
				app.setSize(500,200);
				app.setLayout(new GridLayout(4,1));
			}
		
		public void actionPerformed(ActionEvent evt)
			{
				if(evt.getSource()==go)
					{
						long number=Long.parseLong(custphf.getText());
						String cid;
						if(!customers.containsKey(number))
							{
								cid=JOptionPane.showInputDialog(this,"Enter customer id","New entry",JOptionPane.QUESTION_MESSAGE);
								customers.put(number,cid);
							}
						else
							cid=customers.get(number);
						this.setVisible(false);
						custida.setText(cid);
						custphnuma.setText(number+"");
						cart.setVisible(true);
					}
				if(evt.getSource()==check)
					{
						String itid=itemidf.getText();
						int qty=Integer.parseInt(itemqtyf.getText());
						Item i=null;
						boolean flag=false;
						for(Item x:items)
							{
								if(x.id.equals(itid))
									{
										i=x;
										flag=true;
										break;
									}
							}
						if(flag)
							{
								itemnamea.setText(i.name);
								price=(qty*i.cost);
								totpricea.setText("Rs "+price);
								pay.setEnabled(true);
							}
						else
							{
								itemnamea.setText("Invalid item");
								totpricea.setText("Invalid");
								pay.setEnabled(false);
							}
					}
				if(evt.getSource()==pay)
					{
						int d1=JOptionPane.showOptionDialog(cart,"Enter discount","Offer",0,JOptionPane.INFORMATION_MESSAGE,null,discount,discount[0]);
						JOptionPane.showMessageDialog(cart,"Amount to be paid : Rs. "+(price-(price*discount[d1]/100)),"Bill",JOptionPane.INFORMATION_MESSAGE);
						cart.setVisible(false);
						this.setVisible(true);
					}
			}
	}