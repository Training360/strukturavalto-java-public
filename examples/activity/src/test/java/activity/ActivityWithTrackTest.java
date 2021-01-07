package activity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ActivityWithTrackTest {


    Track track = new Track();
    Activity activityWithTrack = new ActivityWithTrack(
            track, ActivityType.RUNNING
    );

    @Test
    public void testGetDistance() {
        track.addTrackPoint(new TrackPoint(new Coordinate(12.5, 34.89), 123));
        track.addTrackPoint(new TrackPoint(new Coordinate(-12.5, 45.7), 124));
        track.addTrackPoint(new TrackPoint(new Coordinate(13.7, -6.0), 0));
        track.addTrackPoint(new TrackPoint(new Coordinate(3.67, -42.789), 200));

        System.out.println(activityWithTrack.getDistance());
        assertTrue(activityWithTrack.getDistance() > 13611579.57 && activityWithTrack.getDistance() < 13611579.67);
    }


    @Test
    public void testGetType() {
        assertEquals(ActivityType.RUNNING, activityWithTrack.getType());
    }
}