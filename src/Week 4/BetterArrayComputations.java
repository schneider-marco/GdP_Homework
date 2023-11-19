import java.util.Arrays;

public class BetterArrayComputations {
    public static void main(String[] args){

        // Deklarationen
        float[] numbers = new float[]{1.1F, 0.05F, 1.05F, 11, 6, 6, 8, 9, 10};
        boolean[] checks = new boolean[3];
        if ((numbers.length) > 8) {
            int checkCounter = 0;
            for (int i = 0; i < (numbers.length - 2); i= i + 3) {
                System.out.println(numbers[i]);
                float compareValue = numbers[i] - (numbers[i+1] + numbers[i+2]);
                if ((compareValue < 0.001) && (compareValue > -0.001)) {
                    checks[checkCounter] = true;
                    checkCounter++;
                }
            }
            System.out.println(Arrays.toString(checks));
        } else {
            System.out.println("numbers Array nicht lange genug");
        }
    }
}

