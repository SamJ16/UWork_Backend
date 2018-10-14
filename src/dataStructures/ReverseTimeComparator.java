package dataStructures;
import Member.Instant;
import java.util.Comparator;
import dataStructures.ReverseTimeComparator;

public class ReverseTimeComparator implements Comparator<Instant> {
	/**
	* An {@link ReverseIntegerComparator} compares integers in reverse order,
	* e.g., compare(2, 1) returns a negative number.
	*
	*/
    public long compareWith(Instant arg0, Instant arg1) {
    	return arg1.compareWith(arg0);
    }

	@Override
	public int compare(Instant o1, Instant o2) {
		return (int) compareWith(o1,o2);
	}
}
