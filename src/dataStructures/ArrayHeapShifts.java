package dataStructures;

import java.util.ArrayList;
import java.util.Comparator;

public class ArrayHeapShifts<P, V> extends AbstractArrayHeap<P, V> {

	ArrayList<Entry<P, V>> heap;
	Comparator<P> comparator;

	protected ArrayHeapShifts(Comparator<P> comparator) {
		super(comparator);
		this.comparator=super.comparator;
		this.heap=super.heap;
	}

	@Override
	protected int getLeftChildOf(int index) {
		if (index<0) {
			throw new IndexOutOfBoundsException();
		}
		return (index*2)+1;
	}

	@Override
	protected int getRightChildOf(int index) {
		//return getLeftChildOf(index)+1;
		if (index<0) {
			throw new IndexOutOfBoundsException();
		}
		return (index*2)+2;
	}

	@Override
	protected int getParentOf(int index) {
		if (index<=0) {
			throw new IndexOutOfBoundsException();
		}
		return (index-1)/2;
	}

	@Override
	protected void bubbleUp(int index) {
		if (index<=0) return;
		else if (comparator.compare(heap.get(index).getPriority(), heap.get(getParentOf(index)).getPriority())<=0) {
			return;
		}
		else{
			super.swap(index, getParentOf(index));
			bubbleUp(getParentOf(index));
		}
	}

	@Override
	protected void bubbleDown(int index) {
		if (index<0 || getRightChildOf(index)>heap.size()) {return;}
		if (getLeftChildOf(index)<heap.size() && getRightChildOf(index)==heap.size()) {
			if (comparator.compare(heap.get(index).getPriority(), heap.get(getLeftChildOf(index)).getPriority())>=0) {
				return;
			}
			else {
				super.swap(index, getLeftChildOf(index));
				return;
			}
		}
		if (comparator.compare(heap.get(index).getPriority(), heap.get(getLeftChildOf(index)).getPriority())>=0 &&
				comparator.compare(heap.get(index).getPriority(), heap.get(getRightChildOf(index)).getPriority())>=0) {
			return;
		}
		else{
			if (comparator.compare(heap.get(getLeftChildOf(index)).getPriority(), heap.get(getRightChildOf(index)).getPriority())>0) {
				super.swap(index, getLeftChildOf(index));
				bubbleDown(getLeftChildOf(index));
			}
			else{
				super.swap(index, getRightChildOf(index));
				bubbleDown(getRightChildOf(index));
			}
		}		
	}

	@SuppressWarnings("unchecked")
	public void add(int compareTo, V value) {
		this.heap.add(new Entry(compareTo, value));		
	}
}

