package com.simplilearn.Excercise;

import java.util.ArrayList;
import java.util.Scanner;

public class LISOfArrayOfNums {
	/* This methods processes all the numbers in the provided list
	 * and find outs the LIS of the given list...
	 */
	public static int findLIS(ArrayList<Integer> numList, int lenOflist)
	{
		int lis[] = new int[lenOflist];
        int i, j, max = 0;
 
        /* Initialize LIS values for all indexes with 1 */
        for (i = 0; i < lenOflist; i++)
            lis[i] = 1;
 
       //Using the bottom up manner to check the LIS 
        for (i = 1; i < lenOflist; i++)
        {
            for (j = 0; j < i; j++)
            {
            	int firstNum = numList.get(i);
            	int secondNum = numList.get(j);
            	 if (firstNum > secondNum && lis[i] < lis[j] + 1)
            	 {
            		 lis[i] = lis[j] + 1;
            	 }
            }
               
        }
        /* Pick maximum of all LIS values */
        for (i = 0; i < lenOflist; i++)
            if (max < lis[i])
                max = lis[i];
 
        return max;
	}
	
	
	public static void main(String[] args) {
		//Gets the user input for number of elements
		System.out.println("How many numbers to process??");
		Scanner input = new Scanner(System.in);
		int noOfElems = input.nextInt();
		//creates a list to store the user input
		ArrayList<Integer> numList = new ArrayList<Integer>();
		//asks the user to input all the numbers
		System.out.println("Enter the list of numbers");
		for (int index = 0; index < noOfElems;index++)
		{
			numList.add(input.nextInt()); //stores the numbers in a list 
		}
		
		//gets the length of the list
		int listLength = numList.size();
		//sends the input to the method and get backs the LIS
        System.out.println("Length of lis = " + findLIS(numList, listLength) + "\n");
		input.close();
	}

}
