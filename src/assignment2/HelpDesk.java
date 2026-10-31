package assignment2;
import java.util.*;

public class HelpDesk {
	private Map<Integer, SupportRequest> requestsById;
    private Map<Technician, List<SupportRequest>> assignments;

    public HelpDesk() {
        this.requestsById = new HashMap<>();
        this.assignments = new HashMap<>();
    }

    public void addRequest(SupportRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null.");
        }
        if (requestsById.containsKey(request.getId())) {
            throw new IllegalArgumentException("Duplicate request ID: " + request.getId());
        }
        requestsById.put(request.getId(), request);
    }

    public SupportRequest findRequest(int id) {
        return requestsById.get(id);
    }

    public void assignRequest(Technician technician, int requestId) {
        SupportRequest request = findRequest(requestId);
        if (request == null) {
            throw new IllegalArgumentException("Request ID " + requestId + " not found.");
        }

        assignments.putIfAbsent(technician, new ArrayList<>());
        List<SupportRequest> techAssignments = assignments.get(technician);

        //Preventing assigning the exact same request instance to the same technician twice
        if (techAssignments.contains(request)) {
            throw new IllegalStateException("Request " + requestId + " is already assigned to " + technician.getName());
        }

        techAssignments.add(request);
    }

    public int resolveRequest(Technician technician, int requestId) {
        List<SupportRequest> techAssignments = assignments.get(technician);
        if (techAssignments == null) {
            throw new IllegalArgumentException("Technician has no assignments.");
        }

        SupportRequest request = findRequest(requestId);
        if (request == null || !techAssignments.contains(request)) {
            throw new IllegalArgumentException("Request " + requestId + " is not assigned to this technician.");
        }

        // Polymorphic call avoiding request-type checking
        return request.resolveFor(technician);
    }

    public void printAllRequests() {
        System.out.println("--- All Help Desk Requests ---");
        for (SupportRequest req : requestsById.values()) {
            System.out.println(req);
        }
    }

    public void printAssignmentsFor(Technician technician) {
        System.out.println("Assignments for " + technician.getName());
        List<SupportRequest> techAssignments = assignments.get(technician);
        if (techAssignments == null || techAssignments.isEmpty()) {
            System.out.println("No assignments.");
            return;
        }
        for (SupportRequest req : techAssignments) {
            System.out.println(req);
        }
    }
}
