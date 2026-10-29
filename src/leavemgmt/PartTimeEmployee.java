package leavemgmt;

public class PartTimeEmployee extends Employee {
    public PartTimeEmployee(int id, String name, String department) {
        super(id, name, department, 10);
    }

    @Override
    public boolean applyLeave(int d) {
        if (d <= 0) {
            System.out.println("Invalid number of days");
            return false;
        }
        if (d > 5) {
            System.out.println("Part-time can take at most 5 days per request");
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
        return "Part-time";
    }
}
