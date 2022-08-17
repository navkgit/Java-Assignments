package Assignment_3;

public class ReverseString {

	public static void main(String[] args) {
		String str1 = "iNeuron";
		String str2="";
		
		for(int i=str1.length()-1;i>=0;i--) {
			str2=str2+str1.charAt(i);
		}
		System.out.println(str2);
		
		String s1 ="Think Twice";
		String s2="";
		String [] a=s1.split(" ");
		
		for(int i=0;i<a.length;i++) {
			for(int j=a[i].length()-1;j>=0;j--) {
				s2=s2+a[i].charAt(j);
			}
			s2=s2+" ";
		}
		System.out.println(s2);
		
	}

}
