package leavemgmt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Abstract base class for every employee type.
 * Common leave logic lives here; subclasses only supply their own rules.
 */
public abstract class Employee {
    private final int employeeId;
    private final String employeeName;
    private final String department;
    private final int annualLeave;
    private int leaveBalance;
    private final List<String> leaveHistory = new ArrayList<>();

    protected Employee(int employeeId, String employeeName, String department, int annualLeave) {
        if (employeeName == null || employeeName.isBlank()) {
            throw new IllegalArgumentException("Employee name must not be empty");
        }
        if (annualLeave < 0) {
            throw new IllegalArgumentException("Annual leave must not be negative");
        }
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.annualLeave = annualLeave;
        this.leaveBalance = annualLeave;
    }

    // ---------- Abstract methods: each employee type defines its own rules ----------
    public abstract String getEmployeeType();

    public abstract int getMaxDaysPerRequest();

    // ---------- Getters (encapsulation: fields stay private) ----------
    public int getEmployeeId() { return employeeId; }
    public String getEmployeeName() { return employeeName; }
    public String getDepartment() { return department; }
    public int getAnnualLeave() { return annualLeave; }
    public List<String> getLeaveHistory() { return Collections.unmodifiableList(leaveHistory); }

    public int checkLeaveBalance() {
        return leaveBalance;
    }

    // ---------- Method overloading: same name, different parameters ----------
    public void applyLeave(int days) throws LeaveRequestException {
        applyLeave(days, "Not specified");
    }

    public void applyLeave(int days, String reason) throws LeaveRequestException {
        validateDays(days);
        if (days > getMaxDaysPerRequest()) {
            throw new LeaveRequestException(getEmployeeType() + " can take at most "
                    + getMaxDaysPerRequest() + " day(s) per request");
        }
        if (days > leaveBalance) {
            throw new LeaveRequestException("Not enough leave balance (available: " + leaveBalance + ")");
        }
        leaveBalance -= days;
        leaveHistory.add("Applied " + days + " day(s) - " + reason);
    }

    public void cancelLeave(int days) throws LeaveRequestException {
        validateDays(days);
        if (leaveBalance + days > annualLeave) {
            throw new LeaveRequestException("Cannot cancel more leave than was taken");
        }
        leaveBalance += days;
        leaveHistory.add("Cancelled " + days + " day(s)");
    }

    // Subclasses may override to add more details (method overriding)
    public void displayDetails() {
        System.out.printf("%-10s | ID: %d | Name: %-6s | Dept: %-10s | Balance: %2d/%d day(s)%n",
                getEmployeeType(), employeeId, employeeName, department, leaveBalance, annualLeave);
    }

    private void validateDays(int days) throws LeaveRequestException {
        if (days <= 0) {
            throw new LeaveRequestException("Number of days must be greater than zero");
        }
    }
}
