import java.util.Scanner;

public class TrackerApp {

    public static Scanner scanner = new Scanner(System.in);

    static String[] books = {
        "Pride and Prejudice by Jane Austen",
        "Jane Eyre by Charlotte Brontë",
        "Wuthering Heights by Emily Brontë",
        "Great Expectations by Charles Dickens",
        "Moby Dick by Herman Melville"
    };
    static boolean[] borrowed = new boolean[books.length];

    public static void main(String... args) {
        int choice;

        do {
            menuMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();   // use the static scanner
            GoToTrackApp(choice);
        } while (choice != 0);

        System.out.println("Exiting... Goodbye!");
    }

    public static void menuMenu() {
        String prompt = ("""
                Welcome to the Tracking Application

                Choose from the menu:

                1 -> View all books
                2 -> Borrow a book
                3 -> Return a book
                0 -> Exit
                """);
        System.out.println(prompt);
    }

    public static void GoToTrackApp(int trackInput) {
        switch (trackInput) {
            case 1 -> {
                System.out.println("\n=== List of Books ===");
                for (int count = 0; count < books.length; count++) {
                    String status = borrowed[count] ? "Borrowed" : "Available";
                    System.out.println((count + 1) + ". " + books[count] + " - " + status);
                }
            }

            case 2 -> {
                System.out.println("\nWhich book would you like to borrow?");
                for (int count = 0; count < books.length; count++) {
                    if (!borrowed[count]) {
                        System.out.println((count + 1) + ". " + books[count]);
                    }
                }
                System.out.print("Enter book number: ");
                int borrowChoice = scanner.nextInt();
                if (borrowChoice >= 1 && borrowChoice <= books.length) {
                    if (!borrowed[borrowChoice - 1]) {
                        borrowed[borrowChoice - 1] = true;
                        System.out.println("You borrowed \"" + books[borrowChoice - 1] + "\".");
                    } else {
                        System.out.println("Sorry, that book is already borrowed.");
                    }
                } else {
                    System.out.println("Invalid choice.");
                }
            }

            case 3 -> {
                System.out.println("\nWhich book would you like to return?");
                for (int count = 0; count < books.length; count++) {
                    if (borrowed[count]) {
                        System.out.println((count + 1) + ". " + books[count]);
                    }
                }
                System.out.print("Enter book number: ");
                int returnChoice = scanner.nextInt();
                if (returnChoice >= 1 && returnChoice <= books.length) {
                    if (borrowed[returnChoice - 1]) {
                        borrowed[returnChoice - 1] = false;
                        System.out.println("You returned \"" + books[returnChoice - 1] + "\".");
                    } else {
                        System.out.println("That book wasn’t borrowed.");
                    }
                } else {
                    System.out.println("Invalid choice.");
                }
            }

            case 0 -> System.out.println("Thank you for using the library tracker!");

            default -> System.out.println("Invalid option. Please try again.");
        }
    }
}
