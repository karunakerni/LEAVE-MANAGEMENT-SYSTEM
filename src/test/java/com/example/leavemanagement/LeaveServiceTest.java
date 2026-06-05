package com.example.leavemanagement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LeaveServiceTest {
    @Test
    void submitAndApproveLeaveRequest() {
        LeaveService service = new LeaveService();
        LeaveRequest request = service.submitRequest("E123", LeaveType.PAID, 5, "Conference attendance");

        assertNotNull(request.getId());
        assertEquals(LeaveStatus.PENDING, request.getStatus());

        boolean approved = service.approveRequest(request.getId());
        assertTrue(approved);
        assertEquals(LeaveStatus.APPROVED, service.getRequest(request.getId()).getStatus());
    }

    @Test
    void rejectPendingLeaveRequest() {
        LeaveService service = new LeaveService();
        LeaveRequest request = service.submitRequest("E123", LeaveType.SICK, 2, "Medical leave");

        boolean rejected = service.rejectRequest(request.getId());
        assertTrue(rejected);
        assertEquals(LeaveStatus.REJECTED, service.getRequest(request.getId()).getStatus());
    }
}
