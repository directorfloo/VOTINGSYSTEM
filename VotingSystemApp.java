import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
public class VotingSystemApp {

    static Scanner input = new Scanner(System.in); 
    static LocalDate date = LocalDate.now();

    static ArrayList<String> candidates = new ArrayList<>(); 
    static ArrayList<Integer> candidateAges = new ArrayList<>();
   static ArrayList<String> candidatePartys = new ArrayList<>();

    static ArrayList<Integer> voterAges = new ArrayList<>();
    static ArrayList<String> voterCountry = new ArrayList<>();
    static ArrayList<String> voters = new ArrayList<>(); 
	static ArrayList<String> candidateVotes = new ArrayList<>(); 



    public static void main(String... args) {
        registerCandidates();
         registerVoters();
         conductVoting();
        // showResults();
    }
    public static void registerCandidates() {
        System.out.println("======== Welcome to Voting System =======");
        System.out.print("Enter number of candidates: ");
        int number = input.nextInt();
        input.nextLine(); // Consume newline after nextInt()

   	 for (int count = 0; count < number; count++) {
            System.out.print("Enter candidate " + (count + 1 ) + " name: ");
            String name = input.nextLine();

       System.out.print("Enter political party of the candidate: ");
       	 	String party = input.next();
        	input.nextLine(); 
            

       System.out.print("Enter age of candidate: ");
       	 	int age = input.nextInt();
        	input.nextLine(); 
		
		if (age < 35 || age > 75) {
	System.out.println("please you can not registered");	
	} else {
            	candidates.add(name);
            	candidateAges.add(age);
		candidatePartys.add(party);
            	System.out.println( name + " registered successfully!");
	}
        }

System.out.println("\n=== Registered Candidates ===");
for (int counter = 0; counter < candidates.size(); counter++) {
    System.out.println("- " + candidates.get(counter)  + " (Age: " + candidateAges.get(counter)  + ", Party: " + candidatePartys.get(counter) + ")");
}
System.out.println();
 }
    
public static void registerVoters() {
    System.out.print("Enter number of Voters: ");
    int numbers = input.nextInt();
    input.nextLine(); 

    for (int counter = 0; counter < numbers; counter++) {
        System.out.print("Enter voter " + (counter + 1 ) + " name: ");
        String name = input.nextLine();

        System.out.print("Enter age of voter: ");
        int age = input.nextInt();
        input.nextLine(); 

        System.out.print("Enter country of voter: ");
        String country = input.nextLine();

        if (age < 18 ) {
            System.out.println( name + " is under 18 and cannot register.\n");	
        } else if (!country.equalsIgnoreCase("Nigeria")) {
            System.out.println(" Only citizens of Nigeria can register.\n");	
        } else {
            voters.add(name);
            voterAges.add(age);
            voterCountry.add(country);
            System.out.println( name + " registered successfully!\n");
        }
    }
    
    System.out.println("\n=== Registered Voters ===");
    for (int index = 0; index < voters.size(); index++) {
        System.out.println("- " + voters.get(index) 
            + " (Age: " + voterAges.get(index) 
            + ", Country: " + voterCountry.get(index) + ")");
   
}
    System.out.println();
}
	
  public static void conductVoting() {
        System.out.println("\n======== Voting Process Begins ========");
        for (int index = 0; index < voters.size(); index++) {
            System.out.println("\n" + voters.get(index) + ", please cast your vote.");
            System.out.println("Choose a candidate by number:");

            for (int count = 0; count < candidates.size(); count++) {
                System.out.println(( count + 1) + ". " + candidates.get(count) + " (" + candidatePartys.get(count) + ")");
            }

            int choice = 0;
            while (true) {
                System.out.print("Enter choice (1-" + candidates.size() + "): ");
                choice = input.nextInt();
                if (choice >= 1 && choice <= candidates.size()) {
		System.out.println("Thank you for casting your vote.");
                    break;
                } else {
                    System.out.println("Invalid choice. Try again.");
                
           	 }
	         }
		
	 }
         } 
	 }




