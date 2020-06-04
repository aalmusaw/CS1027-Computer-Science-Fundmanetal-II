/**
 * 
 * @author Ali Al-Musawi
 * @version 1.0
 * Assignment 3; CS-1027B; Spring 2019
 * This class is responsible for encoding characters and decoding binary codes
 * using the provided Huffman Tree.
 *
 */
import java.util.Iterator;
public class HuffmanCoder {
	private HuffmanTree huffTree;
	private ArrayUnorderedList<EncodingData> encodingList = new ArrayUnorderedList<EncodingData>() ;
	
	/**
	 * Class constructor.
	 * @param pairsList contains the list of Huffman Pairs used to encode/decode.
	 */
	public HuffmanCoder(ArrayOrderedList<HuffmanPair> pairsList) {
		huffTree = new HuffmanTree(pairsList);		// Call the helper method.
		buildEncodingList(huffTree.getRoot(), "");
	}
	
	/**
	 * A method to decode a character per message.
	 * @param code a String containing binary code for a message character.
	 * @return the decoded message character.
	 */
	public char decode(String code) {
		BinaryTreeNode<HuffmanPair> pointer = huffTree.getRoot();
		// for (every character in code)
		for(int i = 0; i < code.length(); i++) {
			// step through the Huffman Tree
			// ensure all the moves in the tree are valid.
			try {
				if (code.charAt(i) == '0') pointer = pointer.getLeft(); // turn left on 0
				else if (code.charAt(i) == '1') pointer = pointer.getRight(); // turn right on 1
			}
			// A move is not valid if the string is not appropriate for the provided tree.
			catch (NullPointerException e) {
				return (char) 0;
			}
	}
		// if a leaf is encountered, return the encoded character.
		if (pointer.isLeaf()) {
			return pointer.getElement().getCharacter();	}
		else return (char) 0;
		}
	
	/**
	 * This method encodes a character into binary code using a helper method.
	 * @param c the character to encode.
	 * @return the binary code
	 * @throws ElementNotFoundException if the provided character is not found in the Huffman Tree.
	 */
	public String encode(char c) throws ElementNotFoundException {
		String code = "";
		// Create an iterator to traverse through the result of the helper method.
		Iterator<EncodingData> iter = encodingList.iterator();
		// Retrieve the code.
		while(iter.hasNext()) {
			EncodingData data = iter.next();
			if (data.getSymbol() == c) code = data.getEncoding();
		}
		// Check to see if the element actually exists.
		if (code=="") throw new ElementNotFoundException("tree.");
		else
			return code;
		
	}

	/**
	 * A helper method that builds the encodingList recursively.
	 * @param node the node to start at.
	 * @param encoding the result of the traversal; i.e. "0" for left, "1" for right.
	 */
	private void buildEncodingList(BinaryTreeNode<HuffmanPair> node, String encoding) {
		
		try {
			if (node.isLeaf()) {
				encodingList.addToFront(new EncodingData(node.getElement().getCharacter(), encoding));
			}
			else {
				buildEncodingList(node.getLeft(), encoding+"0");
				buildEncodingList(node.getRight(), encoding+"1");
			}
		}
		catch(NullPointerException e) {
			System.out.println("An empty file has been provided.");
			System.out.println("Aborting all operations...");
			System.out.println("The output file(s) may not be valid.");
			System.out.println("Program exited successfully.");
			System.exit(0);
			
		}
	}
	

}
