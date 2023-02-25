package com.simplilearn.Excercise;

public class TypeCasting {

	public static void main(String[] args) {
		char ch = 'A';
		System.out.println("Implicit type Casting from char to int");
		System.out.println("Value before = " + ch);
		int x = ch;
		System.out.println("Value after = " + x);
		
		float f = 65.8f;
		System.out.println("Explicit type Casting from float to int");
		System.out.println("Value before = " + f);
		int y = (int)x;
		System.out.println("Value after = " + y);
	}

}
