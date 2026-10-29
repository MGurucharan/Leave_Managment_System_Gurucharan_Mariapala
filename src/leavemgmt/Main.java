package leavemgmt;

public class Main {
    public static void main(String[] args) {
        // Polymorphism: one array, many employee types
        Employee[] staff = {
            new FullTimeEmployee(1, "Alice", "HR"),
            new PartTimeEmployee(2, "Bob", "IT"),
            new Intern(3, "Carol", "Finance"),
            new Manager(4, "David", "Operations")
        };

        System.out.println("=== Employee details ===");
        for (Employee e : staff) {
            e.displayDetails();
        }

        System.out.println("\n=== Valid leave requests ===");
        tryApply(staff[0], 5, "Family event");
        tryApply(staff[1], 3, "Medical appointment");
        tryApply(staff[2], 2, "Exam preparation");
        tryApply(staff[3], 14, "Annual holiday");

        System.out.println("\n=== More requests (rules enforced per employee type) ===");
        tryApply(staff[1], 6, "Trip");       // part-time max is 5
        tryApply(staff[2], 3, "Vacation");   // intern max is 2
        tryApply(staff[0], 0, "Test");       // invalid days
        tryApply(staff[2], 2, "Second request");
        tryApply(staff[2], 2, "Third request");  // balance too low

        System.out.println("\n=== Cancelling leave ===");
        tryCancel(staff[0], 2);
        tryCancel(staff[0], 10);             // more than was taken

        System.out.println("\n=== Final balances ===");
        for (Employee e : staff) {
            System.out.println(e.getEmployeeName() + " (" + e.getEmployeeType() + "): "
                    + e.checkLeaveBalance() + " day(s) left");
        }

        System.out.println("\n=== Alice's leave history ===");
        staff[0].getLeaveHistory().forEach(h -> System.out.println(" - " + h));
    }

    private static void tryApply(Employee e, int days, String reason) {
        try {
            e.applyLeave(days, reason);
            System.out.println("OK   : " + e.getEmployeeName() + " applied " + days + " day(s)");
        } catch (LeaveRequestException ex) {
            System.out.println("ERROR: " + e.getEmployeeName() + " - " + ex.getMessage());
        }
    }

    private static void tryCancel(Employee e, int days) {
        try {
            e.cancelLeave(days);
            System.out.println("OK   : " + e.getEmployeeName() + " cancelled " + days + " day(s)");
        } catch (LeaveRequestException ex) {
            System.out.println("ERROR: " + e.getEmployeeName() + " - " + ex.getMessage());
        }
    }
}
