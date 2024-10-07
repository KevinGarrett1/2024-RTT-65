package Calculator_App;

import java.util.Scanner;

public class MainEntry {
    public static void main(String[] args) {

        // Step 1: Settin' up the math operations using anonymous classes

        // Addition operation
        Calc<Integer, Double> add = new Calc<>() {
            @Override
            public Double compute(Integer[] intArray) {
                int sum = 0;
                for (int num : intArray) {
                    sum += num;
                }
                return (double) sum;
            }
        };

        // Subtraction operation
        Calc<Integer, Double> subtract = new Calc<>() {
            @Override
            public Double compute(Integer[] intArray) {
                if (intArray.length == 0) return 0.0;
                int result = intArray[0];
                for (int i = 1; i < intArray.length; i++) {
                    result -= intArray[i];
                }
                return (double) result;
            }
        };

        // Multiplication operation
        Calc<Integer, Double> multiply = new Calc<>() {
            @Override
            public Double compute(Integer[] intArray) {
                int result = 1;
                for (int num : intArray) {
                    result *= num;
                }
                return (double) result;
            }
        };

        // Division operation
        Calc<Integer, Double> divide = new Calc<>() {
            @Override
            public Double compute(Integer[] intArray) {
                if (intArray.length != 2) {
                    System.out.println("Division only works with two numbers. No more, no less.");
                    return 0.0;
                }
                if (intArray[1] == 0) {
                    System.out.println("Hold up, can't divide by zero!");
                    return 0.0;
                }
                return intArray[0] / (double) intArray[1];
            }
        };

        // Step 2: Get user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some integers (space-separated): ");
        String input = scanner.nextLine();
        String[] inputStrings = input.split(" ");
        Integer[] numbers = new Integer[inputStrings.length];
        for (int i = 0; i < inputStrings.length; i++) {
            numbers[i] = Integer.parseInt(inputStrings[i]);
        }

        // Step 3: Get operation from user
        System.out.println("What you wanna do? Choose: add, subtract, multiply, divide");
        String operation = scanner.nextLine().toLowerCase();

        // Step 4: Perform the chosen operation
        Double result = 0.0;
        switch (operation) {
            case "add":
                result = add.compute(numbers);
                break;
            case "subtract":
                result = subtract.compute(numbers);
                break;
            case "multiply":
                result = multiply.compute(numbers);
                break;
            case "divide":
                result = divide.compute(numbers);
                break;
            default:
                System.out.println("Uhh, that's not a valid operation.");
                return;
        }

        // Step 5: Show the result
        System.out.println("Here's your result: " + result);
        scanner.close();
    }
}