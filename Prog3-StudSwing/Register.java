import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register implements ActionListener
	{
		JFrame details,text;
		JLabel namel,agel,usnl,catl,addrl;
		JLabel[] seml=new JLabel[8];
		JTextField namef,agef,usnf,catf,addrf;
		JTextField[] semf=new JTextField[8];
		JButton compute, display, done;
		JTextArea print;
		static Student stud=null;
		static ArrayList<Student> register;
		
		Register()
			{
				details=new JFrame("Enter details");
				text=new JFrame("Details");
				register=new ArrayList<Student>();
				
				namel=new JLabel("Enter name");
				agel=new JLabel("Enter age");
				usnl=new JLabel("Enter usn");
				catl=new JLabel("Enter category");
				addrl=new JLabel("Enter address");
				//JLabel[] seml=new JLabel[8];
				
				namef=new JTextField(20);
				agef=new JTextField(3);
				usnf=new JTextField(10);
				catf=new JTextField(15);
				addrf=new JTextField(25);
				//JTextField[] semf=new JTextField[8];
				print=new JTextArea();
				
				compute=new JButton("COMPUTE");
				display=new JButton("DISPLAY");
				done=new JButton("DONE");
				
				compute.addActionListener(this);
				display.addActionListener(this);
				done.addActionListener(this);
				done.setEnabled(false);
				
				details.add(namel);
				details.add(namef);
				details.add(agel);
				details.add(agef);
				details.add(usnl);
				details.add(usnf);
				details.add(catl);
				details.add(catf);
				details.add(addrl);
				details.add(addrf);
				
				for(int i=0;i<8;i++)
					{
						seml[i]=new JLabel("Enter sgpa for semester "+(i+1)+":");
						semf[i]=new JTextField(4);
						details.add(seml[i]);
						details.add(semf[i]);
					}
				
				details.add(compute);
				details.add(display);
				details.add(done);
				
				text.add(print);
			}
		
		public static void main(String[] args)
			{
				Register app=new Register();
				
				app.details.setVisible(true);
				app.details.setSize(600,400);
				app.details.setLayout(new GridLayout(15,2));
				
				app.text.setVisible(true);
				app.text.setSize(300,300);
			}
		
		public void actionPerformed(ActionEvent evt)
			{
				if(evt.getSource()==compute)
					{
						try
							{
								String name=namef.getText();
								int age=Integer.parseInt(agef.getText());
								String usn=usnf.getText();
								String cat=catf.getText();
								String addr=addrf.getText();
								float[] sgpa=new float[8];
								for(int i=0;i<8;i++)
									sgpa[i]=Float.parseFloat(semf[i].getText());
								
								stud=new Student(name,usn,age,cat,sgpa,addr);
								
								//print.setText(null);
								print.insert(stud.CalCgpa(),0);
								
								done.setEnabled(true);
							}
						catch (NumberFormatException e)
							{
								JOptionPane.showMessageDialog(details,"Invalid AGE or SGPA","Error",JOptionPane.ERROR_MESSAGE);
							}
					}
				if(evt.getSource()==display)
					{
						register.add(stud);
						done.setEnabled(true);
						print.setText(null);
						print.insert(stud.toString()+"\n"+stud.CalCgpa(),0);
					}
				if(evt.getSource()==done)
					{
						print.setText(null);
						if(register.isEmpty())
							print.insert("List is empty !",0);
						else
							{
								print.insert("Student details\n\n",0);
								for(Student s:register)
									print.append(s+"\n"+stud.CalCgpa()+"\n\n");
							}
					}
			}
	}