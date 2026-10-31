package assignment2;

public class DeviceSetupRequest extends AbstractSupportRequest {
	private int deviceCount;	

    public DeviceSetupRequest(int id, String title, int basePoints, int deviceCount) {
        super(id, title, basePoints);
        if (deviceCount <= 0) {
            throw new IllegalArgumentException("Device count must be positive.");
        }
        this.deviceCount = deviceCount;
    }

    public int getDeviceCount() { 
    	return deviceCount; 
    	}

    //-----Override----//
    public int resolveFor(Technician technician) {
        markResolved();	//changes the boolean value to true
        int points = getBasePoints() * deviceCount;	//changes points based on request
        technician.addPoints(points);	//adds the points to the technician that did the job
        return points;	//returns the number of points as well
    }
}
