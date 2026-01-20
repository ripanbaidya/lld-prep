// Main
public class Application {
    public static void main(String[] args) {
        EmployeeRegistry registry = new EmployeeRegistry();

        // Register prototype employees
        registry.registerEmployee("java_dev", new Employee("john", "java developer", 10000.00));
        registry.registerEmployee("web_dev", new Employee("lux", "web developer", 5000.00));

        Employee javaDeveloper = registry.getEmployee("java_dev");
        Employee webDeveloper = registry.getEmployee("web_dev");

        javaDeveloper.showDetails();
        webDeveloper.showDetails();
    }
}