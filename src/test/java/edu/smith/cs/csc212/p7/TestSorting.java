package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestSorting {
	/**
	 * This is useful for testing whether sort algorithms work!
	 * @param items - the list of integers.
	 * @return true if it is sorted, false if not.
	 */
	private static boolean checkSorted(List<Integer> items) {
		for (int i=0; i<items.size()-1; i++) {
			if (items.get(i) >= items.get(i+1)) {
				System.err.println("items out of order: "+items.get(i)+", "+items.get(i+1) + " at index="+i);
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkSorted(DoublyLinkedList<Integer> items) {
		for (int i=0; i<items.size()-1; i++) {
			if (items.getIndex(i) >= items.getIndex(i+1)) {
				System.err.println("items out of order: "+items.getIndex(i)+", "+items.getIndex(i+1) + " at index="+i);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Here's some data!
	 */
	private static int[] data = {9,8,7,6,5,4,3,2,1};
	
	@Test
	public void testBubbleSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}
	/**
	 * Test for Select Sort
	 */
	@Test
	public void testSelectSort() {
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		SelectSort.selectSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		SelectSort.selectSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}
	/**
	 * Test for Insert Sort
	 */
	@Test
	public void testInsertSort() {
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		List<Integer> fixed = InsertSort.insertSort(sortMe);
		checkSorted(fixed);
		List<Integer> copy = InsertSort.insertSort(new ArrayList<>(sortMe));
		
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(copy);
		copy=InsertSort.insertSort(copy);
		Assert.assertTrue(checkSorted(copy));
	}
	/**
	 * Test for Merge Sort Recursive
	 */
	@Test
	public void testMergeSortRecurs() {
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		sortMe=MergeSortRecurs.mergeSortRecurs(sortMe);
		checkSorted(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}
	/**
	 * Test for Merge sort iterative
	 */
	@Test
	public void testMergeSortIt() {
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		
		MergeSortIt.mergeSortIt(sortMe);
		checkSorted(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}
	/**
	 * Test for Merge Sort P6 Doubly Linked List
	 */
	@Test
	public void testMergeSortP6() {
		DoublyLinkedList<Integer> sortMe = new DoublyLinkedList<Integer>();
		for (int y : data) {
			sortMe.addBack(y);
		}
		MergeSortP6.mergeSortP6(sortMe);
		checkSorted(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}
	/**
	 * Data to test Merge Sort Long
	 */
	private static int[] dataM1 = {1,2,3,4};
	private static int[] dataM2 = {2,4,5,9};
	
	/**
	 * Test for regular merge sort method that merges two already sorted lists
	 */
	@Test
	public void testMergeSortL() {
		ArrayList<Integer>sortMe=new ArrayList<>();
		ArrayList<Integer>sortMe2=new ArrayList<>();
		for (int y: dataM1) {
			sortMe.add(y);
		}
		for (int x:dataM2) {
			sortMe2.add(x);
		}
		List<Integer> fixed=MergeSortLong.mergeSortLong(sortMe,sortMe2);
		checkSorted(fixed);
		
	}
}


