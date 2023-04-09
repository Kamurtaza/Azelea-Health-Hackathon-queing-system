package problem1Queue;

import java.util.Comparator;


public class PatientRankComparator implements Comparator<Patient>{
	@Override
	public int compare(Patient p1, Patient p2) {
		if (p1.getRank() > p2.getRank()) {
			return -1;
		}
		else if(p1.getRank() == p2.getRank()) {
			return p1.getName().compareTo(p2.getName());
		}
		else return 0;
	}
}
