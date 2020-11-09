package week02;

import java.util.ArrayList;
import java.util.List;

public class Office {

    public List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        System.out.println("printNames");
        for (MeetingRoom meetingRoom: meetingRooms) {
            System.out.println(meetingRoom.getName());
        }
    }

    public void printAreasLargerThan(int area) {
        System.out.println("printAreasLargerThan");
        for (MeetingRoom meetingRoom: meetingRooms) {
            if (meetingRoom.getArea() > area) {
                System.out.println(meetingRoom.getName() +" (" + meetingRoom.getWidth()
                        + " * "  + meetingRoom.getLength() + " = " + meetingRoom.getArea() + ")");
            }
        }
    }

    public List<MeetingRoom> getMeetingRooms() {
        return meetingRooms;
    }

    public void setMeetingRooms(List<MeetingRoom> meetingRooms) {
        this.meetingRooms = meetingRooms;
    }
}
