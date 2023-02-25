package com.simplilearn.Excercise;
import java.util.Scanner;

public class ArithmeticCalculator {
	public static void main(String[] args) {
		System.out.println("Enter the first number");
		Scanner input = new Scanner(System.in);
		int num1 = input.nextInt();
		
		System.out.println("Enter the second number");
		int num2 = input.nextInt();
		
		System.out.println("Enter the operator (+, -, *, /)");
		char oper = input.next().charAt(0);
		
		switch(oper)
		{
			case '+': 	int sum = num1 + num2;
						System.out.println("Sum of numbers = "+sum);
						break;
			case '-': 	int diff = num1 - num2;
						System.out.println("Difference of numbers = "+diff);
						break;
			case '*': 	int prod = num1 * num2;
						System.out.println("Product of numbers = " + prod);
						break;
			case '/': 	if(num2 == 0)
						{
							System.out.println("Error: Division by zero");
							break;
						}
						int quot = num1 / num2;
						System.out.println("Quotient after division = "+quot);
						break;
			default:
			        	System.out.println("Invalid operator!");
			        	break;
		}
		input.close();
	}
}
