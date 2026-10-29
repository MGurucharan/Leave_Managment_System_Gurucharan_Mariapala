package leavemgmt;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee(1, "Alice", "HR");
        Employee e2 = new PartTimeEmployee(2, "Bob", "IT");
        Employee e3 = new Intern(3, "Carol", "Finance");
        e1.displayDetails();
        e2.displayDetails();
        e3.displayDetails();
        e1.applyLeave(5);
        e2.applyLeave(12);
        e3.applyLeave(2);
        e3.cancelLeave(1);
        System.out.println("Alice balance: " + e1.checkLeaveBalance());
    }
}
