public class PayrollEmployee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private double paycheckTotal;


    public PayrollEmployee(int employeeId, String firstName, String lastName) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getPaycheckTotal() {
        return paycheckTotal;
    }

    public void setPaycheckTotal(double paycheckTotal) {
        this.paycheckTotal = paycheckTotal;
    }
}
