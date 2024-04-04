package org.howard.edu.lsp.assignment5;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;


public class IntegerSetTest {
	private IntegerSet IntegerSet;
	private IntegerSet Set1;
	private IntegerSet Set2; 
	@BeforeEach
	public void setUp() {
		IntegerSet = new IntegerSet();
		Set1 = new IntegerSet();
		Set1.add(1);
		Set1.add(2);
		Set1.add(3);
		Set1.add(4);
		Set1.add(5);
		Set2 = new IntegerSet();
		Set2.add(6);
		Set2.add(7);
		Set2.add(8);
		Set2.add(9);
		Set2.add(10);
	}
	@Test
	@DisplayName("Test clear")
	public void testClear() {
		IntegerSet.add(4);
		IntegerSet.add(8);
		assertEquals(2, IntegerSet.length());
		IntegerSet.clear();
		assertEquals(0, IntegerSet.length());
		}
	
	@Test
	@DisplayName("Test length")
	public void testLength() {
		IntegerSet.add(4);
		IntegerSet.add(8);
		IntegerSet.add(5);
		IntegerSet.add(3);
		assertEquals(4, IntegerSet.length());
		IntegerSet.clear();
		assertEquals(0, IntegerSet.length());
	}
	
	@Test
	@DisplayName("Test Equals")
	public void testEquals() {
		assertTrue(Set1.length() == Set2.length(),()-> "Integer sets are not the same length" );
		assertFalse(Set1.equals(Set2), ()-> "Integer sets are the same");
		//Changing Set2 to match the initialized Set1
		Set2 = new IntegerSet();
		Set2.add(1);
		Set2.add(2);
		Set2.add(3);
		Set2.add(4);
		Set2.add(5);
		assertTrue(Set1.equals(Set2), ()-> "Integer sets are not the same");
	}
	
	@Test
	@DisplayName("Test Contains")
	public void testContains() {
		assertTrue(Set1.contains(5), ()-> "Integer set does not contain number");
		assertFalse(Set2.contains(18), ()-> "Integer set does contain number");
		assertFalse(IntegerSet.contains(12), ()-> "Integer set is empty");
		for (int i = 0; i < 1000; i++) {
			IntegerSet.add(i);
		}
		assertTrue(IntegerSet.contains(999));
	}
	
	@Test
	@DisplayName ("Test Largest")
	public void testLargest() throws Exception {
		// Test largest on non-empty set
		IntegerSet.add(10);
		IntegerSet.add(5);
		IntegerSet.add(15);
		assertEquals(15,IntegerSet.largest());
		
		/**
		 * Test exception handling
		 */
		setUp();
		Throwable IntegerSetException = assertThrows(Exception.class, ()-> IntegerSet.largest());
		assertEquals("Set is empty", IntegerSetException.getMessage());
	}
	
	@Test
	@DisplayName ("Test Smallest")
	public void testSmallest() throws Exception {
		// Test largest on non-empty set
		IntegerSet.add(4);
		IntegerSet.add(5);
		IntegerSet.add(-1);
		assertEquals(-1,IntegerSet.smallest());
		
		/**
		 * Test exception handling
		 */
		setUp();
		Throwable IntegerSetException = assertThrows(Exception.class, ()-> IntegerSet.smallest());
		assertEquals("Set is empty", IntegerSetException.getMessage());
	}
	
	@Test
	@DisplayName("Test add")
	public void testAdd() {
		IntegerSet.add(5);
		IntegerSet.add(3);
		assertEquals(2, IntegerSet.length());
		IntegerSet.add(3);
		assertNotEquals(3, IntegerSet.length()); //Length should not increase if a duplicate value is added to set.
	}
	
	@Test
	@DisplayName("Test Remove")
	public void testRemove() {
		assertEquals(5, Set1.length());
		Set1.remove(4);
		assertNotEquals(5, Set1.length());
		assertEquals(4,Set1.length());
		assertFalse(Set1.contains(4), ()-> "Integer set does contain number");
	}

	@Test
	@DisplayName("Test Union")
	public void testUnion() {
		// Test standard union
		Set1.union(Set2);
		assertEquals(10,Set1.length());
		
		//Test union of sets with overlapping elements
		Set1.clear();
		Set2.clear();
		Set1.add(0);
		Set1.add(4);
		Set2.add(2);
		Set2.add(4);
		Set2.union(Set1);
		assertNotEquals(4, Set2.length());
		assertTrue(Set2.contains(0));
		assertTrue(Set2.contains(2));
		assertTrue(Set2.contains(4));
		assertEquals(3, Set2.length());
		
		//Test union of duplicate sets
		setUp();
		Set2.clear();
		Set2.add(1);
		Set2.add(2);
		Set2.add(3);
		Set2.add(4);
		Set2.add(5);
		Set1.union(Set2);
		assertEquals(5, Set1.length());
		
		//Test union contains elements of both sets
		Set1.clear();
		Set2.clear();
		Set1.union(Set2);
		assertTrue(Set1.isEmpty());
		
		//Test union contains elements of both sets
		Set1.add(13);
		Set1.add(14);
		Set2.add(15);
		Set2.add(16);
		Set1.union(Set2);
		assertTrue(Set1.contains(13), ()-> "Integer set does not contain number");
		assertTrue(Set1.contains(14), ()-> "Integer set does not contain number");
		assertTrue(Set1.contains(15), ()-> "Integer set does not contain number");
		assertTrue(Set1.contains(16), ()-> "Integer set does not contain number");
	}
	
	@Test
	@DisplayName("Test Intersection")
	public void testIntersect() {
		Set1.add(10);
		Set1.intersect(Set2);
		assertEquals(1,Set1.length());
		assertTrue(Set1.contains(10), ()-> "Integer sets do not intersect" );
				
		//Test intersection of duplicate sets
		setUp();
		Set2.clear();
		Set2.add(1);
		Set2.add(2);
		Set2.add(3);
		Set2.add(4);
		Set2.add(5);
		Set1.intersect(Set2);
		assertEquals(5, Set1.length());
				
		//Test intersection of empty sets is an empty set
		Set1.clear();
		Set2.clear();
		Set1.intersect(Set2);
		assertTrue(Set1.isEmpty());
	}
	
	@Test 
	@DisplayName("Test Difference")
	public void testDifference() {
		//Test difference of sets with no common elements
		Set1.diff(Set2);
		assertEquals(5,Set1.length());
		assertTrue(Set1.contains(1));
		assertTrue(Set1.contains(2));
		assertTrue(Set1.contains(3));
		assertTrue(Set1.contains(4));
		assertTrue(Set1.contains(5));
		
		//Test difference of duplicate sets equals an empty set
		setUp();
		Set2.clear();
		Set2.add(1);
		Set2.add(2);
		Set2.add(3);
		Set2.add(4);
		Set2.add(5);
		Set1.diff(Set2);
		assertTrue(Set1.isEmpty());
		
		//Test Difference of sets with overlapping elements
		Set1.clear();
		Set2.clear();
		Set1.add(2);
		Set1.add(4);
		Set1.add(6);
		Set2.add(4);
		Set2.add(6);
		Set2.add(8);
		Set1.diff(Set2);
		assertEquals(1, Set1.length());
		assertTrue(Set1.contains(2));
				
	}
	
	@Test 
	@DisplayName("Test Complement")
	public void testComplement() {
		//Test complement of sets with no common elements
		Set1.complement(Set2);
		assertEquals("(6,7,8,9,10)", Set1.toString());
				
		//Test complement of duplicate sets equals an empty set
		setUp();
		Set2.clear();
		Set2.add(1);
		Set2.add(2);
		Set2.add(3);
		Set2.add(4);
		Set2.add(5);
		Set1.complement(Set2);
		assertTrue(Set1.isEmpty());
				
		//Test complement of sets with overlapping elements
		Set1.clear();
		Set2.clear();
		Set1.add(2);
		Set1.add(4);
		Set2.add(4);
		Set2.add(6);
		Set2.add(8);
		Set1.complement(Set2);
		assertEquals("(6,8)",Set1.toString());
	}
	
	@Test
	@DisplayName("Test isEmpty")
	public void testIsEmpty() {
		assertTrue(IntegerSet.isEmpty());
		
		IntegerSet.add(54);
		assertFalse(IntegerSet.isEmpty());
		
		IntegerSet.remove(54);
		assertTrue(IntegerSet.isEmpty());
	}
	
	@Test
	@DisplayName("Test toString")
	public void testToString() {
		assertEquals("(1,2,3,4,5)", Set1.toString());
	}
	
}
