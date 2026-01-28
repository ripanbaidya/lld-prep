package gift;

/**
 * Concrete Component
 * Example of Gift: Watch ..
 */
public class Watch implements Gift {
    private final String brand;

    public Watch(String brand) {
        this.brand = brand;
    }

    @Override
    public String prepare() {
        return "Watch [" + brand + "]";
    }
}
