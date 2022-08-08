import java.util.ArrayList;
import java.util.HashMap;

public class Caesar {
    private int k; // key value
    private String cipher;
    public static HashMap<Character, Integer> alphaMap; // map for each alphabet character corresponding to an integer
    private ArrayList<Character> caesarList;

    public Caesar(int k, String cipher) {
        this.k = k;
        this.cipher = cipher;
        alphaMap = new HashMap<>();
        caesarList = new ArrayList<>();
        alphabet();
    }

    // hashmap method for each character and it's corresponding value
    public static void alphabet() {
        alphaMap.put('A', 0);
        alphaMap.put('B', 1);
        alphaMap.put('C', 2);
        alphaMap.put('D', 3);
        alphaMap.put('E', 4);
        alphaMap.put('F', 5);
        alphaMap.put('G', 6);
        alphaMap.put('H', 7);
        alphaMap.put('I', 8);
        alphaMap.put('J', 9);
        alphaMap.put('K', 10);
        alphaMap.put('L', 11);
        alphaMap.put('M', 12);
        alphaMap.put('N', 13);
        alphaMap.put('O', 14);
        alphaMap.put('P', 15);
        alphaMap.put('Q', 16);
        alphaMap.put('R', 17);
        alphaMap.put('S', 18);
        alphaMap.put('T', 19);
        alphaMap.put('U', 20);
        alphaMap.put('V', 21);
        alphaMap.put('W', 22);
        alphaMap.put('X', 23);
        alphaMap.put('Y', 24);
        alphaMap.put('Z', 25);
    }

    // method to decrypt caesar cipher
    public void caesarDecrypt() {
        char[] cipherArray = cipher.toCharArray(); // splits the cipher text into characters
        // for loop to decrypt the cipher text
        for (int i = 0; i < cipherArray.length; i++) {
            char ci = cipherArray[i]; // extracting each character
            ci = Character.toUpperCase(ci); // capitalising each character
            int c = alphaMap.get(ci); // getting the int value of the character

            int p = (c - k % 26); // calculates the int value of the plain text character
            if (p < 0) {
                p = p + 26; // converts negative p values to positive
            }

            // for each loop to find the character in the hashmap
            for (char ch : alphaMap.keySet()) {
                if (alphaMap.get(ch).equals(p)) {
                    caesarList.add(ch); // adds the plain text character to the arraylist
                }
            }
        }

        for (char c : caesarList) {
            System.out.print(c);
        }

        // string length counter
//        String test = "NANDTHELUGGAGEDIDNOTARRIVEANDT";
//        System.out.println("\n" + "Plaintext: " + test + " length is: " + test.length());
    }

    // to be fixed -- printing way too many characters
    public void caesarEncrypt() {
        char[] cipherArray = cipher.toCharArray(); // splits the cipher text into characters

        for (char ci : cipherArray) {
            int p = alphaMap.get(ci);
            int c = (p + k % 26);
            if (c < 0) {
                c = c + 26; // converts negative c values to positive
            }

            for (char ch : alphaMap.keySet()) {
                if (alphaMap.get(ch).equals(c)) {
                    caesarList.add(ch);
                }
            }

            for (char l : caesarList) {
                System.out.print(l);
            }
        }
    }

    public static void main(String[] args) {
        Caesar c = new Caesar(7, "xbhuabt");
        c.caesarDecrypt();
//        c.caesarEncrypt();
    }
}
