import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ChainRounding {

    // WHY IS BUFFERED READER SO WEIRDDDDDD
    // ISTG Ima use scanner next questions
    // BufferedReader scanner;
    // StringTokenizer tokenizer;

    // public ChainRounding() {
    // scanner = new BufferedReader(
    // new InputStreamReader(System.in));
    // }

    // public String next() {
    // while (tokenizer == null || !tokenizer.hasMoreElements()) {
    // try {
    // tokenizer = new StringTokenizer(scanner.readLine());
    // } catch (IOException e) {
    // e.printStackTrace();
    // System.out.print("IOException, something's up");
    // } catch (Exception e) {
    // System.out.print("General Excpetion, edge case galore imo");
    // e.printStackTrace();
    // }
    // }
    // return tokenizer.nextToken();
    // }

    // public double nextD() {
    // return Double.parseDouble(next());
    // }

    // public int nextI() {
    // return Integer.parseInt(next());
    // }

    // public String nextL() {
    // String str = "";
    // try {
    // if (tokenizer.hasMoreTokens()) {
    // str = tokenizer.nextToken("\n");
    // } else {
    // str = scanner.readLine();
    // }
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // return str;
    // }

    // public long nextLong() {
    // return Long.parseLong(next());
    // }

    // public static void main(String[] args) {
    // ChainRounding cr = new ChainRounding();

    // int numTests = cr.nextI();

    // String output = "";
    // for (int i = 0; i < numTests; i++) {
    // int bessie = cr.nextI();

    // int count = 0;

    // for (int j = 0; j <= bessie; j++) {
    // int roundedprimary = thisclosetoendingitall(j, findP(j));
    // int chain = chainRound(j, findP(j));
    // if (roundedprimary != chain) {
    // count++;
    // }
    // }
    // output += count + "\n";
    // }
    // System.out.print(output.substring(0, output.length() - 1) + "\n");

    // }

    // public static int findP(int bessie) {
    // String beforeString = "" + bessie;

    // return beforeString.length();
    // }

    // public static int thisclosetoendingitall(int x, int y) {
    // return (int) Math.round(x / Math.pow(10, y)) * (int) Math.pow(10, y);
    // }

    // public static int chainRound(int x, int y) {
    // for (int i = 1; i <= y; i++) {
    // x = thisclosetoendingitall(x, i);
    // }
    // return x;
    // }

    // Brute force bhenc
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bounds = scanner.nextInt();

        long[] arr = new long[bounds];
        for (int i = 0; i < bounds; i++) {
            int scan = scanner.nextInt();
            arr[i] = count((long) scan);
        }

        for (long e : arr) {
            System.out.println(e);
        }

        scanner.close();
    }

    /*
     * public int computeValue(long input) {
     * int range = getRange(input);
     * 
     * switch (range) {
     * case 0:
     * return 0;
     * case 1:
     * return (int) (input - 45 + 1);
     * case 2:
     * return (int) (input - 445 + 5 + 1);
     * case 3:
     * return (int) (input - 4445 + 500 - 445 + 5 + 1);
     * case 4:
     * return (int) (input - 44445 + 5000 - 4445 + 500 - 445 + 5 + 1);
     * case 5:
     * return (int) (input - 444445 + 50000 - 44445 + 5000 - 4445 + 500 - 445 + 5 +
     * 1);
     * case 6:
     * return (int) (input - 4444445 + 500000 - 444445 + 50000 - 44445 + 5000 - 4445
     * + 500 - 445 + 5 + 1);
     * case 7:
     * return (int) (input - 44444445 + 5000000 - 4444445 + 500000 - 444445 + 50000
     * - 44445 + 5000 - 4445 + 500 - 445 + 5 + 1);
     * case 8:
     * return (int) (input - 444444445 + 50000000 - 44444445 + 5000000 - 4444445 +
     * 500000 - 444445 + 50000 - 44445 + 5000 - 4445 + 500 - 445 + 5 + 1);
     * default:
     * return (int) (input - 444444445 + 50000000 - 44444445 + 5000000 - 4444445 +
     * 500000 - 444445 + 50000 - 44445 + 5000 - 4445 + 500 - 445 + 5 + 1);
     * }
     * }
     * 
     * private int getRange(long input) {
     * if (input < 45) return 0;
     * if (input < 445L) return 1;
     * if (input < 4445L) return 2;
     * if (input < 44445L) return 3;
     * if (input < 444445L) return 4;
     * if (input < 4444445L) return 5;
     * if (input < 44444445L) return 6;
     * if (input < 444444445L) return 7;
     * if (input < 4444444445L) return 8;
     * return 9;
     * }
     */

    // Every fiber of my soul haates this, there has to be a more pretty way

    public static long count(long input) {
        if (input < 45) {
            return 0;
        } else if (input < 445L && input >= 49L) {
            return 5;
        } else if (input < 4445L && input >= 499L) {
            return 500 - 445 + 5;
        } else if (input < 44445L && input >= 4999L) {
            return 5000 - 4445 + 500 - 445 + 5;
        } else if (input < 444445L && input >= 49999L) {
            return 50000 - 44445 + 5000 - 4445 + 500 - 445 + 5;
        } else if (input < 4444445L && input >= 499999L) {
            return 500000 - 444445 + 50000 - 44445 + 5000 - 4445 + 500 - 445 + 5;
        } else if (input < 44444445L && input >= 4999999L) {
            return 5000000 - 4444445 + 500000 - 444445 + 50000 - 44445 + 5000 - 4445 + 500 - 445 + 5;
        } else if (input < 444444445L && input >= 49999999L) {
            return 50000000 - 44444445 + 5000000 - 4444445 + 500000 - 444445 + 50000 - 44445 + 5000 - 4445 + 500 - 445
                    + 5;
        } else if (input < 4444444445L && input >= 499999999L) {
            return 500000000 - 444444445 + 50000000 - 44444445 + 5000000 - 4444445 + 500000 - 444445 + 50000 - 44445
                    + 5000 - 4445 + 500 - 445 + 5;
        } else if (input < 45) {
            return 0;
        } else if (input < 445L) {
            return input - 45 + 1;
        } else if (input < 4445L) {
            return input - 445 + 5 + 1;
        } else if (input < 44445L) {
            return input - 4445 + 500 - 445 + 5 + 1;
        } else if (input < 444445L) {
            return input - 44445 + 5000 - 4445 + 500 - 445 + 5 + 1;
        } else if (input < 4444445L) {
            return input - 444445 + 50000 - 44445 + 5000 - 4445 + 500 - 445 + 5 + 1;
        } else if (input < 44444445L) {
            return input - 4444445 + 500000 - 444445 + 50000 - 44445 + 5000 - 4445 + 500 - 445 + 5 + 1;
        } else if (input < 444444445L) {
            return input - 44444445 + 5000000 - 4444445 + 500000 - 444445 + 50000 - 44445 + 5000 - 4445 + 500 - 445 + 5
                    + 1;
        } else {
            return input - 444444445 + 50000000 - 44444445 + 5000000 - 4444445 + 500000 - 444445 + 50000 - 44445 + 5000
                    - 4445 + 500 - 445 + 5 + 1;
        }
    }

}