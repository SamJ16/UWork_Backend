package dataStructures;

import java.util.Comparator;

public class ReverseIntegerComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2.compareTo(o1);
	}

}
