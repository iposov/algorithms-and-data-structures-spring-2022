import java.util.*;

class EditDistance {

    static int compute(String str1, String str2) {
        if (str1.isEmpty()) {
            return str2.length();
        }
        if (str2.isEmpty()) {
            return str1.length();
        }

        int replace = compute(str1.substring(1), str2.substring(1)) + findNumOfReplacement(str1.charAt(0),str2.charAt(0));
        int insert = compute(str1, str2.substring(1)) + 1;

        int delete = compute(str1.substring(1), str2) + 1;
        int[] answer = new int[] {replace, insert, delete};
        return Arrays.stream(answer).min().orElse(Integer.MAX_VALUE);
    }

    static int findNumOfReplacement(char c1, char c2) {
        return c1 == c2 ? 0 : 1;
    }


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();

        System.out.println(compute(s1, s2));
    }
}