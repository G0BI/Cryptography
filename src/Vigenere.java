import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Vigenere {
    private ArrayList<Integer> keyList; // arraylist of int key values from the alphabet method
    private ArrayList<Character> vigenereList;
    private ArrayList<Character> cipherList;
    private HashMap<Character, Double> letterMap;
    private ArrayList<Double> totalList;

    public Vigenere() {
        keyList = new ArrayList<>();
        vigenereList = new ArrayList<>();
        cipherList = new ArrayList<>();
        letterMap = new HashMap<>();
        totalList = new ArrayList<>();
        Caesar.alphaMap = new HashMap<>();
        Caesar.alphabet(); // alphabet map from the Caesar class
        letterFrequency();
    }

    public void letterFrequency() {
        letterMap.put('A', 0.08167);
        letterMap.put('B', 0.01492);
        letterMap.put('C', 0.02782);
        letterMap.put('D', 0.04253);
        letterMap.put('E', 0.12702);
        letterMap.put('F', 0.02228);
        letterMap.put('G', 0.02015);
        letterMap.put('H', 0.06094);
        letterMap.put('I', 0.06966);
        letterMap.put('J', 0.00153);
        letterMap.put('K', 0.00772);
        letterMap.put('L', 0.04025);
        letterMap.put('M', 0.02406);
        letterMap.put('N', 0.06749);
        letterMap.put('O', 0.07507);
        letterMap.put('P', 0.01929);
        letterMap.put('Q', 0.00095);
        letterMap.put('R', 0.05987);
        letterMap.put('S', 0.06327);
        letterMap.put('T', 0.09056);
        letterMap.put('U', 0.02758);
        letterMap.put('V', 0.00978);
        letterMap.put('W', 0.02360);
        letterMap.put('X', 0.00150);
        letterMap.put('Y', 0.01974);
        letterMap.put('Z', 0.00074);
    }

    public void vigenereDecipher(String cipher) {
        String key = "qubit"; // key used to crack vigenere cipher
        key = key.toUpperCase();
        char[] keyArray = key.toCharArray(); // split the key into individual characters

        // extracted each int value for each key character and added into the arraylist
        for (int i = 0; i < keyArray.length; i++) {
            char keyChar = keyArray[i];
            int k = Caesar.alphaMap.get(keyChar);
            keyList.add(k);
        }

        char[] cipherArray = cipher.toCharArray(); // split the cipher text into individual characters

        // decrypting the cipher text into plain text
        for (int j = 0; j < cipherArray.length; j++) {
            char ci = cipherArray[j];
            ci = Character.toUpperCase(ci);
            int c = Caesar.alphaMap.get(ci);

            int p = (c - keyList.get(j % 5) % 26); // #################### change numeric value based on key length
            if (p < 0) {
                p = p + 26; // converts negative p values to positive
            }

            // for each loop to find the character in the hashmap
            for (char ch : Caesar.alphaMap.keySet()) {
                if (Caesar.alphaMap.get(ch).equals(p)) {
                    vigenereList.add(ch); // adds the plain text character to the arraylist
                }
            }
        }

        for (char c : vigenereList) {
            System.out.print(c);
        }

        // string length counter
//        String test = "TOTHEDEVILANDTHATHEWALKSATTIME";
//        System.out.println("\n" + "Plaintext: " + test + " length is: " + test.length());
    }

    public void cipherSplit(String cipher) {
        int count = 0;
        int j = 0;
        int k = 6; // change split index ###############

        // performs letter frequency analysis
        while (count < 140) { // change count value 840 / 6 = 140 ####################
//            cipherList.add(cipher.substring(j, k));
//            System.out.println(cipher.substring(j, k));
            String str = cipher.substring(j, k); // splits into 6 character strings
            char[] charArray = str.toCharArray();
            char c = charArray[5]; // selects the index in the character string #################
            cipherList.add(c);

            j = j + 6; // increment the starting character index (change for key length) ##################
            k = k + 6; // increment the last character index (change for key length) #################
            count++;
        }

        // calculates the frequency of each character
        Map<Character, Long> duplicate = cipherList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(duplicate);

        double total = 0;

//        for (char c : duplicate.keySet()) {
//            double freq = duplicate.get(c);
//            double sum = (freq / 140) * letterMap.get(c);
//            total += sum;
//        }
//        System.out.println(total);

        char[] alphaArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
//        double t0 = 0;
//        for (int i = 0; i < alphaArray.length; i++) {
//            char freqChar = alphaArray[(i + 25) % 26];
//            char letterChar = alphaArray[i];
//            if (duplicate.get(freqChar) == null) {
//                continue;
//            }
//            double freq = duplicate.get(freqChar);
//            double sum = (freq / 140) * letterMap.get(letterChar);
//            t0 += sum;
//        }
//        System.out.println(t0);

//        double t1 = 0;
//        for (int i = 0; i < alphaArray.length; i++) {
//            char freqChar = alphaArray[(i + 1) % 26];
//            char letterChar = alphaArray[i];
//            if (duplicate.get(freqChar) == null) {
//                continue;
//            }
//            double freq = duplicate.get(freqChar);
//            double sum = (freq / 140) * letterMap.get(letterChar);
//            t1 += sum;
//        }
//        System.out.println(t1);

        Boolean loop = true;
        Boolean zeroSwitch = true;
        int intLoop = 0;
        int index = 0;
        int inc = 0;
        double t2 = 0;

        // calculates the sum, largest value and the shift value in letter frequency analysis
        while (loop) {
            intLoop = intLoop % 26;
            // zero switch skips the first 0 in the interation
            if (intLoop == 0 && !zeroSwitch) {
                index = intLoop; // increments the index in the alphabet
                inc++; // increments the shift value
                totalList.add(t2);
                System.out.println(t2);
                t2 = 0; // reset the total
            } else {
                index = intLoop;
                zeroSwitch = false;
            }
            char freqChar = alphaArray[(index + inc) % 26]; // gets the character
            char letterChar = alphaArray[index % 26]; // gets the letter frequency character

            intLoop++;

            // if the frequency is 0 then skip
            if (duplicate.get(freqChar) == null) {
                continue;
            }
            double freq = duplicate.get(freqChar); // gets the character frequency in the cipher text
            double sum = (freq / 140) * letterMap.get(letterChar); // calculates the sum of the frequency
            t2 += sum; // tallies the sum

//            if (index == 25 && inc == 0) {
//                index++;
//            }

            if (inc == 26) {
                loop = false; // breaks the loop when it reaches the last letter
            }

        }

        double max = 0;
        // finds the largest sum
        for (double d : totalList) {

            if (d > max) {
                max = d;
            }

        }

        char keyChar = ' ';

        // for each loop to find the key character in the alphabet hashmap
        for (char ch : Caesar.alphaMap.keySet()) { // searches through the hashmap
            if (Caesar.alphaMap.get(ch).equals(totalList.indexOf(max))) { // finds the integer value of each character and compares it with the shift value
                keyChar = ch; // stores the character to be printed
            }
        }

        System.out.println("The largest value is " + max); // prints the largest sum
        System.out.println("The shift value is " + totalList.indexOf(max)); // prints the shift value from the start to the largest sum
        System.out.println("The key character is " + keyChar); // prints the key character corresponding to the shift value
    }

    public static void main(String[] args) {
        Vigenere v = new Vigenere();
        v.vigenereDecipher("sinxnjuuqhd");
//        v.cipherSplit("IILXVBTPABRLSNZQKFTQSBBQPNLYDCHMZUWCANLXVNTNAJVKDLLQKRWCKKECMJWSKCSFQWISTMGCVGCZGHDYICGDRLSFWVKRWYKECGIUJODYCVWXZLSBWHZRLUKTLQZQZUEQWYVHVUCYSHKMUFADKADGTQJFPHVYERWYDQECPNLXVCCNJQEATNGJYCWUEBVRHBWQGNGISSYCSUYYIJPHVXVPAINUIUXNZELRIBWYIMQMWHMGCAZUIRWYQMVPTNSBBGCAFEJCRLWJJYCXLXVAAYSHLLRIFSVPCYVLFGRYGVKFTSGKEELIEQEGCLWIGMCMWJFRWYOQIKTLSSTCCNKEWRWYEQEQELWQUGCNGJYCRBABCWPCJQJRWYGDVQDILXZLVNZYEELCLXZLIBWTLQZSZEIGOIFVLJAIXQJRPAFQERDVKSLPXNQKGMCQZYTFCILXZLVYDIVGCNJKUCSZGHRKDGWDKRWYNEZATMUXVCGYVJYCWYSHKMUNWIJRXFDIYCGYSIFLTXLXRRIBAIZLIYJLZCLBSTZRHIJYXGCIFEECHCVUFPIBWEKFTLADKFTMSCVYINJQTRXIFMYGRBZQUZTYFJYCELWBLBTNGXVPDQFJIGQODQKGDHOXVLHBWSRKTWDEJCIBWWZPANMHECSMWHVLTFQQEBGYUEXLXTWTYCGNZUPMJHYCRLLUDAZLVIXVZLTGTQIPPMKCVLINZUNMBUFMRQXTRXLCINOXFQTCFJVPTMLYERTMKIVVROJIZMCCECVBXULUCWHOHUIQTXWTYCGIODGPDWWUUGCAKJVQHXATEMIYPFCYXHNUIWRFWQIJNCLIICHODJJY");
    }
}
