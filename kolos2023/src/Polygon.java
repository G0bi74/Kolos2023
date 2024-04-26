import java.util.ArrayList;
import java.util.List;

public class Polygon {
    private List<Point> points = new ArrayList<Point>();


    public Polygon(List<Point> points) {
        this.points = points;
    }

    public boolean inside(Point point) {
        int counter = 0;

        for (int i = 0; i < points.size(); i++) {
            Point pa = points.get(i);
            Point pb = points.get((i + 1) % points.size());
            double d, x, a, b;

            if (pa.getY() > pb.getY()) {
                Point tmp;
                tmp = pa;
                pa = pb;
                pb = tmp;
            }
            if (pa.getY() < point.getY() && point.getY() < pb.getY()) {
                d = pb.getX() - pa.getX();
                if (d == 0) {
                    x = pa.getX();
                } else {
                    a = (pb.getY() - pa.getY()) / d;
                    b = pa.getY() - a * pa.getX();
                    x = (point.y - b) / a;
                }
                if (x < point.x) {
                    counter++;
                }
            }
        }
        return (counter % 2 != 0) ? true : false;
    }

    public List<Point> getPoints() {
        return points;
    }
}

