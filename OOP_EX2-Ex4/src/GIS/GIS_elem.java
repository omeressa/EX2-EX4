package GIS;


import Coords.MyCoords;
import Geom.Geom_element;
import Geom.Point3D;


public class GIS_elem implements GIS_element {

     Geom_element geom;
     Meta_data data;
     
     /**
      * copy constructor
      */
    public GIS_elem(Geom_element geom, Meta_data data) {
        this.geom = geom;
        this.data = data;
    }
    
    /**
     * getGoem function
     */
    @Override
    public Geom_element getGeom() {
        return geom;
    }
    
    /**
     * getData function
     */
    @Override
    public Meta_data getData() {
        return data;
    }

	@Override
	public void translate(Point3D vec) {
		// TODO Auto-generated method stub
		
	}

    /**
     * tranlase method is to change given input's value
     * it means to stand at this Gis_element , and to "move" the element by a vector
     * @param vec is the translated element.
     */
    /*
    @Override
    public void translate(Point3D vec) {
        MyCoords myCoords = new MyCoords();
        GIS_element element = new GIS_elem(vec,this.data);
        Point3D translate = myCoords.vector3D(new Point3D(element.getGeom().toString()),vec);
        GIS_element translated = new GIS_elem(translate,element.getData());
        this.geom = translated.getGeom();
        this.data = translated.getData();
    }
    */

}