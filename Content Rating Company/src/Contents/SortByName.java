package Contents;

import java.util.Comparator;

public class SortByName<T> implements Comparator<T>{

	@Override
	public int compare(T o1, T o2) {
		if(o1 instanceof Movie && o2 instanceof Movie) {
			return ((Movie) o1).getName().compareTo(((Movie) o2).getName());
		}
		else if(o1 instanceof Game && o2 instanceof Game) {
			return ((Game) o1).getName().compareTo(((Game) o2).getName());
		}
		return 0;
	}
}
