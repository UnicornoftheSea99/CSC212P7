//CSC212 P7
//Emily Rhyu

package edu.smith.cs.csc212.p7;

import java.util.ArrayList;

/**
 * Merge Sort Doubly Linked List from P6 Doubly Linked List
 * Uses already coded Merge Sort Iterative and P6 Doubly Linked List
 * @author emilyrhyu
 *
 */
public class MergeSortP6 {
	/**
	 * The input list is split into left and right parts until it has a list of lists of size
	 * one or two. Those lists are sorted and then combined and merge sorted with other lists
	 * of size 2. Then it merge sorts with other lists of size 4, and so on until it becomes
	 * one big sorted list. Unlike recursive, uses looping and merged left and right are 
	 * stored in new temp list instead of being returned.
	 * 
	 * Same as MergeSort Iterative, just applied to Doubly Linked List
	 * 
	 * @param input-Doubly Linked List of items
	 * @param N-size of Doubly Linked LIst
	 * @param size-used as marker
	 * @param start, end,mid,-markers on input used for splitting
	 */
	public static void mergeSortP6(DoublyLinkedList<Integer> input){
		int N=input.size();
		int size;
		int start,end,mid;

		DoublyLinkedList<Integer> left= new DoublyLinkedList<>();
		DoublyLinkedList<Integer> right= new DoublyLinkedList<>();
		DoublyLinkedList<Integer> temp = new DoublyLinkedList<>();
		
		for(size=2;size<=2*N;size+=size) {
			
			start=0;
			end=start+size;
			mid=start+(size/2);
			
			while(start<N) {
				left.clear();
				for (int i=start;i<mid && i<N;i++) {
					left.addBack(input.getIndex(i));
				}
				right.clear();
				for (int j=mid;j<N && j<end;j++) {
					right.addBack(input.getIndex(j));
				}
				temp=MergeSortLong.mergeSortLong(left, right);

				for (int i=start;i<N && i<end;i++) {
					input.removeIndex(i);
					input.addIndex(temp.getIndex(i-start),i);
				}
				start+=size;
				end+=size;
				mid+=size;
			}
		}
	}
}



