package javagram.filters;

import java.awt.Color;
import java.util.ArrayList;

import javagram.Picture;

public class BlurFilter implements Filter {
	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
//think in terms of the Cartesian plane, left is negative x, right positive, up is positive, down is negative
	    	  Color center = original.get(i, j);
	    	  Color right = null;
	    	  if(i + 1 > original.width()) {
	    		  right = null;
	    	  } else {
	    		  right = original.get(i + 1,j); 
	    	  }
	    	  
	    	  if (i - 1 < original.width()) {
	    		  Color left = original.get(i, j);
	    	  } else {
	    		  Color left = original.get(i - 1, j);
	    	  }
	    	  
	    	  if (j + 1 > original.height()) {
	    		  Color top = original.get(i, j);
	    	  } else {
	    		  Color top = original.get(i,  j + 1);
	    	  }
	    	  
	    	  if (j - 1 < original.height()) {
	    		  Color bottm = original.get(i, j);
	    	  } else {
	    		  Color bottm = original.get(i,  j -1);
	    	  }
	    	  
	    	  
//I decided to put each of the RGB values for each pixel as their own ArrayList so that way it wouldn't get 
	    	  //too confusing
	    	  ArrayList <Integer> center_vals = new ArrayList<Integer>();
	    	  ArrayList <Integer> right_vals = new ArrayList<Integer>();
	    	  ArrayList <Integer> left_vals = new ArrayList<Integer>();
	    	  ArrayList <Integer> top_vals = new ArrayList<Integer>();
	    	  ArrayList <Integer> bottm_vals = new ArrayList<Integer>();
//multiply the values by the corresponding number, 8 for center, 3 for everywhere else
	    	  center_vals.add(center.getRed() * 8);
	    	  center_vals.add(center.getGreen() * 8);
	    	  center_vals.add(center.getBlue() * 8);
	    	  
	    	  
			right_vals.add(right.getRed() * 3);
	    	  right_vals.add(right.getGreen() * 3);
	    	  right_vals.add(right.getBlue() * 3);
	    	  
	    	  Color left;
			left_vals.add(left.getRed() * 3);
	    	  left_vals.add(left.getGreen() * 3);
	    	  left_vals.add(left.getBlue() * 3);
	    	  
	    	  Color top;
			top_vals.add(top.getRed() * 3);
	    	  top_vals.add(top.getGreen() * 3);
	    	  top_vals.add(top.getBlue() * 3);
	    	  
	    	  Color bottm;
			bottm_vals.add(bottm.getRed() * 3);
	    	  bottm_vals.add(bottm.getGreen() * 3);
	    	  bottm_vals.add(bottm.getBlue() * 3);
//now it's time to divide each list of RGB by 20
	    	  int new_r = (center_vals.get(0) + right_vals.get(0) + left_vals.get(0) + top_vals.get(0) + bottm_vals.get(0)) / 20;
	    	  int new_g = (center_vals.get(1) + right_vals.get(1) + left_vals.get(1) + top_vals.get(1) + bottm_vals.get(1)) / 20;
	    	  int new_b = (center_vals.get(2) + right_vals.get(2) + left_vals.get(2) + top_vals.get(2) + bottm_vals.get(2)) / 20;
	    	  //return the new pixel
	    	  processed.set(i, j, new Color(new_r, new_g, new_b));
	      }
	    }
		
		return processed;
	}
	

}
