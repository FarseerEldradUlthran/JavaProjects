import java.util.*;

class Employee extends EmployeeTest {
    private final String Name;
    private final String Surname;
    private final String Post;
    private final double Salary;

    public Employee(String name, String surname, String post, double salary) {
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
    private final ArrayList<Employee> employees = new ArrayList<>();
    public static double allIncome;
    public static int quantitySum;

    void hireAll(String post, int quantity, ArrayList<Employee> employee) {
        int i;
        Manager manager = new Manager();
        TopManager topManager = new TopManager();
        Operator operator = new Operator();
        switch (post) {
            case "Manager":
                for (i = 0; i < quantity; i++) {
                    employees.add(i, new Employee("Tom", "Reddle", "Manager", manager.calcSalary()));
                }
                break;
            case "Top Manager":
                for (i = 0; i < quantity; i++) {
                    employees.add(i, new Employee("Henry", "Exhaust", "Top Manager", topManager.calcSalary()));
                }
                break;
            case "Operator":
                for (i = 0; i < quantity; i++) {
                    employees.add(i, new Employee("Cris", "Goodmorning", "Operator", operator.calcSalary()));
                }
                break;
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
        int k = Company.quantitySum - 1;
        for (int i=0; i<Company.quantitySum/2; i++) {
            employees.remove(k);
            k--;
        }
    }
    public void getBiggestSalary(int count) {
        if(count < 0 || count > employees.size()) {
            return;
        }
        ArrayList<Employee> get = new ArrayList<>(this.employees);
        get.sort(Comparator.comparing(Employee::getSalary));
        Collections.reverse(get);
        ArrayList<Employee> biggestSalary = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            biggestSalary.add(get.get(i));
        }
        for (int i = 0; i < count; i++) {
            System.out.println(biggestSalary.get(i));
        }
    }

    public void getLowestSalary(int count) {
        if(count < 0 || count > employees.size()) {
            return;
        }
        for (int i = 0; i < employees.size(); i++) {
            for (int j = 0; j < employees.size() - 1 - i; j++) {
                if (employees.get(j).getSalary() > employees.get(j + 1).getSalary()) {
                    Employee t;
                    t = employees.get(j);
                    employees.set(j, employees.get(j + 1));
                    employees.set(j + 1, t);
                }
            }
        }
        List<Employee> lowestSalary = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lowestSalary.add(employees.get(i));
        }
        for (int i = 0; i < count; i++) {
            System.out.println(lowestSalary.get(i));
        }
    }
    public int longList() {
        return employees.size();
    }
}

public class EmployeeTest{
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Company company = new Company();
        company.hireAll("Top Manager", 10, employees);
        company.hireAll("Manager", 80, employees);
        company.hireAll("Operator", 180, employees);
        company.output();
        company.getBiggestSalary(15);
        company.getLowestSalary(30);
        company.destroyFiftyPercent();
        company.getBiggestSalary(15);
        company.getLowestSalary(30);
    }
}