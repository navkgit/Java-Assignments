package Assignment_3;

import java.util.Scanner;

public class Pangram {
	
	public static boolean isAlphabets(char c) {
		if(!Character.isLetter(c))
			return false;
		return true;
	}
	
	public static boolean checkString(String str) {
		
		boolean[] present=new boolean[26];
		int index;
		
		for(int i=0;i<str.length();i++) {
			if(isAlphabets(str.charAt(i))) {
				index=(int)str.charAt(i)-'a';
				present[index]=true;
			}
		}
		
		for(int i=0;i<present.length;i++) {
			if(present[i]!= true) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the String: ");
		String str1 = sc.nextLine();
		
		boolean check = checkString(str1.toLowerCase());
		
		if(check==true) {
			System.out.println("String is pangram");
		}
		else
			System.out.println("String is not pangram");
		
		sc.close();
	}

}
