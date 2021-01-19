package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    private List<Photo> photos = new ArrayList<>();

    public void addPhoto(String... names) {
        for (String name: names) {
            photos.add(new Photo(name));
        }
    }

    public void starPhoto(String name, Quality quality) {
        boolean found = false;
        for (Photo photo: photos) {
            if (photo.getName().equals(name)) {
                photo.setQuality(quality);
                found = true;
            }
        }
        if (!found) {
            throw new PhotoNotFoundException();
        }
    }

    public int numberOfStars() {
        int count = 0;
        for (Photo photo: photos) {
            switch(photo.getQuality()) {
                case TWO_STAR:
                    count ++;
                case ONE_STAR:
                    count ++;
            }
        }
        return count;
    }

    public List<Photo> getPhotos() {
        return photos;
    }
}
