import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    static LocalDate parseDate(String dateString) {
        DateTimeFormatter foo = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        return LocalDate.parse(dateString, foo);
    }

    static String[] hashtags(String input) {
        Pattern pattern = Pattern.compile("#\\w+");
        Matcher mat = pattern.matcher(input);
        List<String> results = new ArrayList<String>();
        while (mat.find()) {
            results.add(mat.group());
        }
        return results.toArray(new String[0]);

    }

    public static void main(String[] args) {
        String testDate = "January 14, 2023";
        LocalDate foo = parseDate(testDate);
        System.out.println(foo);

        String hash = "I got some #cookies for my #bunny \n\n#tasty";
        for (String match : hashtags(hash)) {
            System.out.println(match);
        }

    }

}
