# Design (before coding)

## Main objects
- Employee (base): id, name, department, leave balance
- FullTimeEmployee, PartTimeEmployee, Intern: employee types with different leave rules
- Manager: later change request, extra leave benefits
- LeaveRequestException: signals an invalid leave operation

## Data
employeeId, employeeName, department, leaveBalance, leaveHistory

## Behaviours
applyLeave(), cancelLeave(), displayDetails(), checkLeaveBalance()

## Relationships
- FullTimeEmployee, PartTimeEmployee, Intern *inherit from* Employee (is-a)
- Manager *inherits from* FullTimeEmployee (is-a)
- Employee *uses* LeaveRequestException (throws)

## Leave rules
| Type      | Annual leave | Max days per request |
|-----------|--------------|----------------------|
| Full-time | 20           | 10                   |
| Part-time | 10           | 5                    |
| Intern    | 5            | 2                    |
| Manager   | 30           | 15                   |
