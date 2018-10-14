package Member;
import Shift.Shift;
import Workplace.Workplace;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimulationWorkplace {
	
	Workplace WorcesterDC;
	Member boss;
	Clock timer = new Clock();
	
	public SimulationWorkplace() {
		this.WorcesterDC = new Workplace();
		this.boss = new Member("Henry", 0, WorcesterDC);
		boss.hire("Frank", 1);
		boss.hire("Danny", 2);
		boss.hire("Joe", 2);
		boss.hire("Erin", 3);
		boss.hire("Jamie", 3);
	}
	
	@Test
	public void testOrganizationSetupValid() {
		Set<Integer> ranks = new HashSet<Integer> ();
		ranks.add(0);
		ranks.add(1);
		ranks.add(2);
		ranks.add(3);
		assertEquals(ranks, WorcesterDC.employeeList.keySet());
	}
	
	@Test
	public void testFireAll() throws IllegalStateException{
		try {
			boss.fire(this.boss);
		} catch(IllegalStateException ise){
			assertTrue(true);
		}
		try {
			WorcesterDC.employeeList.get(3).get(0).fire(WorcesterDC.employeeList.get(3).get(0));
		} catch(IllegalStateException ise){
			assertTrue(true);
		}
	}
	
	@Test
	public void testCoverUp() {
		ArrayList<Member> dishboys = new ArrayList<> (WorcesterDC.employeeList.get(3));
		ArrayList<Member> busboys = new ArrayList<> (WorcesterDC.employeeList.get(2));
		Shift ImolaTest = new Shift(timer.instant().plusMillis(10000l), dishboys, 1, "Hillside washroom this afternoon");
		WorcesterDC.coverUps.enqueue(ImolaTest.time, timer.instant(), ImolaTest);
		try{
			dishboys.get(0).assignTask(busboys.get(0));
		} catch (IllegalStateException ise){
			assertTrue(true);
		}
		assertEquals("Hillside washroom this afternoon", WorcesterDC.coverUps.peek().taskDescription);
		boss.assignTask(dishboys.get(0));
		assertEquals(1, dishboys.get(0).schedule.size());
		dishboys.get(0).requestCover();
		assertEquals(WorcesterDC.coverUps.peek().taskDescription, "Hillside washroom this afternoon");
		busboys.get(0).cover();
		assertEquals(busboys.get(0).schedule.peek().taskDescription, "Hillside washroom this afternoon");
	}
}
