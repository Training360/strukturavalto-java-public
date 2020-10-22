package classstructuremethods;

public class ClientMain {

    public static void main(String[] args) {
        Client client = new Client();

        client.setName("John Doe");
        client.setYear(1993);
        client.setAddress("1106 Budapest, Kozma utca 4.");

        System.out.println("Név: " + client.getName());
        System.out.println("Születési év: " + client.getYear());
        System.out.println("Lakcím: " + client.getAddress());

        client.migrate("8200 Veszprém, Ladik u. 34.");

        System.out.println("Új lakcíme: " + client.getAddress());
    }
}
