package leavemgmt;

public class FullTimeEmployee extends Employee {
    public FullTimeEmployee(int id, String name, String department) {
        super(id, name, department, 20);
    }

    @Override
    public boolean applyLeave(int d) {
        if (d <= 0) {
            System.out.println("Invalid number of days");
            return false;
        }
        if (d > 10) {
            System.out.println("Full-time can take at most 10 days per request");
            return false;
        }
        if (d > leaveBalance) {
            System.out.println("Not enough leave balance");
            return false;
        }
        leaveBalance = leaveBalance - d;
        System.out.println(getEmployeeName() + " applied for " + d + " day(s)");
        return true;
    }

    @Override
    public String getEmployeeType() {
        return "Full-time";
    }
}
