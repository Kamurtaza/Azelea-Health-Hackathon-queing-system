package problem1Queue;


public class testPatientManager {

	public static void main(String[] args) {
		Patient_Manager Az = new Patient_Manager();
		Patient johnMax = new Patient("John Max", 24, 3,"Patient is having trouble breathing","Waiting");
		Patient may = new Patient("May", 4, 5, "Patient has Covid-19","Checked out");
		Patient tim = new Patient("Tim", 11, 1, "Patient has no clear conditions","Waiting");
		Patient jane = new Patient("Jane Doe", 99, 10, "Patient is having a stroke","Waiting");
		Patient johnDoe = new Patient("John Doe", 109, 10,"Patient is the president of the USA","In-Progress",1);
		Az.addPatient(johnMax);
		Az.addPatient(may);
		Az.addPatient(tim);
		Az.addPatient(jane);
		Az.addPatient(johnDoe);
		Az.setStatus("John Max", "Checked Out");
		
		for(Patient p : Az.getList()) {
			System.out.println(p.toString()+ "\n");
		}
	}

}
