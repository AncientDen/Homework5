/*
 * Author:      Anysenko Denys
 * Course:      SDT 100 Principles of Programming
 * Assignment:  Homework 5 Part 1
 * Instructor:  Dr. V. Kolesnikov
 * Date:        September 27, 2026
 */


import calculations.calculations;
import java.util.Scanner;

public class calculator {
    public static void main(String[] args) { // Start the program

        Scanner input = new Scanner(System.in);   // Needed for taking input
        calculations calculator = new calculations(); //Needed to use calculations class

        double FirstOperand = 0; // Creating needed variables
        double SecondOperand = 0;
        double Result = 0;
        char Operation = ' ';
        String Choice = "Yes";
        boolean Prevresult = false;
        boolean Active = true;

        System.out.println("Welcome to the calculator");
        while (Active) {
            if (!Prevresult) { // Checks if there's a started operation
                System.out.print("Enter first operant: "); // Ask for the first input
                FirstOperand = input.nextDouble();
            } else { // If there is a started operation
                FirstOperand = Result;
                System.out.printf("Using previous result: " + FirstOperand + " ");
            }
            System.out.print(
                    "Enter operation (+, -, *, /) or R to reset: ");
            String Input = input.next();
            if (Input.equalsIgnoreCase("r")) {
                Prevresult = false; // Remove the previous result
                System.out.println(
                        "Reset completed."); // Tell the user the calculator was reset

            } else { //Or continue if user chooses to
                Operation = Input.charAt(0); // Get the operation character
                System.out.print("Enter second number: "); // Ask for the second number
                SecondOperand = input.nextDouble();

                if (Operation == '+') { // Addition process
                    Result = calculator.add(FirstOperand, SecondOperand);

                } else if (Operation == '-') { // Subtraction process
                    Result = calculator.subtract(FirstOperand, SecondOperand);

                } else if (Operation == '*') { // Multiplication process
                    Result = calculator.multiply(FirstOperand, SecondOperand);

                } else if (Operation == '/') {              // Division process
                    Result = calculator.divide(FirstOperand, SecondOperand);

                }
                System.out.printf("Your result is " + "%.2f%n", Result);
                Prevresult = true; // Save the result for the next calculation
            }

            if (Active) {
                System.out.print(
                        "Do you want to continue? Write Yes or No ");
                Choice = input.next();  // Read the user's choice
                    if (Choice.equalsIgnoreCase("No")) {
                        Active = false;                        // Stop the program
                }
            }
        }
        System.out.println(
                "Closing the program");
        input.close();
    }
}
