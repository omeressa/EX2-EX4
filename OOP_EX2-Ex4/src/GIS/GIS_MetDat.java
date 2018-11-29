package GIS;


import Geom.Point3D;

public class GIS_MetDat implements Meta_data{

    private long data;
    Point3D Orientation;//not needed here for now!


    public GIS_MetDat(long data){ 
        this.data = data;
    }

    /**
     * return Universal Time Clock;
     */
    @Override
    public long getUTC(){
        return data;
    }
    
    /**
     * string function
     */
    public String toString(){
        return getUTC()+ ",";
    }
    
    /**
     * proffeser said to keep it NULL!
     */
    @Override
    public Point3D get_Orientation(){
        return null;
    }

}