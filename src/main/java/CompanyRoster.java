import java.util.ArrayList;
import java.util.Scanner;

public class CompanyRoster {

    private PayrollEmployee exec1 = new PayrollExecutive(10000, "Shawn",  "Daniels");
    private PayrollEmployee devel1 = new PayrollDeveloper(10001, "Sarah",  "Greene");
    private PayrollEmployee devel2 = new PayrollDeveloper(10002, "Derek",  "Mosher");
    private PayrollEmployee devel3 = new PayrollDeveloper(10004, "Nick",  "Naumenko");
    private PayrollEmployee sales1 = new PayrollSales(10005, "Ben",  "Williams");
    private PayrollEmployee hourly1 = new PayrollHourly(10006, "Travis",  "Pettrey");
    private PayrollEmployee hourly2 = new PayrollHourly(10007, "Cliff",  "Jenkins");

    private ArrayList<PayrollEmployee> allEmployees = new ArrayList<>();

    public void addInitialEmployees (){
        allEmployees.add(exec1);
        allEmployees.add(devel1);
        allEmployees.add(devel2);
        allEmployees.add(devel3);
        allEmployees.add(sales1);
        allEmployees.add(hourly1);
        allEmployees.add(hourly2);


    }

    public void displayEmployees (){
        System.out.println( "First Name\t Last Name");
        for (PayrollEmployee employee:allEmployees) {
            System.out.println( "\t"+ employee.getFirstName() +"\t\t"+ employee.getLastName());
        }
    }

    public void displayPayroll (){
        System.out.println( "First Name\t Last Name\tPay Amount");
        for (PayrollEmployee employee:allEmployees) {
            System.out.println( "\t"+ employee.getFirstName() +"\t\t"+ employee.getLastName() + "\t\t" + employee.getPaycheckTotal());
        }
    }



    public void calculatePay() {
        double paycheckTotal = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input bonus amount for the pay period ");
        double bonusToBePaid = scanner.nextDouble();

        for (PayrollEmployee employee : allEmployees) {
            if (employee instanceof PayrollHourly) {
                System.out.println("Please input the number of hours worked for " + employee.getFirstName() +""+ employee.getLastName());
                ((PayrollHourly) employee).setHoursWorked(scanner.nextInt());
                paycheckTotal = ((PayrollHourly) employee).getHoursWorked() * ((PayrollHourly) employee).getHourlyRate();


            } else if(employee instanceof PayrollSales){
                System.out.println("Please input the comission amount for " + employee.getFirstName() +""+ employee.getLastName());
                ((PayrollSales) employee).setSalesCommission(scanner.nextDouble());
              paycheckTotal = ((PayrollSales) employee).getPayPeriodEarnings() + ((PayrollSales) employee).receiveBonus(bonusToBePaid) + ((PayrollSales) employee).getSalesCommission();


            }else if (employee instanceof PayrollDeveloper) {
                paycheckTotal = ((PayrollDeveloper) employee).getPayPeriodEarnings() + ((PayrollDeveloper) employee).receiveBonus(bonusToBePaid) - ((PayrollDeveloper) employee).payInsurance();

            }else if (employee instanceof PayrollExecutive) {
                paycheckTotal = ((PayrollExecutive) employee).getPayPeriodEarnings() +((PayrollExecutive) employee).receiveBonus(bonusToBePaid) -((PayrollExecutive) employee).payInsurance();


            }
            employee.setPaycheckTotal(paycheckTotal);
        }


    }


    public ArrayList<PayrollEmployee> getAllEmployees() {
        return allEmployees;
    }
}
