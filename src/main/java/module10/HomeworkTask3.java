package module10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class HomeworkTask3 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("words.txt");
        String text = "";
        if(file.exists()) {
            InputStream inputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()){
                text += " "+scanner.nextLine();
            }
        }

        String[] keys = text.trim().split(" ");
        String[] uniqueKeys;
        int count = 0;

        uniqueKeys = getUniqueKeys(keys);

        for(String key: uniqueKeys) {
            if(key == null) {
                break;
            }
            for(String s : keys) {
                if(key.equals(s)) {
                    count++;
                }
            }
            System.out.println(key+" "+count);
            count = 0;
        }
    }
    private static String[] getUniqueKeys(String[] keys) {
        String[] uniqueKeys = new String[keys.length];
        uniqueKeys[0] = keys[0];
        int uniqueKeyIndex = 1;
        boolean keyAlreadyExists = false;

        for(int i=1; i<keys.length ; i++) {
            for(int j=0; j<=uniqueKeyIndex; j++) {
                if(keys[i].equals(uniqueKeys[j])) {
                    keyAlreadyExists = true;
                }
            }

            if(!keyAlreadyExists) {
                uniqueKeys[uniqueKeyIndex] = keys[i];
                uniqueKeyIndex++;
            }
            keyAlreadyExists = false;
        }
        return uniqueKeys;
    }
}