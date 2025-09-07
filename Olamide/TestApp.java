import java.util.Scanner;

public class SpeedTest {

    public static int TimeCalculator(long endTime, long startTime) {
        int timeTaken = (int) ((endTime - startTime) / 1000); 
        return timeTaken;
    }

   
    public static int WordCalculator(int numberOfWords, int timeTaken) {
        if (timeTaken == 0) return 0; 
        double wordsPerMinute = (numberOfWords / (timeTaken / 60.0));
        return (int) wordsPerMinute;
    }

   
public static int AccuracyCalculator(int correctCharacters, int totalCharactersTyped) {
        if (totalCharactersTyped == 0) return 0; 
        double accuracy = ((double) correctCharacters / totalCharactersTyped) * 100; 
        return (int) accuracy;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    
        String sentence = "The quick brown fox jumps over the lazy dog.";
        System.out.println("Typing Speed Test");
        System.out.println("Type the following sentence:");
        System.out.println(sentence);

        System.out.println("\nPress ENTER when ready...");
        scanner.nextLine();

       
        long startTime = System.currentTimeMillis();

      
        System.out.println("\nStart typing now:");
        String userInput = scanner.nextLine();

        
        long endTime = System.currentTimeMillis();

      
        int timeTaken = TimeCalculator(endTime, startTime);

       int numberOfWords = userInput.trim().split("\\s+").length;
        int wpm = WordCalculator(numberOfWords, timeTaken);

        int correctChars = 0;
        int minLength = Math.min(sentence.length(), userInput.length());
	        for (int i = 0; i < minLength; i++) {
            if (sentence.charAt(i) == userInput.charAt(i)) {
                correctChars++;
            }
        }
        int accuracy = AccuracyCalculator(correctChars, sentence.length());

        System.out.println("\n=== Results ===");
        System.out.println("Time taken: " + timeTaken + " seconds");
        System.out.println("Words per minute: " + wpm);
        System.out.println("Accuracy: " + accuracy + "%");

}
}