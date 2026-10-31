package assignment2;

public interface SupportRequest {
	int getId();			//Request id number
    String getTitle();		//name for request
    int getBasePoints();	//points valued for completion
    boolean isResolved();	//yes or no has been fixed
    int resolveFor(Technician technician);	
}
