/* Implement Your own custom Exception */

public interface Tree<T> extends Iterable<Position<T>> {

	Position<T> root() throws Exception;

	Iterable<? extends Position<T>> children(Position<T> p)
			throws Exception; 

	int size();

	boolean isEmpty();

	boolean isInternal(Position<T> p) throws Exception;

	boolean isRoot(Position<T> p) throws Exception;
}