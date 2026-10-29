package leavemgmt;

public class Main {
    public static void main(String[] args) {
        Employee[] staff = {
            new FullTimeEmployee(1, "Alice", "HR"),
            new PartTimeEmployee(2, "Bob", "IT"),
            new Intern(3, "Carol", "Finance")
        };
        for (Employee e : staff) {
            e.displayDetails();
        }
        staff[0].applyLeave(5);
        staff[1].applyLeave(12);
        staff[2].applyLeave(2, "Exam preparation");
        staff[2].cancelLeave(1);
        System.out.println("Alice balance: " + staff[0].checkLeaveBalance());
    }
}
