import java.util.ArrayList;
import java.util.List;

public class Land extends Polygon{
    private List<City> cities = new ArrayList<City>();

    public Land(List<Point> points) {
        super(points);
    }

    public boolean addCity(City src){
        if(super.inside(src.center)){
            cities.add(src);
            src.setPortTown(isPortTown(src));
            System.out.println(src.getName()+" added!");
            return true;
        }else{
            System.out.println(src.getName()+" Not added!");
            return false;
        }
    }
    public Boolean isPortTown( City src){
        List<Point> townCorners = src.getPoints();
        for (Point corner : townCorners) {
            if(!super.inside(corner)){
                return true;
            }
        }
        return false;
    }
    public City getCity(int index){
        return cities.get(index);
    }
}
