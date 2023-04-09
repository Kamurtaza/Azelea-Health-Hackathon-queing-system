package problem1Queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Patient_Manager {
	static ArrayList<Patient> patients = new ArrayList<Patient>();
	static final String WAITING = "Waiting";
	static final String READY = "Ready";
	static final String INPROGRESS = "In-Progress";
	static final String ONHOLD = "On Hold";
	static final String CHECKEDOUT = "Checked Out";
	static final Comparator<Patient> COMPNAME = new PatientNameComparator();
	static final Comparator<Patient> COMPRANK = new PatientRankComparator();
	static private Scanner input = new Scanner(System.in);
	
	public Patient_Manager() {		
	}


	public static void main(String[] args) {
		Patient_Manager manager = new Patient_Manager();
		
		String a = "";
		while(!a.equalsIgnoreCase("Exit")) {
			System.out.println("Choose one of the options below:\n(New Patient, Edit Current Patient, View Patients):\n");
			a = input.nextLine();
			switch (a.substring(0,2).toLowerCase()) {
			case "ne":
				manager.createNewPatient();
				break;
			case "ed":
				manager.editCurrentPatient();
				break;
			case "vi":			
				manager.viewPatients();
				break;
			default:
				if (!a.equalsIgnoreCase("Exit")) System.out.println("Invalid input, try again.");
			}
		}


		input.close();
	}


	private void createNewPatient() {
		//TODO
		String a = "";
		
		
		
		
		System.out.println("Creating...");
		
	}
	
	private void editCurrentPatient() {
		String a = "";
		
		System.out.println("\n\nEditing...");
		
		while (!a.equalsIgnoreCase("Exit")) {
			System.out.println("Enter name of patient to edit or type \"view patients\"");
			a = input.nextLine();
			switch (a.toLowerCase()) {
			case "view patients":
				listPatientNames(COMPRANK);
				break;
			default:
				if (patients.contains(new Patient(a))) {
					editPatient(a);
				}else {
					System.out.printf("\n\nUnable to find patient %s\n",a);
				}
			}
		}
		
	}

	private void editPatient(String a) {
		Patient pat = getPatient(a);
		System.out.println(pat);
		String b = "";
		while (!b.equalsIgnoreCase("Exit")) {
			System.out.println("Change what about the patient?\n(Name, Age, Condition, Severity, Status, Room number)");
			b = input.nextLine();
			switch (b.toLowerCase()) {
			case "name":
				System.out.print("Enter a new name for patient:");
				pat.setName(input.nextLine());
				break;
			case "age":
				System.out.print("Enter a new age (integer) for patient:");
				pat.setAge(Integer.parseInt(input.nextLine()));
				break;
			case "condition":
				System.out.print("Explain condition of patient:");
				pat.setCondition(input.nextLine());
				break;
			case "severity":
				System.out.print("Enter a severity level (1-10) for patient:");
				pat.setRank(Integer.parseInt(input.nextLine()));
				break;
			case "status":
				System.out.print("Enter patient status\n((1)WAITING,(2)READY,(3)INPROGRESS,(4)ONHOLD,(5)CHECKEDOUT):");
				b = input.nextLine();
				switch (b.toLowerCase()) {
				case "1":
				case "waiting":
					pat.setStatus(WAITING);
					break;
				case "2":
				case "ready":
					pat.setStatus(READY);
					break;
				case "3":
				case "inprogress":
				case "in-progress":
				case "in progress":
					pat.setStatus(INPROGRESS);
					break;
				case "4":
				case "onhold":
				case "on hold":
				case "on-hold":
					pat.setStatus(ONHOLD);
					break;
				case "5":
				case "checkedout":
				case "checked-out":
				case "checked out":
					pat.setStatus(CHECKEDOUT);
					break;
				}
				break;
			case "room number":
				System.out.print("Enter a room number for the patient");
				pat.setRoomNum(Integer.parseInt(input.nextLine()));
				break;
			default:
				if (!a.equalsIgnoreCase("Exit")) System.out.println("Invalid input, try again.");	
			}
		}
	}
	
	private void viewPatients() {
		String a = "";

		while (!a.equalsIgnoreCase("exit")) {
			System.out.println("View patients by (1)Name, (2)Rank, (3)Condition");
			a = input.nextLine();
			switch (a.toLowerCase()) {
			case "1":
			case "name":
				listPatientNames(COMPNAME);
				break;
			case "2":
			case "rank":				
				listPatientNames(COMPRANK);
				break;
			case "3":
			case "condition":
				patientStatusMenu();
				break;
			default:
				System.out.print("\nInvalid input, try again.");
			}
			
		}
	}
	
	private void listPatientNames(Comparator<Patient> a) {
		//TODO: list all patient names alphabetically
	}
	
	private void patientStatusMenu() {
		String a = "";
		
		while(!a.equalsIgnoreCase("Exit")){
			System.out.print("Enter a patient status to view (Waiting,Ready,In-Progress,On Hold,Checked Out):");
			a = input.nextLine();
			ArrayList<Patient> c = getListStatus(a);
			c.sort(COMPRANK);
			for(Patient p : c) {
				System.out.println(p.toString()+ "\n");
			}
		}
	}

	public ArrayList<Patient> getList(){
		return patients;
	}
	
	public static void addPatient(Patient p) {
		if (patients.contains(p)){
			p.setStatus(WAITING);
		}
		else {
			patients.add(p);
			patients.sort(new PatientRankComparator());
		}
	}
	
	public Patient getPatient(String name) {
		for (Patient p : patients) {
			if(p.getName() == name) {
				return p;
			}
		}
		return null;
	}
	
	public void setRank(String name,int rank) {
		getPatient(name).setRank(rank);
	}
	
	public void setStatus(String name, String status) {
		getPatient(name).setStatus(status);
		if(status == CHECKEDOUT) {
			patients.remove(getPatient(name));
		}
	}
	
	public void setAge(String name, int age) {
		getPatient(name).setAge(age);
	} 
	
	//Patients are sorted by Rank
	public void sortListRank() {
		patients.sort(COMPNAME);
	}
	
	//Patients sorted by Name
	public void sortListName() {
		patients.sort(COMPRANK);
	}
	
	public ArrayList<Patient> getListStatus(String status){
		ArrayList<Patient> list = new ArrayList<Patient>();
		for(Patient p : patients) {
			if(p.getStatus().equalsIgnoreCase(status)) {
				list.add(p);
			}
		}
		return list;
	
	}
	}

