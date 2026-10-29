package leavemgmt;

public class FullTimeEmployee extends Employee {
    public static final int ANNUAL_LEAVE = 20;
    public static final int MAX_DAYS_PER_REQUEST = 10;

    public FullTimeEmployee(int id, String name, String department) {
        this(id, name, department, ANNUAL_LEAVE);
    }

    // Lets subclasses (e.g. Manager) reuse this class with a different entitlement
    protected FullTimeEmployee(int id, String name, String department, int annualLeave) {
        super(id, name, department, annualLeave);
    }

    @Override
    public String getEmployeeType() {
        return "Full-time";
    }

    @Override
    public int getMaxDaysPerRequest() {
        return MAX_DAYS_PER_REQUEST;
    }
}
