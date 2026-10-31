package assignment2;

public abstract class AbstractSupportRequest implements SupportRequest {
	protected int id;		//this class will now fulfill the "contract" that the interface
    protected String title;		//requires to be made
    protected int basePoints;
    protected boolean resolved;

    public AbstractSupportRequest(int id, String title, int basePoints) {
    	//checking all inputed values for illegal passes
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive.");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank.");
        }
        if (basePoints <= 0) {
            throw new IllegalArgumentException("Base points must be positive.");
        }
        //otherwise sets the values
        this.id = id;
        this.title = title;
        this.basePoints = basePoints;
        this.resolved = false;	//a request automatically starts at unresolved
    }

    //-------Override Functions-------------//
    public int getId() { 
    	return id; 
    	}

    public String getTitle() { 
    	return title; 
    	}

    public int getBasePoints() { 
    	return basePoints; 
    	}

    public boolean isResolved() { 
    	return resolved; 
    	}

    protected void markResolved() {
        if (this.resolved) {	//checks to see if request that has been completed was already marked completed
            throw new IllegalStateException("Request is already resolved.");	//if so that's an error
        }
        this.resolved = true;	//only should be resolved once
    }

    public String toString() {				//fun ternary use				
        return "Request #" + id + " [" + (resolved ? "RESOLVED" : "UNRESOLVED") + "]: " + title + " (Base Points: " + basePoints + ")";
    }
}
