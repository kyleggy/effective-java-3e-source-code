package effectivejava.chapter2.item6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestKeySet {

    public static void main(String[] args) {

        Map<String, String> testkeySets = new HashMap<>();
        testkeySets.put("key1","value1");
        testkeySets.put("key2","value2");
        testkeySets.put("key3","value3");
        testkeySets.put("key4","value");
        Set<String> keys1 = testkeySets.keySet();
        Set<String> keys2 = testkeySets.keySet();
        if (keys1 == keys2) {
            System.out.println("They are equal");
        }

        System.out.println("Change it and verify they are still the same");
        testkeySets.put("key5", "value5");
        if (keys1 == keys2 && (keys1.size() == 5)) {
            System.out.println("They are eual");
        }
    }
}
