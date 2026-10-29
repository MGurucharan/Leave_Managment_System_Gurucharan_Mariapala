package leavemgmt;

public class Intern extends Employee {
    public Intern(int id, String name, String department) {
        super(id, name, department, 5);
    }

    @Override
    public boolean applyLeave(int d) {
        if (d <= 0) {
            System.out.println("Invalid number of days");
            return false;
        }
        if (d > 2) {
            System.out.println("Intern can take at most 2 days per request");
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
        return "Intern";
    }
}
