public class Transposition {
    private String text;
    private int column;

    public Transposition(String text, int column) {
        this.text = text; // cipher text
        this.column = column; // number of columns
    }

    public void transpositionCrack() {
        int row = 840 / column; // number of rows

        String first = "";
        String second = "";
        String third = "";
        String fourth = "";
        String fifth = "";
        String sixth = "";

        // cipher string of all the columns
        first = text.substring(0, row);
        second = text.substring(row, 2 * row);
        third = text.substring(2 * row, 3 * row);
        fourth = text.substring(3 * row, 4 * row);

        if (column == 5) {
            fifth = text.substring(4 * row, 5 * row);
        } else if (column == 6){
            fifth = text.substring(4 * row, 5 * row);
            sixth = text.substring(5 * row, 6 * row);
        }

        // prints all the cipher strings
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(fourth);

        if (column == 5) {
            System.out.println(fifth);
        }
        else if (column == 6) {
            System.out.println(fifth);
            System.out.println(sixth);
        }
        System.out.println(); // line break
        System.out.println();

        int count = 0;
        char[] firstArray = first.toCharArray();
        char[] secondArray = second.toCharArray();
        char[] thirdArray = third.toCharArray();
        char[] fourthArray = fourth.toCharArray();
        char[] fifthArray = fifth.toCharArray();
        char[] sixthArray = sixth.toCharArray();

//        if (column == 5) {
//            char[] fifthArray = fifth.toCharArray();
//        }
//        else if (column == 6) {
//            char[] fifthArray = fifth.toCharArray();
//            char[] sixthArray = sixth.toCharArray();
//        }

        // prints the rows and columns of the transposition cipher
        while (count < row) {
            if (column == 4) {
                    System.out.println(firstArray[count] + " " + secondArray[count] + " " + thirdArray[count] + " " + fourthArray[count]);
            }
            else if (column == 5) {
                    System.out.println(firstArray[count] + " " + secondArray[count] + " " + thirdArray[count] + " " + fourthArray[count] + " " + fifthArray[count]);
            } else {
                    System.out.println(firstArray[count] + " " + secondArray[count] + " " + thirdArray[count] + " " + fourthArray[count] + " " + fifthArray[count] + " " + sixthArray[count]);
            }
            count++;
        }

        // prints the plaintext
        Boolean printSwitch = true;
        int num = 0;
        while (printSwitch) {
            System.out.print(firstArray[num]);
            System.out.print(secondArray[num]);
            System.out.print(thirdArray[num]);
            System.out.print(fourthArray[num]);

            if (column == 5) {
                System.out.print(fifthArray[num]);
        }
        else if (column == 6) {
                System.out.print(fifthArray[num]);
                System.out.print(sixthArray[num]);
        }
            num ++;

        // stops printing after the last row is printed
        if (num == row) {
                printSwitch = false;
            }
        }

        // string length counter
        String test = "S DURBEYFIELDS FIGURE MOTIONLESS UNDER THE GREAT HOLLY TREE NO OBJECT COULD HAVE LOOKED MORE FOREIGN TO THE GLEAMING CRANKS AND WHEELS THAN THIS UNSOPHISTICATED GIRL WITH THE ROUND BARE ARMS THE RAINY FACE AND HAIR THE SUSPENDED ATTITUDE OF A FRIENDLY LEOPARD AT PAUSE THE PRINT GOWN OF NO DATE OR FASHION AND THE COTTON BONNET DROOPING ON HER BROW SHE MOUNTED AGAIN BESIDE HER LOVER WITH A MUTE OBEDIENCE CHARACTERISTIC OF IMPASSIONED NATURES AT TIMES AND WHEN THEY HAD WRAPPED THEMSELVES UP OVER HEAD AND EARS IN THE SAILCLOTH AGAIN THEY PLUNGED BACK INTO THE NOW THICK NIGHT TESS WAS SO RECEPTIVE THAT THE FEW MINUTES OF CONTACT WITH THE WHIRL OF MATERIAL PROGRESS LINGERED IN HER THOUGHT LONDONERS WILL DRINK IT AT THEIR BREAKFASTS TO MORROW WONT THEY SHE ASKED STRANGE PEOPLE THAT WE HAVE NEVER SEEN YES I SUPPOSE THEY WILL THOUGH NOT".replace(' ', '|'); // replaces space characters with a vertical bar
        String cipherTest = "DPZOCUYT|HYFZDP|HSOCYPVNMHNIFYDDPOIZYCPMJYPSCYWMPJNFFTPMCYYPINPNULYEMPENOFZPJWBYPFNNAYZPVNCYP|NCYHSIPMNPMJYPSFYWVHISPECWIADPWIZPKJYYFDPMJWIPMJHDPOIDNGJHDMHEWMYZPSHCFPKHMJPMJYPCNOIZPUWCYPWCVDPMJYPCWHITP|WEYPWIZPJWHCPMJYPDODGYIZYZPWMMHMOZYPN|PWP|CHYIZFTPFYNGWCZPWMPGWODYPMJYPGCHIMPSNKIPN|PINPZWMYPNCP|WDJHNIPWIZPMJYPENMMNIPUNIIYMPZCNNGHISPNIPJYCPUCNKPDJYPVNOIMYZPWSWHIPUYDHZYPJYCPFNBYCPKHMJPWPVOMYPNUYZHYIEYPEJWCWEMYCHDMHEPN|PHVGWDDHNIYZPIWMOCYDPWMPMHVYDPWIZPKJYIPMJYTPJWZPKCWGGYZPMJYVDYFBYDPOGPNBYCPJYWZPWIZPYWCDPHIPMJYPDWHFEFNMJPWSWHIPMJYTPGFOISYZPUWEAPHIMNPMJYPINKPMJHEAPIHSJMPMYDDPKWDPDNPCYEYGMHBYPMJWMPMJYP|YKPVHIOMYDPN|PENIMWEMPKHMJPMJYPKJHCFPN|PVWMYCHWFPGCNSCYDDPFHISYCYZPHIPJYCPMJNOSJMPFNIZNIYCDPKHFFPZCHIAPHMPWMPMJYHCPUCYWA|WDMDPMNPVNCCNKPKNIMPMJYTPDJYPWDAYZPDMCWISYPGYNGFYPMJWMPKYPJWBYPIYBYCPDYYIPTYDPHPDOGGNDYPMJYTPKHFFPMJNOSJPINMP";
//        test.replace(' ', '|');
        System.out.println("\n\n" + "Plaintext: " + test + " length is: " + test.length() + "\n\n");
        System.out.println(test);
        System.out.println(cipherTest);
    }

    public static void main(String[] args) {
        Transposition t = new Transposition("EDTYIOSPEECHTMIOVTETMEERLYFHDOOOAISANUUGGOHSTGNYSNSGGAMRHYERLMUETMLSTTWUHORHAPONAONTTGIMYERDMEYAUAOTYFTPANMOEPIUAEOHLARCBWIUCIDDEEETRNEOXOTLEKUUHHHEEHWOHECIEIHHDENDGEDYFLSDINLYSSOETANANUOATWHECGIDPPDOOMIOEOSEARYISOLUIOHYOOOAEIECFHORNAIYOOARNLYDSTTRSOTTAOHHOCIDNOTREMEERRYEHNOESAHEEPETPECOAENLDTNOMAEIAHORWNLVNBOTHEPYAUXTTLVEMIISYOAIFHONMUYLAOSTAFANELTATAIIAADEHUAXTTNKIYNTKOSGFOAYTONGYOEEWGOVDVDRRKHIIALEKRIAIPRENCOTTETEEDEULWNNAOMMBRDHNOOATTFHDERLYAGISTWIYCIIOHNMIETONHOIORHORDNOCYAOLAHIESNTRHURENNCDDYHOTTRETTETAOWDEEUUEARSWNLCMWDENENKTTMCTYANURRFDDBTORVTARTABYNMCSCUROLVPETDESDTHOIOOOUMIETKOOULEIOTESEYPWFETSRODEINNDESTGOUHOWATINETYAUMVUEEERNAOMRTHHOOASAIFLHDAEHSOONNDEDENSMUAETNMYETEHAWOOVTDLEDNSTOMETFUJSKTAESTHORREERHNMOHDITARTHAOWDEEOHBSTGEOOEKHODTESBIRYUITSEIFAHLOODWHRHSEWDEEDOLTWIYIFNMORRINAHINFRFHVTEALAOOEARHHTGLAPGIHFOHTMTISHPT", 4);
//        Transposition t = new Transposition("PRTCNHDDACSEOHYOLFREBDWFSRTUIIDNESFEUNEEEEIMEONAFEECNUEHUATARTTSEDUATDSEEHIARMEETMLEAMFOIUTDTASURHOHSTEDDNPAIAETETRAUCOICINRCDEOWDRANEELAISEMUANEWALRIGHEWBHGOUEFEEOSODQDTNIESFRSEDDHMBATTAIOHSIAOVTOONREIOAHNDPIYSPCCDVOMTDFOPHIEOWSTGOHHSOETRTEIREOOAILVHFPNEETINAAHSFTEYSTAISETHESTECEENODIBTSEASFITOITONLBHCAMEESOREXIETCENRSLRENTDNAYEHILREGCTVSIENIWMSYIERSTDLTEINHEATLETGNRHSHCONSITAEALATEERTDAHNREMRHTNOCOOHTBFAEBCEDIEFNUOATMLRHHEOEDINLEIHEAANTRLSARUOSTTRNTASHEDNSSUASAULAWUYNEBTOELMNLTSTIIHMEEHEOEEICSSYDIOTERIICIIESOMGETITSFEAUUIDRSOTAIWAFNDWOTLELHNHOEROSOETFTETHADEHECFRTDOSSNTABLDHLOTNASRAAHEOUTCANTASCIRSRTTDHMWEERNUTLBTWTAHMVEIXNIYTFIAIOHUTVVSTLSNLTRRTVEORHSSHONYLANTOOUHMSHSRDWAFILELEMEWPATKNCHARSOUUCEHHBNLSLHTGHRHIYIOLSROTNEDPOAHHSGEEEDQEEMBLHNHTDSYHCHEAOLORIBSTSDIWHNUHDNTILNRMNHIDBEWEKACONHTVNISHDCQYEIICYCOEWOALHTSIHATITRHTTRTFGRF", 6);
        t.transpositionCrack();
    }

}
