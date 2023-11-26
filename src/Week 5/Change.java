import java.util.Arrays;

public class Change {
    static int[] exchangeRates;
    public static void main(String[] args){

        // start
        setExchangeRates(new int[]{10, 5, 2, 10});
        printMoney(Change.exchangeRates);
        System.out.println(getExchangeRate(0, 0));
        System.out.println(Change.convertToCheapestCurrency(new int[]{0, 0, 1, 3, 1}));
        System.out.println(Arrays.toString(convertToCurrencies(1280)));
        System.out.println(Arrays.toString(computeChange(new int[]{0, 0, 1, 3, 1}, new int[]{0, 1})));
    }

    /**
     *
     * @param arr Integer Array mit den entsprechenden Wechselkursen
     * Speicehr die Wechselkurse in exchangeRates
     * */
    public static void setExchangeRates(int[] arr) {
        exchangeRates = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            Change.exchangeRates[i] = arr[i];
        }

    }

    /**
     *
     * @param arr Integer Array, welches, auf der Konsole ausgegeben werden soll
     */
    public static void printMoney(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param from Aktuelle Waehrung
     * @param to Waehrung, in welche das Geld umgetauscht werden soll
     * @return Gibt den Umrechnungsfaktor zurueck
     */
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

    /**
     *
     * @param arr Die Methode bekommt ein Ganzzahl-Array übergeben, in dem für die Währungsarten jeweils eine Anzahl an Münzen dieser Währung gespeichert ist
     * @return Alle verfügbaren Münzen in Münzen der geringsten Währung umwandeln und zurückgeben
     */
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

    /**
     *
     * @param coins  Anzahl an Münzen der geringsten Währung
     * @return Gibt ein Array zurück, das diese Münzen so weit wie möglich in die höherwertigen Währungen umrechnet
     */
    public static int[] convertToCurrencies (int coins){


        int newcoins = coins;
        int[] arr = new int[5];
        for (int i = 5; i >= 0; i--) {

            switch (i) {
                case 4 -> {
                    newcoins = coins % 1000;
                    arr[i] = (int) ((coins-newcoins) * getExchangeRate(0, i));
                    coins = newcoins;
                }
                case 3 -> {
                    newcoins = coins % 100;
                    arr[i] = (int) ((coins-newcoins) * getExchangeRate(0, i));
                    coins = newcoins;
                }
                case 2 -> {
                    newcoins = coins % 50;
                    arr[i] = (int) ((coins-newcoins) * getExchangeRate(0, i));
                    coins = newcoins;
                }
                case 1 -> {
                    newcoins = coins % 10;
                    arr[i] = (int) ((coins-newcoins) * getExchangeRate(0, i));
                    coins = newcoins;
                }
                case 0 -> {
                    arr[i] = coins;
                }
            }

        }
        int lenght = 0;

        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] == 0){
                continue;
            }
            lenght = i;
            break;
        }

        int[] arr2 = new int[lenght+1];
        for (int i = 0; i < arr2.length; i++){
            arr2[i] = arr[i];
        }

        return arr2;
    }

    /**
     *
     * @param costs Kosten eines Produkts
     * @param paid gezahlter Betrag
     * @return Gibt das Geld zurück, welches nach dem Kauf uebrig bleibt
     */
    public static int[] computeChange(int[] costs, int[] paid) {

        int cost = 0;
        int pay = 0;

        for (int i = 0; i < costs.length; i++) {
            cost = (int) (cost + (costs[i] * getExchangeRate(i, 0)));
        }

        for (int i = 0; i < paid.length; i++) {
            pay = (int) (pay + (paid[i] * getExchangeRate(i, 0)));
        }

        int total = pay - cost;
        if (total < 0){
            return new int[]{};
        }else {
            return convertToCurrencies(total);
        }

    }

}
