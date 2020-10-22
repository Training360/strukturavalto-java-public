package abstractclass.gamecharacter;


public class Point {
	final private long x;
	final private long y;

	public long getX() { return x; }

	public long getY() {
		return y;
	}

	public Point(long x, long y) {
		this.x = x;
		this.y = y;
	}

	public long distance(Point otherPoint) {
		return (long) Math.sqrt(
				Math.pow((double)x - otherPoint.getX(), 2) +
				Math.pow((double)y - otherPoint.getY(), 2)
		);
	}

}
