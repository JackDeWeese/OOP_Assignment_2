package assignment2;

public class PasswordResetRequest extends AbstractSupportRequest {
	private String accountName;

    public PasswordResetRequest(int id, String title, int basePoints, String accountName) {
        super(id, title, basePoints);
        if (accountName == null || accountName.isBlank()) {
            throw new IllegalArgumentException("Account name cannot be null or blank.");
        }
        this.accountName = accountName;
    }

    public String getAccountName() { return accountName; }

    //-----Override-----//
    public int resolveFor(Technician technician) {
        markResolved();		//marks resolved
        int points = getBasePoints();	//changes the points
        technician.addPoints(points);	//gives to the tech who worked on it
        return points;		//returns value of points
    }
}
