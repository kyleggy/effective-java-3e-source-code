package effectivejava.chapter2.item9.learntrywithresource;

public class CustomAutoClosable implements AutoCloseable {

    public void doIt() {
        System.out.println("CustomAutoClosable doing it!");
    }

    @Override
    public void close() throws Exception {
        System.out.println("CustomAutoClosable closed!");
    }

    private static void myAutoClosable() throws Exception {

        try(CustomAutoClosable myAutoClosable = new CustomAutoClosable()){
            myAutoClosable.doIt();
        }
    }

    public static void main(String[] args) {
        try {
            myAutoClosable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
