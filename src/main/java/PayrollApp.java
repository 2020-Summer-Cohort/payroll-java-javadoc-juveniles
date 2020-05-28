import java.util.Scanner;

public class PayrollApp {

    public static void main(String[] args) {

        CompanyRoster allEmployees = new CompanyRoster();
        allEmployees.addInitialEmployees();
        allEmployees.displayEmployees();

        allEmployees.calculatePay();


    }
}
