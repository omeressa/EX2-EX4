package GIS;

import Geom.Point3D;

import java.util.Date;

/**
 * This class implements the metadata interface which allows us to create metadata about the project (TIME OF CREATION)
 */
public class Other implements Meta_data
{
    private long current_time;

    public Other()
    {
        Date date = new Date();
        current_time = date.getTime();
    }

    @Override
    public long getUTC()
    {
        return current_time;
    }

    /**
     * as proffesor asked, null
     */
    @Override
    public Point3D get_Orientation()
    {
        return null;
    }

    
    @Override
    public String toString()
    {
        return "time: " + getUTC();
    }
}