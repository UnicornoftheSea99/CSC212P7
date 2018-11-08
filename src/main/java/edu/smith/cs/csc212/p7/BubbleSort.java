//CSC212 P7
//Emily Rhyu

package edu.smith.cs.csc212.p7;

import java.util.List;

//Source: https://www.youtube.com/watch?v=RT-hUXUWQ2I

/**
 * BubbleSort is a simple sort that is O(n^2).
 * @author jfoley
 *
 * Sorting method basically just swaps items until list is in order.
 */
public class BubbleSort {

	/**
	 * Swap items in a list!
	 * @param items the list.
	 * @param i swap the item at this index with the one at j.
	 * @param j swap the item at this index with the one at i.
	 */
	public static void swap(List<Integer> items, int i, int j) {
		assert(i != j);
		int tmp = items.get(i);
		items.set(i,  items.get(j));
		items.set(j, tmp);
	}
	
	/**
	 * Bubble Sort is done! And it is easy to do in-place.
	 * @param input - the list to be sorted.
	 * @param N-size of list
	 */
	public static void bubbleSort(List<Integer> input) {
		int N = input.size();
		
		while(true) {
			boolean sorted = true;
			for (int i=0; i<N-1; i++) {
				if (input.get(i) > input.get(i+1)) {
					swap(input, i, i+1);
					sorted = false;
				}
			}
			if (sorted) {
				break;
			}
			N = N - 1;
		}
	}
}
