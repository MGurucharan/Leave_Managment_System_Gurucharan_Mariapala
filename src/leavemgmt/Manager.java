package leavemgmt;

public class Manager extends Employee {
    public Manager(int id, String name, String department) {
        super(id, name, department, 30);
    }

    @Override
    public boolean applyLeave(int d) {
        if (d <= 0) {
            System.out.println("Invalid number of days");
            return false;
        }
        if (d > 15) {
            System.out.println("Manager can take at most 15 days per request");
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
        return "Manager";
    }
}
