import java.util.ArrayList;

public class UniquePolygons
{
    private final String ERROR_MESSAGE = "Duplicado";
    ArrayList<Poligono> polygons;

    public UniquePolygons()
    {
        polygons = new ArrayList<Poligono>();
    }

    public void add(Poligono poly)
    {
        if (isEqualToAnyPolygon(poly))
            Error.terminateProgram(ERROR_MESSAGE);
        polygons.add(poly);
    }

    private boolean isEqualToAnyPolygon(Poligono poly)
    {
        for (Poligono p : polygons)
            if (poly.equals(p))
                return true;
        return false;
    }

    public String[] toStrings()
    {
        String[] strings = new String[this.polygons.size()];
        for (int i = 0; i < this.polygons.size(); i++)
            strings[i] = polygons.get(i).toString();
        return strings;
    }

    public Poligono get(int index)
    {
        return this.polygons.get(index);
    }
}
