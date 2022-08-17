package Assignment_3;

import java.util.Scanner;

public class Anagram {
	
	public static String sortingString(String str) {
		String s =" ";
		char[] st = str.toCharArray();
		
		for(int i=0;i<st.length;i++) {
			for(int j=i+1;j<st.length;j++) {
				if(st[i]>st[j]) {
					char temp = st[i];
					st[i]=st[j];
					st[j]=temp;
				}
			}
			if(st[i]!=' ') {
				s=s+st[i];
			}
		}
		
		return s;
	}

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter String 1 : ");
		String str1 = sc.nextLine();
		
		System.out.println("Enter String 2 : ");
		String str2 = sc.nextLine();
		
		
			String s1=sortingString(str1);
			String s2=sortingString(str2);
			
			if(s1.equals(s2)) {
				System.out.println("Entered two strings are anagram");
			}
			else {
				System.out.println("Entered two strings are not anagram");
			}
		
		sc.close();
	}

}
