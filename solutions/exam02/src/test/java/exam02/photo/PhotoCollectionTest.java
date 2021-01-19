package exam02.photo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PhotoCollectionTest {

    @Test
    public void testCreatePhoto() {
        Photo photo = new Photo("a.jpg");
        assertEquals("a.jpg", photo.getName());
        assertEquals(Quality.NO_STAR, photo.getQuality());
    }

    @Test
    public void testIsStarable() {
        Qualified qualified = new Photo("a.jpg");
        assertEquals(Quality.NO_STAR, qualified.getQuality());
    }

    @Test
    public void testCreatePhotoWithStar() {
        Photo photo = new Photo("a.jpg", Quality.ONE_STAR);
        assertEquals("a.jpg", photo.getName());
        assertEquals(Quality.ONE_STAR, photo.getQuality());

    }

    @Test
    public void testStarPhoto() {
        Photo photo = new Photo("a.jpg");
        assertEquals("a.jpg", photo.getName());
        assertEquals(Quality.NO_STAR, photo.getQuality());

        photo.setQuality(Quality.ONE_STAR);
        assertEquals(Quality.ONE_STAR, photo.getQuality());
    }

    @Test
    public void testCreatePhotoCollection() {
        PhotoCollection photoCollection = new PhotoCollection();
        assertEquals(0, photoCollection.getPhotos().size());
    }

    @Test
    public void testStarsEmpty() {
        PhotoCollection photoCollection = new PhotoCollection();
        photoCollection.addPhoto("a.jpg", "b.jpg", "c.jpg");
        assertEquals(0, photoCollection.numberOfStars());
    }

    @Test
    public void testNotFound() {
        PhotoCollection photoCollection = new PhotoCollection();
        photoCollection.addPhoto("a.jpg", "b.jpg", "c.jpg");
        assertThrows(PhotoNotFoundException.class,
                () -> photoCollection.starPhoto("d.jpg", Quality.ONE_STAR));
    }

    @Test
    public void testStars() {
        PhotoCollection photoCollection = new PhotoCollection();
        photoCollection.addPhoto("a.jpg", "b.jpg", "c.jpg");
        photoCollection.starPhoto("a.jpg", Quality.TWO_STAR);
        photoCollection.starPhoto("a.jpg", Quality.ONE_STAR);
        assertEquals(1, photoCollection.numberOfStars());
    }

    @Test
    public void testStarsThree() {
        PhotoCollection photoCollection = new PhotoCollection();
        photoCollection.addPhoto("a.jpg", "b.jpg", "c.jpg", "d.jpg", "e.jpg");
        photoCollection.starPhoto("a.jpg", Quality.ONE_STAR);
        photoCollection.starPhoto("b.jpg", Quality.TWO_STAR);
        assertEquals(3, photoCollection.numberOfStars());
    }
}
