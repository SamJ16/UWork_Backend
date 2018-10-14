/**
 * 
 */
/**
 * @author samja
 *
 */
package Member;
import java.util.*;
import dataStructures.MinQueueTimer;
import dataStructures.PriorityQueue;
import Shift.Shift;
import Workplace.Workplace;

class Clock{
	
	public Instant currentTime;
	
	Clock() {
		currentTime = new Instant();
	}
	
	public Instant instant() {
		return new Instant();
	}
	
}

public class Member {
	
	public Workplace myJob;
	String name;
	int ID;
	int rank;
	public PriorityQueue<Integer, Shift> schedule = new MinQueueTimer<Shift> ();
	public List<Shift> missedShifts = new ArrayList<> ();
	public List<Shift> coveredShifts = new ArrayList<> ();
	public Clock timer = new Clock();
	
	public Member(String name, int currentRank, Workplace myWorkplace) throws IllegalArgumentException{ //adding member to system;
		if (name.length()==0) {throw new IllegalArgumentException();}
		this.name = name;
		this.rank = currentRank;
		this.myJob = myWorkplace;
		this.ID=0;
		if (myJob.employeeList.isEmpty()) {
			this.hire(name, 0);
		}
	}
	public Member() {
		if (name!=null && myJob!=null) {
			this.schedule.enqueue(schedule.peek().time, timer.instant(), schedule.dequeue());
		}
	}
	
	public void hire(String name, int newRank) {
		if (this.myJob.employeeList.size()==0) {
			this.myJob.employeeList.put(0, new ArrayList<Member> ());
			this.myJob.employeeList.get(0).add(new Member(name, 0, this.myJob));
		}
		else if (this.rank==0) {
			Member person = new Member(name, newRank, this.myJob);
			if (this.myJob.employeeList.get(newRank)==null) {
				this.myJob.employeeList.put(newRank, new ArrayList<Member> ());
			}
			this.myJob.employeeList.get(newRank).add(person);
			person.ID=ID+1;
		}
		else {
			return;
		}
	}
	
	public void fire(Member person) throws IllegalStateException{
		if (this.myJob.employeeList.size()<=1) {
			throw new IllegalStateException("can't fire yourself boss");
		}
		else if (this.rank==0 && person.rank>0) {
			this.myJob.employeeList.get(person.rank).remove(person);
		}
		else {
			if (this.rank!=0) {
				throw new IllegalStateException("you can't fire anyone");
			}
			if (person.rank==0) {
				throw new IllegalStateException("can't fire yourself boss");
			}
		}
	}
	
	public void assignTask(Member person) throws IllegalStateException{
		if (this.rank==0) {
			person.schedule.enqueue(this.myJob.coverUps.peek().time, (timer.instant()), this.myJob.coverUps.dequeue());
		}
		else {
			throw new IllegalStateException("you are not authorized to assign tasks");
		}
	}
	
	public void cover() {
		coveredShifts.add(this.myJob.coverUps.peek());
		this.schedule.enqueue(this.myJob.coverUps.peek().time, (timer.currentTime), this.myJob.coverUps.dequeue());
	}
	
	public void requestCover() {
		this.myJob.coverUps.enqueue(this.schedule.peek().time, (timer.currentTime), this.schedule.dequeue());
	}
}