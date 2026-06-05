LMS Board Plan

Board name: LMS

1. Title: Leave Management System Flow

2. Swimlane / Section: Actors
- Employee
- Manager
- Administrator

3. Flow Nodes:
- Employee Login / Authentication
- Submit Leave Request
  - Input: leave type, start date, end date, reason
  - Validation: date range, leave type selection
- Request Created (status: Pending)
- Employee View Request Status
  - Pending / Approved / Rejected
- Manager View Team Leave Requests
- Manager Approve or Reject Request
  - Optional comments
- Update Request Status
  - Approved -> adjust leave balance
  - Rejected -> record reason
- Employee Notification (placeholder)
- Administrator Manage Leave Types
  - Add / update leave types
- Administrator Configure Entitlements
  - Set annual values per leave type
- Reporting / Summary
  - Leave usage by type and status

4. Diagram Flow:
- Employee -> Submit Leave Request -> Request Created
- Request Created -> Employee View Request Status
- Request Created -> Manager Review
- Manager Review -> Approve / Reject
- Approve -> Update Balance -> Reporting
- Reject -> Record Reason -> Employee View Request Status
- Administrator -> Manage Leave Types / Configure Entitlements -> Reporting

5. Notes:
- Overlap Validation: Add a decision node after Submit Leave Request
  - If overlapping approved leave -> Reject request or flag overlap
  - Else proceed to Request Created
- Leave days calculation happens after approval
- System entities: LeaveRequest, LeaveType, LeaveBalance, Employee, Manager

Use this plan to create the LMS diagram in Miro.
