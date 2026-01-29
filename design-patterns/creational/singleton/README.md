# Singleton Design Pattern

| Pattern Name | Category   | Complexity  |
| ------------ | ---------- | ----------- |
| Singleton    | Creational | Easy–Medium |

> **Intent (One-liner):** Ensure that a class has **only one instance** and provide a **global access point** to it.

## Introduction (What + Why)

The **Singleton Pattern** restricts the instantiation of a class to **exactly one object** throughout the application lifecycle.

It is used when:

- A **single shared resource** must coordinate actions
- Multiple instances would cause **inconsistency or resource waste**

📌 Common examples: Configuration manager, Logger, Cache, Thread pool, Database connection manager

## Problem Statement (Why this pattern exists)

Consider a class like `DatabaseConnection`.

### ❌ Without Singleton

- Multiple instances are created
- Multiple DB connections open unnecessarily
- Inconsistent state across the app
- Wasted memory and resources

```java
DatabaseConnection db1 = new DatabaseConnection();
DatabaseConnection db2 = new DatabaseConnection(); // ❌ different object
```

This breaks:

- Resource management
- Data consistency
- Performance guarantees

### ✅ With Singleton

- Only one instance exists
- All clients share the same object
- Centralized control

## When to Use and When NOT to Use

### Use Singleton when:

- Exactly **one instance** is required
- The object represents a **shared system-wide resource**
- You need **controlled access** to that instance
- Object creation is **expensive**

### Avoid Singleton when:

- You need **multiple instances** in future
- Testing/mocking is important (Singletons make testing harder)
- The class holds mutable global state
- Dependency Injection can solve the problem better

📌 Overusing Singleton leads to **hidden global state**.

## Core Components (Participants)

| Component            | Responsibility                  |
| -------------------- | ------------------------------- |
| Singleton Class      | Holds the single instance       |
| Private Constructor  | Prevents external instantiation |
| Static Access Method | Returns the single instance     |

## UML / Structure (Mental Model)

<div style="text-align: center;">
  <img 
    src="https://media.geeksforgeeks.org/wp-content/uploads/20240112161311/Implementation-of-Singleton-Method-Design-Pattern.jpg"
    alt="Singleton Design Pattern"
    width="700"
    height="400"
  />
</div>

🧠 **Mental model**:

> “Private constructor + static instance + static accessor”

## Code (All Variations)

### 1 Eager Initialization

```java
public class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```

### 2 Lazy Initialization (NOT Thread-Safe ❌)

```java
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

❌ Breaks in multithreaded environment

### 3 Thread-Safe (Synchronized Method)

```java
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

✅ Thread-safe
❌ Performance overhead

### 4 Double-Checked Locking (Best Interview Choice ⭐)

```java
public class Singleton {
    // volatile ensures visibility of changes across threads
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        // First check (not synchronized) to improve performance)
        if (instance == null) {
            // Synchronize on the class object
            synchronized (Singleton.class) {
                // Second check (synchronized) to ensure thread safety
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

✅ Thread-safe
✅ Lazy
✅ High performance

📌 `volatile` prevents instruction reordering

### 5. Bill Pugh (Initialization-on-Demand Holder)

```java
public class Singleton {

    private Singleton() { }

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
```

✅ Best balance
✅ Lazy + Thread-safe
✅ No synchronization

### 6. Enum Singleton (Safest ⭐⭐)

```java
public enum Singleton {
    INSTANCE;
}
```

✅ Thread-safe
✅ Serialization safe
✅ Reflection safe
❌ Less flexible

## Real-World Use Cases

- Logger
- Configuration Manager
- Cache
- Thread Pool
- Database Connection Pool
- Spring Beans (default scope = singleton)

## Pros & Cons

### ✅ Pros

- Controlled access to sole instance
- Saves memory and resources
- Centralized state management

### ❌ Cons

- Global mutable state
- Hard to test and mock
- Tight coupling
- Can hide dependencies

## Common Pitfalls (VERY IMPORTANT)

### ❌ Breaking Singleton using Reflection

```java
void breakSingletonUsingReflection() throws Exception {
    // With the help of reflection we are accessing the private constructor
    Constructor<Singleton> constructors = Singleton.class.getDeclaredConstructor();

    // Making the private constructor accessible
    constructors.setAccessible(true);

    // Creating a new instance of Singleton using Singleton class itself
    // and using reflection
    Singleton instance1 = Singleton.getInstance();
    Singleton instance2 = constructors.newInstance();

    // The hashcode of both the instances will be different
    System.out.println(instance1.hashCode());
    System.out.println(instance2.hashCode());
    System.out.println(instance2.equals(instance1)); // false
}

✅ Fix:

We can use an boolean flag to which will be set to true when the instance is created. If the flag is already set, we will not create a new instance.
```

### ❌ Breaking using Serialization

```java
static void breakSingletonUsingSerialization() throws Exception {

    Singleton instance1 = Singleton.getInstance();

    // Serializing the instance
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file"));
    oos.writeObject(instance1);
    oos.close();

    // Deserializing the instance
    ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("file"));
    Singleton instance2 = (Singleton) ooi.readObject();
    ooi.close();

    // The hashcode of both the instances will be different
    System.out.println(instance1.hashCode());
    System.out.println(instance2.hashCode());
    System.out.println(instance2.equals(instance1)); // false
}
```

✅ Fix: Singleton should implement Serializable interface and override `readResolve()` method. to return the same instance and it will prevent the singleton pattern from being broken using deserialization.

## Related Patterns

| Pattern              | Relation                                |
| -------------------- | --------------------------------------- |
| Factory              | May return singleton instance           |
| Builder              | Controls object creation                |
| Dependency Injection | Preferred alternative                   |
| Monostate            | Shared state instead of shared instance |

📌 _Common confusion_:
Singleton ≠ Global Variable
Singleton **controls instantiation**

## Summary (Last Minute)

- Singleton ensures **only one instance**
- Private constructor is mandatory
- Thread safety matters
- Best choices:
  - **Enum Singleton**
  - **Bill Pugh**
  - **Double-checked locking**

- Avoid overuse

🧠 **One-liner recall**:

> “Singleton restricts a class to one instance and provides global access to it.”

## Resources

### Articles

- https://algomaster.io/learn/lld/singleton
- https://refactoring.guru/design-patterns/singleton

### Videos
