package dataStructures;
import Member.Instant;
import Shift.Shift;

import java.util.Comparator;
import java.util.Iterator;
import dataStructures.ReverseIntegerComparator;
import dataStructures.Entry;
import dataStructures.ArrayHeapShifts;

public class MinQueueTimer<V> implements PriorityQueue<Integer, V> {
	
	Comparator<Integer> comparator=new ReverseIntegerComparator ();
	ArrayHeapShifts<Integer, V> heap=new ArrayHeapShifts<Integer, V> (comparator);

	@Override
	public V dequeue() {
		return this.heap.remove();
	}

	@Override
	public V peek() {
		return this.heap.peek();
	}

	@Override
	public Iterator<Entry<Integer, V>> iterator() {
		return this.heap.asList().iterator();
	}

	@Override
	public Comparator<Integer> getComparator() {
		return comparator;
	}

	@Override
	public int size() {
		return this.heap.size();
	}

	@Override
	public boolean isEmpty() {
		return this.heap.isEmpty();
	}

	@Override
	public void enqueue(Instant now, Instant shiftStart, V value) {
		this.heap.add((int)shiftStart.compareWith(now), value);	
	}
}