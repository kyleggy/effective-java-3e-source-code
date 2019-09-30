package effectivejava.chapter2.item4;

// Noninstantiable utility class (Page 19)
public class UtilityClass {
    // Suppress default constructor for noninstantiability
    private UtilityClass() {
         throw new AssertionError();
    }

    public static void sayHello() {
        System.out.println("Hello");
    }

    // Remainder omitted

    public static void main(String[] args) {
        UtilityClass.sayHello();

        UtilityClass utilityClass = new UtilityClass();
        utilityClass.sayHello();
    }
}
