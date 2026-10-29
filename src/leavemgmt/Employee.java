package leavemgmt;

public class Employee {
    private int employeeId;
    private String employeeName;
    private String department;
    private int leaveBalance;

    public Employee(int employeeId, String employeeName, String department, int leaveBalance) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.leaveBalance = leaveBalance;
    }

    public int getEmployeeId() { return employeeId; }
    public String getEmployeeName() { return employeeName; }
    public String getDepartment() { return department; }
    public int getLeaveBalance() { return leaveBalance; }

    public boolean applyLeave(int d) {
        if (d <= 0) {
            System.out.println("Invalid number of days");
            return false;
        }
        if (d > leaveBalance) {
            System.out.println("Not enough leave balance");
            return false;
        }
        leaveBalance = leaveBalance - d;
        System.out.println(employeeName + " applied for " + d + " day(s)");
        return true;
    }

    public boolean cancelLeave(int d) {
        if (d <= 0) {
            System.out.println("Invalid number of days");
            return false;
        }
        leaveBalance = leaveBalance + d;
        System.out.println(employeeName + " cancelled " + d + " day(s)");
        return true;
    }

    public int checkLeaveBalance() {
        return leaveBalance;
    }

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + employeeName
                + ", Department: " + department + ", Leave balance: " + leaveBalance);
    }
}
