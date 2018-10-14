package Member;

public class Instant{
	
	public long time = 0l;
	
	public Instant() {
		time = System.currentTimeMillis();
	}
	
	public long compareWith(Instant other) {
		return other.time-this.time;
	}

	public Instant plusMillis(long i) {
		this.time=time+i;
		return this;
	}
	
}