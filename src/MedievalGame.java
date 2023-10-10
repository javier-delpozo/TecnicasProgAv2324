import java.util.Scanner;

public class MedievalGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Medieval Adventure Game!");
        System.out.println("Choose your character class:");
        System.out.println("1. Mage");
        System.out.println("2. Orc");
        System.out.println("3. Soldier");
        System.out.println("4. Archer");
        System.out.print("Enter the number of your choice: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                displayStatistics("Mage", 50, 20, 10);
                break;
            case 2:
                displayStatistics("Orc", 80, 10, 5);
                break;
            case 3:
                displayStatistics("Soldier", 70, 15, 15);
                break;
            case 4:
                displayStatistics("Archer", 60, 25, 8);
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }

        scanner.close();
    }

    public static void displayStatistics(String className, int health, int attack, int defense) {
        System.out.println("\nYou have chosen the " + className + " class.");
        System.out.println("Statistics:");
        System.out.println("Health: " + health);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("Enjoy your adventure!");
    }
}
