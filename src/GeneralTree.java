
/**
 * This is the general tree, sort of complex
 * implements the tree interface
 * 
 * And the tree interface extends the iterator interface
 * Important use of BFS and DFS
 * 
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;



public class GeneralTree<T> implements Tree<T> {

	private MusicTreeDemo<T> root;
	private int size;

	public GeneralTree(T rootElement) {
		root = new MusicTreeDemo<T>(rootElement, null, this);
		size = 1;
	}

	@Override
	public Position<T> root() {
		return root;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterable<? extends Position<T>> children(Position<T> pos) {
		return getNodeElement(pos).getDirectChilren();
	}
	

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isInternal(Position<T> pos) {
		return getNodeElement(pos).getChildren().hasNext();
	}

	@Override
	public boolean isRoot(Position<T> pos) {
		return pos == root;
	}

	// add child
	public Position<T> addChild(Position<T> parent, T element) {
		size++;
		return getNodeElement(parent).addChild(
				new MusicTreeDemo<T>(element, getNodeElement(parent),
						this));
	}


	private void isValidTree(Position<T> pos) {
		if (!(pos instanceof MusicTreeDemo)) {
			throw new IllegalArgumentException("Invalid tree.");
		}
	}

	
	private MusicTreeDemo<T> getNodeElement(Position<T> pos) {
		isValidTree(pos);
		return (MusicTreeDemo<T>) pos;
	}

	
	@Override
	public Iterator<Position<T>> iterator() {
		return new PostOrderIterator();
	}


	private class PostOrderIterator implements Iterator<Position<T>> {
		MusicTreeDemo<T> cursor = root;
		Queue<MusicTreeDemo<T>> OutputQueue;

		public PostOrderIterator() {
			OutputQueue = new LinkedList<MusicTreeDemo<T>>();
			this.buildPostOrderTraversal(cursor);
		}

		private void buildPostOrderTraversal(MusicTreeDemo<T> cur) {
			Iterator<MusicTreeDemo<T>> it = cur.getChildren();
			while (it.hasNext()) {
				this.buildPostOrderTraversal(it.next());
			}
			OutputQueue.add(cur);
		}

		@Override
		public boolean hasNext() {
			return !OutputQueue.isEmpty();
		}

		@Override
		public Position<T> next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			return OutputQueue.poll();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException(
					"Cannot remove from tree iterator.");
		}
	}

}