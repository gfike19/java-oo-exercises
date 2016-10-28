package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Javagram {

	private static Scanner scanner;

	public static void main(String[] args) {

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath = null;
		Picture picture = null;
		Scanner in = new Scanner(System.in);
		
		// prompt user for image to filter and validate input
		do {
			
			String imagePath = "path not set";
			
			// try to open the file
			try {
				
				System.out.println("Image path (relative to " + dir + "):");
				System.out.println("Enter the name of the image you wish to filter plus its extension");
				relPath = in.next();
				
//				String[] relPathParts = relPath.split(File.separator);
//				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));
				imagePath = dir + File.separator + relPath;
				
				
				picture = new Picture(imagePath);
				
			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		
		// TODO - prompt user for filter and validate input
		

		int choice1 = 0;
		do {
			choice1 = displayFilterMenu();
		try {
			getFilter(choice1);
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid choice, select another option");
		}
		} while (choice1  != 0 && choice1 != 1 && choice1 != 2);
		
		
		
		// TODO - pass filter ID int to getFilter, and get an instance of Filter back 
		Filter filter = getFilter(choice1);			

		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();
		
		System.out.println("Image successfully filtered");
		
		String fileName = "";
		// save image, if desired
//		System.out.println("Save as jpg or png file?");
//		String ext ="." + in.next();
		System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
		System.out.println("Enter the name you wish to save the image as and its extension");
		fileName = in.next();
		do{
		
		// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original
			System.out.println("Using this name will override the current image. Continue? (Y/N)");
			String dec = in.next();
			if (dec.equalsIgnoreCase("y")){
				String absFileName = dir + File.separator + fileName;
				processed.save(absFileName);
				System.out.println("Image saved to " + absFileName);
			} 
			if (dec.equalsIgnoreCase("n")){
				System.out.println("Enter a different name to save the image.");
				fileName = in.next();
			}
//			in.close();
		}while (fileName.equals(relPath));
		if (fileName.equals("exit")) {
			System.out.println("Image not saved");
		} else {
			String absFileName = dir + File.separator + fileName;
			processed.save(absFileName);
			System.out.println("Image saved to " + absFileName);
		}	
		
		// close input scanner
		in.close();
	}
	
	// TODO - refactor this method to accept an int parameter, and return an instance of the Filter interface
	// TODO - refactor this method to thrown an exception if the int doesn't correspond to a filter
	private static Filter getFilter(int choice) {
		ArrayList <Filter> test = new ArrayList<Filter>();
		BlueFilter b = new BlueFilter();
		InvertFilter inv = new InvertFilter();
		GreyscaleFilter g = new GreyscaleFilter();
		test.add(b);
		test.add(inv);
		test.add(g);
		if (choice == 0 || choice == 1 || choice == 2) {
			
		// TODO - create some more filters, and add logic to return the appropriate one
		return test.get(choice);
		}
		else {
			throw new IllegalArgumentException();
		}
		}
	
	private static int displayFilterMenu() {
		System.out.println("Enter the number of the filter you desire: ");
	System.out.println("1. Blue filter");
	System.out.println("2. Invert Filter");
	System.out.println("3. Grayscale filter");
	scanner = new Scanner(System.in);
	int choice = scanner.nextInt() - 1;
	return choice;
	}
	}
