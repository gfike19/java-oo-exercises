package javagram.filters;

import javagram.Picture;

public interface Filter {

	/* (non-Javadoc)
	 * @see javagram.filters.Filter#process(javagram.Picture)
	 */
	Picture process(Picture original);

}