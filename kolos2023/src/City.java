import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class City extends Polygon{
    public final Point center;
    private final String name;
    private Boolean portTown = false;
    Set<Resource.Type> townResourcesTypes = new HashSet<>();

    public static List<Point> squer(Point center, float wall){
        double halfW = wall / 2;
        List<Point> points = new ArrayList<>();
        points.add(new Point((center.getX() - halfW), (center.getY() - halfW)));
        points.add(new Point((center.getX() + halfW), (center.getY() - halfW)));
        points.add(new Point((center.getX() + halfW) , (center.getY() + halfW)));
        points.add(new Point((center.getX() - halfW), (center.getY() + halfW)));
        return points;
    }


    public City(Point center, String name, Float wall){
        super(City.squer(center, wall));
        this.center = center;
        this.name = name;
    }

    public void setPortTown(Boolean portTown) {
        this.portTown = portTown;
    }

    public String getName() {
        return name;
    }
    public List<Point> getPoints(){
        List<Point> points = new ArrayList<Point>(super.getPoints());
        return points;
    }
    public Boolean getPortTown(){
        return portTown;
    }
    public void addResourceInRange(List<Resource> landResource, double range){
        for(Resource r : landResource){
            if(r.pointOfResource.distanceToPoint(center) <= range){
                if(Resource.Type.Fish == r.typeOfResource){
                    if(portTown){
                       townResourcesTypes.add(r.typeOfResource);
                    }else {
                        System.out.println("Adding Resource "+ r.typeOfResource + " failed " + this.name + " is not port");
                    }
                }else {
                    townResourcesTypes.add(r.typeOfResource);
                }
            }else{
                System.out.println(r.typeOfResource + " Resource is not in the range " + range);
            }
        }
    }

}
