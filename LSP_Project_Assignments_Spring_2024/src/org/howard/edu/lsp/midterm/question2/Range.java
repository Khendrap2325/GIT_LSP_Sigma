package org.howard.edu.lsp.midterm.question2;
	
/*
 * This interface determines if a specific value falls within a certain range
 */
	public interface Range {
		// TODO Auto-generated method stub
		/**
	     * Checks if the specified value is within the range.
	     *
	     * @param value is the integer value that's checked.
	     * @return true if the value is within the range; false otherwise.
	     */
		boolean contains(int value);
		
		/**
	     * Determines if there is an overlap with this range and another range.
	     *
	     * @param other - other range to check for an overlap with.
	     * @return true if there is at least one common element between the two ranges;
	     *         false otherwise.
	     */
		boolean overlaps(Range other);
		
		/**
	     * Calculates the size of the range
	     *
	     * @return size of the range as type integer.
	     */
		int size();
	}

