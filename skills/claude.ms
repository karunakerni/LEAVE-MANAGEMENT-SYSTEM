# Business Requirement Document: Leave Management System

## 1. Purpose

This document describes the business requirements for the Leave Management System. The system must allow employees to request leave, managers to review and approve or reject requests, and administrators to manage leave types and workflows.

## 2. Scope

In scope:
- Employee leave request creation and status tracking
- Leave type definition and entitlement management
- Manager approval/rejection workflow
- Leave balance calculation and reporting
- Email or notification placeholder for request updates

Out of scope:
- Payroll integration
- Multi-company organizational hierarchies
- Mobile native app support

## 3. Business Requirements

### 3.1 Employee Requirements
- Employees can submit leave requests with leave type, start date, end date, and reason.
- Employees can view the status of their leave requests (Pending, Approved, Rejected).
- Employees can see their remaining leave balance by leave type.

### 3.2 Manager Requirements
- Managers can view leave requests submitted by their direct reports.
- Managers can approve or reject leave requests with optional comments.
- Managers receive a record of decision and request details.

### 3.3 Administrator Requirements
- Administrators can define leave types (e.g. Annual, Sick, Casual).
- Administrators can configure annual leave entitlement values.
- Administrators can generate a summary report of leave usage.

## 4. Functional Requirements

- The system will store leave requests, employees, leave types, and leave balances.
- The system will validate that requested leave dates do not overlap existing approved leave.
- The system will calculate total leave days and adjust balances upon approval.
- The system will support test automation for request creation and approval.

## 5. Non-functional Requirements

- The system will run on Java 17 and Maven.
- The system will be maintainable with clear domain entities like LeaveRequest and LeaveService.
- The system will support unit tests and future Selenium/TestNG automation.

## 6. File Location

This requirement document is stored in the project under:
- `skills/claude.ms`

## 7. Notes

- If you want this document saved to a different skill file name, I can move it to that file instead.
