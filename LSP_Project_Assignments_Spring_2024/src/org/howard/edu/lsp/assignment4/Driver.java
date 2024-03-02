package org.howard.edu.lsp.assignment4;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerSet set1 =  new IntegerSet();
		set1.add(0);
		set1.add(7);
		set1.add(1);
		set1.add(8);
		set1.add(9);
		set1.add(5);
		
		IntegerSet set2 =  new IntegerSet();
		
		set2.add(4);
		set2.add(9);
		set2.add(8);
		set2.add(3);
		set2.add(5);
		set2.add(1);
		
		
		// print length of set1 and set2
		System.out.println("Set 1: " + set1.toString());
		System.out.println("The length of set 1 is: " + set1.length());
		System.out.println("Set 2: " + set2.toString());
		System.out.println("The length of set 2 is: " + set2.length());
		
		//Print the result of equating set1 and set1
		System.out.println("Set1 is equal to set2: " + set1.equals(set2));
		
		//Check if set1 and set2 contain specific integer values
		System.out.println("Set1 contains the integer 6: " + set1.contains(6));
		System.out.println("Set2 contains the integer 3: " + set2.contains(3));
		
		//Check for the largest and smallest element in the set
		try {
			System.out.println("largest of Set1 is: " + set1.largest());
		} catch (Exception emptySet) {
			emptySet.printStackTrace();
		}
		
		try {
			System.out.println("smallest of Set2 is: " + set2.smallest());
		} catch (Exception emptySet) {
			emptySet.printStackTrace();
		}
		
		//Print the intersection of set1 and set2
		System.out.println("Set1: " + set1.toString());
		System.out.println("Set2: " + set2.toString());
		set1.intersect(set2);
		System.out.println("Intersection of set1 and set2: " + set1.toString());
		
		//Print the union of set1 and set2
		System.out.println("Set1: " + set1.toString());
		System.out.println("Set2: " + set2.toString());
		set1.union(set2);
		System.out.println("Union of set1 and set2: " + set1.toString());
		
		//Print the difference of set1 and set2
		System.out.println("Set1: " + set1.toString());
		System.out.println("Set2: " + set2.toString());
		set1.diff(set2);
		System.out.println("Difference of set1 and set2: " + set1.toString());
		
		//Print the complement of set1 and set2
		System.out.println("Set1: " + set1.toString());
		System.out.println("Set2: " + set2.toString());
		set1.complement(set2);
		System.out.println("Complement of set1 with set2: " + set1.toString());
		
		//Remove a value from set 2
		System.out.println("Set2: " + set2.toString());
		set2.remove(4);
		System.out.println("Set2 after removing 4: " + set2.toString());
		
		//Clear set 1 and check if it is empty
		System.out.println("Set1: " + set1.toString());
		set1.clear();
		System.out.println("Clear set1: " + set1.toString());
		System.out.println("Set1 is empty: " + set1.isEmpty());
	}

}
