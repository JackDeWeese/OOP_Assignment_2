package assignment2;
import java.util.Objects;

public class Technician {
	private String name;		//name and service point values
    private int servicePoints;	

    //setter
    public Technician(String name) {		
        if (name == null || name.isBlank()) {	//throw out illegal entries
            throw new IllegalArgumentException("Technician name cannot be null or blank.");
        }
        this.name = name;	//if all good, set the name
        this.servicePoints = 0;	//creating a new technician starts them out at 0 points
    }

    //Getters for the technician's name and points counter
    public String getName() { 
    	return name; 
    	}
    
    public int getServicePoints() { 
    	return servicePoints; 
    	}

    public void addPoints(int amount) {
        if (amount < 0) {	//cannot add negative points
            throw new IllegalArgumentException("Cannot add negative service points.");
        }
        this.servicePoints += amount;	//add legal amounts of points
    }

    //---------Override Functions-----------------//
    public String toString() {
        return "Technician: " + name + " (Points: " + servicePoints + ")";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Technician that = (Technician) o;
        return Objects.equals(name, that.name);
    }

    public int hashCode() {
        return Objects.hash(name);
    }
}
