package stacksAndQueues;

import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 20; i++) {

            int degrees = i * 90;
            while (degrees >= 360){
                degrees = degrees % 360;
                System.out.print(degrees + " " );
            }
        }

    }
}
