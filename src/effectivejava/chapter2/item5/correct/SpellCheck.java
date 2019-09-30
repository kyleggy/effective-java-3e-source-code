package effectivejava.chapter2.item5.correct;

import effectivejava.chapter2.item5.Lexicon;

import java.util.List;
import java.util.Objects;

public class SpellCheck {
    private final Lexicon lexicon;

    public SpellCheck(Lexicon lexicon) {
        this.lexicon = lexicon;
        Objects.requireNonNull(lexicon);
    }

    public static boolean isValid(String word){
        return true;
    }

    public static List<String> suggestions(String typo) {
        return null;
    }
}
