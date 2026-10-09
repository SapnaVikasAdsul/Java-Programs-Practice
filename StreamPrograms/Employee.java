
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Employee {

    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Amit", 40000),
                new Employee(2, "Rahul", 60000),
                new Employee(3, "Priya", 75000),
                new Employee(4, "Ankit", 45000)
        );

        //get the names of employees whose salary is greater than 50,000.
        List<String> names = employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .map(e -> e.getName())
                .toList();

        System.out.println(names);

        //Comparator.comparing(Employee::getName)          // String field
        //Comparator.comparingInt(Employee::getAge)        // int field
        //Comparator.comparingDouble(Employee::getSalary)  // double field
        //Sort salary in descending order
        List<Employee> sortedEmp = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .toList();

        System.out.println(sortedEmp);

        //find the employee with the highest salary.
        Optional<Employee> maxSal = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));

        System.out.println(maxSal);

        //find the employee with the second-highest salary.
        Optional<Employee> secondMax = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();
        System.out.println(secondMax);

        double totalSalary = employees.stream()
                .mapToDouble(e -> e.getSalary())
                .sum();

    }

}
