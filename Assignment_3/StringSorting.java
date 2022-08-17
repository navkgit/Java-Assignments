package Assignment_3;

import java.util.Scanner;

public class StringSorting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the string:");
		String str = sc.nextLine();
		
		char[] strings = str.toCharArray();
		
		for(int i=0;i<strings.length;i++) {
			for(int j=i+1;j<strings.length;j++) {
				if((int)strings[i]>(int)strings[j]) {
					char temp=strings[i];
					strings[i]=strings[j];
					strings[j]=temp;
				}
			}
		}
		
		System.out.println("Sorted String : ");
		for (char c : strings) {
			System.out.print(c+" ");
		}
		
		sc.close();
	}

}
