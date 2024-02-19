import java.util.ArrayList;
import java.util.Scanner;

public class NumberList {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> numbers = new ArrayList<>();
    System.out.println("Enter numbers:");
    while (true) {
      String input = scanner.nextLine();
      if (input.equalsIgnoreCase("done")) {
        break;
      }

      try {
        int number = Integer.parseInt(input);
        numbers.add(number);
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
      }
    }
    if (numbers.isEmpty()) {
      System.out.println("No numbers entered.");
    } else {
      System.out.println("Entered numbers:");
      for (int number : numbers) {
        System.out.println(number);
      }
    }
  }
}
