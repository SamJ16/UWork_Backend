package dataStructures;
import Member.Instant;
import Shift.Shift;

import java.util.Comparator;
import java.util.Iterator;

/**
 * A {@link PriorityQueue} is a queue data structure that allows elements to be
 * enqueued with a priority such that higher priority elements are dequeued
 * first.
 * 
 * @author jcollard
 * 
 * @param <P>
 *            the priority type of this {@link PriorityQueue}
 * @param <V>
 *            the value type of this {@link PriorityQueue}
 */
public interface PriorityQueue<P, V> extends Iterable<Entry<P, V>> {

	/**
	 * Removes the value with the highest priority in this {@link PriorityQueue}
	 * and then returns it. This runs in O(log(size)) time.
	 * 
	 * @return the value with the highest priority in this {@link PrioirtyQueue}
	 * @throws IllegalStateException
	 *             if this {@link PriorityQueue} is empty.
	 */
	public V dequeue();

	/**
	 * Returns the value with the highest priority in this {@link PriorityQueue}.
	 * 
	 * @return the value with the highest priority in this {@link PriorityQueue}.
	 * @throws IllegalStateException
	 *             if this {@link PriorityQueue} is empty.
	 */
	public V peek();

	/**
	 * Returns an {@link Iterator} over all of the entries in this
	 * {@link PriorityQueue}. The order of these elements is unspecified and a
	 * call to {@link Iterator#remove()} results in an
	 * {@link UnsupportedOperationException}.
	 * 
	 * @return an {@link Iterator} over all of the values in this
	 *         {@link PriorityQueue}.
	 */
	public Iterator<Entry<P, V>> iterator();

	/**
	 * Returns the {@link Comparator} that is used to determine the ordering of
	 * {@link Entry}s in this {@link PriorityQueue}.
	 * 
	 * @return the {@link Comparator} that is used to determine the ordering of
	 *         {@link Entry}s in this {@link PriorityQueue}.
	 */
	public Comparator<P> getComparator();

	/**
	 * Returns the total number of elements in this {@link PriorityQueue}
	 * 
	 * @return the total number of elements in this {@link PriorityQueue}
	 */
	public int size();

	/**
	 * Returns {@code true} if this {@link PrioirtyQueue} has no elements and
	 * {@code false} otherwise.
	 * 
	 * @return {@code true} if this {@link PrioirtyQueue} has no elements and
	 *         {@code false} otherwise.
	 */
	public boolean isEmpty();

	public void enqueue(Instant now, Instant shiftStart, V value);

}
