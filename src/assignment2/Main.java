package assignment2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// Creating at least 3 technicians, including two with the same name to test HashSet behavior
        Technician tech_1 = new Technician("Macie Hoffman");
        Technician tech_2 = new Technician("Caleb Curry");
        Technician tech_3 = new Technician("Macie Hoffman"); // creating duplicate
        Technician tech_4 = new Technician("Pat Stewart");	//RIP

        Set<Technician> techSet = new HashSet<>();
        techSet.add(tech_1);
        techSet.add(tech_2);
        techSet.add(tech_3); // Should be considered a duplicate due to equals/hashCode
        techSet.add(tech_4);

        System.out.println("Technicians in HashSet (size should be 2): " + techSet.size());
        for (Technician t : techSet) {
            System.out.println(t);
        }
        System.out.println();

        //Create HelpDesk and at least 6 support requests (2 of each type minimum)
        HelpDesk helpDesk = new HelpDesk();

        PasswordResetRequest request_1 = new PasswordResetRequest(101, "Reset Admin Password", 10, "admin_user");
        PasswordResetRequest request_2 = new PasswordResetRequest(102, "Unlock Student Account", 10, "student123");

        DeviceSetupRequest request_3 = new DeviceSetupRequest(201, "Configure Lab Laptops", 15, 4);
        DeviceSetupRequest request_4 = new DeviceSetupRequest(202, "Setup Conference Projector", 20, 2);

        NetworkIssueRequest request_5 = new NetworkIssueRequest(301, "Library Wi-Fi Outage", 25, 12);
        NetworkIssueRequest request_6 = new NetworkIssueRequest(302, "Hallway Ethernet Drop", 15, 5);

        //Add requests to help desk
        helpDesk.addRequest(request_1);
        helpDesk.addRequest(request_2);
        helpDesk.addRequest(request_3);
        helpDesk.addRequest(request_4);
        helpDesk.addRequest(request_5);
        helpDesk.addRequest(request_6);

        //Assign at least 4 requests across at least 2 technicians
        helpDesk.assignRequest(tech_1, 101);
        helpDesk.assignRequest(tech_3, 201);
        helpDesk.assignRequest(tech_2, 301);
        helpDesk.assignRequest(tech_4, 102);

        //Resolve at least 3 requests across different request types
        helpDesk.resolveRequest(tech_1, 101); // PasswordReset
        helpDesk.resolveRequest(tech_1, 201); // DeviceSetup
        helpDesk.resolveRequest(tech_2, 301); // NetworkIssue

        //Printing all requests and technician assignments
        helpDesk.printAllRequests();
        System.out.println();

        helpDesk.printAssignmentsFor(tech_1);
        System.out.println();
        helpDesk.printAssignmentsFor(tech_2);
        System.out.println();
        helpDesk.printAssignmentsFor(tech_4);
        System.out.println();

        //Print final technician service point totals & test HelpDeskUtil.sumPoints
        System.out.println("--- Service Point Totals (Using Generics Utility) ---");
        List<Technician> techList = new ArrayList<>(techSet);
        HelpDeskUtil.printAll(techList);
        
        int totalPoints = HelpDeskUtil.sumPoints(techList);
        System.out.println("Total Service Points across all technicians: " + totalPoints);
        System.out.println();

        //Fail-Fast validations
        System.out.println("--- Demonstrating Fail-Fast Exceptions ---");
        try {
            System.out.println("Attempting to add a duplicate request ID (101)...");
            helpDesk.addRequest(new PasswordResetRequest(101, "Duplicate ID Test", 5, "test"));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        try {
            System.out.println("Attempting to resolve a request that is already resolved (101)...");
            helpDesk.resolveRequest(tech_1, 101);
        } catch (IllegalStateException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }

}
