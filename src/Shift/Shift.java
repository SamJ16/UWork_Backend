package Shift;
import java.util.*;

import Member.Instant;
import Member.Member;

class Clock{
	
	public Instant currentTime;
	
	Clock() {
		currentTime = new Instant();
	}
	
	public Instant instant() {
		return new Instant();
	}
	
}

public class Shift {
	
	public boolean isCovered=false;
	public Clock timer = new Clock();
	public Instant time;
	public List<Member> onsite;
	public String taskDescription;
	
	public Shift(Instant clockIn, ArrayList<Member> peepsOnJob, int requiredWorkerCount, String workDescription) {
		this.time=clockIn;
		this.onsite=peepsOnJob;
		if (onsite.size()>=requiredWorkerCount) {
			isCovered=true;
		}
		else {
			isCovered=false;
		}
		this.taskDescription=workDescription;
	}
	
}
