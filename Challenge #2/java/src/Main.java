import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var leetText = transformNaturalLanguageToLeetLanguage("this is a test language");
        System.out.println("leetText = " + leetText);
    }


    private static String transformNaturalLanguageToLeetLanguage(String text) {
        var leetText = new StringBuilder();
        Arrays.stream(text.trim().split("")).forEach(word -> {
            var leetWord = leetMapper.getOrDefault(word, " ");
            leetText.append(leetWord);
        });
        return leetText.toString();
    }


    private static final Map<String, String> leetMapper = Map.ofEntries(
            Map.entry("a", "4"),
            Map.entry("b", "l3"),
            Map.entry("c", "["),
            Map.entry("d", ")"),
            Map.entry("e", "3"),
            Map.entry("f", "|="),
            Map.entry("g", "&"),
            Map.entry("h", "#"),
            Map.entry("i", "1"),
            Map.entry("j", "_l"),
            Map.entry("k", ">|"),
            Map.entry("l", "1"),
            Map.entry("m", "/\\/\\"),
            Map.entry("n", "^/"),
            Map.entry("o", "0"),
            Map.entry("p", "|*"),
            Map.entry("q", "(_,)"),
            Map.entry("r", "l2"),
            Map.entry("s", "5"),
            Map.entry("t", "7"),
            Map.entry("u", "|_|"),
            Map.entry("v", "\\/"),
            Map.entry("w", "\\/\\/"),
            Map.entry("x", "><"),
            Map.entry("y", "`/"),
            Map.entry("z", "2")
    );
}