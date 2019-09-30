package effectivejava.chapter2.item5.anonymousclasses;

public class AnonymousClassChangeValue {
    interface ChangeIt {
        public void add();
    }

    public int changeValue(final int a) {
        //https://stackoverflow.com/questions/4732544/why-are-only-final-variables-accessible-in-anonymous-class
        int[] array = new int[1];
        ChangeIt changeIt = new ChangeIt() {
            @Override
            public void add() {
                int b = a + 1;
                array[0] = b;
            }
        };
        changeIt.add();
        return array[0];
    }

    public static void main(String... args) {
        AnonymousClassChangeValue anonymousClassChangeValue = new AnonymousClassChangeValue();
        int changed = anonymousClassChangeValue.changeValue(5);
        System.out.println(changed);
    }

}
