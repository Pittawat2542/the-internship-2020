import java.util.Arrays;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        sortingAcronyms(scanner);

        scanner.close();
    }

    private static void sortingAcronyms(Scanner scanner) {
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] fullNameList = new String[n];
        String[] acronymList = new String[n];

        for (int i = 0; i < n; i++) {
            fullNameList[i] = scanner.nextLine();
        }

        for (int i = 0; i < n; i++) {
            String fullName = fullNameList[i];
            StringBuilder acronym = new StringBuilder();
            for (String partOfFullName : fullName.split(" ")) {
                char firstCharacter = partOfFullName.charAt(0);
                if (firstCharacter >= 65 && firstCharacter <= 90) {
                    acronym.append(firstCharacter);
                }
            }
            acronymList[i] = acronym.toString();
        }

        Arrays.sort(acronymList);
        Arrays.sort(acronymList, (s1, s2) -> s2.length() - s1.length());

        for (String acronym : acronymList) {
            if (!acronym.isEmpty())
                System.out.println(acronym);
        }
    }
}
