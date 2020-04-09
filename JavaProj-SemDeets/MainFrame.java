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
	String[] sems = {"Semester 1","Semester 2","Semester 3","Semester 4","Semester 5","Semester 6","Semester 7","Semester 8","Supplementary Semester"};
	final JComboBox<String> branch_choice,sem_choice;
	JButton next1;
	
	JFrame frame1;
	JLabel coursel;
	//return courses from database as array
	String[] courses = {"JAVA","OOADP","CG","ML"};
	final JComboBox<String> course_choice;
	String course;
	JButton update,del;
	
	JFrame frame2;
	JLabel coursenamel,semesterl,typel,credsl;
	JTextField coursenamef,semesterf,credsf;
	String[] type = {"Mandatory","Elective"};
	final JComboBox<String> type_choice;
	
	
	
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
		final String course = course_choice.getSelectedItem().toString();
		System.out.println(course);
		update = new JButton("Update");
		del = new JButton("Delete");
		update.addActionListener(this);
		del.addActionListener(this);
		
		frame1.add(coursel);
		frame1.add(course_choice);
		frame1.add(update);
		frame1.add(del);
		
		frame2 = new JFrame("Update course details");
		coursenamel = new JLabel("Course name");
		coursenamef = new JTextField(20);
		semesterl = new JLabel("Semester");
		semesterf = new JTextField(20);
		typel = new JLabel("Sem Type");
		type_choice = new JComboBox<String>(type);
		credsl = new JLabel("Credits");
		credsf = new JTextField(2);
		
		
		
		frame2.add(coursenamel);
		frame2.add(typel);
		frame2.add(type_choice);
		
		
		
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
			
		}
		
		if(evt.getSource() == update)
		{
			frame1.dispose();
			UpdateDeets();
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
		frame2.setSize(800,200);
		frame2.setLayout(new GridLayout(3,8));
	}
}