//CSC212 P7
//Emily Rhyu

package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;

//Sources:
//https://www.youtube.com/watch?v=Pr2Jf83_kG0
//https://stackoverflow.com/questions/32445391/merge-sort-recursion

/**
 * MergeSort Recursive ! Complexity O(nlog(n))
 * @author emilyrhyu
 *
 */
public class MergeSortRecurs {
	/**
	 * What this does is that it splits the input list into two lists, left and right,
	 * and uses a recursive loop to keep splitting until they are size 1 and then 
	 * the lists are merged until there is one sorted list.
	 * 
	 * @param input-things in list
	 * @param N - size of input list
	 * @param mid - size of each sublist
	 * @return - original list if size is less than 2
	 * @return- merged sorted list otherwise
	 */
	public static ArrayList<Integer> mergeSortRecurs(ArrayList<Integer> input){
		int N=input.size();
		int mid=N/2;
		
		ArrayList<Integer> left= new ArrayList<>();
		ArrayList<Integer> right= new ArrayList<>();
		
		if (N<2) {
			return input;
		}
		
		else {
			
			for (int i=0;i<mid;i++) {
				left.add(input.get(i));
			}

			for (int j=mid;j<N;j++) {
				right.add(input.get(j));
			}
			
			left=mergeSortRecurs(left);
			right=mergeSortRecurs(right);

			return MergeSortLong.mergeSortLong(left,right);
		}
	}
}
