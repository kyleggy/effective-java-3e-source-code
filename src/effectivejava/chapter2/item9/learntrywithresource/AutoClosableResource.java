package effectivejava.chapter2.item9.learntrywithresource;

public class AutoClosableResource implements AutoCloseable {

    private String   name                 = null;
    private boolean throwExceptionOnClose = false;

    public AutoClosableResource(String name, boolean throwExceptionOnClose) {
        this.name = name;
        this.throwExceptionOnClose = throwExceptionOnClose;
    }

    public void doOp(boolean throwException) throws Exception {
        System.out.println("Resource " + this.name + " doing operation");
        if(throwException) {
            throw new Exception("Error when calling doOp() on resource " + this.name);
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("Resource " + this.name + " close() called");
        if(this.throwExceptionOnClose){
            throw new Exception("Error when trying to close resource " + this.name);
        }
    }

//    public static void main(String[] args){
//        try {
//            tryWithResourcesSingleResource();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Throwable[] suppressed = e.getSuppressed();
//            for (int i = 0; i < suppressed.length; i ++) {
//                System.out.println(suppressed[i].getMessage());
//            }
//
//        }
//    }

    public static void main(String[] args){
        try {
            tryWithResourcesTwoResources();
        } catch (Exception e) {
            e.printStackTrace();
            Throwable[] suppressed = e.getSuppressed();
            for (int i = 0; i < suppressed.length; i ++) {
                System.out.println(suppressed[i].getMessage());
            }

        }
    }

    public static void tryWithResourcesSingleResource() throws Exception {
        try(AutoClosableResource resourceOne = new AutoClosableResource("One", false)) {
            resourceOne.doOp(false);
        }
    }

    public static void tryWithResourcesTwoResources() throws Exception {
        //Last one declared, first one close
        try(AutoClosableResource resourceOne = new AutoClosableResource("One", true);
            AutoClosableResource resourceTwo = new AutoClosableResource("Two", true)
        ){
            resourceOne.doOp(false);
            resourceTwo.doOp(false);
        }
    }
}
