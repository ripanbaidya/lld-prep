/**
 * Enum Examples in Java
 */

/**
 * Example 1
 */
enum OrderStatus {
  PENDING,
  IN_PROGRESS,
  COMPLETED

  // .. more fields
}

/**
 * Example 2
 */
enum Coin {
  PENNY(1),
  NICKEL(5),
  DIME(10),
  QUARTER(25);

  private final int value;

  Coin(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}

public class Main {
  public static void main(String[] args) {

    // ** Example 1 **
    System.out.println(OrderStatus.PENDING.name()); // PENDING    
    System.out.println(OrderStatus.PENDING.ordinal()); // 0    

    OrderStatus status = OrderStatus.PENDING;
    switch (status) {
      case PENDING:
        System.out.println("Order is pending");
        break;
      case IN_PROGRESS:
        System.out.println("Order is in progress");
        break;
      case COMPLETED:
        System.out.println("Order is completed");
        break;
    }

    // ** Example 2 **
    Coin coin = Coin.DIME;
    System.out.println("The value of " + coin + " is " + coin.getValue());
  }
}