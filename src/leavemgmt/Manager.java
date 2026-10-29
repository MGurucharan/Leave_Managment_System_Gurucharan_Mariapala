package leavemgmt;

/**
 * Change request: Manager gets extra leave benefits.
 * Reuses FullTimeEmployee, so only the differences are written here.
 */
public class Manager extends FullTimeEmployee {
    public static final int BONUS_LEAVE = 10;
    public static final int MAX_DAYS_PER_REQUEST = 15;

    public Manager(int id, String name, String department) {
        super(id, name, department, FullTimeEmployee.ANNUAL_LEAVE + BONUS_LEAVE);
    }

    @Override
    public String getEmployeeType() {
        return "Manager";
    }

    @Override
    public int getMaxDaysPerRequest() {
        return MAX_DAYS_PER_REQUEST;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("           (includes " + BONUS_LEAVE + " bonus leave day(s) for managers)");
    }
}
