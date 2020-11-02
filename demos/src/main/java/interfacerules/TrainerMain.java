package interfacerules;

public class TrainerMain {

    public static void main(String[] args) {

        HasName hasName = new Trainer();
        hasName.getName();

        CanWork canWork = new Trainer();
        canWork.doWork();

        System.out.println(EmployeeType.FULL_TIME);
    }
}
