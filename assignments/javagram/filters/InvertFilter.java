package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class InvertFilter implements Filter {

	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, j);
	          
	          //get color components from each pixel
	          int r = c.getRed();
	          int g = c.getGreen();
	          int b = c.getBlue();
	          
	          int new_r = b + 0;
	          int new_g = r + 0;
	          int new_b = g + 0;
	          
	          processed.set(i, j, new Color(new_r, new_g, new_b));
	    	  
	      }
	    }
		
		return processed;
	}

}
