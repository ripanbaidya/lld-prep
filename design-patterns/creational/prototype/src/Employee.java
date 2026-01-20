public class Employee implements Prototype<Employee> {

    private String name;
    private String role;
    private double salary;

    public Employee(String name, String role, double salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    // Copy constructor (only for internal use)
    private Employee(Employee employee) {
        this.name = employee.name;
        this.role = employee.role;
        this.salary = employee.salary;
    }

    @Override
    public Employee clone() {
        return new Employee(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println(
                "Name: " + name +
                        ", Role: " + role +
                        ", Salary: " + salary
        );
    }
}