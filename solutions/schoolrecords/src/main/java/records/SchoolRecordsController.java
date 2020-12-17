package records;

import java.util.*;

public class SchoolRecordsController {

    private ClassRecords classRecords = new ClassRecords("9.A", new Random());
    private List<Subject> subjects;
    private List<Tutor> tutors;


    public void initSchool() {
        Subject math = new Subject("math");
        Subject physics = new Subject("physics");
        Subject biology = new Subject("biology");
        Subject literature = new Subject("literature");
        subjects = new ArrayList<>(Arrays.asList(math, physics, biology, literature));

        tutors = new ArrayList<>(Arrays.asList(
                new Tutor("John Doe", new ArrayList<>(Arrays.asList(math, physics))),
                new Tutor("Jane Smith", new ArrayList<>(Arrays.asList(biology, literature))),
                new Tutor("Chris Murray", new ArrayList<>(Arrays.asList(biology, math)))
        ));
    }


    public void menuToConsole() {
        System.out.println("1. Diákok nevének listázása\n" +
                "2. Diák név alapján keresése\n" +
                "3. Diák létrehozása\n" +
                "4. Diák név alapján törlése\n" +
                "5. Diák feleltetése\n" +
                "6. Osztályátlag kiszámolása\n" +
                "7. Tantárgyi átlag kiszámolása\n" +
                "8. Diákok átlagának megjelenítése\n" +
                "9. Diák átlagának kiírása\n" +
                "10. Diák tantárgyhoz tartozó átlagának kiírása\n" +
                "11. Kilépés");
    }


    private Tutor findTutorByName(String tutorName) {
        for (Tutor tutor : tutors) {
            if (tutorName.equals(tutor.getName())) {
                return tutor;
            }
        }
        throw new IllegalArgumentException("Cant find tutor with this name!");
    }

    private Subject findSubjectByName(String subjectName) {
        for (Subject subject : subjects) {
            if (subjectName.equals(subject.getSubjectName())) {
                return subject;
            }
        }
        throw new IllegalArgumentException("Cant find subject with this name!");
    }

    private MarkType findMarkTypeByValue(int value) {
        for (MarkType markType : MarkType.values()) {
            if (markType.getValue() == value) {
                return markType;
            }
        }

        throw new IllegalArgumentException("Cannot find mark with this value!");
    }


    public String oneDataIn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kérem az adatot:");
        return sc.nextLine();
    }


    public void averageOfOneStudent() {
        Student student = classRecords.findStudentByName(oneDataIn());
        System.out.println(student.calculateAverage());
    }

    public void getAverageOfStudentBySubject() {
        Student student = classRecords.findStudentByName(oneDataIn());
        Subject subject = findSubjectByName(oneDataIn());
        System.out.println(student.calculateSubjectAverage(subject));
    }


    public void studentRepetition() {
        Scanner sc = new Scanner(System.in);
        Student student = classRecords.repetition();
        System.out.println("Kérem a jegyet");
        int mark = Integer.parseInt(sc.nextLine());
        System.out.println("Kérem a tárgy nevét:");
        String subjectName = sc.nextLine();
        System.out.println("Kérem a tanár nevét:");
        String tutorName = sc.nextLine();

        Mark actualMark = new Mark(findMarkTypeByValue(mark), findSubjectByName(subjectName), findTutorByName(tutorName));
        student.grading(actualMark);
    }


    private void executeMenu(int menuNumber) {
        switch (menuNumber) {
            case 1: {
                System.out.println(classRecords.listStudentNames());
                return;
            }
            case 2: {
                System.out.println(classRecords.findStudentByName(oneDataIn()));
                return;
            }
            case 3: {
                classRecords.addStudent(new Student(oneDataIn()));
                return;
            }
            case 4: {
                classRecords.removeStudent(new Student(oneDataIn()));
                return;
            }
            case 5: {
                studentRepetition();
                return;
            }
            case 6: {
                classRecords.calculateClassAverage();
                return;
            }
            case 7: {
                System.out.println(classRecords.calculateClassAverageBySubject(new Subject(oneDataIn())));
                return;
            }
            case 8: {
                System.out.println(classRecords.listStudyResults());
                return;
            }
            case 9: {
                averageOfOneStudent();
                return;
            }
            case 10: {
                getAverageOfStudentBySubject();
                return;
            }
            case 11: {
                return;
            }
            default: {
                System.out.println("Nem létezik ilyen menüpont!");
            }
        }
    }


    public void runMenu() {
        Scanner scanner = new Scanner(System.in);
        int menuNumber = 0;
        while (menuNumber != 11) {
            menuToConsole();
            System.out.println("Kérem adja meg a menus számát:");
            try {
                menuNumber = Integer.parseInt(scanner.nextLine());
                executeMenu(menuNumber);
            } catch (NumberFormatException nfe) {
                System.out.println("Nyomatékosan kérem egy egész számot adjon meg!");
            } catch (IllegalArgumentException | ArithmeticException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }


    public static void main(String[] args) {

        SchoolRecordsController schoolRecordsController = new SchoolRecordsController();
        schoolRecordsController.initSchool();
        schoolRecordsController.runMenu();
    }

}
