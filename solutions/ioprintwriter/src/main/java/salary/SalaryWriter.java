package salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SalaryWriter {

    private List<String> names;

    public SalaryWriter(List<String> names) {
        this.names = names;
    }


    public void writeNamesAndSalaries(Path file) {
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(file))) {
            for (String name : names) {
                pw.print(name);
                pw.print(": ");
                pw.println(decideSalary(name));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file!");
        }
    }


    private long decideSalary(String name) {
        if (name.contains("Dr")) {
            return 500_000;
        }
        if (name.contains("Mr") || name.contains("Mrs")) {
            return 200_000;
        } else {
            return 100_000;
        }
    }


}
