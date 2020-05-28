import java.util.ArrayList;
import java.util.Scanner;

public class CompanyRoster {

    private PayrollEmployee exec1 = new PayrollExecutive(10000, "Shawn", "Daniels");
    private PayrollEmployee devel1 = new PayrollDeveloper(10001, "Sarah", "Greene");
    private PayrollEmployee devel2 = new PayrollDeveloper(10002, "Derek", "Mosher");
    private PayrollEmployee devel3 = new PayrollDeveloper(10004, "Nick", "Naumenko");
    private PayrollEmployee sales1 = new PayrollSales(10005, "Ben", "Williams");
    private PayrollEmployee hourly1 = new PayrollHourly(10006, "Travis", "Pettrey");
    private PayrollEmployee hourly2 = new PayrollHourly(10007, "Cliff", "Jenkins");

    private ArrayList<PayrollEmployee> allEmployees = new ArrayList<>();

    public void addInitialEmployees() {
        allEmployees.add(exec1);
        allEmployees.add(devel1);
        allEmployees.add(devel2);
        allEmployees.add(devel3);
        allEmployees.add(sales1);
        allEmployees.add(hourly1);
        allEmployees.add(hourly2);


    }

    public void displayEmployees() {
        System.out.println("First Name\t Last Name");
        for (PayrollEmployee employee : allEmployees) {
            System.out.println("\t" + employee.getFirstName() + "\t\t" + employee.getLastName());
        }
    }

    public void displayPayroll() {
        System.out.println("First Name\t Last Name\tPay Amount");
        for (PayrollEmployee employee : allEmployees) {
            System.out.println("\t" + employee.getFirstName() + "\t\t" + employee.getLastName() + "\t\t" + employee.getPaycheckTotal());
        }
    }


    public void calculatePay() {
        double paycheckTotal = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Will there be a bonus? 1 for yes, 2 for no");
        int userInput = scanner.nextInt();
        double bonusToBePaid = 0;
        if (userInput == 1) {
            System.out.println("Please input bonus amount for the pay period ");
            bonusToBePaid = scanner.nextDouble();
        } else {
            System.out.println("No bonus will be paid this pay period");

        }


        for (PayrollEmployee employee : allEmployees) {
            if (employee instanceof PayrollHourly) {
                System.out.println("Please input the number of hours worked for " + employee.getFirstName() + " " + employee.getLastName());
                ((PayrollHourly) employee).setHoursWorked(scanner.nextInt());
                System.out.println("Was this hazard pay? 1 for yes, 2 for no ");

                int userInput1 = scanner.nextInt();
                if (userInput1 == 1) {
                    ((PayrollHourly) employee).receiveHazardPay();
                }
                paycheckTotal = ((PayrollHourly) employee).getHoursWorked() * ((PayrollHourly) employee).getHourlyRate();


            } else if (employee instanceof PayrollSales) {
                System.out.println("Please input the commission amount for " + employee.getFirstName() + " " + employee.getLastName());
                ((PayrollSales) employee).setSalesCommission(scanner.nextDouble());
                paycheckTotal = ((PayrollSales) employee).getPayPeriodEarnings() + ((PayrollSales) employee).receiveBonus(bonusToBePaid) + ((PayrollSales) employee).getSalesCommission();


            } else if (employee instanceof PayrollDeveloper) {
                System.out.println("Do you want insurance fees deducted from "  + employee.getFirstName() + " " + employee.getLastName() + " pay?  1 for yes, 2 for no");

                int userInput3 = scanner.nextInt();
                if (userInput3 == 1) {
                    paycheckTotal = ((PayrollDeveloper) employee).getPayPeriodEarnings() + ((PayrollDeveloper) employee).receiveBonus(bonusToBePaid) - ((PayrollDeveloper) employee).payInsurance();
                } else {
                    paycheckTotal = ((PayrollDeveloper) employee).getPayPeriodEarnings() + ((PayrollDeveloper) employee).receiveBonus(bonusToBePaid);
                }
            } else if (employee instanceof PayrollExecutive) {
                System.out.println("Do you want insurance fees deducted from " +employee.getFirstName() + " " +employee.getLastName() +  " pay? 1 for yes, 2 for no");

                int userInput4 = scanner.nextInt();
                if (userInput4 == 1) {
                    paycheckTotal = ((PayrollExecutive) employee).getPayPeriodEarnings() + ((PayrollExecutive) employee).receiveBonus(bonusToBePaid) - ((PayrollExecutive) employee).payInsurance();
                } else {
                    paycheckTotal = ((PayrollExecutive) employee).getPayPeriodEarnings() + ((PayrollExecutive) employee).receiveBonus(bonusToBePaid);
                }

            }
            employee.setPaycheckTotal(paycheckTotal);
        }


    }


    public ArrayList<PayrollEmployee> getAllEmployees() {
        return allEmployees;
    }
}
