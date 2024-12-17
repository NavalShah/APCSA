import java.util.Scanner;

public class FarmerBlock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int scannedInt = scanner.nextInt();
        int scannedInt2 = scanner.nextInt();

        // I'm getting flashbacks from multivariable calc
        int[][] flatPlane = new int[scannedInt][scannedInt];
        int[][] yzPlane = new int[scannedInt][scannedInt];
        int[][] xzPlane = new int[scannedInt][scannedInt];

        int count = 0;
        for (int i = 0; i < scannedInt2; i++) {
            int[] coords = { scanner.nextInt(), scanner.nextInt(), scanner.nextInt() };
            // Its just same shit repeat
            flatPlane[coords[0]][coords[1]] += 1;
            if (flatPlane[coords[0]][coords[1]] == scannedInt) {
                count++;
                flatPlane[coords[0]][coords[1]] = -1;
            }
            yzPlane[coords[1]][coords[2]] += 1;
            if (yzPlane[coords[1]][coords[2]] == scannedInt) {
                count++;
                yzPlane[coords[1]][coords[2]] = -1;
            }
            xzPlane[coords[0]][coords[2]] += 1;
            if (xzPlane[coords[0]][coords[2]] == scannedInt) {
                count++;
                xzPlane[coords[0]][coords[2]] = -1;
            }

            System.out.print(count + "\n");// How tf does println work
        }

        scanner.close();
    }

}
