import java.util.Scanner;

public class Problem2 {
    final static int MAX_CONSIDER_DIGIT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        floatingPrime(scanner);

        scanner.close();
    }

    private static void floatingPrime(Scanner scanner) {
        String currentNumber = scanner.nextLine();
        while (!currentNumber.equals("0.0")) {
            boolean isFloatingPrime = false;
            if (!currentNumber.contains(".")) {
                currentNumber += ".000";
            }

            String beforeDecimal = currentNumber.split("[.]")[0];

            if (Integer.parseInt(beforeDecimal) < 10) {
                if (currentNumber.length() < 5) {
                    for (int i = 0; i < 5 - currentNumber.length() + 1; i++) {
                        currentNumber += "0";
                    }
                }
            } else {
                if (currentNumber.length() < 6) {
                    for (int i = 0; i < 6 - currentNumber.length() + 1; i++) {
                        currentNumber += "0";
                    }
                }
            }

            String afterDecimal = currentNumber.split("[.]")[1];

            StringBuilder currentConsider = new StringBuilder(beforeDecimal);
            for (int i = 0; i < MAX_CONSIDER_DIGIT; i++) {
                currentConsider.append(afterDecimal.charAt(i));

                if (isPrime(Integer.parseInt(currentConsider.toString()))) {
                    isFloatingPrime = true;
                    break;
                }
            }

            if (isFloatingPrime) {
                System.out.println("TRUE");
            } else {
                System.out.println("FALSE");
            }

            currentNumber = scanner.nextLine();
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
