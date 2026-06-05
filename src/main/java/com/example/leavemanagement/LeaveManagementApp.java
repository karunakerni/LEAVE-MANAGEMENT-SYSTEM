package com.example.leavemanagement;

public class LeaveManagementApp {
    public static void main(String[] args) {
        LeaveService leaveService = new LeaveService();
        LeaveRequest request = leaveService.submitRequest("E123", LeaveType.PAID, 5, "Family event");
        System.out.println("Submitted request: " + request);

        leaveService.approveRequest(request.getId());
        System.out.println("Request after approval: " + leaveService.getRequest(request.getId()));
    }
}
