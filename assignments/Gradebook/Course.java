package Gradebook;

import java.util.ArrayList;

public class Course {
	private String name;
	private int seats;
	private ArrayList<Student> roster = new ArrayList<Student>();
	private int cnum;
	private int credits;

	public Course(String name, int credits, int seats) {
		this.name = name;
		this.setCredits(credits);
		this.cnum = 0;
		this.seats = seats;
	}

	public boolean addStudent(Student s) {
		if (seats == 0 ){
			return false;
		}
		if (!roster.contains(s)) {
			roster.add(s);
		} this.seats = seats - 1;
		return true;
	}

	public String generateRoster() {
		String roster_str = "";
		for (Student i : this.roster) {
			String i_name = i.getName();
			roster_str = i_name + "\n";
		}
		return roster_str;
	}

	public double averageGPA() {
		double total_GPA = 0.0;
		int divisor = roster.size();
		for (Student s : roster) {
			total_GPA += s.getGPA();
		}
		return total_GPA / divisor;
	}

	public String toString() {
		String course_num = "" + cnum;
		return this.name + " " + course_num;
	}

	public String getName() {
		return this.name;
	}

	public int getRemainingSeats() {
		return this.seats;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}
}
