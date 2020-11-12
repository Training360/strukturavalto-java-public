package stringmethods.url;


import org.junit.jupiter.api.Test;

import java.rmi.server.ExportException;

import static org.junit.jupiter.api.Assertions.*;

public class UrlManagerTest {


    @Test
    public void testCreate() {

        String url = "HTTPS://EarthQuake.USgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";

        UrlManager urlManager = new UrlManager(url);

        assertEquals("https", urlManager.getProtocol());
        assertEquals("earthquake.usgs.gov", urlManager.getHost());
        assertEquals("/fdsnws/event/1/query", urlManager.getPath());
        assertNull(urlManager.getPort());
    }

    @Test
    public void testCreateWithPortAtEnd() {

        String url = "HTTPS://EarthQuake.USgs.gov:80";

        UrlManager urlManager = new UrlManager(url);

        assertEquals("https", urlManager.getProtocol());
        assertEquals("earthquake.usgs.gov", urlManager.getHost());
        assertEquals("", urlManager.getPath());
        assertEquals(Integer.valueOf(80), urlManager.getPort());
    }

    @Test
    public void testCreateWithPort() {

        String url = "HTTPS://EarthQuake.USgs.gov:80/query?a=4";

        UrlManager urlManager = new UrlManager(url);

        assertEquals("https", urlManager.getProtocol());
        assertEquals("earthquake.usgs.gov", urlManager.getHost());
        assertEquals("/query", urlManager.getPath());
        assertEquals(Integer.valueOf(80), urlManager.getPort());
    }

    @Test
    public void testCreateMissingHost() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new UrlManager("http://"));
        assertEquals("Invalid url", ex.getMessage());
    }

    @Test
    public void testCreateMissingProtocol() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new UrlManager("www.google.com"));
        assertEquals("Invalid url", ex.getMessage());
    }

    @Test
    public void testHasProperty() {
        String url = "HTTPS://EarthQuake.USgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";

        UrlManager urlManager = new UrlManager(url);

        assertTrue(urlManager.hasProperty("format"));
    }

    @Test
    public void testHasPropertyMissing() {
        String url = "HTTPS://EarthQuake.USgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";

        UrlManager urlManager = new UrlManager(url);

        assertFalse(urlManager.hasProperty("place"));
    }

    @Test
    public void testHasPropertyForKeypart() {
        String url = "HTTPS://EarthQuake.USgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";

        UrlManager urlManager = new UrlManager(url);

        assertFalse(urlManager.hasProperty("time"));
    }

    @Test
    public void testHasPropertyWithNull() {
        String url = "HTTPS://EarthQuake.USgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";
        UrlManager urlManager = new UrlManager(url);

        assertThrows(IllegalArgumentException.class, () -> urlManager.hasProperty(null));

    }

    @Test
    public void testGetProperty() {
        String url = "HTTPS://EarthQuake.USgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";

        UrlManager urlManager = new UrlManager(url);

        assertEquals("geojson", urlManager.getProperty("format"));
    }

    @Test
    public void testGetPropertyMissing() {
        String url = "HTTPS://EarthQuake.USgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";

        UrlManager urlManager = new UrlManager(url);

        assertNull(urlManager.getProperty("place"));
    }

    @Test
    public void testGetPropertyForKeyPart() {
        String url = "HTTPS://EarthQuake.USgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";

        UrlManager urlManager = new UrlManager(url);

        assertNull(urlManager.getProperty("time"));
    }


    @Test
    public void testHasPropertyWithBlankParameter() {
        String url = "HTTPS://EarthQuake.USgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";
        UrlManager urlManager = new UrlManager(url);

        assertThrows(IllegalArgumentException.class, () -> urlManager.hasProperty("  "));
    }
}
