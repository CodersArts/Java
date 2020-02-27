import java.util.Random;
import java.util.Scanner;

public class SlotMachine {

	private Random generator;
	private int tokenCredit = 0;
	private static int houseCredit;

	public SlotMachine() {

	}

	public void topupTokens(int tokens) {
		tokenCredit = tokens + tokenCredit ;
	}

	public int cashoutTokens() {
		return tokenCredit;
	}

	public void pullLever() {
		int slotNumber[] = new int[3];
		int max = 9;
		int min = 0;

		for (int i = 0; i < 3; i++) {
			slotNumber[i] = (int) ((Math.random() * ((max - min) + 1)) + min);
		}

		if ((slotNumber[0] == 0) && (slotNumber[1] == 0) && (slotNumber[2] == 0)) {
			System.out.println("Super Jackpot Winner");
			tokenCredit = tokenCredit + (500 * 1);
		}

		if ((slotNumber[0] == slotNumber[1]) && (slotNumber[1] == slotNumber[2]) && (slotNumber[2] == slotNumber[0])) {
			System.out.println("Jackpot Winner");
			tokenCredit = tokenCredit + (50 * 1);
		}

		if ((slotNumber[0] == slotNumber[1]) && (slotNumber[2] >= 0 || slotNumber[2] <= 9)) {
			System.out.println("Free Spin");
			tokenCredit = tokenCredit + 1;
		}

		if ((slotNumber[0] != slotNumber[1]) && (slotNumber[1] != slotNumber[2]) && (slotNumber[2] != slotNumber[0])) {
			System.out.println("Bad Luck");
			tokenCredit = tokenCredit - 1;
		}

		if (1 < getTokenBalance())
			System.out.println("Insufficient Token Balance To Pull Lever");

	}

	public void pullLever(int tokenInput) {
		int slotNumber[] = new int[3];
		int max = 9;
		int min = 0;

		for (int i = 0; i < 3; i++) {
			slotNumber[i] = (int) ((Math.random() * ((max - min) + 1)) + min);
		}

		if ((slotNumber[0] == 0) && (slotNumber[1] == 0) && (slotNumber[2] == 0)) {
			System.out.println("Super Jackpot Winner");
			tokenCredit = tokenCredit + (500 * tokenInput);

		}

		else if ((slotNumber[0] == slotNumber[1]) && (slotNumber[1] == slotNumber[2])
				&& (slotNumber[2] == slotNumber[0])) {
			System.out.println("Jackpot Winner");
			tokenCredit = tokenCredit + (50 * tokenInput);
		}

		else if ((slotNumber[0] == slotNumber[1]) && (slotNumber[2] >= 0 || slotNumber[2] <= 9)) {
			System.out.println("Free Spin");
			tokenCredit = tokenCredit + tokenInput;
		}

		else if ((slotNumber[0] != slotNumber[1]) && (slotNumber[1] != slotNumber[2])
				&& (slotNumber[2] != slotNumber[0])) {
			System.out.println("Bad Luck");
			tokenCredit = tokenCredit - tokenInput;
		}

		else if (tokenInput > tokenCredit)
			System.out.println("Insufficient Token Balance To Pull Lever " + getTokenBalance());

		else
			System.out.println("Play Again");

	}

	public int getTokenBalance() {
		return tokenCredit;
	}

	public int getHouseCredit() {
		return houseCredit;
	}
	
	
	public static void main(String[] args) {
		int cashOutToken = 0;
		int inputNOOfToken;
		int machineTokenCredit = 0;
		int noOfSlotMachine = 3;
		int slotChoice;
		int exitChoice;
		int playChoice;
		int addAmount;
		
		SlotMachine SlotMachineGame[] = new SlotMachine[3];
		Scanner scanInput = new Scanner(System.in);

		for (int i = 0; i < noOfSlotMachine; i++) {
			SlotMachine game = new SlotMachine();
			SlotMachineGame[i] = game;
		}

		System.out.println("No of Slot Machine in Casino : " + noOfSlotMachine);
		do {
			for (int i = 0; i < noOfSlotMachine; i++)
				System.out.println("Slot Machine " + (i + 1));
			System.out.println("Total amount of tokens inserted across all instances of SlotMachine " + houseCredit);
			System.out.println("Enter your choice for slot machine");
			slotChoice = scanInput.nextInt();
			switch (slotChoice) {
			case 1:
				do {
					System.out.println("Token Available in Machine 1 : " + SlotMachineGame[0].getTokenBalance());
					System.out.println("Do you want to add amount in the Machine if yes enter 1 or else 0");
					addAmount = scanInput.nextInt();
					if (addAmount == 1) {
						System.out.println("Enter the amount of Token to enter in machine 1: ");
						machineTokenCredit = scanInput.nextInt();
						machineTokenCredit = machineTokenCredit + SlotMachineGame[0].getTokenBalance();
						SlotMachineGame[0].topupTokens(machineTokenCredit);
					} else {
						machineTokenCredit = SlotMachineGame[0].getTokenBalance();
						SlotMachineGame[0].topupTokens(machineTokenCredit);
					}
					System.out.println("Enter the no of Input Tokens to Gamble : ");
					inputNOOfToken = scanInput.nextInt();
					houseCredit = houseCredit + machineTokenCredit;
					machineTokenCredit = machineTokenCredit + SlotMachineGame[0].getTokenBalance();
					SlotMachineGame[0].pullLever(inputNOOfToken);
					System.out.println("Do you want to play again enter 1 or else 0");
					playChoice = scanInput.nextInt();
				} while (playChoice == 1);
				break;

			case 2:
				do {
					System.out.println("Token Available in Machine 2 : " + SlotMachineGame[1].getTokenBalance());
					System.out.println("Do you want to add amount in the Machine if yes enter 1 or else 0");
					addAmount = scanInput.nextInt();
					if (addAmount == 1) {
						System.out.println("Enter the amount of Token to enter in machine 2: ");
						machineTokenCredit = scanInput.nextInt();
						machineTokenCredit = machineTokenCredit + SlotMachineGame[1].getTokenBalance();
						SlotMachineGame[1].topupTokens(machineTokenCredit);
					}

					else {
						machineTokenCredit = SlotMachineGame[1].getTokenBalance();
						SlotMachineGame[1].topupTokens(machineTokenCredit);
					}
					System.out.println("Enter the no of Input Tokens to Gamble : ");
					inputNOOfToken = scanInput.nextInt();
					houseCredit = houseCredit + machineTokenCredit;
					machineTokenCredit = machineTokenCredit + SlotMachineGame[1].getTokenBalance();
					SlotMachineGame[1].pullLever(inputNOOfToken);
					System.out.println("Do you want to play again enter 1 or else 0");
					playChoice = scanInput.nextInt();
				} while (playChoice == 1);
				break;

			case 3:
				do {
					System.out.println("Token Available in Machine 3 : " + SlotMachineGame[2].getTokenBalance());
					System.out.println("Do you want to add amount in the Machine if yes enter 1 or else 0");
					addAmount = scanInput.nextInt();
					if (addAmount == 1) {
						System.out.println("Enter the amount of Token to enter in machine 3: ");
						machineTokenCredit = scanInput.nextInt();
						machineTokenCredit = machineTokenCredit + SlotMachineGame[2].getTokenBalance();
						SlotMachineGame[2].topupTokens(machineTokenCredit);
					} else {
						machineTokenCredit = SlotMachineGame[2].getTokenBalance();
						SlotMachineGame[2].topupTokens(machineTokenCredit);
					}
					System.out.println("Enter the no of Input Tokens to Gamble : ");
					inputNOOfToken = scanInput.nextInt();
					houseCredit = houseCredit + machineTokenCredit;
					SlotMachineGame[2].pullLever(inputNOOfToken);
					System.out.println("Do you want to play again enter 1 or else 0");
					playChoice = scanInput.nextInt();
				} while (playChoice == 1);
				break;

			}
			System.out.println("Do you want to Exit Casino enter 1 or else 0");
			exitChoice = scanInput.nextInt();

		} while (exitChoice == 1);
		cashOutToken = SlotMachineGame[0].cashoutTokens() + SlotMachineGame[1].cashoutTokens()
				+ SlotMachineGame[2].cashoutTokens();
//		machineTokenCredit = SlotMachineGame[0].getHouseCredit() + SlotMachineGame[1].getHouseCredit()
//				+ SlotMachineGame[2].getHouseCredit();
		System.out.println("Cash Out the Token");
		System.out.println("Token Amount is cashed Out : " + cashOutToken);
		System.out.println("Total Amount is put into All machine : " + houseCredit);
	}

}
