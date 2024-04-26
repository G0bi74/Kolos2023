public class Resource {
    public Resource(Point pointOfResource, Type typeOfResource) {
        this.pointOfResource = pointOfResource;
        this.typeOfResource = typeOfResource;
    }

    public enum Type{ Coal, Wood, Fish}
    public final Point pointOfResource;
    public final Type typeOfResource;
}
