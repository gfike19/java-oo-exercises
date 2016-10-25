package javagram.filters;

import java.util.Scanner;

import javagram.Picture;

public interface Filter {

	Picture process(Picture original);
	Scanner in = new Scanner(System.in);
	
	public static int displayFilterMenu() {
		System.out.println("1. Blue filter");
		int choice = in.nextInt();
		return choice;
		}
	
	
}