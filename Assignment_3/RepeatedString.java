package Assignment_3;

import java.util.Scanner;

public class RepeatedString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the string:");
		String str = sc.nextLine();
		StringBuilder s=new StringBuilder(str.toLowerCase());
		String str1=" ";
		
		for(int i=0;i<s.length();i++) {
			int count=0;
			for(int j=i+1;j<s.length();j++) {
				if(s.charAt(i)==s.charAt(j) && s.charAt(i)!=' ') {
					count++;
					s.setCharAt(j, ' ');
				}
			}
			if(count>0) {
				str1=str1+s.charAt(i)+":"+(count+1)+" ";
			}
		}
		System.out.println("Repeated String are :"+str1);
		System.out.println(s);
		
		sc.close();
	}

}
