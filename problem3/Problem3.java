import java.util.Scanner;

public class Problem3 {
    final static int DIGITS_COUNT = 12;
    final static int ANSWER_COUNT = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        digitHangman(scanner);

        scanner.close();
    }

    private static void digitHangman(Scanner scanner) {
        int[] gameDigitList = new int[DIGITS_COUNT];
        int[] userDigitList = new int[ANSWER_COUNT];
        char[] gameStatus = new char[DIGITS_COUNT + ANSWER_COUNT];
        int wrongCount = 0;
        int score = 0;

        for (int i = 0; i < DIGITS_COUNT; i++) {
            gameDigitList[i] = scanner.nextInt();
        }

        for (int i = 0; i < ANSWER_COUNT; i++) {
            userDigitList[i] = scanner.nextInt();
        }

        for (int i = 0; i < DIGITS_COUNT; i++) {
            gameStatus[i] = '_';
        }

        printGameStatus(gameStatus);

        for (int userDigit : userDigitList) {
            boolean isWrong = true;
            for (int i = 0; i < DIGITS_COUNT; i++) {
                if (userDigit == gameDigitList[i]) {
                    gameStatus[i] = (char) (userDigit + '0');
                    isWrong = false;
                    score++;
                }
            }

            if (isWrong) {
                gameStatus[DIGITS_COUNT + wrongCount++] = (char) (userDigit + '0');
            }

            printGameStatus(gameStatus);
        }

        System.out.println(score);
    }

    private static void printGameStatus(char[] gameStatus) {
        for (char digit : gameStatus) {
            System.out.print(digit + " ");
        }
        System.out.println();
    }
}
