import java.io.*;
import java.util.*;

public class Menu {

    public static void run() throws IOException {
        String file = "";
        String[] files = files();
        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Get List");
        System.out.println("2 - Check if present");
        System.out.println("3 - Create new file");
        String menuOption = sc.next();

        switch (menuOption) {
            case "1" -> getList(files);
            case "2" -> checkFile(files);
            case "3" -> newFile();
        }
    }

    private static void getList(String[] files) throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("src/TotalFiles"));
            writer.write(Arrays.toString(files));
            System.out.println("File Created");
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (Objects.nonNull(writer)) {
                writer.close();
            }
        }
    }

    private static void checkFile(String[] files){
        Scanner sc = new Scanner(System.in);
        System.out.println("File name?");
        String file = sc.next();
        for (String f : files) {
            if (f.equals(file)) {
                System.out.println("EXIST");
                return;
            }
        }
        System.out.println("DONT EXIST");
    }

    private static void newFile() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("New File name?");
        String file = sc.next();
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/Files/" + file));

        writer.close();
    }
    private static String[] files() {
        File file = new File("src/Files");
        return file.list();
    }
}
