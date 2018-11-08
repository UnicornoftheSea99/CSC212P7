//CSC212 P7
//Emily Rhyu

package edu.smith.cs.csc212.p7;

import java.util.List;

//Sources: 
//Data Structures and Algorithms in Java, 2nd ed.by Drozdek
//https://www.geeksforgeeks.org/selection-sort/
//https://www.youtube.com/watch?v=AgFR0kO05RM

/**
 * 
 * Select Sort is a simply sort that is O(n^2).
 * @author emilyrhyu
 * 
 * Sorting method brings minimum value to front of list until sorted.
 */
public class SelectSort {

	/**
	 * Swap items in a list!
	 * 
	 * @param items the list.
	 * @param i swap the item at this index with the one at least.
	 * @param least swap the item at this index with the one at i.
	 */
	public static void swap(List<Integer> items, int i, int least) {
		int tmp = items.get(least);
		items.set(least, items.get(i));
		items.set(i, tmp);
	}

	/**
	 * Select Sort Finds the Minimum Value and Brings it to the Front.
	 * 
	 * @param input - the list to be sorted.
	 * @param N- size of list
	 */
	public static void selectSort(List<Integer> input) {
		int N = input.size();
		
		for (int i = 0; i < N - 1; i++) {
			int least = i;
			for (int j = i + 1; j < N; j++) {
				if (input.get(least) > input.get(j)) {
					swap(input, least, j);
				}
			}
			swap(input, i, least);
		}
	}
}
