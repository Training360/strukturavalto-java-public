package interfaceextends.robot;

import java.util.List;

public interface MovableRobot {

    void moveTo(Point position);

    void fastMoveTo(Point position);

    void rotate(int angle);

    List<Point> getPath();
}
