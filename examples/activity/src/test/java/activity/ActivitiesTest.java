package activity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ActivitiesTest {

    Track track = new Track();

    Activities activities = new Activities(Arrays.asList(
            new ActivityWithTrack(track, ActivityType.RUNNING),
            new ActivityWithoutTrack(ActivityType.BASKETBALL),
            new ActivityWithTrack(track, ActivityType.RUNNING)));

    @Test
    public void testNumberOfWithTrack() {

        assertEquals(2, activities.numberOfTrackActivities());
    }

    @Test
    public void testNumberOfWithoutTrack() {

        assertEquals(1, activities.numberOfWithoutTrackActivities());
    }

    @Test
    public void testGetReportType() {
        track.addTrackPoint(new TrackPoint(new Coordinate(12.5, 34.89), 123));
        track.addTrackPoint(new TrackPoint(new Coordinate(-12.5, 45.7), 124));
        track.addTrackPoint(new TrackPoint(new Coordinate(13.7, -6.0), 0));
        track.addTrackPoint(new TrackPoint(new Coordinate(3.67, -42.789), 200));

        List<Report> result = activities.distancesByTypes();

        assertEquals(0.0, result.get(1).getDistance());

        assertEquals(0.0, result.get(0).getDistance());

        assertEquals(ActivityType.RUNNING, result.get(2).getActivityType());
        assertEquals(27223158, result.get(2).getDistance(), 5);

        assertEquals(ActivityType.BASKETBALL, result.get(3).getActivityType());
    }

}