package odd;

import java.util.Scanner;

public class BlackJack
{


	public static void main(String[] args)
	{

		Scanner read = new Scanner(System.in);
		System.out.println("Welcome to Mr. Lee's Blackjack Casino!");
		System.out.println("Would you like to play Blackjack against me?");
		System.out.print("Please type yes or no:");
		String answer = read.next();
		while(answer.compareToIgnoreCase("yes")!=0 && answer.compareToIgnoreCase("no")!=0) {
			System.out.print("Didn't get that. Re-enter:");
			answer=read.next();
		}
		if(answer.compareToIgnoreCase("yes") == 0)
		{
			System.out.println("Your cards will be here soon!");
			run();
		}
		else if (answer.compareToIgnoreCase("no") == 0)
		{
			System.out.println("See you next time!");
			System.exit(0);
		}

		else 
		{
			System.exit(0);
		}

	}
	public static void run()	// Runs the game
	{
		int mcard1;	
		int mcard2;
		int mcard3 = 0;
		int dcard1;
		int dcard2;
		int dcard3 = 0;
		int dtotalloop;
		int mtotal;
		int dtotal;
		Scanner read = new Scanner(System.in);
		System.out.println("RESULTS:: ");
		mcard1 = rand();
		mcard2 = rand();
		mtotal = mcard1+mcard2;
		dcard1 = rand();
		dcard2 = rand();
		dtotal = dcard1 + dcard2;

		System.out.println("You have the following cards " + mcard1 + " and " + mcard2);
		System.out.println("Your total is:: " + mtotal);
		if(mtotal>21) {
			System.out.println("You lost! ");
			System.exit(0);
		}
		System.out.println("Your dealer has the card "+dcard1 + " and the value for the other card is unknown. The total is also unknown.");
		System.out.println();


		System.out.println("Hit or stay?");
		String choice=read.next();
		while(choice.compareToIgnoreCase("hit")!=0 && choice.compareToIgnoreCase("stay")!=0) {
			System.out.println("Didn't get that. Hit or Stay?");
			choice  = read.next();
		}
		if (choice.compareToIgnoreCase("hit")==0) {
			hit (mcard3, mtotal, dtotal, dcard3);
			String choice2 =read.next();
			while(choice2.compareToIgnoreCase("hit")!=0 && choice2.compareToIgnoreCase("stay")!=0) {
				System.out.println("Didn't get that. Hit or Stay?");
				choice2  = read.next();
			}
			while(choice2.equals("hit")) {
				hit (mcard3, mtotal, dtotal, dcard3);
			}
			choice=read.next();
			while(choice.compareToIgnoreCase("hit")!=0 && choice.compareToIgnoreCase("stay")!=0) {
				System.out.println("Didn't get that. Hit or Stay?");
				choice  = read.next();
			}
		}
		System.out.println("Dealer reveals his secrets");
		System.out.println("2nd card: "+dcard2);
		System.out.println("Total:"+dtotal);
		System.out.println("Dealer's turn.");

		System.out.println("Dealer stays.");
		System.out.println("Let us compare numbers: ");
		System.out.println("Your total is "+mtotal+" while the dealer's is "+dtotal);
		if(choice.compareToIgnoreCase("stay")==0){
			stay(dtotal, dcard3);
		}
		System.out.println("Dealer stays.");
		System.out.println("Your total is "+mtotal+"while the dealer's is "+dtotal);
		if(dtotal>=mtotal) {
			System.out.println("You lose!");
		}
		else if (dtotal<mtotal){
			System.out.println("You win!");
		}
		else {
			System.out.println("Didn't get that. Hit or Stay?");
			choice  = read.next();
		}
	}


	

 


public static int rand() {
	int x;
	x = (int)(11* Math.random()+1);
	return x;

}  
public static void stay(int dtotal, int dcard3) {
	System.out.println("Dealer's turn.");
	while(dtotal<=16) {
		System.out.println("Dealer will hit.");
		dcard3 = rand();
		dtotal+=dcard3;
		System.out.println("Dealer draws a "+ dcard3);
		System.out.println("Dealer total is "+dcard3);
		if(dtotal>21) {
			System.out.println("You win!");
			System.exit(0);
		}
	}

}
public static void hit (int mcard3, int mtotal, int dtotal, int dcard3)  {
	System.out.println("You chose to hit"); 
	mcard3 = rand(); ;
	mtotal+=mcard3;
	System.out.println("You drew a " + mcard3 + ". You current total is " + mtotal );
	if(mtotal>21) {
		System.out.println("You lost.");
		System.exit(0);
	}
	System.out.println("Hit or stay?");
	while(dtotal<=16) {
		System.out.println("Dealer will hit.");
		dcard3 = rand();
		dtotal+=dcard3;
		System.out.println("Dealer draws a "+ dcard3);
		System.out.println("Dealer total is "+dtotal);
		busted(dtotal);
	
	}
	if(dtotal>=mtotal) {
		System.out.println("You lose!");
	}
	else {
		System.out.println("You win!");
	}

}
public static void busted (int dtotal) {
	if(dtotal>21) {
		System.out.println(" You win!");
		System.exit(0);
	}
}

}
