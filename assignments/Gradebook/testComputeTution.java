package Gradebook;

import static org.junit.Assert.*;

import org.junit.Test;

public class testComputeTution {

	@Test
	public void test() {
			Student s = new Student("jane", "doe", 573961);
			s.setCredits(12);
			assertTrue(s.computeTuition() != 0);
		}
	}

