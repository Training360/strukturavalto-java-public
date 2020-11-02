package lambdacomparator.cloud;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CloudsTest {

    private List<CloudStorage> storages;
    private List<CloudStorage> storagesWithoutFree;

    @BeforeEach
    public void initStorages() {
        storagesWithoutFree = List.of(
                new CloudStorage("iDrive", 2000, PayPeriod.ANNUAL, 52.12),
                new CloudStorage("iDrive", 5000, PayPeriod.ANNUAL, 74.62),
                new CloudStorage("pCloud", 500, PayPeriod.LIFETIME, 175.0),
                new CloudStorage("pCloud", 2000, PayPeriod.LIFETIME, 350.0),
                new CloudStorage("pCloud", 500, PayPeriod.MONTHLY, 3.99),
                new CloudStorage("pCloud", 2000, PayPeriod.MONTHLY, 7.99),
                new CloudStorage("Zoolz", 100, PayPeriod.ANNUAL, 35.88),
                new CloudStorage("Zoolz", 500, PayPeriod.ANNUAL, 83.88),
                new CloudStorage("Zoolz", 1000, PayPeriod.MONTHLY, 12.99),
                new CloudStorage("Mega", 200, PayPeriod.MONTHLY, 4.99),
                new CloudStorage("Mega", 1000, PayPeriod.MONTHLY, 9.99),
                new CloudStorage("Mega", 4000, PayPeriod.MONTHLY, 19.99),
                new CloudStorage("OneDrive", 100, PayPeriod.MONTHLY, 1.99)
        );
        storages = new ArrayList<>(storagesWithoutFree);
        storages.addAll(List.of(
                new CloudStorage("iDrive", 5),
                new CloudStorage("Zoolz", 1),
                new CloudStorage("Mega", 50),
                new CloudStorage("OneDrive", 5)
        ));
    }

    @Test
    public void testAlphabeticallyFirst() {
        Clouds clouds = new Clouds();

        CloudStorage cloudStorage = clouds.alphabeticallyFirst(storages);

        assertEquals("iDrive", cloudStorage.getProvider());
    }

    @Test
    public void testBestPriceForShortestPeriodWithoutFree() {
        Clouds clouds = new Clouds();

        CloudStorage cloudStorage = clouds.bestPriceForShortestPeriod(storagesWithoutFree);

        assertEquals(1.99, cloudStorage.getPrice(), 0.0000001);
        assertEquals("OneDrive", cloudStorage.getProvider());
    }

    @Test
    public void testBestPriceForShortestPeriod() {
        Clouds clouds = new Clouds();

        CloudStorage cloudStorage = clouds.bestPriceForShortestPeriod(storages);

        assertEquals(0, cloudStorage.getPrice(), 0.0000001);
    }

    @Test
    public void testWorstOffersWithoutFree() {
        Clouds clouds = new Clouds();

        List<CloudStorage> worstStorages = clouds.worstOffers(storagesWithoutFree);

        assertEquals(3, worstStorages.size());
    }

    @Test
    public void testWorstOffers() {
        Clouds clouds = new Clouds();

        List<CloudStorage> worstStorages = clouds.worstOffers(storages);

        assertEquals(3, worstStorages.size());
        assertEquals(List.of("Zoolz", "Mega", "OneDrive"), worstStorages.stream().map(CloudStorage::getProvider).collect(Collectors.toList()));
        assertEquals(List.of(100, 200, 100), worstStorages.stream().map(CloudStorage::getSpace).collect(Collectors.toList()));
        assertEquals(List.of(PayPeriod.ANNUAL, PayPeriod.MONTHLY, PayPeriod.MONTHLY), worstStorages.stream().map(CloudStorage::getPeriod).collect(Collectors.toList()));
        assertEquals(List.of(35.88, 4.99, 1.99), worstStorages.stream().map(CloudStorage::getPrice).collect(Collectors.toList()));
    }

    @Test
    public void testWorstOffersWithOneProvider() {
        Clouds clouds = new Clouds();

        List<CloudStorage> worstStorages = clouds.worstOffers(List.of(new CloudStorage("iDrive", 2000, PayPeriod.ANNUAL, 52.12)));

        assertEquals(1, worstStorages.size());
        assertEquals(List.of("iDrive"), worstStorages.stream().map(CloudStorage::getProvider).collect(Collectors.toList()));
        assertEquals(List.of(2000), worstStorages.stream().map(CloudStorage::getSpace).collect(Collectors.toList()));
        assertEquals(List.of(PayPeriod.ANNUAL), worstStorages.stream().map(CloudStorage::getPeriod).collect(Collectors.toList()));
        assertEquals(List.of(52.12), worstStorages.stream().map(CloudStorage::getPrice).collect(Collectors.toList()));
    }
}
