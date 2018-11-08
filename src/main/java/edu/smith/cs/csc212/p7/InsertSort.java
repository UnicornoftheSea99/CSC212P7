//CSC212 P7
//Emily Rhyu

package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;

//Sources
//https://www.youtube.com/watch?v=OGzPmgsI-pQ
////Data Structures and Algorithms in Java, 2nd ed.by Drozdek
//https://www.geeksforgeeks.org/insertion-sort/

/**
 * Insert Sort is a simple sort of complexity O(n^2).
 * @author emilyrhyu
 * 
 * @param input-list of items to sort
 * @param N- size of list of items
 * @param sorted- new list where put newly sorted items
 * @return new list of sorted items
 * 
 * Sorting Method sorts by moving input items into new list in order.
 * Compares i and item before i, j
 * Uses boolean so that can add any items not fulfilling if condition at end.
 */
public class InsertSort {

	public static List<Integer> insertSort(List<Integer> input) {
		int N = input.size();
		ArrayList<Integer> sorted = new ArrayList<>();
		sorted.add(input.get(0)); //add first item of input automatically
		
		for (int i=1; i<N;i++) {
			int key=input.get(i);
			boolean found = false;
			for (int j=0; j<sorted.size() && !found; j++) {
				if(sorted.get(j)>key) {
					found = true;
					sorted.add(j, key);
				}
			}
			if (found==false) {
				sorted.add(key);
			}
		}
		return sorted; //list of sorted items
	}
}
