import java.util.*;
import java.io.*;

public class permutation {
    public static void main(String[] args) throws java.lang.Exception {
        //reader
        BufferedReader bufferedReader = null;
        //csv file path
        String csv = "";
        //to input each line
        String change_line = "";
        //seprator in csv file
        String regex = ",";
        ArrayList<String> arrayList = new ArrayList<String>();
//        String string = "";
//        Scanner in = new Scanner(System.in);
        csv = args[0];

        // EXCEPTION HANDLING
        try {
            bufferedReader = new BufferedReader(new FileReader(csv));
            while ((change_line = bufferedReader.readLine()) != null) {
                String string = "";
                String[] value = change_line.split(regex);
                for (int i=0; i<value.length;i++) {
                    string = string+ value[i].charAt(1);
                }
                arrayList.add(string);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
//The code loops through each line of the csv file while selecting single elements
// from the first string from all the lines,#FIRST OUTPUT STRING# and then selecting
// Second string from the last, and so on the loop completes.
        ArrayList<String> finalString = new ArrayList<String>();
        String s = arrayList.get(0);
//intially the arraylist contains the first line of the csv file
        for (int i= 0; i < s.length(); i++) {
            finalString.add(String.valueOf(s.charAt(i)));
        }
        // AFTER SELECTING THE THE FIRST ELEMENT OF finalString, IT SELECTS ELEMENTS FROM NEXT LINE
        for (int i= 1; i < arrayList.size(); i++) {
            String every_string = arrayList.get(i);
            ArrayList<String> rev = new ArrayList<String>();
            for (int j = 0; j < every_string.length(); j++) {
                int a = 0;
                while (a < finalString.size()) {
                    rev.add(finalString.get(a) + every_string.charAt(j));
                    a++;
                }
            }
            finalString = rev;
        }
        for (int t = 0; t < finalString.size(); t++) {
            System.out.print(finalString.get(t) + ",");
        }
    }
}

