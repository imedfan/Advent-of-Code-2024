import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(mul());
        System.out.println(mulparttwo());
    }

    static int mul() throws FileNotFoundException {
        File file = new File("C:\\dev\\AoC_24\\Day3_input.txt");
        Scanner sc = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }
        sc.close();

        String pattern = "mul\\((-?\\d+)\\s*,\\s*(-?\\d+)\\)";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(sb.toString());

        int result = 0;

        while (matcher.find()) {
            String firstNumber = matcher.group(1);
            String secondNumber = matcher.group(2);
            result = result + (Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber));
        }

        return result;
    }

    static int mulparttwo() throws FileNotFoundException {
        File file = new File("C:\\dev\\AoC_24\\Day3_input.txt");
        Scanner sc = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }
        sc.close();

        final String doo = "do()";
        final String dont = "don't()";
        final String mul = "mul";
        // to search few patterns at the same time, for example mul(d,d) |(or) do() |(or) don't() 
        String rgx = "mul\\((-?\\d+)\\s*,\\s*(-?\\d+)\\)|\\bdo\\b\\(\\)|\\bdon't\\b\\(\\)";

        Pattern pattern = Pattern.compile(rgx);
        Matcher matcher = pattern.matcher(sb.toString());

        int result = 0;
        Boolean status = null;

        while (matcher.find()) {
            if (matcher.group().startsWith(mul)) {
                if ((status != null && status) || status == null) {
                    String firstNumber = matcher.group(1);
                    String secondNumber = matcher.group(2);
                    result = result + (Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber));
                }
            } else if (matcher.group().equals(doo)) {
                status = true;
            } else if (matcher.group().equals(dont)) {
                status = false;
            }
        }

        return result;
    }
}
