package module10;

import java.io.*;
import java.util.Scanner;

public class HomeworkTask1 {
    public static void main(String[] args) throws IOException {

        File file = new File("File.txt");

        if(file.exists()) {
            InputStream inputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()){
                String s = scanner.nextLine();
                if (isValidNumber(s)) {
                    System.out.println(s);
                }
            }
        }

    }
    static boolean isValidNumber(String phone) {
       // (xxx) xxx-xxxx или xxx-xxx-xxxx
        String phonePattern1 = "^[0-9\\s]{1,3}-[0-9\\s]{1,3}-[0-9\\s]{1,4}";
        String phonePattern2 = "^[(][0-9\\s]{1,3}[)] [0-9\\s]{1,3}-[0-9\\s]{1,4}";
        return phone.matches(phonePattern1)||phone.matches(phonePattern2);
    }
}
