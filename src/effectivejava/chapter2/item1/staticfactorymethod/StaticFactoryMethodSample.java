package effectivejava.chapter2.item1.staticfactorymethod;

import effectivejava.chapter2.item1.rank.Rank;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.*;

public class StaticFactoryMethodSample {


    public static void main(String[] args) {

        Boolean bool = Boolean.valueOf("true");
        System.out.println(bool);


        BigInteger bigInteger = BigInteger.probablePrime(10, new Random(1));
        System.out.println(bigInteger);

        Set set = Collections.emptySet();

        Date d = Date.from(Instant.now());
        System.out.println(d);

        //https://www.baeldung.com/java-enumset
        Set<Rank> faceCards = EnumSet.of(Rank.JACK, Rank.KING, Rank.SOLIDER);
        System.out.println(faceCards);

        BigInteger biggestInt = BigInteger.valueOf(Integer.MAX_VALUE);
        System.out.println(biggestInt);

        BigInteger biggestLong =   BigInteger.valueOf(Long.MAX_VALUE);
        System.out.println(biggestLong);

        StackWalker stackWalker = StackWalker.getInstance(StackWalker.Option.SHOW_HIDDEN_FRAMES);
        System.out.println(stackWalker);

        String[] stringArray = (String[])Array.newInstance(String.class, 3);

        Array.set(stringArray, 0, "First");
        Array.set(stringArray, 1, "Second");
        Array.set(stringArray, 2, "Third");

        System.out.println("stringArray[0] = " + Array.get(stringArray, 0));
        System.out.println("stringArray[1] = " + Array.get(stringArray, 1));
        System.out.println("stringArray[2] = " + Array.get(stringArray, 2));

        try {
            FileStore fileStore = Files.getFileStore(Path.of("."));
            System.out.println(fileStore);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader br = Files.newBufferedReader(Path.of("."));
            System.out.println(br);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Vector v = new Vector();

        // populate the vector
        v.add("A");
        v.add("B");
        v.add("C");
        v.add("D");
        v.add("E");

        // create enumeration
        Enumeration e = v.elements();

        // get the list
        List arrlist = Collections.list(e);

        System.out.println("Value of returned list: "+arrlist);

    }
}
