package filescanner;

import java.io.IOException;
import java.util.Scanner;

public class EmployeeReader {

    public static void main(String[] args) {
        // Scanner scanner = new Scanner(Path.of("a.txt"))
        // Ebben a csomagban/könyvtárban van a fájl
        // src/main/resources/filescanner/employees.txt
        try (Scanner scanner = new Scanner(EmployeeReader.class.getResourceAsStream("employees.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

        }
//        catch (IOException ioe) {
//            throw new IllegalStateException("Can not read file", ioe);
//        }

    }
}
