//CSC212 P7
//Emily Rhyu

package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;

//Sources:
//https://www.youtube.com/watch?v=Pr2Jf83_kG0
//https://www.geeksforgeeks.org/iterative-merge-sort/

/**
 * MergeSort Iterative! AKA Bottom Up Merge Sort
 * Complexity of O(nlog(n))
 * 
 * @author emilyrhyu
 *
 */
public class MergeSortIt {
	/**
	 * 
	 * The input list is split into left and right parts until it has a list of lists of size
	 * one or two. Those lists are sorted and then combined and merge sorted with other lists
	 * of size 2. Then it merge sorts with other lists of size 4, and so on until it becomes
	 * one big sorted list. Unlike recursive, uses looping and merged left and right are 
	 * stored in new temp list instead of being returned.
	 * 
	 * @param input- list of items
	 * @param N-size of list
	 * @param start,end,mid-markers on original input list 
	 */
	public static void mergeSortIt(ArrayList<Integer> input){
		int N=input.size();
		int size;
		int start,end,mid;

		ArrayList<Integer> left= new ArrayList<>();
		ArrayList<Integer> right= new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();

		for(size=2;size<=2*N;size+=size) {
			start=0;
			end=start+size;
			mid=start+(size/2);
			
			while(start<N) {
				left.clear();
				for (int i=start;i<mid && i<N;i++) {
					left.add(input.get(i));
				}
				right.clear();
				for (int j=mid;j<N && j<end;j++) {
					right.add(input.get(j));
				}
				temp=MergeSortLong.mergeSortLong(left, right);
				for (int i=start;i<N && i<end;i++) {
					input.remove(i);
					input.add(i, temp.get(i-start));
				}
				start+=size;
				end+=size;
				mid+=size;
			}
		}
	}
}
