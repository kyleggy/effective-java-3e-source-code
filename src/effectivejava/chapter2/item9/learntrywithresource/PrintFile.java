package effectivejava.chapter2.item9.learntrywithresource;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PrintFile {

    public static void main(String[] args) throws IOException {
        printFile();
        try {
            printFileInJava9();
        } catch (IOException e) {
            e.printStackTrace();
        }

        printFileMultiple();
    }

    public static void printFile() {
        try(FileInputStream input = new FileInputStream("file.txt")) {

            int data = input.read();
            while(data != -1){
                System.out.print((char) data);
                data = input.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printFileInJava9() throws FileNotFoundException {
        FileInputStream input = new FileInputStream("file.txt");
        try(input) {

            int data = input.read();
            while(data != -1){
                System.out.print((char) data);
                data = input.read();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printFileMultiple() throws IOException {

        try(  FileInputStream     input         = new FileInputStream("file.txt");
              BufferedInputStream bufferedInput = new BufferedInputStream(input)
        ) {

            int data = bufferedInput.read();
            while(data != -1){
                System.out.print((char) data);
                data = bufferedInput.read();
            }
        }
    }
}
