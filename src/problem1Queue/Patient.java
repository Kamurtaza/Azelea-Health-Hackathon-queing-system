package problem1Queue;

public class Patient {
    protected String name;
    protected int age;
    protected int rank;
    protected String condition;
    protected String status = "checked out";
    protected int roomNum;


	public Patient(String name, int age, int rank, String condition,String status, int roomNum) {
		this(name,age,rank,condition,status);
		this.roomNum = roomNum;
	}
	
	public Patient(String name, int age, int rank, String condition, String status) {
		this.name = name;
		this.age = age;
		this.rank = rank;
		this.condition = condition;
		this.status = status;
		this.roomNum = 0;
	}
	
	public Patient(String name) {
		this(name, 0, 0, "", "");
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
    	if (rank <0 || rank > 10) {
    		// throw exception
    		
    	}
    	this.rank = rank;
    }


    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }
    
    @Override 
    public String toString() {
    	String msg = "";
    	msg += "Name: " + name + "\nAge: " + age + "\nSeverity Ranking: " + rank + "\nDescription: " + condition + "\nStatus: " +status + "\nRoom Number: "
    			 + roomNum;
    			return msg;
    		}

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

