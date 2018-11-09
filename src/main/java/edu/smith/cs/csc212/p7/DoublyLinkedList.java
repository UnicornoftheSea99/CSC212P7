//CSC212 P7
//Emily Rhyu

package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.p6.errors.BadIndexError;
import edu.smith.cs.csc212.p6.errors.EmptyListError;
import edu.smith.cs.csc212.p6.errors.P6NotImplemented;
import edu.smith.cs.csc212.p6.errors.RanOutOfSpaceError;

/**
 * 
 * Create Doubly Linked List
 * Taken from P6
 *
 * @param <T>-type of item in list
 * @param start- reference node used later
 * @param end - refernece node used later
 */

public class DoublyLinkedList<T> implements P6List<T> {
	private Node<T> start;
	private Node<T> end;
	
	/**
	 * A doubly-linked list starts empty.
	 */
	public DoublyLinkedList() {
		this.start = null;
		this.end = null;
	}
	
	/**
	 * Deletes item at index 0 AKA front of list
	 * 
	 * O(1)-maintain constant rate regardless of amt data
	 * 
	 * @return the value of the item that was deleted.
	 * @throws EmptyListError if the list is empty.
	 */
	@Override
	public T removeFront() {
		checkNotEmpty();
		T before = start.value;
		start = start.after;
		return before;
	}
	
	@Override
	public void clear() {
		this.start=null;
		this.end=null;
	}

	/**
	 * Deletes last item of list
	 * 
	 * O(1)-maintain constant rate regardless of amt data
	 * 
	 * If there is only one item in the list, will simply remove that item
	 * Otherwise, will loop through to item to item before last value and set last
	 * item to null in order to remove
	 * 
	 * @return the value of the item that was deleted.
	 * @throws EmptyListError if the list is empty.
	 */
	@Override
	public T removeBack() {
		checkNotEmpty();
		if (size()==1) {
			T casper=start.value;
			start=null;
			return casper;
		}
		else {
			for (Node<T> current = start; current != null; current = current.after) {
				if (current.after.after==null) {
					T groot=current.after.value;
					current.after=null;
					return groot;
				}
			}
		}
		return null;
	}

	/**
	 * Removes item at index(int index)
	 * 
	 * O(n)-indicate some change in growth of function, speed proportional to amt data
	 * possible, but annoying
	 * 
	 * 
	 * If only one value in list, will remove that item
	 * Otherwise, loop through list until item before item to be deleted. Delete
	 * links and create new link in order to delete desired item. 
	 * 
	 * Ex: a -->b-->c-->null becomes a-->c
	 * 
	 * @return the value of the item that was deleted.
	 * @throws EmptyListError if the list is empty.
	 * @param index a number from 0 to size (excluding size).
	 * @throws BadIndexError  if the index does not exist.
	 */
	@Override
	public T removeIndex(int index) {
	
		T removed;
			int gl=0;
			Node<T>current=start;
			for (gl=0; gl<index; gl++) {
				if(current==null) {
					return null;
					}
				else {
					current=current.after;
				}
			}
			removed=current.value;
			 	
			if (current.before!=null) {
			current.before.after=current.after;
			}
			else {
				start=current.after;
			}
			if (current.after!=null) {
			current.after.before=current.before;
			}
			else {
				end=current.before;
			}
			return removed;
		}

	/**
	 * Adds item to front 
	 * 
	 * O(1)-rate constant regardless amt data
	 * 
	 * Need to link to both item before and after, create references to do so
	 * If there is no second, new node is both start and end
	 * Otherwise, new node is added before second
	 * 
	 * @param item the data to add to the list.
	 */
	@Override
	public void addFront(T item) {
		Node<T> first = new Node<T>(item);
		Node<T> second = start;
		if (second==null) {
			start=first;
			end=first;
		}else {
		second.before = first;
		first.after = second;
		first.before = null;
		start = first;
		}
	}

	/**
	 * Add an item to the back of this list. 
	 * 
	 * O(1)-indicate constant rate
	 * 
	 * Need to link to both item before and after, create references to do so
	 * If there is nothing in list, new node is both start and end
	 * Otherwise, new node is added after second to last, aka old end
	 * 
	 * @param item the data to add to the list.
	 * @throws RanOutOfSpaceError if number of items in list is over array length
	 */
	@Override
	public void addBack(T item) {
		Node<T> last = new Node<T>(item);
		Node<T> secondLast = end;
		if(size()==0) {
			addFront(item);
			start=last;
			end=last;
		}else {
			secondLast.after=last;
			last.before=secondLast;
			last.after=null;
			end=last;
		}
	}

	/**
	 *  Add an item before ``index`` in this list. 
	 * 
	 * O(1)-constant rate
	 * 
	 * Need to link to both item before and after, create references to do so
	 * If there is nothing in list, use addFront to make
	 * Otherwise, loop through to item before place want to add and add new Node
	 * 
	 * @param item  the data to add to the list.
	 * @param index the index at which to add the item.
	 * @throws RanOutOfSpaceError if number items is over array length
	 */
	@Override
	public void addIndex(T item, int index) {
		if(index==0){
			addFront(item);
		}else if (index==size()) {
			addBack(item);
		}else {
			int gi=0;
			for (Node<T> current = start; current != null; current = current.after) {
				if (gi==index-1) {
					Node<T> boo = new Node<T>(item);
					boo.before=current;
					boo.after=current.after;
					if (current.after!=null) {
						current.after.before=boo;
					}
					current.after=boo;
				}
				 gi++;
			}
		}	
	}

	/**
	 * Get the first item in the list.
	 * 
	 * O(1)-constant rate
	 * 
	 * @return the item.
	 * @throws EmptyListError
	 */
	@Override
	public T getFront() {
		return start.value;
	}

	/**
	 * Get the last item in the list.
	 * 
	 * O(1)-constant rate
	 * 
	 * @return the item.
	 * @throws EmptyListError
	 */
	@Override
	public T getBack() {
		return end.value;
	}
	
	/**
	 * Find the index-th element of this list.
	 * 
	 * O(1)-no matter how much data, will execute at constant time
	 * 
	 * @param index a number from 0 to size, excluding size.
	 * @return the value at index.
	 * @throws IndexOutofBoundsException if the index does not exist.
	 */
	@Override
	public T getIndex(int index) {
		checkNotEmpty();
		int at = 0;
		for (Node<T> current = start; current != null; current = current.after) {
			if (at == index) {
				return current.value;
			}
			at++;
	}
		throw new IndexOutOfBoundsException();
	}

	/**
	 * Calculate the size of the list.
	 * 
	 * O(1)-no matter how much data, will execute at constant time
	 * 
	 * Create counter and loop through list to count
	 * 
	 * @return the length of the list, or zero if empty.
	 */
	@Override
	public int size() {
		int count = 0;
		for (Node<T> n = this.start; n != null; n = n.after) {
			count++;
		}
		return count;
	}

	/**
	 * This is true if the list is empty. Looks at fill.
	 * 
	 * @return true if the list is empty.
	 */
	@Override
	public boolean isEmpty() {
		if (this.size() ==0)
			return true;
		else {
		return false;
	}
	}
	
	/**
	 * Helper method to throw the right error for an empty state.
	 */
	private void checkNotEmpty() {
		if (this.isEmpty()) {
			throw new EmptyListError();
		}
	}
	
	@Override
	public String toString() {
		StringBuffer out = new StringBuffer();
		for (Node<T> current =start; current!=null; current=current.after) {
			out.append(current.value +" ");
		}
		return out.toString();
		
	}
	
	/**
	 * The node on any linked list should not be exposed.
	 * Static means we don't need a "this" of DoublyLinkedList to make a node.
	 * @param <T> the type of the values stored.
	 */
	private static class Node<T> {
		/**
		 * What node comes before me?
		 */
		public Node<T> before;
		/**
		 * What node comes after me?
		 */
		public Node<T> after;
		/**
		 * What value is stored in this node?
		 */
		public T value;
		/**
		 * Create a node with no friends.
		 * @param value - the value to put in it.
		 */
		public Node(T value) {
			this.value = value;
			this.before = null;
			this.after = null;
		}
	}
}
