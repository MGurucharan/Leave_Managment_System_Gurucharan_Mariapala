package leavemgmt;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Alice", "HR", 20);
        Employee e2 = new Employee(2, "Bob", "IT", 10);
        Employee e3 = new Employee(3, "Carol", "Finance", 5);
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
