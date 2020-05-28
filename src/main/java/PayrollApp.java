import java.util.Scanner;

public class PayrollApp {

    public static void main(String[] args) {

        CompanyRoster allEmployees = new CompanyRoster();
        allEmployees.addInitialEmployees();
        allEmployees.displayEmployees();


        allEmployees.calculatePay();

        allEmployees.displayPayroll();


    }
}
//    Stretch Tasks
//    Give the user the option to not deduct insurance fees from insured employees
//    Give the user the option to not distribute a bonus DONE
//    Give the user the option to apply hazard pay, doubling the paycheckTotal for PayrollHourly DONE