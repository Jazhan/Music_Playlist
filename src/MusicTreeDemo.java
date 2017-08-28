import java.util.ArrayList;
import java.util.Iterator;

//This is the Tree Demo is for getters and setters.
// Retreving the direct child, to the root of parrent.
// Setting each child to the exact root. //

public class MusicTreeDemo<T> implements Position<T> {

	private Tree<T> tree;
	private T element;
	private ArrayList<MusicTreeDemo<T>> children;
	private MusicTreeDemo<T> parent;

	public MusicTreeDemo(T elem, MusicTreeDemo<T> p, Tree<T> t) {
		element = elem;
		children = new ArrayList<MusicTreeDemo<T>>();
		parent = p;
		tree = t;
	}

	@Override
	public T element() {
		return element;
	}

	public Iterator<MusicTreeDemo<T>> getChildren() {
		return children.iterator();
	}

	public ArrayList<MusicTreeDemo<T>> getDirectChilren() {
		return children;
	}

	public MusicTreeDemo<T> getParent() {
		return parent;
	}


	public MusicTreeDemo<T> addChild(MusicTreeDemo<T> child) {
		children.add(child);
		return child;
	}

	public T replace(T newElement) {
		T oldElement = element;
		element = newElement;
		return oldElement;
	}

	@Override
	public String toString() {
		return element.toString();
	}



}
