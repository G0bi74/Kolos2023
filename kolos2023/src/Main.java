import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Point insidePoint = new Point(5, 5);
        Point underPoint = new Point(5, 2);
        Point rightPoint = new Point(12, 8);
        List<Point> squerPoints = new ArrayList<Point>();
        squerPoints.add(new Point(4,4));
        squerPoints.add(new Point(8,4));
        squerPoints.add(new Point(8,8));
        squerPoints.add(new Point(4,8));
        Polygon polygonTest = new Polygon(squerPoints);

        System.out.println(polygonTest.inside(insidePoint));
        System.out.println(polygonTest.inside(underPoint));
        System.out.println(polygonTest.inside(rightPoint));

        List<Point> landPoints = new ArrayList<Point>();
        landPoints.add(new Point(41,1));
        landPoints.add(new Point(80,1));
        landPoints.add(new Point(80,40));
        landPoints.add(new Point(41,40));
        Land polska = new Land(landPoints);
        City cityInLand = new City((new Point(45,5)), "Lublin", 12.f);
        City cityOutLand = new City((new Point(30,0)), "Kraśnik", 5.f);
        City cityInLand2 = new City((new Point(55,15)), "Świdnik", 8.f);
        polska.addCity(cityInLand);
        polska.addCity(cityOutLand);
        polska.addCity(cityInLand2);
        System.out.println(polska.getCity(0).getPortTown());
        System.out.println(polska.getCity(1).getPortTown());


        List<Resource> landResources = new ArrayList<>();
        landResources.add(new Resource(new Point(49, 8), Resource.Type.Coal));
        landResources.add(new Resource(new Point(50, 11), Resource.Type.Wood));
        landResources.add(new Resource(new Point(40, 8), Resource.Type.Fish));
        landResources.add(new Resource(new Point(55, 15), Resource.Type.Fish));
        System.out.println(cityInLand.getName()+": ");
        cityInLand.addResourceInRange(landResources, 6.0);
        System.out.println(cityInLand.townResourcesTypes);

        System.out.println(cityInLand2.getName()+": ");
        cityInLand2.addResourceInRange(landResources, 4.0);
        System.out.println(cityInLand2.townResourcesTypes);


    }

}