package effectivejava.chapter2.item5;

import effectivejava.chapter2.item5.Lexicon;

public class LexiconChinese implements Lexicon {
    @Override
    public void Translate() {
        System.out.println("Translate Chinese");
    }
}
