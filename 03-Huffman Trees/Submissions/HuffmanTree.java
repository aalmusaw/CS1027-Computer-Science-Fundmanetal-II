/**
 * 
 * @author Ali Al-Musawi
 * @version 1.0
 * Assignment 3; CS-1027B; Spring 2019
 * This class is responsible for creating Huffman Trees to use for encoding and decoding.
 *
 */
import java.util.Iterator;
public class HuffmanTree extends LinkedBinaryTree<HuffmanPair> implements Comparable<HuffmanTree> {
	
	/**
	 * Class constructor
	 * Creates an empty tree.
	 */
	public HuffmanTree() {
		super();
	}
	
	/**
	 * Class constructor.
	 * creates a Huffman tree with one Huffman pair at the root.
	 * @param element the root element
	 */
	public HuffmanTree(HuffmanPair element) {
		super(element);
	}
	
	/**
	 * Class constructor.
	 * creates a Huffman tree rooted at a node containing element.
	 * @param element to add to the node.
	 * @param leftSubtree whose root is the left child of the Huffman Tree.
	 * @param rightSubtree whose root is the right child of the Huffman Tree.
	 */
	public HuffmanTree(HuffmanPair element, HuffmanTree leftSubtree, HuffmanTree rightSubtree) {
		super(element, leftSubtree, rightSubtree);
		
	}
	
	/**
	 * Class constructor.
	 * This contructor creates a full Huffman tree based on the list provided.
	 * @param pairsList an ordered list containing Huffman pairs sorted by frequency.
	 * 
	 */
	public HuffmanTree(ArrayOrderedList<HuffmanPair> pairsList) {
		Iterator<HuffmanPair> iter = pairsList.iterator();
		// If the provided list has more than one pair, it needs to be constructed according to the 
		// specifications of a Huffman tree code. The root node has the highest frequency Huffman pair.
		if (pairsList.size()>1) {
			//create a temporary ordered list
			ArrayOrderedList<HuffmanTree> buildList = new ArrayOrderedList<HuffmanTree>();
			//Create a tree for each Huffmain pair in the provided list and add it to the temp list.
			while(iter.hasNext()) {
				HuffmanPair pair = iter.next();
				if (pair != null) buildList.add(new HuffmanTree(pair));
			}
			HuffmanTree leftSubtree;
			HuffmanTree rightSubtree;
			// while the temp list has more than a tree, combine the first two into a new tree.
			// the root of this tree is a huffmain pair with root node containing the sum of the frequencies
			// of the first two trees' root nodes containing their respective Huffmain pairs.
			while(buildList.size()>1) {
				leftSubtree = buildList.removeFirst();
				rightSubtree = buildList.removeFirst();
				// the sum of the frequencies of the Huffman pairs
				int frequencySum = leftSubtree.getRoot().getElement().getFrequency()+rightSubtree.getRoot().getElement().getFrequency();
				// create a new tree whose root node is the sum of the two Huffman pairs.
				HuffmanTree mainTree = new HuffmanTree(new HuffmanPair(frequencySum), leftSubtree, rightSubtree);
				buildList.add(mainTree);
				this.setRoot(mainTree.getRoot());
			}
			buildList = null;
		}
		
		else if (pairsList.size()==1) {
			new HuffmanTree(pairsList.removeFirst());
		}
		
		else
		{System.out.println("Warning: The list passed is empty. An empty tree has been created.");
		new HuffmanTree();
		}
		
	}
	
	/**
	 * A method to compare two Huffman trees by the root node's frequency.
	 * @param otherTree the other tree to compare to.
	 * @return int < 0 if this tree should be a subtree or int > 0 if the other tree should be a subtree.
	 */
	public int compareTo(HuffmanTree otherTree) {
		return super.getRoot().getElement().getFrequency() - otherTree.getRoot().getElement().getFrequency();
	}
	
	/**
	 * A method that returns a string representation of a Huffman tree.
	 * @return all the contents of the HuffmanPair nodes in preorder traversal.
	 */
	public String toString() {
		String result = "";
		while (super.iteratorPreOrder().hasNext()) result += super.iteratorPreOrder().next().toString();
		return result;
		
	}
	
	
}
