import java.util.Arrays;

public class Change {
    static int[] exchangeRates;
    public static void main(String[] args){

        // start
        setExchangeRates(new int[]{10, 5, 2, 10});
        printMoney(Change.exchangeRates);
        System.out.println(getExchangeRate(4, 2));
        System.out.println(Change.convertToCheapestCurrency(new int[]{0, 0, 1, 3, 1}));
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

    public static float getExchangeRate(int from, int to) {

        float[][] rate = new float[exchangeRates.length+1][exchangeRates.length+1];

        int counter = 0;
        int dev = 1;
        for (float[] e : rate){

            switch (counter){
                case 0 -> dev = 1;
                case 1 -> dev = 10;
                case 2 -> dev = 50;
                case 3 -> dev = 100;
                case 4 -> dev = 1000;
            }

            for (int i = 0; i < e.length; i++) {
                switch (i){
                    case 0 -> e[i] = (float) (1)/dev;
                    case 1 -> e[i] = (float) (exchangeRates[0])/dev;
                    case 2 -> e[i] = (float) (exchangeRates[0] * exchangeRates[1])/dev;
                    case 3 -> e[i] = (float) (exchangeRates[0] * exchangeRates[1] * exchangeRates[2])/dev;
                    case 4 -> e[i] = (float) (exchangeRates[0] * exchangeRates[1] * exchangeRates[2] * exchangeRates[3])/dev;
                }
            }

            counter++;
        }

        if (from > exchangeRates.length+1 || to > exchangeRates.length+1){
            return 0.0F;
        }else {
            return rate[to][from];
        }
    }

    public static int convertToCheapestCurrency (int[] arr){
        if (arr.length > exchangeRates.length+1){
            return 0;
        }else {
            int money = 0;

            for (int i = arr.length; i != 0; i--) {
                //            System.out.println(arr[i-1]);
                money = (int) (money + (arr[i - 1] * getExchangeRate(i - 1, 0)));
            }

            return money;
        }
    }

    public static int[] convertToCurrencies (int coins){
        return
    }

}
