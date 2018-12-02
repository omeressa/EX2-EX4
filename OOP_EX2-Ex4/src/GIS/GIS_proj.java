package GIS;


import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Geom.Point3D;

public class GIS_proj implements GIS_project {

	Set<GIS_layer> set = new HashSet<>();
	Meta_data data;
	long time;

	public GIS_proj() {
		time = System.currentTimeMillis();
	}

	@Override
	public boolean add(GIS_layer arg0) {
		// TODO Auto-generated method stub
		return set.add(arg0);
	}

	@Override
	public boolean addAll(Collection<? extends GIS_layer> arg0) {
		// TODO Auto-generated method stub
		return set.addAll(arg0);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		set.clear();
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return set.contains(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return set.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return set.isEmpty();
	}

	@Override
	public Iterator<GIS_layer> iterator() {
		// TODO Auto-generated method stub
		return set.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return set.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return set.remove(arg0);
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return set.retainAll(arg0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return set.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return set.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return set.toArray(arg0);
	}

	/**
	 * need to go through this one more time
	 */
	@Override
	public Meta_data get_Meta_data() {
		return new Meta_data() {
			@Override
			public long getUTC() {
				return time;
			}
			@Override
			public Point3D get_Orientation() {
				return null;
			}
		};
	}
}

