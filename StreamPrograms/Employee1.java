
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;

    // getters, setters, constructor
    public Employee(int id, String department, String name, int salary) {
        this.department = department;
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Amit", "IT", 40000),
                new Employee(2, "Rahul", "Finance", 60000),
                new Employee(3, "Priya", "HR", 75000),
                new Employee(4, "Ankit", "HR", 45000)
        );

        //    Collectors.counting()          // count
        //    Collectors.averagingDouble()   // average
        //    Collectors.summingDouble()     // sum
        // Using Streams, group employees by department.
        Map<String, List<Employee>> grouping = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println(grouping);

        //  find how many employees are present in each department.
        Map<String, Long> result = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ));
        System.out.print(result);

        //    Average Salary by Department
        Map<String, Double> average = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
        System.out.println(average);
        //partition two groups whose salary>50000
        // groupingBy()    → multiple groups based on a key
       //  partitioningBy() → exactly two groups: true / false
        Map<Boolean, List<Employee>> partition = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 50000));
        System.out.println(partition);
         
        //Names from IT dept with salary>50000
        List<String> namesFromIT = employees.stream()
        .filter(e -> e.getDepartment().equals("IT")
                && e.getSalary() > 50000)
        .map(Employee::getName)
        .toList();

        //
        boolean anyEmp = employees.stream()
        .anyMatch(e -> e.getSalary() > 100000);

    }
      

}
