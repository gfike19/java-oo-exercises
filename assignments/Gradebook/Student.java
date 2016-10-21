package Gradebook;

import java.lang.Math;

public class Student {
	private String fname;
	private String lname;
	private int stuID;
	private int credits;
	private Double GPA;

	public Student(String fname, String lname, int stuID) {
		this.fname = fname;
		this.lname = lname;
		this.stuID = stuID;
		this.credits = 0;
		this.GPA = 0.0;
	}

	public String getName(String fname, String lname) {
		String name = this.fname + " " + this.lname;
		return name;
	}

	public String getName() {
		return this.fname + " " + this.lname;
	}

	public int getStudentID() {
		return this.stuID;
	}

	public Double getGPA() {
		return this.GPA;
	}

	public int getCredits() {
		return this.credits;
	}

	public String getClassStanding() {
		String standing = "";
		if (credits < 30) {
			standing = "Freshman";
		} else if (credits >= 30 && credits < 60) {
			standing = "Sophomore";
		} else if (credits >= 60 && credits < 90) {
			standing = "Junior";
		} else if (credits >= 90) {
			standing = "Senior";
		}
		return standing;
	}

	public void submitGrade(double g, int c) {
		double q_score = g * c;
		double qscore_total = (this.GPA * credits);
		qscore_total += q_score;
		this.credits += c;
		this.GPA = (double) (qscore_total / this.credits);
		this.GPA = Math.round(this.GPA * 1000) / 1000.0;
	}

	public Student(Student one, Student two) {
		fname = one.getName();
		lname = two.getName();
		stuID = one.getStudentID() + two.getStudentID();
		GPA = (one.getGPA() + two.getGPA()) / 2;
		if (one.getCredits() > two.getCredits()) {
			credits = one.getCredits();
		} else {
			credits = two.getCredits();
		}
	}

    public double computeTuition() {
        int num_sem = credits / 15; //since a full semester is 20k
        int extra_cred = credits % 15;
        double tuition = num_sem * 20000;
        tuition += (int)(1333.33 * extra_cred * 100) / 100.0;
        return tuition;
    }

	public Student createLegacy(Student one, Student two) {
		Student child = new Student(one, two);
		return child;
	}

	public String toString() {
		String ID = "" + stuID;
		return this.lname + "," + " " + this.fname + " " + ID;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

}
