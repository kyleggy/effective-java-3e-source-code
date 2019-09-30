package effectivejava.chapter2.item5.wrong;

import effectivejava.chapter2.item5.Lexicon;
import effectivejava.chapter2.item5.LexiconChinese;

import java.util.List;

public class SpellCheckerPrivateConstructor {
    private static final Lexicon dictionary = new LexiconChinese();

    private SpellCheckerPrivateConstructor() {} // Noninstantiable

    public static boolean isValid(String word){
        return true;
    }

    public static List<String> suggestions(String typo) {
        return null;
    }
}
