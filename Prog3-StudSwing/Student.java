import java.util.*;
import javax.swing.*;

public class Student
	{
		String name,usn,addr,cat;
		int age;
		float[] sgpa=new float[8];
		float cgpa;
		
		Student(String n, String u, int a, String c, float s[], String ad)
			{
				name=n;
				usn=u;
				age=a;
				cat=c;
				sgpa=s;
				addr=ad;
			}
		
		public String CalCgpa()
			{
				float sum=0;
				for(float s:sgpa)
					sum+=s;
				cgpa=sum/8;
				return "CGPA :"+cgpa;
			}
		
		public String toString()
			{
				return "Name:"+name+"\nUSN:"+usn+"\nAge:"+age+"\nCategory:"+cat+"\nAddress:"+addr;
			}
	}
