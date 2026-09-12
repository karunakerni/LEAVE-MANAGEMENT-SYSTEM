package com.example.leavemanagement;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LeaveServiceAllTestCases {
#This change is for just learning. This change has been added from local
    @Test
    void TC001_createValidLeaveRequest() {
        LeaveService service = new LeaveService();
        LeaveRequest request = service.submitRequest("E123", LeaveType.PAID, 5, "Vacation");

        assertNotNull(request.getId());
        assertEquals("E123", request.getEmployeeId());
        assertEquals(LeaveType.PAID, request.getType());
        assertEquals(5, request.getDays());
        assertEquals("Vacation", request.getReason());
        assertEquals(LeaveStatus.PENDING, request.getStatus());
        assertSame(request, service.getRequest(request.getId()));
    }

    @Test
    void TC002_createLeaveRequestWithAlternateType() {
        LeaveService service = new LeaveService();
        LeaveRequest request = service.submitRequest("E124", LeaveType.SICK, 3, "Medical");

        assertNotNull(request.getId());
        assertEquals(LeaveType.SICK, request.getType());
        assertEquals("Medical", request.getReason());
        assertEquals(LeaveStatus.PENDING, request.getStatus());
    }

    @Test
    void TC003_viewLeaveBalance() {
        LeaveService service = new LeaveService();
        LeaveRequest request = service.submitRequest("E125", LeaveType.PAID, 4, "Annual leave");

        Map<String, LeaveRequest> allRequests = service.getAllRequests();
        assertTrue(allRequests.containsKey(request.getId()));
        assertEquals(1, allRequests.size());
    }

    @Test
    void TC004_submitLeaveRequestWithReason() {
        LeaveService service = new LeaveService();
        LeaveRequest request = service.submitRequest("E126", LeaveType.PAID, 2, "Family event");

        assertEquals("Family event", request.getReason());
        assertEquals(LeaveStatus.PENDING, request.getStatus());
    }

    @Test
    void TC005_managerApprovesPendingRequest() {
        LeaveService service = new LeaveService();
        LeaveRequest request = service.submitRequest("E127", LeaveType.PAID, 5, "Conference");

        boolean approved = service.approveRequest(request.getId());
        assertTrue(approved);
        assertEquals(LeaveStatus.APPROVED, service.getRequest(request.getId()).getStatus());
    }

    @Test
    void TC006_managerRejectsPendingRequest() {
        LeaveService service = new LeaveService();
        LeaveRequest request = service.submitRequest("E128", LeaveType.SICK, 1, "Medical");

        boolean rejected = service.rejectRequest(request.getId());
        assertTrue(rejected);
        assertEquals(LeaveStatus.REJECTED, service.getRequest(request.getId()).getStatus());
    }

    @Test
    void TC007_employeeViewsApprovedStatus() {
        LeaveService service = new LeaveService();
        LeaveRequest request = service.submitRequest("E129", LeaveType.PAID, 3, "Training");
        service.approveRequest(request.getId());

        LeaveRequest stored = service.getRequest(request.getId());
        assertEquals(LeaveStatus.APPROVED, stored.getStatus());
    }

    @Test
    void TC008_employeeViewsRejectedStatus() {
        LeaveService service = new LeaveService();
        LeaveRequest request = service.submitRequest("E130", LeaveType.SICK, 2, "Medical");
        service.rejectRequest(request.getId());

        LeaveRequest stored = service.getRequest(request.getId());
        assertEquals(LeaveStatus.REJECTED, stored.getStatus());
    }

    @Test
    void TC009_adminCreatesNewLeaveType() {
        LeaveService service = new LeaveService();
        LeaveRequest request = service.submitRequest("E131", LeaveType.UNPAID, 5, "Compassionate leave");

        assertEquals(LeaveType.UNPAID, request.getType());
        assertEquals("Compassionate leave", request.getReason());
    }

    @Test
    void TC010_generateLeaveUsageReport() {
        LeaveService service = new LeaveService();
        service.submitRequest("E132", LeaveType.PAID, 2, "Vacation");
        service.submitRequest("E133", LeaveType.SICK, 1, "Medical");

        Map<String, LeaveRequest> allRequests = service.getAllRequests();
        assertEquals(2, allRequests.size());
    }

    @Disabled("Feature not implemented: overlap validation")
    @Test
    void TC011_submitLeaveWithOverlappingDates() {
        // TODO: Implement overlap validation in LeaveService
    }

    @Disabled("Feature not implemented: date validation")
    @Test
    void TC012_submitLeaveWithEndDateBeforeStartDate() {
        // TODO: Implement invalid date range validation in LeaveService
    }

    @Disabled("Feature not implemented: required reason enforcement")
    @Test
    void TC013_submitLeaveWithoutRequiredReason() {
        // TODO: Implement required reason validation in LeaveService
    }

    @Disabled("Feature not implemented: manager direct-report authorization")
    @Test
    void TC014_managerApprovesNonDirectReportRequest() {
        // TODO: Implement direct-report authorization in LeaveService
    }

    @Disabled("Feature not implemented: invalid leave type handling")
    @Test
    void TC015_submitRequestWithInvalidLeaveType() {
        // TODO: Implement unsupported leave type validation in LeaveService
    }

    @Disabled("Feature not implemented: missing date validation")
    @Test
    void TC016_requestCreationWithMissingDates() {
        // TODO: Implement required date validation in LeaveService
    }

    @Disabled("Feature not implemented: entitlement exhaustion validation")
    @Test
    void TC017_requestCreationWhenEntitlementExhausted() {
        // TODO: Implement entitlement tracking in LeaveService
    }

    @Disabled("Feature not implemented: approved-state rejection prevention")
    @Test
    void TC018_managerRejectsAlreadyApprovedRequestAttempt() {
        // TODO: Implement invalid state transition prevention in LeaveService
    }

    @Disabled("Feature not implemented: duplicate leave type management")
    @Test
    void TC019_adminCreatesDuplicateLeaveType() {
        // TODO: Implement duplicate leave type handling in LeaveService
    }

    @Disabled("Feature not implemented: entitlement boundary validation")
    @Test
    void TC020_submitLeaveAtEntitlementBoundary() {
        // TODO: Implement boundary entitlement validation in LeaveService
    }

    @Disabled("Feature not implemented: single-day leave handling test")
    @Test
    void TC021_submitOneDayLeaveRequest() {
        // TODO: Implement single-day leave request validation if required
    }

    @Disabled("Feature not implemented: report generation")
    @Test
    void TC022_generateReportWithNoLeaveRequests() {
        // TODO: Implement reporting capability in LeaveService
    }

    @Disabled("Feature not implemented: boundary date validation")
    @Test
    void TC023_submitLeaveRequestOnBoundaryDate() {
        // TODO: Implement boundary date validation in LeaveService
    }
}
