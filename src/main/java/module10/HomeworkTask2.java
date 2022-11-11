package module10;

import com.google.gson.Gson;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class HomeworkTask2 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("File2.txt");
        Scanner scanner = new Scanner(inputStream);
        Map<String, Integer> result = new HashMap<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] data = line.split(" ");
            String name = data[0];
            Integer amount = Integer.parseInt(data[1]);
            if(!result.containsKey(name)) {
                result.put(name, amount);
            }
            else {
                Integer currentAmount = result.get(name);
                result.put(name, currentAmount + amount);
            }
        }
        Gson gson = new Gson();
        List<User> list = result.entrySet().stream()
                                           .map((e)->new User(e.getKey(),e.getValue()))
                                           .collect(Collectors.toList());

        String json = new Gson().toJson(list);

        System.out.println(json);

    }
}
