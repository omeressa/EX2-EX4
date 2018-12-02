package GIS;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * in this class we used set that holds all the info
 */
public class GIS_lay implements GIS_layer {

	private Other gps_point;
	private Set<GIS_element> set;
	public String name;


	public GIS_lay(String filename) {
		gps_point = new Other();
		set = new LinkedHashSet<GIS_element>();
		this.name = filename;
	}

	@Override
	public Meta_data get_Meta_data() {
		return gps_point;
	}

	public boolean add(GIS_element arg0) {////
		return set.add(arg0);
	}


	public boolean addAll(Collection<? extends GIS_element> arg0) {////
		return set.addAll(arg0);
	}

	public void clear() {////
		set.clear();
	}

	public boolean contains(Object arg0) {////
		return set.contains(arg0);
	}

	public boolean containsAll(Collection<?> arg0) {////
		return set.containsAll(arg0);
	}

	public boolean isEmpty() {////
		return set.isEmpty();
	}

	public Iterator<GIS_element> iterator() {////
		return set.iterator();
	}

	public boolean remove(Object arg0) {////
		return set.remove(arg0);
	}

	public boolean removeAll(Collection<?> arg0) {////
		return set.remove(arg0);
	}

	public boolean retainAll(Collection<?> arg0) {////
		return set.retainAll(arg0);
	}

	public int size() {////
		return set.size();
	}

	public Object[] toArray() {/////
		return set.toArray();
	}

	public <T> T[] toArray(T[] arg0) {////
		return set.toArray(arg0);
	}

	/**
	 * helping function
	 */
	public String name() {
		return this.name;
	}

	/**
	 * writing each line in the file
	 *
	 * @return data
	 */
	public String toString()
	{
		StringBuilder SB = new StringBuilder();
		for (GIS_element line : this.set)
			SB.append(line.toString()+'\n');//writing data and sorting them!
		return SB.toString();
	}
}