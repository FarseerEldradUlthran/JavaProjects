import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Employee {
    private final String Name;
    private final String Surname;
    private final LocalDate Birth;
    private  String Lplace;
    private long Number;
    private int Salary;

    public Employee(String name, String surname, LocalDate birth, String lplace, long number, int salary) {
        Name = name;
        Surname = surname;
        Birth = birth;
        Lplace = lplace;
        Number = number;
        Salary = salary;
    }

    public String getName(){
        return Name;
    }

    public String getSurame(){
        return Surname;
    }

    public LocalDate getBirth(){
        return Birth;
    }

    public String getLplace(){
        return Lplace;
    }

    public long getNumber(){
        return Number;
    }

    public int getSalary(){
        return Salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Name is '" + Name + '\'' +
                ", Surname is '" + Surname + '\'' +
                ", Birth date is " + Birth +
                ", Living place is '" + Lplace + '\'' +
                ", Number is '" + Number + '\'' +
                ", Salary is " + Salary +
                '}' + '\n';
    }
}

class Company {
    private ArrayList<Employee> employees = new ArrayList<>();
    public void hire(Employee employee){
        employees.add(employee);
    }
    public void output(){
        System.out.println(employees);
    }
    public void destroy(int k){
        employees.remove(k);
    }
    public void doSomethingWithSomeEmployees(employeeSelector selector, employeesHandler handler) {
        int count = 0;
        for(Employee employee: employees) {
            if (selector.needEmployee(employee)) {
                    handler.handleEmployees(employee, count);
                    count++;
            }
            System.out.println(count);
        }
    }
    @Override
    public String toString() {
        return "Company{" +
                "employees=" + employees +
                '}';
    }
}

interface employeeSelector {
    boolean needEmployee(Employee employee);
}

interface employeesHandler{
    void handleEmployees(Employee employee, int index);
}

class NumberSelector implements employeeSelector {

    private long Number;

    public NumberSelector(int Number) {

        this.Number = Number;
    }

    @Override
    public boolean needEmployee(Employee employee) {
        return employee.getNumber() > Number;
    }
}

public class EmployeeTest9 {
    public static void main(String[] args) {
        Company company = new Company();
        Random random = new Random(123);
        LocalDate time = LocalDate.of(1990, 01, 01);
        int i;
        for (i = 0; i < 5; i++) {
            company.hire(new Employee("Smith", "Blacksmith", time, "Sailor Avenue, 79/3", 80000000000L + random.nextInt(2100000000), 3000 + random.nextInt(3000)));
        }
        company.output();
        Scanner in = new Scanner(System.in);
        int k;
        k = in.nextInt();
        company.destroy(k);
        company.output();
        company.doSomethingWithSomeEmployees(bestEmployee -> bestEmployee.getName().startsWith("S"),
                (employee, index) -> {
                    System.out.println("===========" + index + "===========");
                    System.out.println(employee);
                });
        employeeSelector selector = bestEmployee -> bestEmployee.getSalary() < 4000;
        company.doSomethingWithSomeEmployees(
                selector,
                (Employee employee, int j) -> System.out.println(employee.getNumber()));
    }
}




















