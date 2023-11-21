public class TemperatureMeasurements {
    public static void main(String[] args){
        // start main
        String month = args[0];
        int[] days = new int[(args.length-1)/2];
        int dayCounter = 0;
        float[] temps = new float[(args.length-1)/2];
        int tempCounter = 0;

        for (int i = 1; i < args.length; i++) {
            // System.out.println(args[i]);
            switch (i%2) {
                case 1 -> {
                    days[dayCounter] = Integer.parseInt(args[i]);
                    dayCounter++;
                }
                case 0 -> {
                    temps[tempCounter] = Float.parseFloat(args[i]);
                    tempCounter++;
                }
                default -> {
                }
            }
        }

        for (int i = 0; i < days.length; i++) {
            System.out.println(days[i] + " " + month + " " + temps[i]);
        }

        System.out.println("Durchschnittstemperatur: " + average(temps));
        System.out.println("Höchsttemperatur am nächsten am Durchschnitt " + fetchClosestDay(temps, average(temps)));
    }

    public static float average(float[] arr) {
        float sum = 0;
        for (float i : arr) {
            sum = sum + i;
        }
        return sum / arr.length;
    }

    public static float fetchClosestDay(float[] arr, float average) {
        float closestDay = 0;

        for (float i : arr) {
            if (Math.abs(i-average) < (Math.abs(closestDay-average))){
                closestDay = i;
            }
        }
        return closestDay;
    }

}