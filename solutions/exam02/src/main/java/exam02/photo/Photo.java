package exam02.photo;

public class Photo implements Qualified {

    private String name;

    private Quality quality = Quality.NO_STAR;

    public Photo(String name) {
        this.name = name;
    }

    public Photo(String name, Quality quality) {
        this.name = name;
        this.quality = quality;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public String getName() {
        return name;
    }
}
