package Assignment_1;

public class PrintingNumbersAndHousePattern {

	public static void main(String[] args) {
		int n=14;
		
		for(int i=1;i<5;i++) {
			for(int j=1;j<5;j++) {
				System.out.print(i);
			}
			System.out.println(" ");
		}
		System.out.println(" ");
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==0 || i==n-1 || j==0 || j==n-1 || i+j<=(n-1)/2 || j-i>=(n-1)/2)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println(" ");
		}
	}

}
