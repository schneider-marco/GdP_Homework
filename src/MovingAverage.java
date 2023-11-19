import java.util.Arrays;

public class MovingAverage {
    public static void main(String[] args){
        // start
        final int fensterbreite = 3;

        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        double[] middle = new double[data.length-2];
        int middleCounter = 0;
        for (int i = 1; i < (data.length-1); i++) {
            middle[middleCounter] = (data[i] + data[i-1] + data[i+1])/(float)fensterbreite;
            middleCounter++;
        }

        System.out.println("Anfangsdaten:");
        System.out.println(Arrays.toString(data));
        System.out.println("Berechnete Daten:");
        System.out.println(Arrays.toString(middle));
    }
}
