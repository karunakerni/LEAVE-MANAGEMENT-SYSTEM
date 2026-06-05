package com.example.leavemanagement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LeaveService {
    private final Map<String, LeaveRequest> requests = new HashMap<>();

    public LeaveRequest submitRequest(String employeeId, LeaveType type, int days, String reason) {
        LeaveRequest request = new LeaveRequest(employeeId, type, days, reason);
        requests.put(request.getId(), request);
        return request;
    }

    public boolean approveRequest(String requestId) {
        LeaveRequest request = requests.get(requestId);
        if (request == null || request.getStatus() != LeaveStatus.PENDING) {
            return false;
        }
        request.setStatus(LeaveStatus.APPROVED);
        return true;
    }

    public boolean rejectRequest(String requestId) {
        LeaveRequest request = requests.get(requestId);
        if (request == null || request.getStatus() != LeaveStatus.PENDING) {
            return false;
        }
        request.setStatus(LeaveStatus.REJECTED);
        return true;
    }

    public LeaveRequest getRequest(String requestId) {
        return requests.get(requestId);
    }

    public Map<String, LeaveRequest> getAllRequests() {
        return Collections.unmodifiableMap(requests);
    }
}
