package temperatures;

public class Temperatures {

    private byte[] data;

    public Temperatures(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public double getYearAverage() {
        double average = 0;
        for (byte temperature : data) {
            average += temperature;
        }
        return average / 365;
    }

    public double getMonthAverage() {
        double average = 0;
        for (int i = data.length - 1; i > data.length - 31; i--) {
            average += data[i];
        }
        return average / 30;
    }
}
