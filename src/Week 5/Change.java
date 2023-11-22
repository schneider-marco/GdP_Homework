import java.util.Arrays;

public class Change {
    static int[] exchangeRates;
    public static void main(String[] args){
        // start
        setExchangeRates(new int[]{10, 5, 2, 10});
        printMoney(Change.exchangeRates);
        getExchangeRate(4, 4);
    }

    /**
     *
     * @param arr Integer Array mit den entsprechenden Wechselkursen
     *
     */
    public static void setExchangeRates(int[] arr) {
        exchangeRates = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            Change.exchangeRates[i] = arr[i];
        }

    }

    public static void printMoney(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static float getExchangeRate(int from, int to){
        int kupfer = 0;
        int silber = 1;
        int elektrum = 2;
        int gold = 3;
        int platin = 4;
        float[] exchangeRate = new float[exchangeRates.length+1];
        float value = 0F;
//        // Kupfer, Silber, Elektrum, Gold, Platin
//            {1.0, 0.1, 0.02, 0.01, 0.005}, // Kupfer
//            {10.0, 1.0, 0.2, 0.1, 0.05},  // Silber
//            {50.0, 5.0, 1.0, 0.5, 0.25},   // Elektrum
//            {100.0, 10.0, 2.0, 1.0, 0.5},  // Gold
//            {200.0, 20.0, 4.0, 2.0, 1.0}   // Platin
//        for (float[] e : exchangeRate){
//
//            for (int i = 0; i < e.length; i++){
//                switch (i) {
//                    case 0 -> e[i] =
//                }
//            }
//
//        }
//      10, 5, 2, 10 -> {10.0, 1.0, 0.2, 0.1, 0.05}
        int place = 0;
        if (from == to) {
            exchangeRate[from] = 1.0F;
            place = from;
        }
        System.out.println(place);
        for (int i = 0; i < exchangeRate.length; i++) {
            if (i < place) {
                exchangeRate[i] = exchangeRates[i] * exchangeRate[place];
            } else if (i > place) {
                System.out.println("größer");
            }
        }

        System.out.println(Arrays.toString(exchangeRate));
//        System.out.println(Arrays.toString(Change.exchangeRates));
        return value;
    }
}
