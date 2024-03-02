package org.howard.edu.lsp.assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * @author KhendraPhillips
 * @version 3/1/24
 */

/**
 * IntegerSet is a class that performs a variety operations on a given set.
 */
public class IntegerSet {
	//Store the set elements in an ArrayList
	private List<Integer>set= new ArrayList<Integer>();
	
	/**
	 * Default constructor
	 */
	public IntegerSet() {
		
	}
	
	/**
	 * Constructor if you want to pass in already initialized set.
	 * @param set initial integer set, considered as set1
	 */
	public IntegerSet(ArrayList<Integer> set) {
		this.set=set;
	}
	
	/**
	 * Clears the internal representation of the set
	 */
	public void clear() {
		set.clear();
	};
	
	/**
	 * Returns the length of the set.
	 * @return the length of the set;
	 */
	public int length(){
		return set.size(); //returns the length
	}; 
	
	/**
	 * Returns true if both sets are equal to each other and false if they are not.
	 * Two sets are equal if they contain all of the same values in ANY order.
	 * This overrides the equal method from the Object class.
	 * @return  true  if the 2 sets are equal, false otherwise;
	 * @param   set2  an integer set that will be compared to set1
	 */
	public boolean equals(IntegerSet set2) {
		if (set.size() != set2.length()) {
			return false;
		}
		for (int item : set2.set) {
			if(!set.contains(item)) {
				return false;
			}
		}
		return true;
	}
	
	/** 
	 * Return boolean value true or false depending on whether or not the specified value is found in the set
	 * @return true if the set contains the value, false otherwise
	 * @param value integer that will be searched for in set
	 */
	public boolean contains(int value) {
		if (set.contains(value)){
			return true;
		}
		else return false;
	}
	
	/**
	 * Returns the largest integer in the set
	 * @return the largest item in the set; 
	 * @throws IntegerSetException if the set is empty
	 */
	public int largest() throws Exception {
		if (set.isEmpty()) {
			throw new Exception("Set is empty");
		}
		return Collections.max(set);
	}
	
	/**
	 * Returns the smallest integer in the set
	 * @return the smallest item in the set; 
	 * @throws IntegerSetException if the set is empty
	 */
	public int smallest() throws IntegerSetException {
		if (set.isEmpty()) {
			throw new IntegerSetException("Set is empty");
		}
		int smallest = set.get(0);
		for (int element : set) {
			if (element < smallest) {
					smallest = element;
			}
		}
		return smallest;
	}
	
	/** Adds an integer to the set or does nothing if not there
	 * @param num integer to be added to the set
	 */
	public void add(int num) {
		if (!set.contains(num)) {
			set.add(num);
		}
	}
	
	/** Removes an integer from the set or does nothing if not there
	 * @param num integer to be removed from the set
	 */
	public void remove(int num) {
		set.remove(Integer.valueOf(num));
	}
	
	/** 
	 * Gives the union of two sets, all the elements from set1 and set2
	 * @param set2 integer set joined with set1
	 */
	public void union(IntegerSet set2) {
		for (int item : set2.set) {
			if (!set.contains(item)) {
				set.add(item);
			}
		}
	} 
	
	/**Set intersection, all elements in both set1 and set2
	 * @param set2 integer set intersected with set1
	 */
	public void intersect(IntegerSet set2) {
		set.retainAll(set2.set);
	}
	
	/**
	 * Set difference, all the elements in set1 that are not in set, i.e., set1 - set2
	 * @param intSet2 integer set subtracted from set1
	 */
	public void diff(IntegerSet intSet2) {
		set.removeAll(intSet2.set);
	}
	
	/**
	 * Set Complement, all the elements not in set 1
	 * @param intSet2 integer set complemented with set1
	 */
	public void complement(IntegerSet intSet2) {
		List<Integer> itemsToAdd = new ArrayList<Integer>();
		for (int item : intSet2.set) {
			if (!set.contains(item)) {
				itemsToAdd.add(item);
				}
			}
		set.clear();
		for (int item : itemsToAdd) {
			set.add(item);

		}

	}
	
	/** Returns true or false depending on whether or no the set is empty
	 * @return true if the set is empty, false otherwise
	 */
	public boolean isEmpty() {
		return set.isEmpty();
	}
	
	/**
	 * Returns the string representation of the set
	 * @return set as a string type
	 * This overrides the equal method from the Object class.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for (int i = 0; i < set.size(); i++) {
			sb.append(set.get(i));
			if (i != set.size()-1) {
				sb.append(",");
			}
		}
		sb.append(")");
		return sb.toString();
	}	
}
