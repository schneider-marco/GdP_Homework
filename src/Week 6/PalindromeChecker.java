public class PalindromeChecker {
    public static void main(String[] args){

        String[] palindromes = new String[args.length];
        String[] words = new String[args.length];
        int palindromeCounter = 0;
        int wordCounter = 0;

        for (String i : args){
//            System.out.println(i);
            String equ = "";

            for (int x = 0; x < i.length(); x++){
                equ += i.charAt(i.length()-x-1);

            }
//            System.out.println(equ);
            if (equ.equalsIgnoreCase(i)){
                palindromes[palindromeCounter] = i;
                palindromeCounter++;
            } else {
                words[wordCounter] = i;
                wordCounter++;
            }
        }

        System.out.println("These words are palindromes:");
        for (String i : palindromes) {
            if (i != null) {
                System.out.println(i);
            }
        }

        System.out.println();

        System.out.println("These words are not palindromes:");
        for (String i : words) {
            if (i != null) {
                System.out.println(i);
            }
        }
    }
}
