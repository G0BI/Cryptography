import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Transposition_Cipher {

    HashMap<Integer, String> splitted_Txt_Into_Groups = new HashMap<Integer, String>(); // stores chars at each position and groups em together
    ArrayList<String> alphabet = new ArrayList<String>(
            Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));

    int columns =0;
    Transposition_Cipher(int columns, String txt)
    {
        this.columns=columns;
        String txt1 = txt;
        splitted_Txt_Into_Groups = new HashMap<Integer, String>();

        splitTxt_ByColumns(txt1, columns);
    }


    public void splitTxt_ByColumns(String txt, int columns)
    {
        int index = 1;
        txt.replaceAll("\\s+", "");
        char[] charArray = txt.toCharArray();
        int chars_PerColumn = (int) (charArray.length / columns);
        int chars_onColumn =0;

        for (Character ch : charArray)
        {
            String s_char = String.valueOf(ch);

            if(alphabet.contains(s_char.toUpperCase()))
            {
                if (!(splitted_Txt_Into_Groups.containsKey(index))) {
                    splitted_Txt_Into_Groups.put(index, s_char);
                } else {
                    String previous_result = splitted_Txt_Into_Groups.get(index);
                    splitted_Txt_Into_Groups.put(index, previous_result += s_char);
                }
                chars_onColumn++;


                // reset index if it goes beyond keylength
                if (chars_onColumn == chars_PerColumn) {
                    chars_onColumn = 0;
                    if(index<columns)
                    {
                        index++;
                    }
                }

            }
        }
        System.out.printf("Size is %s", charArray.length);
        for (int keyName : splitted_Txt_Into_Groups.keySet())
        {
            String space = "";
            if (keyName < 10) {
                space = "\t";
            }
            System.out.printf("\n%s  %s= %s", keyName, space, splitted_Txt_Into_Groups.get(keyName));
        }

        rebuildList(columns, chars_PerColumn);

    }

    public void rebuildList( int columns, int rows)
    {
        System.out.println("\n\n");

        int column = 1;

        // for each row
        for (int i=0; i<rows;i++)
        {
            String rowTxt ="";

            // for each column get pos
            for(int col = 1; col <= columns; col++)
            {
                char[] temp = splitted_Txt_Into_Groups.get(col).toCharArray();
                rowTxt+= "\t"+temp[i];
            }
            System.out.println(rowTxt);
            System.out.println("\n");


        }

    }

    public static void main(String[] args)
    {
//        String txt = "aeseaooi tvuinnnn eerlcfte lnvlerls";
//        Transposition_Cipher tc = new Transposition_Cipher(4,txt);

        String txt3 = "EAHTEOPETSEWLTTHALEEAIHFPRSEEE";
        Transposition_Cipher tc3 = new Transposition_Cipher(4,txt3);

        Transposition_Cipher tc4 = new Transposition_Cipher(5,txt3);
        Transposition_Cipher tc5 = new Transposition_Cipher(6,txt3);

    }
}
