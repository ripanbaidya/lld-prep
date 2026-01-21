// Person class
class Person {
  // Fields or attributes
  String name;
  int age;

  // Constructor
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // Methods
  public void displayPersonInfo() {
    System.out.println(
      "Name: " + name +
      " Age: " + age
    );
  }
}

// Main class
public class Main {
  public static void main(String[] args) {
    Person p1 = new Person("Ripan Baidya", 21);
    Person p2 = new Person("John Doe", 23);

    p1.displayPersonInfo();
    p2.displayPersonInfo();
  }
}