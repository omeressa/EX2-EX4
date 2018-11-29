package GIS;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Geom.Point3D;

public class GIS_lay {

	
    Set<GIS_element> set = new HashSet<>();
    Meta_data data;
    long time;
	
    public GIS_lay(){////
        time = System.currentTimeMillis();
   }
    
    public void setData(long data) {////
        if (this.data == null) this.data = new GIS_MetDat(data);
    }
    
	public boolean add(GIS_element arg0){////
		return set.add(arg0);
	}

	
	public boolean addAll(Collection<? extends GIS_element> arg0){////
		return set.addAll(arg0);
	}

	public void clear(){////
		set.clear();
	}

	public boolean contains(Object arg0){////
		return set.contains(arg0);
	}

	public boolean containsAll(Collection<?> arg0){////
		return set.containsAll(arg0);
	}

	public boolean isEmpty(){////
		return set.isEmpty();
	}

	public Iterator<GIS_element> iterator(){////
		return set.iterator();
	}

	public boolean remove(Object arg0){////
		return set.remove(arg0);
	}

	public boolean removeAll(Collection<?> arg0){////
		return set.remove(arg0);
	}

	public boolean retainAll(Collection<?> arg0){////
		return set.retainAll(arg0);
	}

	public int size(){////
		return set.size();
	}

	public Object[] toArray(){/////
		return set.toArray();
	}

	public <T> T[] toArray(T[] arg0){////
		return set.toArray(arg0);
	}
	
   public Meta_data get_Meta_data(){////
       return new Meta_data(){
           @Override
           public long getUTC(){
               return time;
           }
           @Override
           public Point3D get_Orientation(){
               return null;
           }
       };
   }
	
}
