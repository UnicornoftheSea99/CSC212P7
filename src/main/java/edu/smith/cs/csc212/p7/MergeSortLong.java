//CSC212 P7 
//Emily Rhyu

package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;

//Sources:
//https://www.youtube.com/watch?v=Pr2Jf83_kG0
//https://www.geeksforgeeks.org/merge-sort/

/**
 * MergeSortLong is of complexity O(nlog(n))
 * @author emilyrhyu
 *
 */
public class MergeSortLong {
	/**
	 * Merge sorting! Will be used for MergeSort Recursive and MergeSort Iterative
	 * 
	 *@param input-first list of items
	 *@param input2-second list of items
	 *@param sorted- combined sorted list of input and input2
	 *@param N-size of list input
	 *@param N2-size of list input2
	 *@param i,j,key - index references
	 *@return sorted list of items
	 *
	 * What this does is that it takes in two already sorted lists and "zippers" them
	 * into one big sorted list. In essence, it compares values from both lists and adds 
	 * them to a bigger list so that it eventually becomes sorted.
	 */

	public static ArrayList<Integer> mergeSortLong(List<Integer> input, List<Integer> input2) {
		int N = input.size();
		int N2=input2.size();
		
		ArrayList<Integer> sorted = new ArrayList<>();
		int i=0;
		int j=0;
		int key=1;
		while (i<N && j<N2) {
			if (input.get(i)<= input2.get(j)) {
				sorted.add(input.get(i));
				i++;
			}else {
				sorted.add(input2.get(j));
				j++;
			}key++;
		}
		
		/* Copy remaining elements of input if any. Solves problem if other list
		 * already empty */
        while (i < N) { 
        	sorted.add(input.get(i));
            i++; 
            key++; 
        } 

        /* Copy remaining elements of input2 if any. Solves problem if other list
         * already empty */
        while (j < N2)  { 
        	sorted.add(input2.get(j));
            j++; 
            key++; 
        }
		return sorted; //return sorted list
	}
}