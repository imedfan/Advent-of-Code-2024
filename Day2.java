import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(reports());
        System.out.println(reportstwo());
    }

    static int reports() throws FileNotFoundException, ArrayIndexOutOfBoundsException {
        File file = new File("C:\\dev\\AoC_24\\Day2_input.txt");
        Scanner sc = new Scanner(file);
        List<String[]> ls = new ArrayList<>();
        while (sc.hasNext()) {
            ls.add(sc.nextLine().split(" "));
        }
        int result = 0;
        int count = 1;
        boolean incrise = false;
        for (int i = 0; i < ls.size(); i++) {
            count = 1;
            incrise = false;
            String[] s = ls.get(i);
            if ((Integer.parseInt(s[0]) < Integer.parseInt(s[1]))) {
                incrise = true;
            }
            for (int j = 0; j < s.length; j++) {
                if (j + 2 <= s.length) {
                    if (incrise == true){
                        if ((Integer.parseInt(s[j]) < Integer.parseInt(s[j + 1]))) {
                            int c = Math.abs((Integer.parseInt(s[j]) - Integer.parseInt(s[j + 1])));
                            if (c <= 3 && c >= 1){
                                count++;
                            }
                        } 
                    } else {
                        if ((Integer.parseInt(s[j]) > Integer.parseInt(s[j + 1]))) {
                            int c = Math.abs((Integer.parseInt(s[j]) - Integer.parseInt(s[j + 1])));
                            if (c <= 3 && c >= 1){
                                count++;
                            }
                        }
                    }
                }
            }
            if (count == s.length) {
                result++;
            }
        }
        return result;
    }

    static int reportstwo() throws FileNotFoundException, ArrayIndexOutOfBoundsException {
        File file = new File("C:\\dev\\AoC_24\\Day2_input.txt");
        Scanner sc = new Scanner(file);
        List<List<Integer>> ls = new ArrayList<>();

        while (sc.hasNext()) {
            String[] ss = sc.nextLine().split(" ");
            List<Integer> oo = new ArrayList<>();
            for (int i = 0; i<ss.length; i++){
                oo.add(Integer.parseInt(ss[i]));
            }
            ls.add(oo);
        }

        int result = 0;
        int count = 1;
        boolean incrise = false;
        int countLvl = 0;
        for (int i = 0; i < ls.size(); i++) {
            count = 1;
            incrise = false;
            countLvl = 0;
            List<Integer> li = ls.get(i);
            if (li.get(0) < li.get(1)) {
                incrise=true;
            }
            for (int j = 0; j < li.size(); j++) {
                if (j + 2 <= li.size()) {

                    if (incrise == true){
                        if (li.get(j) < li.get(j+1)) {
                            int c = Math.abs(li.get(j) - li.get(j+1));
                            if (c <= 3 && c >= 1){
                                count++;
                            } else {
                                if (countLvl == 0){
                                    li.remove(j+1);
                                    j--;
                                    countLvl++;
                                }
                            }
                        } else {
                            if (countLvl == 0){
                                li.remove(j+1);
                                j--;
                                countLvl++;
                            } else {
                                break;
                            }
                        }
                    } else {
                        if (li.get(j) > li.get(j+1)) {
                            int c = Math.abs(li.get(j) - li.get(j+1));
                            if (c <= 3 && c >= 1){
                                count++;
                            } else {
                                if (countLvl == 0){
                                    li.remove(j+1);
                                    j--;
                                    countLvl++;
                                }
                            }
                        } else {
                            if (countLvl == 0){
                                li.remove(j+1);
                                j--;
                                countLvl++;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            if (count == li.size()) {
                result++;
                // System.out.println("Заебок: " + result + " : " + li.toString());
            } else {
                System.out.println("Не заебок " + "0" + " : " + li.toString());
            }
        }
        return result;
    }
}
