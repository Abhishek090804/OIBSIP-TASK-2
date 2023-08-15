import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int maxTimeSeconds = 60;
        int round = 1;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between" + minRange + " and " + maxRange);

        while (true) {
            System.out.println("Round " + round);
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            long startTime = System.currentTimeMillis();
            int attempts = 0;

            while (attempts < maxAttempts) {
                long currentTime = System.currentTimeMillis();
                long elapsedTime = (currentTime - startTime) / 1000;

                if (elapsedTime >= maxTimeSeconds) {
                    System.out.println("Time's up!");
                    break;
                }
                System.out.println("Time left: " + (maxTimeSeconds - elapsedTime) + " seconds");
                System.out.println("Attempts left: " + (maxAttempts - attempts));
                System.out.println("Enter your guess:");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else if (guess > targetNumber) {
                    System.out.println("Too high!");
                } else {
                    int roundScore = calculateRoundScore(attempts, maxTimeSeconds - elapsedTime);
                    totalScore += roundScore;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    System.out.println("Round score: " + roundScore);
                    System.out.println("Total score: " + totalScore);
                    System.out.println("You won this round!");
                    break;
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've used all your attempts!");
                    System.out.println("The correct number was: " + targetNumber);
                    System.out.println("You lost this round.");
                    
                }
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            if (playAgain.equalsIgnoreCase("no")) {
                System.out.println("Thanks for playing!");
                System.out.println("Have a Good Day!");

                break;
            }

            round++;
        }

        scanner.close();
    }
    

    private static int calculateRoundScore(int attempts, long remainingTime) {
         return (10 - attempts) * (int) (remainingTime /3 );

        

    }
}
