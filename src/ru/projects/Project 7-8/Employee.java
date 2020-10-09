import java.time.LocalDate;
import java.util.*;

class Employees extends Employee {
    private final String Name;
    private final String Surname;
    private String Post;
    private double Salary;

    public Employees(String name, String surname, String post, double salary) {
        Name = name;
        Surname = surname;
        Post = post;
        Salary = salary;
    }

    public String getName() {
        return Name;
    }

    public String getSurame() {
        return Surname;
    }

    public String getPost() {
        return Post;
    }

    public double getSalary() {
        return Salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Name is '" + Name + '\'' +
                ", Surname is '" + Surname + '\'' +
                ", post is '" + Post + '\'' +
                ", Salary is " + Salary +
                '}' + '\n';
    }
}
interface EmployeePosition{
    String getJobTitle();
    double calcSalary();
}

class Manager implements EmployeePosition{
    public String getJobTitle() {
        return "Manager";
    }
    public double calcSalary() {
        Random random = new Random();
        double income = 115000 + random.nextInt(25000);
        Company.allIncome += (0.95 * income);
        return 0.05 * income + 45000;
    }
}

class TopManager implements EmployeePosition{
    public String getJobTitle() {
        return "Top Manager";
    }
    public double calcSalary() {
        if (Company.allIncome > 10000000){
            return 1.5 * 100000 + 100000;
        } else{
            return 100000;
        }
    }
}

class Operator implements EmployeePosition{
    public String getJobTitle() {
        return "Operator";
    }

    public double calcSalary() {
        return 45000;
    }
}

class Company{
    private ArrayList<Employee> employees = new ArrayList<>();
    public static double allIncome;
    public static int quantitySum;

    void hireAll(String post, int quantity, ArrayList<Employee> employee) {
        int i;
        Manager manager = new Manager();
        TopManager topManager = new TopManager();
        Operator operator = new Operator();
        if (post == "Manager"){
            for (i=0; i<quantity; i++){
                employees.add(i, new Employees("Tom", "Reddle", "Manager", manager.calcSalary()));
            }
        }
        else if (post == "Top Manager"){
            for (i=0; i<quantity; i++){
                employees.add(i, new Employees("Henry", "Exhaust", "Top Manager", topManager.calcSalary()));
            }
        }
        else if (post == "Operator"){
            for (i=0; i<quantity; i++){
                employees.add(i, new Employees("Cris", "Goodmorning", "Operator", operator.calcSalary()));
            }
        }
        Company.quantitySum = Company.quantitySum + quantity;
        System.out.println(quantity + " " + post + "s hired." + '\n');
    }
    public void output(){
        System.out.println(employees);
    }

    public void hire(Employee employee){
        employees.add(employee);
    }

    public void destroy(int k){
        employees.remove(k);
    }

    public void destroyFiftyPercent(){
        int k = Company.quantitySum;
        for (int i=0; i<Company.quantitySum/2; i++) {
            employees.remove(k);
            k--;
        }
    }

    public void salarySorting(){
        Map<Employee, Double> sortedMap = new TreeMap<Employee, Double>(new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        sortedMap.putAll((Map<? extends Employee, ? extends Double>) employees);
    }

    public void lowestSalary(ArrayList<Employee> employees, int count){
        salarySorting();
        for(int i=0; i<count; i++){
            System.out.println(employees.get(i));
            }
    }
    public void bestSalary(List<Employee> employees, int count) {
        salarySorting();
        for (int i = Company.quantitySum; i > Company.quantitySum - count; i--) {
            System.out.println(employees.get(i));
        }
    }
}

public class Employee{
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Company company = new Company();
        company.hireAll("Top Manager", 10, employees);
        company.hireAll("Manager", 80, employees);
        company.hireAll("Operator", 180, employees);
        company.output();
    }
}
