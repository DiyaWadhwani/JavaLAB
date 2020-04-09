import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame implements ActionListener
{
	JFrame main;
	JLabel branchl,seml;
	String[] branches = {"Information Science and Engineering","Computer Science and Engineering","Industrial Engineering and Management","Electronics and Communication Engineering"};
	String[] sems = {"Semester 1","Semester 2","Semester 3","Semester 4","Semester 5","Semester 6","Semester 7","Semester 8"};
	final JComboBox<String> branch_choice,sem_choice;
	JButton next1;
	
	JFrame frame1;
	JLabel coursel; 
	//return courses from database as array
	String[] courses = {"JAVA","OOADP","CG","ML"};
	final JComboBox<String> course_choice;
	String course;
	JButton update,del,prev,subdeets;
	
	JFrame frame2;
	JLabel coursenamel,semesterl,typel,credsl;
	JTextField credsf;
	JTextArea coursenamef, semesterf;
	String[] type = {"Mandatory","Elective"};
	final JComboBox<String> type_choice;
	JButton confirm, cancel;
	
	JFrame frame3;
	JTextArea subjdet;
	
	MainFrame()
	{
		
		main = new JFrame("Welcome");
		branchl = new JLabel("Branch");
		branch_choice = new JComboBox<String>(branches);
		seml = new JLabel("Semester");
		sem_choice = new JComboBox<String>(sems);
		next1 = new JButton("NEXT");
		next1.addActionListener(this);
		
		main.add(branchl); 
		main.add(branch_choice);
		main.add(seml); 
		main.add(sem_choice);
		main.add(next1);
		
		
		frame1 = new JFrame("Available Courses");
		coursel = new JLabel("All courses");
		course_choice = new JComboBox<String>(courses);
		update = new JButton("Update");
		del = new JButton("Delete");
		prev = new JButton("Previous");
		subdeets = new JButton("Subject Details");
		update.addActionListener(this);
		del.addActionListener(this);
		prev.addActionListener(this);
		
		frame1.add(coursel);
		frame1.add(course_choice);
		frame1.add(update);
		frame1.add(del);
		frame1.add(prev);
		frame1.add(subdeets);
		
		
		frame2 = new JFrame("Update course details");
		coursenamel = new JLabel("Course name");
		coursenamef = new JTextArea();
		semesterl = new JLabel("Semester");
		semesterf = new JTextArea();
		typel = new JLabel("Sem Type");
		type_choice = new JComboBox<String>(type);
		credsl = new JLabel("Credits");
		credsf = new JTextField(2);
		confirm = new JButton("Confirm");
		cancel = new JButton("Cancel");
		confirm.addActionListener(this);
		cancel.addActionListener(this);
		
		frame2.add(coursenamel);
		frame2.add(coursenamef);
		coursenamef.setEnabled(false);
		frame2.add(semesterl);
		frame2.add(semesterf);
		semesterf.setEnabled(false);
		frame2.add(typel);
		frame2.add(type_choice);
		frame2.add(credsl);
		frame2.add(credsf);
		frame2.add(confirm);
		frame2.add(cancel);
		
		//add frame 3, text area with subject details
		//check total credits add upto 25
		
	}
	
	public static void main(String[] args)
	{
		MainFrame app = new MainFrame();
		app.main.setVisible(true);
		app.main.setSize(600,200);
		app.main.setLayout(new GridLayout(4,5));
		
		app.frame1.setVisible(false);
		app.frame2.setVisible(false);
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource() == next1)
		{
			main.dispose();
			courseFrame();
		}
		
		if(evt.getSource() == del)
		{
			int response = JOptionPane.showConfirmDialog(frame1,"Are you sure you want to delete ?","Delete ?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(response == JOptionPane.YES_OPTION)
			{
				//add function
			}
		}
		
		if(evt.getSource() == update)
		{
			frame1.dispose();
			String course = (String) course_choice.getSelectedItem();
			String sem = (String) sem_choice.getSelectedItem();
			coursenamef.setText(course);
			semesterf.setText(sem);
			UpdateDeets();
		}
		
		if(evt.getSource() == prev)
		{
			frame1.dispose();
			main.setVisible(true);
		}
		
		if(evt.getSource() == subdeets)
		{
			frame1.dispose();
			frame3.setVisible(true);
			DisplaySubDeets();
		}
		
		if(evt.getSource() == confirm)
		{
			try
			{
				int credits = Integer.parseInt(credsf.getText());
				if(credits <=0 || credits >6)
					throw new NumberFormatException();
				else
				{
					int response = JOptionPane.showConfirmDialog(frame2,"Are you sure you want to update and proceed ?","Save Changes ?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(response == JOptionPane.YES_OPTION)
					{
						//add function
					}
				}
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(frame2,"Invalid no. of Credits","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(evt.getSource() == cancel)
		{
			frame2.dispose();
			frame1.setVisible(true);
			courseFrame();
		}
	}

	public void courseFrame()
	{
		frame1.setVisible(true);
		frame1.setSize(800,200);
		frame1.setLayout(new GridLayout(3,8));
	}
	
	public void UpdateDeets()
	{
		frame2.setVisible(true);
		frame2.setSize(800,300);
		frame2.setLayout(new GridLayout(5,8));
	}
	
	public void DisplaySubDeets()
	{
		frame3.setVisible(true);
		frame3.setSize(800,200);
		frame3.setLayout(new GridLayout(5,8));
	}

}