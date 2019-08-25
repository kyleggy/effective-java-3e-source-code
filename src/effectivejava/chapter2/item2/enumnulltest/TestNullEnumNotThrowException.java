package effectivejava.chapter2.item2.enumnulltest;

public class TestNullEnumNotThrowException {
    private COLOR color;

    enum COLOR {
        RED, GREEN, BLUE
    }

    public TestNullEnumNotThrowException(COLOR color) {
        this.color = color;
    }

    public COLOR getColor() {
        return color;
    }
    public static void main(String[] args) {
        TestNullEnumNotThrowException testNullEnumNotThrowException = new TestNullEnumNotThrowException(null);

        //https://www.baeldung.com/a-guide-to-java-enums runtime safety to use == for enum compare
        //not throw
        System.out.println(testNullEnumNotThrowException.getColor() == COLOR.BLUE);

        //not throw
        System.out.println(COLOR.BLUE.equals(testNullEnumNotThrowException.getColor()));

        //throw nullpointexception
        System.out.println(testNullEnumNotThrowException.getColor().equals(COLOR.BLUE));

    }
}


