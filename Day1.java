import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {

        List<String[]> ls = parser("C:\\dev\\AoC_24\\Day1_input.txt");

        System.out.println(pair(ls));
        System.out.println(pairtwo(ls));
    }

    static int pair(List<String[]> ls) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 0; i < ls.size(); i++) {
            String[] a = ls.get(i);
            left.add(Integer.parseInt(a[0]));
            right.add(Integer.parseInt(a[1]));
        }

        Collections.sort(left);
        Collections.sort(right);

        int result = 0;
        for (int j = 0; j < left.size(); j++) {
            result += Math.abs(left.get(j) - right.get(j));
        }

        return result;
    }

    static int pairtwo(List<String[]> ls) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 0; i < ls.size(); i++) {
            String[] a = ls.get(i);
            left.add(Integer.parseInt(a[0]));
            right.add(Integer.parseInt(a[1]));
        }

        int count = 0;
        int result = 0;
        for (int i = 0; i < left.size(); i++) {
            for (int j = 0; j < right.size(); j++) {
                if (left.get(i).equals(right.get(j))) {
                    count++;
                }
            }
            result += left.get(i) * count;
            count = 0;
        }

        return result;
    }

    static List<String[]> parser(String path) throws FileNotFoundException {
        Scanner sc;
        List<String[]> ls = new ArrayList<>();
        File file = new File(path);
        sc = new Scanner(new File(path));

        while (sc.hasNextLine()) {
            ls.add(sc.nextLine().split("   "));
        }
        
        return ls;
    }

}
