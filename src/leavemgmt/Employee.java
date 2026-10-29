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

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + employeeName
                + ", Department: " + department + ", Leave balance: " + leaveBalance);
    }
}
