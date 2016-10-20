package Gradebook;
import java.lang.Math;
import java.util.ArrayList;


public class Student {
	private String fname;
	private String lname;
	private int stuID;
	private int credits;
	private Double GPA;
	
public Student (String fname, String lname, int stuID){
	this.fname = fname;
	this.lname = lname;
	this.stuID = stuID;
	this.credits = credits;
}

public String getName(String fname, String lname){
	String name = this.fname + " " + this.lname;
	return name;
}

public String getName(){
	return this.fname + " " + this.lname;
}

public void settName(String name) {
	String name_lst [] = name.split(" ");
	this.fname = name_lst[0];
	this.lname = name_lst[1];
}

public int getStudentID () {
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
		standing = "Freshmen";
	}
	else if (credits >= 30 && credits < 60) {
		standing = "Sophomore";
	}
	else if (credits >= 60 && credits < 90) {
		standing ="Junior";
	}
	else if (credits >= 90) {
		standing = "Senior";
	}
	return standing;
}

public void submitGrade(int g, int c) {
	int q_score = (int) (g * c);
	int qscore_total = 0;
	qscore_total += q_score;	
	this.GPA = (double) (qscore_total/this.credits);
	Math.rint(this.GPA);
}

public void submitGrade(Double g, int c) {
	int q_score = (int) (g * c);
	int qscore_total = 0;
	qscore_total += q_score;	
	this.GPA = (double) (qscore_total / credits);
	Math.rint(this.GPA);
}

public Student(Student one, Student two) {
	 this.fname = one.getName();
	 this.lname = two.getName();
	 this.stuID = one.getStudentID() + two.getStudentID();
	 this.GPA = (one.getGPA() + two.getGPA()) / 2;
	if (one.getCredits() > two.getCredits()){
		this.credits = one.getCredits();
	}
	else {
		this.credits = two.getCredits();
	}
}

public Student(Student one) {
	 this.fname = one.getName();
	 this.stuID = one.getStudentID();
	 this.GPA = one.getGPA();
	 this.credits = one.getCredits();
}

public Double computeTuition(){
	Double tution = this.credits * 0.00075;
	Math.rint(tution);
	return tution;
}

public Student createLegacy (Student one, Student two){
	Student child = new Student(one, two);
	return child;
}

public Student createLegacy (Student one){
	Student child = new Student(one);
	return child;
}

public String toString(){
	String ID = (String) stuID;
	return this.lname + "," + " " + this.fname + " " + ID;
}

}