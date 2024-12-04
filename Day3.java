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
        // String pattern = "mul\\((-?\\d+)\\s*,\\s*(-?\\d+)\\)";
        // String patternDo = "\\bdo\\b\\(\\)";
        // String patternDont = "\\bdon't\\b\\(\\)";
        final String doo = "do()";
        final String dont = "don't()";
        final String mul = "mul";

        String patternCompile = "mul\\((-?\\d+)\\s*,\\s*(-?\\d+)\\)|\\bdo\\b\\(\\)|\\bdon't\\b\\(\\)";

        Pattern pttrnCompile = Pattern.compile(patternCompile);
        Matcher matcherCompile = pttrnCompile.matcher(sb.toString());

        // Pattern compiledPattern = Pattern.compile(pattern);
        // Matcher matcher = compiledPattern.matcher(sb.toString());

        // Pattern compiledPatternDo = Pattern.compile(patternDo);
        // Matcher matcherDo = compiledPatternDo.matcher(sb.toString());

        // Pattern compiledPatternDont = Pattern.compile(patternDont);
        // Matcher matcherDont = compiledPatternDont.matcher(sb.toString());

        int result = 0;
        int checkFirstMul = 0;
        Boolean status = null;

        while (matcherCompile.find()) {
            // StringBuilder sb = new StringBuilder();
            // sb.append(matcherCompile.group().startsWith())
            if (matcherCompile.group().startsWith(mul)) {
                if ((status != null && status) || status == null) {
                    String firstNumber = matcherCompile.group(1);
                    String secondNumber = matcherCompile.group(2);
                    result = result + (Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber));
                }
            } else if (matcherCompile.group().equals(doo)) {
                status = true;
            } else if (matcherCompile.group().equals(dont)) {
                status = false;
            }
        }

        // while (matcher.find() || matcherDo.find() || matcherDont.find()) {
        // if (matcherDont.find()) {
        // if ((status != null && status) || status == null) {
        // String firstNumber = matcher.group(1);
        // String secondNumber = matcher.group(2);
        // result = result + (Integer.parseInt(firstNumber) *
        // Integer.parseInt(secondNumber));
        // }
        // } else if (matcherDo.find()) {
        // status = true;
        // } else if (matcherDont.find()) {
        // status = false;
        // }
        // }

        return result;
    }
}
