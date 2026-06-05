package com.example.leavemanagement;

import java.util.UUID;

public class LeaveRequest {
    private final String id;
    private final String employeeId;
    private final LeaveType type;
    private final int days;
    private final String reason;
    private LeaveStatus status;

    public LeaveRequest(String employeeId, LeaveType type, int days, String reason) {
        this.id = UUID.randomUUID().toString();
        this.employeeId = employeeId;
        this.type = type;
        this.days = days;
        this.reason = reason;
        this.status = LeaveStatus.PENDING;
    }

    public String getId() {
        return id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public LeaveType getType() {
        return type;
    }

    public int getDays() {
        return days;
    }

    public String getReason() {
        return reason;
    }

    public LeaveStatus getStatus() {
        return status;
    }

    public void setStatus(LeaveStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LeaveRequest{" +
                "id='" + id + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", type=" + type +
                ", days=" + days +
                ", reason='" + reason + '\'' +
                ", status=" + status +
                '}';
    }
}
