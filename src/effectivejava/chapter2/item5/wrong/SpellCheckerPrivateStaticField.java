package effectivejava.chapter2.item5.wrong;

import effectivejava.chapter2.item5.Lexicon;
import effectivejava.chapter2.item5.LexiconChinese;

import java.util.List;

public class SpellCheckerPrivateStaticField {
    private final Lexicon dictionary = new LexiconChinese();

    public static final SpellCheckerPrivateStaticField spellCheckerPrivateStaticField = new SpellCheckerPrivateStaticField();

    private SpellCheckerPrivateStaticField() {
        throw new AssertionError();
    }

    public static boolean isValid(String word){
        return true;
    }

    public static List<String> suggestions(String typo) {
        return null;
    }
}
