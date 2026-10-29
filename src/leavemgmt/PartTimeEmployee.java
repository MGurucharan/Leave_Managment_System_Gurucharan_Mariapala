package leavemgmt;

public class PartTimeEmployee extends Employee {
    public static final int ANNUAL_LEAVE = 10;
    public static final int MAX_DAYS_PER_REQUEST = 5;

    public PartTimeEmployee(int id, String name, String department) {
        super(id, name, department, ANNUAL_LEAVE);
    }

    @Override
    public String getEmployeeType() {
        return "Part-time";
    }

    @Override
    public int getMaxDaysPerRequest() {
        return MAX_DAYS_PER_REQUEST;
    }
}
