/**
 * 
 */
/**
 * @author samja
 *
 */
package Workplace;

import java.util.*;
import Member.Instant;
import Member.Member;
import Shift.Shift;
import dataStructures.PriorityQueue;
import dataStructures.MinQueueTimer;

public class Workplace{
	
	public Map<Integer/*rank or position of employee*/, ArrayList<Member>/*employees in a certain position*/> employeeList = new HashMap<Integer, ArrayList<Member>> ();
	public PriorityQueue<Integer/*time of shift*/, Shift/*Job*/> coverUps= new MinQueueTimer<Shift> ();
	
	public Workplace() {}
	
}