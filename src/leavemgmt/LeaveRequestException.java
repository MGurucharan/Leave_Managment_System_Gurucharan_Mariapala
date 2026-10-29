package leavemgmt;

/** Thrown when a leave operation breaks a business rule. */
public class LeaveRequestException extends Exception {
    private static final long serialVersionUID = 1L;

    public LeaveRequestException(String message) {
        super(message);
    }
}
