package Gradebook;
import java.util.ArrayList;

public class Course {
	private String name;
	private int credits;
	private int rem_seats;
	private ArrayList <Student> roster = new ArrayList<Student>();
	private int cnum;
//	private double total_GPA = 0 ; don't add stuff to a class if you don't need it
	
	public Course (String name, int credits, int rem_seats) {
		this.name = name;
		this.credits = credits;
		this.cnum = 0;
		this.rem_seats = rem_seats;
//		this.total_GPA = 0.0;
	}
	
	public boolean addStudent(Student s) {
		for (Student stu : roster) {
			if (s.getName() == stu.getName()){
				return false;
			}
			}
		if (this.rem_seats > 0) {
			roster.add(s);
			this.rem_seats -= 1;
			return true;
		}
		return false;
	}
	
	public String generateRoster(){
		String roster_str = "";
		for (Student i : roster) {
			String i_name = i.getName();
			roster_str = i_name + "\n";
		}
		return roster_str;
	}
	
	public Double averageGPA() { 
		double total_GPA = 0.0;
		for (Student s : roster) {
			total_GPA += s.getGPA();
		}
		return total_GPA / this.roster.size();
	}
	
	public String toString() {
		String course_num = "" + cnum;
		return this.name + " " + course_num;
	}
	
	public void setRemainingSeats(int rem_seats){
		this.rem_seats = rem_seats;
	}
	
	public int getRemainingSeats(){
		return this.rem_seats;
	}
	
	public String getName(){
		return this.name;
	}
}
