import java.util.*;
import java.io.*;

public class MooContest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt();
        int minner = scanner.nextInt();
        scanner.nextLine();
        String timesrunning = scanner.nextLine();

        Set<String> solutions = new TreeSet<>();
        Map<String, Integer> nomorenames = new HashMap<>();

        // Precompute frequencies for the original string
        for (int i = 0; i < min - 2; i++) {
            String moo = timesrunning.substring(i, i + 3);
            if (works(moo)) {
                nomorenames.put(moo, nomorenames.getOrDefault(moo, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> key : nomorenames.entrySet()) {
            if (key.getValue() >= minner)
                solutions.add(key.getKey());
        }

        // Simulate one character corruption
        for (int i = 0; i < min; i++) {
            char original = timesrunning.charAt(i);
            for (char replacement = 'a'; replacement <= 'z'; replacement++) {
                if (replacement == original)
                    continue;

                // Modify the string with the replacement
                String modified = timesrunning.substring(0, i) + replacement + timesrunning.substring(i + 1);

                // Only check substrings affected by the change
                for (int j = Math.max(0, i - 2); j <= Math.min(min - 3, i); j++) {
                    String moo = modified.substring(j, j + 3);
                    if (works(moo)) {
                        int count = calc(modified, moo);
                        if (count >= minner)
                            solutions.add(moo);
                    }
                }
            }
        }

        System.out.println(solutions.size());
        for (String moo : solutions) {
            System.out.println(moo);
        }

        scanner.close();
    }

    private static boolean works(String moo) {
        if (moo.length() != 3)
            return false;
        return moo.charAt(0) != moo.charAt(1) && moo.charAt(1) == moo.charAt(2);
    }

    private static int calc(String str, String target) {
        int count = 0;
        for (int i = 0; i <= str.length() - 3; i++) {
            if (str.substring(i, i + 3).equals(target)) {
                count++;
            }
        }
        return count;
    }
}

// Next time To DOs
/*
 * Buffered Reader make sure
 * do more for hash maps
 * Figure out USACo scoring guides
 * STUFY
 */