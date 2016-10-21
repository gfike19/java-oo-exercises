package Gradebook;
import java.util.ArrayList;

public class Course {
	private String name;
	private int credits;
	private int rem_seats;
	private ArrayList <Student> roster = new ArrayList<Student>();
	private int cnum;
	
	public Course (String name, int credits, int cnum) {
		this.name = name;
		this.credits = credits;
//		this.rem_seats = rem_seats;
//		this.roster = roster;
		this.cnum = cnum;
		rem_seats = 0;
	}
	
	public Boolean addStudent(Student s) {
		if (rem_seats == 0){
			return false;
		}
		for(Student temp : roster) {
			String temp_name = temp.getName();
			String s_name = s.getName();
			if(!temp_name.equalsIgnoreCase(s_name)) {
				roster.add(s);
				rem_seats -= 1;
			}
		}
		return true;
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
		int j = 0;
		double total_GPA = 0.0;
		for(Student i : roster) {
			Double iGPA = i.getGPA();
			total_GPA += iGPA;
			j = j + 1;
		}
		double avg_GPA = total_GPA / j;
		return avg_GPA;
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
