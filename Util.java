import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;


// https://stackoverflow.com/questions/39192945/serialize-java-8-localdate-as-yyyy-mm-dd-with-gson
class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
    }

    // https://stackoverflow.com/questions/51183967/deserialize-date-attribute-of-json-into-localdate
    @Override
    public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {
        return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
    }
}

 */

public class Util {
    static LocalDate parseDate(String dateString) {
        // https://stackoverflow.com/questions/23488721/how-to-check-if-string-matches-date-pattern-using-time-api
        DateTimeFormatter foo = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        return LocalDate.parse(dateString, foo);
    }

    static String readFileAsString(String filename) {
        Path path = Paths.get(filename);
        try {
            return Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void writeStringToFile(String content, String filename) {
        try {
            Files.write(Paths.get(filename), content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String[] hashtags(String input) {
        Pattern pattern = Pattern.compile("#\\w+");
        Matcher match = pattern.matcher(input);
        List<String> results = new ArrayList<String>();
        while (match.find()) {
            results.add(match.group());
        }
        return results.toArray(new String[0]);

    }

    /*
     * static String objectToJson(Object obj) {
     * Gson gson = new GsonBuilder()
     * // .setPrettyPrinting()
     * .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
     * .create();
     * String result = gson.toJson(obj);
     * return result;
     * }
     *
     * static ArrayList<Visit> jsonToVisits(String json) {
     * Gson gson = new GsonBuilder()
     * .setPrettyPrinting()
     * .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
     * .create();
     * // Using Gson instructions:
     * //
     * https://github.com/google/gson/blob/master/UserGuide.md#collections-examples
     * ArrayList<Visit> visits = gson.fromJson(
     * json, new TypeToken<ArrayList<Visit>>() {
     * });
     * return visits;
     * }
     */

    public static void main(String[] args) {
        String testDate = "January 14, 2023";
        LocalDate foo = parseDate(testDate);
        System.out.println(foo);

        String hash = "I got some #cookies for my #bunny \n\n#tasty";
        for (String match : hashtags(hash)) {
            System.out.println(match);
        }

        // Hints:
        // https://stackoverflow.com/questions/23756456/java-separate-string-on-first-line-break
        // https://stackoverflow.com/questions/5455794/removing-whitespace-from-strings-in-java
        // https://github.com/google/gson

    }

}
