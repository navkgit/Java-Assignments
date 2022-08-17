package Assignment_3;

import java.util.Scanner;

public class VowelsAndConsonantsAndSpecicalChar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int vowelCount=0;
		int consCount=0;
		int spcount=0;
		int special=0;
		
		
		char[] vowels= {'A','E','I','O','U','a','e','i','o','u'};
		
		System.out.println("Enter the string:");
		String str = sc.nextLine();
		char[] strings = str.toCharArray();
		
		for(int i=0;i<strings.length;i++) {
			if(strings[i]==' ') 
				spcount++;
			if(str.charAt(i)<'A' || str.charAt(i)>'Z' && str.charAt(i)<'a' || str.charAt(i)>'z')
					special++;
			for(int j=0;j<vowels.length;j++) {
				if(strings[i]==vowels[j]) {
					vowelCount++;
				}
			}
		}
		
		consCount=strings.length-vowelCount-special;
		System.out.println("Total Letters : "+str.length());
		System.out.println("Total Vowels count : "+vowelCount);
		System.out.println("Total Consonant count : "+consCount);
		System.out.println("Total Space count : "+spcount);
		System.out.println("Total Special characters : "+(special-spcount));
		sc.close();
	}

}
