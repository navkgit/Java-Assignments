package Assignment_2;

import java.util.*;


class Guesser{
	
	int guessNum;
	
	public int guessNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Guesser guess the number:");
		guessNum=scan.nextInt();
		return guessNum;
	}
}

class Players{
	
	int pguessNum;
	
	public int pguessNumber() {
		Scanner scan=new Scanner(System.in);
		System.out.println("Player kindly guess the number between 0 to 10 :");
		pguessNum=scan.nextInt();
		int n = validNum(pguessNum);
		return n;
		
	}
	
	public int validNum(int num) {
		Scanner scan=new Scanner(System.in);
		while(num<0 || num>10) {
			System.out.println("Entered number is invalid");
			System.out.println("Player kindly guess the number between 0 to 10 :");
			num=scan.nextInt();
		}
		return num;
	}
}


class Umpire{
	
	int numFromGuesser;
	
	int []numFromPlayer = new int[10];
	
	int [] qflist = null;
	
	int [] sflist = null;
	
	int [] finalList = null;
	
	int []playerList = null;
	
	int count=0,qfcount=0,sfcount,fcount;
	
	public void collectNumFromGuesser()
	{
		Guesser guess = new Guesser();
		numFromGuesser=guess.guessNumber();
	}
	
	public void collectNumFromPlayers() {
		Players[] players = new Players[10];
		
		for(int i=0;i<players.length;i++) {
			players[i]=new Players();
			System.out.println("Player : "+(i+1));
			numFromPlayer[i]=players[i].pguessNumber();
		}
	}
	
	public void compare() {
		playerList = new int[10];
		for(int i=0;i<numFromPlayer.length;i++) {
			if(numFromGuesser==numFromPlayer[i]) {
				playerList[i]=i+1;
				count++;
			}
		}
		displayList();
		if(count>4) {
			System.out.println("\n\n"+" Quarter Final Round: ");
			quarterFinal(count);
		}
		else if(count<5 && count>=2) {
			System.out.println("\n\n"+" Semi Final Round: ");
			semiFinal(count);
		}
		else if(count>1){
			System.out.println("\n\n"+" Final Round: ");
			Final(count);
		}
		
	}
	
	public void displayList() {
		if(count>1) {
			System.out.println("\n Players won the game : ");
			for(int i=0;i<playerList.length;i++) {
				if(playerList[i]>0) {
					System.out.println(" Player-"+playerList[i]+" ");
				}
			}
		}
		else if(count==1) {
			System.out.println("\n Final winner win of the game : ");
			for(int i=0;i<playerList.length;i++) {
				if(playerList[i]>0) {
					System.out.print(" Player-"+playerList[i]+" ");
				}
			}
		}
		else
			System.out.println("\n"+" Better luck next time!!! No players won the game.");
	}
	
	// Quarter Final Lists 
	
	public void quarterFinal(int totalPlayers) {
		collectNumFromGuesser();
		int total[] = new int[totalPlayers];
		int j=0;
		for(int i=0;i<playerList.length;i++) {
			if(playerList[i]>0) {
				total[j]=playerList[i];
				j++;
			}
		}
		collectNumFromPlayers(total);
		
	}
	
	public void collectNumFromPlayers(int []qfPlayer) {
		
		Players[] qf = new Players[10];
		int qfnumFromPlayer[] = new int[10];
		int j=0;
		for(int i=0;i<qf.length;i++) {
			if(j<qfPlayer.length) {
				if(i==(qfPlayer[j]-1)) {
					qf[i]=new Players();
					System.out.println("Player : "+(i+1));
					qfnumFromPlayer[i]=qf[i].pguessNumber();
					j++;
				}
			}
		}
		compare(qfnumFromPlayer);
	}
	
	public void compare(int[] qfplayers) {
		qflist = new int[10];
		for(int i=0;i<qfplayers.length;i++) {
			if(numFromGuesser==qfplayers[i]) {
				qflist[i]=i+1;
				qfcount++;
			}
		}
		displayList(qflist);
		
		if(qfcount>2) {
			System.out.println("\n\n"+" Semi Final Round: ");
			semiFinal(qfcount);
		}
		else if(qfcount>1){
			System.out.println("\n\n"+" Final Round: ");
			Final(qfcount);
		}
	}

	public void displayList(int[] qflist) {
		if(qfcount>1) {
			System.out.println("\n\n"+" Quarter Finals winner:"+"\n");
			for(int i=0;i<qflist.length;i++) {
				if(qflist[i]>0) {
					System.out.print(" Player-"+(i+1)+" ");
				}
			}
		}
		else if(qfcount==1) {
			System.out.println("\n Final winner win of the game : ");
			for(int i=0;i<qflist.length;i++) {
				if(qflist[i]>0) {
					System.out.print(" Player-"+qflist[i]+" ");
				}
			}
		}
		else {
			System.out.println("\n"+"No player guessed the number correctly. Once again - ");
			System.out.println("\n\n"+" Quarter Final Round: ");
			quarterFinal(count);
		}
	}
	
	// Semi-Final List
	
	public void semiFinal(int totalPlayers) {
		collectNumFromGuesser();
		int total[] = new int[totalPlayers];
		int j=0;
		if(qflist == null) {
			for(int i=0;i<playerList.length;i++) {
				if(playerList[i]>0) {
					total[j]=playerList[i];
					j++;
				}
			}
		}else {
			for(int i=0;i<qflist.length;i++) {
				if(qflist[i]>0) {
					total[j]=qflist[i];
					j++;
				}
			}
		}
		collectNumFromPlayersSemi(total);
	}
	
public void collectNumFromPlayersSemi(int []sfPlayer) {
		
		Players[] sf = new Players[10];
		int sfnumFromPlayer[] = new int[10];
		int j=0;
		for(int i=0;i<sf.length;i++) {
			if(j<sfPlayer.length) {
				if(i==(sfPlayer[j]-1)) {
					sf[i]=new Players();
					System.out.println("Player : "+(i+1));
					sfnumFromPlayer[i]=sf[i].pguessNumber();
					j++;
				}
			}
		}
		comparesf(sfnumFromPlayer);
	}

public void comparesf(int[] sfplayers) {
	
	sflist = new int[10];
	for(int i=0;i<sfplayers.length;i++) {
		if(numFromGuesser==sfplayers[i]) {
			sflist[i]=i+1;
			sfcount++;
		}
	}
	displayListsf(sflist);
	if(sfcount>1) {
		System.out.println("\n\n"+" Final Round: ");
		Final(sfcount);
	}
}

public void displayListsf(int[] list) {
	if(sfcount>1) {
		System.out.println("\n\n"+" Semi Finals winner");
		for(int i=0;i<list.length;i++) {
			if(list[i]>0) {
				System.out.print(" Player-"+(i+1)+" ");
			}
		}
	}
	else if(sfcount==1){
		System.out.println("\n\n"+" Final winner of the game:");
		for(int i=0;i<list.length;i++) {
			if(list[i]>0) {
				System.out.print(" Player-"+(i+1)+" ");
			}
		}
	}
	else {
		System.out.println("\n"+"No player guessed the number correctly. Once again - ");
		System.out.println("\n\n"+" Semi Final Round: ");
		semiFinal(qfcount);
	}
}

// Finals List

public void Final(int totalPlayers) {
	collectNumFromGuesser();
	int total[] = new int[totalPlayers];
	int j=0;
	if(qflist == null && sflist == null) {
		for(int i=0;i<playerList.length;i++) {
			if(playerList[i]>0) {
				total[j]=playerList[i];
				j++;
			}
		}
	}else if(sflist == null){
		for(int i=0;i<qflist.length;i++) {
			if(qflist[i]>0) {
				total[j]=qflist[i];
				j++;
			}
		}
	}
	else {
		for(int i=0;i<sflist.length;i++) {
			if(sflist[i]>0) {
				total[j]=sflist[i];
				j++;
			}
		}	
	}
	collectNumFromPlayersFinal(total);
}

public void collectNumFromPlayersFinal(int []fPlayer) {
	
	Players[] f = new Players[10];
	int fnumFromPlayer[] = new int[10];
	int j=0;
	for(int i=0;i<f.length;i++) {
		if(j<fPlayer.length) {
			if(i==(fPlayer[j]-1)) {
				f[i]=new Players();
				System.out.println("Player : "+(i+1));
				fnumFromPlayer[i]=f[i].pguessNumber();
				j++;
			}
		}
	}
	comparef(fnumFromPlayer);
	
}

public void comparef(int[] fplayers) {
	
	finalList = new int[10];
	for(int i=0;i<fplayers.length;i++) {
		if(numFromGuesser==fplayers[i]) {
			finalList[i]=i+1;
			fcount++;
		}
	}
	displayListf(finalList);
	
}

public void displayListf(int[] list) {
	 if(fcount==1){
		System.out.println("\n\n"+" Final winner of the game:");
		for(int i=0;i<list.length;i++) {
			if(list[i]>0) {
				System.out.print(" Player-"+(i+1)+" ");
			}
		}
	}
	 else if(fcount>1) {
		 System.out.println("\n\n"+" Final Round:");
		 Final(fcount);
	 }
	 
	else {
		System.out.println("\n"+"No player guessed the number correctly. Better Luck Next time.");
	}
}
	
}

public class NumberGuessingGame {

	public static void main(String[] args) {
		
		System.out.println("Rules for the game:");
		System.out.println("1. 10 players will play the game.\n"
				+ "2. In first round 10 player will guess the number, player who guess the number between 1 to 10.\n" 
				+"3. correctly guessing playerwill move to next round like Quarter final, Semi Final or Final Round\n"
				+ "4. In Quarter final 5 player will be playing, in Semi final 4 will be player playing, in final 2 players will  be playing.\n"
				);
		
		Umpire umpire = new Umpire();
		umpire.collectNumFromGuesser();
		umpire.collectNumFromPlayers();
		umpire.compare();
		
	}

}
