import java.util.*;

public class Main {
    public static void main(String[] args) {
        Words[] words = Words.values();
        String megoldas = words[new Random().nextInt(words.length)].toString();
        char[] eddigKitalalt = "_".repeat(megoldas.length()).toCharArray();
        Set<Character> eddigTippelt = new HashSet<>();
        int lives = 15;

        Scanner sc = new Scanner(System.in);

        while (Arrays.toString(eddigKitalalt).contains("_") && lives > 0) {
            System.out.println("You have " + lives + " lives left");
            String tippString = sc.nextLine();
            if (tippString.isEmpty()) {
                continue;
            }
            char tipp = Character.toUpperCase(tippString.charAt(0));
            if (!eddigTippelt.add(tipp)) {
                System.out.println("You already tried that BRO");
            } else {
                lives--;
                boolean talalt = false;
                for (int i = 0; i < megoldas.length(); i++) {
                    if (Character.toUpperCase(megoldas.charAt(i)) == tipp) {
                        eddigKitalalt[i] = Character.toUpperCase(tipp);
                        talalt = true;
                    }
                }
                if (!talalt) {
                    System.out.println("Wrong guess!");
                }
                System.out.println(szepenFormaz(eddigKitalalt));
            }
        }

        System.out.println(lives > 0 ? "You win!" : ("You Lose! The correct answer is: " + megoldas));

    }

    public static String szepenFormaz(char[] karakterek) {
        StringBuilder result = new StringBuilder();
        for (char c : karakterek) {
            result.append(c).append(" ");
        }
        return result.toString().toUpperCase();
    }
}
