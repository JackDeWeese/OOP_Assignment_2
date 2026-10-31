package assignment2;

public class NetworkIssueRequest extends AbstractSupportRequest{
	private int affectedUsers;

    public NetworkIssueRequest(int id, String title, int basePoints, int affectedUsers) {
        super(id, title, basePoints);
        if (affectedUsers <= 0) {
            throw new IllegalArgumentException("Affected users count must be positive.");
        }
        this.affectedUsers = affectedUsers;
    }

    public int getAffectedUsers() { return affectedUsers; }

    @Override
    public int resolveFor(Technician technician) {
        markResolved();
        // Weighted rule: basePoints + (affectedUsers * 2)
        int points = getBasePoints() + (affectedUsers * 2);
        technician.addPoints(points);
        return points;
    }
}
