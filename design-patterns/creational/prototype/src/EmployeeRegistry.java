import java.util.HashMap;
import java.util.Map;

public class EmployeeRegistry {

    private Map<String, Employee> prototypes = new HashMap<>();

    // Register a prototype
    public void registerEmployee(String key, Employee employee) {
        this.prototypes.put(key, employee);
    }

    // Get a prototype
    public Employee getEmployee(String key) {
        Employee employee = this.prototypes.get(key);
        if (employee == null) {
            throw new IllegalArgumentException("Employee " + key + " not found");
        }
        return employee.clone();
    }

}