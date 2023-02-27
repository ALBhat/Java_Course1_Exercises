package com.simplilearn.Excercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SearchEmailId {
	/*This method searches the given email id inside the array of email id's.
	 * If the email id is present then return the index at which it is present
	 * otherwise just display the message saying email id not found.
	 */
	public void searchEmailId(ArrayList<String> listOfEmailIds, String searchEmailId, int index)
	{
		//creates a iterator for the email id list
		Iterator<String> arrIter = listOfEmailIds.iterator();
		boolean isEmailFound = false; //initialize the boolean value to indicate the presence of email id
		index = 0;
		//iterate inside the email list until there is no item left
		while(arrIter.hasNext())
		{
			index++; //increment the index
			//checks whether the user specified email id is same as email id at specific index
			//Note: It is case sensitive check
			if (arrIter.next().equals(searchEmailId))
			{
				//prints the message indicating the existence of email id at particular index
				System.out.println(searchEmailId + " found at index: " + index); 
				isEmailFound = true; //sets the boolean value to true
				break;
			}
		}
		//displays a message on the console that user specified email id is not present in the list of emails
		if (!isEmailFound)
		{
			System.out.println(searchEmailId + " not found!!");
		}
		
	}
	
	public static void main(String[] args) {
		
		//Asks the user to input number of email ids one want to enter
		System.out.println("Provide the total number of email-ids present??");
		Scanner sc = new Scanner(System.in); //Use the scanner object to get the user input
		int numOfEmaiIds = sc.nextInt(); //get the number
		
		//asks the user for entering the email ids
		System.out.println("Provide the list of emails");
		
		ArrayList<String> listOfEmailIds = new ArrayList<String>();//Creating arraylist  
		int index = 0;
		//iterate until the number of email ids matches the number provided by user 
		for (index = 0; index < numOfEmaiIds; index++)
		{
			//gets the email ids and put it inside the arraylist
			String emailId = sc.next();
			listOfEmailIds.add(emailId); 
		}
		//Asks the user to input the search email id
		System.out.println("Enter the email id to be searched??");
		String searchEmailId = sc.next(); //stores the email id in String
		sc.close();
		
		//create a object of current class and call the search method by passing the values.
		SearchEmailId searchemailid = new SearchEmailId();
		searchemailid.searchEmailId(listOfEmailIds, searchEmailId, index);
	}

}
