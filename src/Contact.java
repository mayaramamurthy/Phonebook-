import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Contact implements Comparable<Contact> {
	private String first; // declares the string
	private String last;
	private double phonenumber; // declares the integer
	private String address;
	private String city;
	private String state;
	
	public Contact (){}

	public Contact(String first, String last, double phonenumber,String address, String city, String state) {
		this.first = first; // constructs a new word with a new word and score
		this.last = last;
		this.phonenumber = phonenumber;
		this.address = address;
		this.city = city;
		this.state = state;
	}

	public String getfirst() {
		return this.first; // return the score of the word
	}

	public String getlast() {
		return this.last; // return the score of the word
	}

	public double getphone() {
		return this.phonenumber; // return the score of the word
	}

	public String getaddress() {
		return this.address; // return the score of the word
	}

	public String getcity() {
		return this.city; // return the score of the word
	}

	public String getstate() {
		return this.state; // return the score of the word
	}

	public void setfirst(String first) {
		this.first = first; // sets the score of the word to the passed
							// parameter
	}

	public void setlast(String last) {
		this.last = last; // sets the score of the word to the passed parameter
	}

	public void setphone(double phonenumber) {
		this.phonenumber = phonenumber; // sets the score of the word to the
										// passed parameter
	}

	public void setaddress(String address) {
		this.address = address; // sets the score of the word to the passed
								// parameter
	}

	public void setcity(String city) {
		this.city = city; // sets the score of the word to the passed parameter
	}

	public void setstate(String state) {
		this.state = state; // sets the score of the word to the passed
							// parameter
	}

	//@Override
	public int compareTo(Contact w) {
		int result = this.getfirst().compareToIgnoreCase(w.getfirst()); // if  the score  id bigger then returns 1
		// if the score id smaller then it returns -1
		return result; // else it returns zero if equal
	}

	public String toString() {
		return "{" + this.first + "," + this.last + "," + this.phonenumber
				+ "," + this.address + "," + this.city + "," + this.state + "}";
	}

	public static class Modifications<Key extends Comparable<Key>, Value> { // the binarysearchtree class
		private Node root,r; // the root is the first node
		public ArrayList find = new ArrayList ();
		private class Node {
			private Key key; // declares the key
			private Value val;// declares the value
			private Node left, right;// declares the left and right nodes
			private int N;// declares the size

			public Node(Key key, Value val, int N) {
				this.key = key;
				this.val = val;
				this.N = N;
			}
		} // constructor for the new Node

		public int size(Node x) { // checks the size of the tree
			if (x == null)
				return 0;// return 0 if there are no nodes
			else
				return x.N;
		} // counts the nodes

		public int size() {
			return size(root);
		} // returns the size of the tree

		public boolean contains(Key key) {
			return get(key) != null;
		}

		public Value get(Key key) {
			return get(root, key);
		} // returns the value associated with a specific key

		private Value get(Node x, Key key) { // takes a node and key to get the
												// value associated
			if (x == null)
				return null; // returns null if nothing found
			int compare = key.compareTo(x.key); // it compares if it is greater
												// or less
			if (compare < 0)
				return get(x.left, key); // if it is less it goes to the left
											// side of the tree
			else if (compare > 0)
				return get(x.right, key);// if it is greater it goes to the
											// right side of the tree
			else
				return x.val;
		}// returns the value when found

		public void delete(Key key) {
			root = delete(root, key);
		}

		private Node delete(Node x, Key key) {
			if (x == null)
				return null;
			int compare = key.compareTo(x.key);
			if (compare < 0)
				x.left = delete(x.left, key);
			else if (compare > 0)
				x.right = delete(x.right, key);
			else {
				if (x.right == null)
					return x.left;
				if (x.left == null)
					return x.right;
				Node t = x;
				x = min(t.right);
				x.right = deleteMin(t.right);
				x.left = t.left;
			}
			x.N = size(x.left) + size(x.right) + 1;
			return x;
		}

		public Key min() {
			if (isEmpty())
				return null;
			return min(root).key;
		}

		public boolean isEmpty() {
			return size() == 0;
		}

		private Node min(Node x) {
			if (x.left == null)
				return x;
			else
				return min(x.left);
		}

		private Node deleteMin(Node x) {
			if (x.left == null)
				return x.right;
			x.left = deleteMin(x.left);
			x.N = size(x.left) + size(x.right) + 1;
			return x;
		}

		public Node put(Key key, Value val) {// puts a value at a specific key
			root = sort(root, key, val);
			return root;
		}

		public Node sort(Node x, Key key, Value val) { //
			if (x == null){
				return new Node(key, val, 1);// if it is the first node it creates a new node as a root
			}
			int compare = key.compareTo(x.key);// compares the keys
			if (compare < 0)
				if (x.left == null){x.left = new Node (key, val, x.N);}
				else{x.left = sort(x.left, key, val);}// goes to the left if less
			else if (compare > 0)
				if (x.right == null){x.right = new Node (key, val, x.N);}
				else{x.right = sort(x.right, key, val);}// goes to the right if
													// greater
			else
				x.val = val;
			x.N = size(x.left) + size(x.right) + 1; // the size of the tree is
													// the size of the two sides
													// plus the node itself
			return x;
		} // returns the node

		public String display(Key key) {
			Value info = get(key);
			String contact = "The contact information is " + key + "," + info;
			return contact;
		}

		public void Modify(Key key, Value value) {
			delete(key);
			put(key, value);
		}
		
		public ArrayList findAll (Key y){
			find.clear();
			return searchAll(root, y);
			
		}
		
		public ArrayList searchAll (Node x, Key key){
			if (((String) x.key).contains((CharSequence) key)){
				find.add(x.key + " " + get(x.key));
			}
			if (x.left != null){searchAll(x.left, key);}
			if (x.right != null){searchAll(x.right, key);}
			return find;
			
		}
	}

	public static void main(String[] args) throws IOException {
		makeContact.contactToFile();
		Contact toadd = new Contact("diana", "saw", 25552525, "fdsf", "fdsfs",
				"dfsdf");
		Modifications<String, String> phonebook = new Modifications<String, String>();
		File nameFile = new File("data/contact.txt");
		Scanner hf = new Scanner(nameFile);
		String toaddd = hf.nextLine();
		String search = "Jane", l = "Aaron";
		String todelete = "Abe";
		String todisplay = "Abe";
		for (int i = 0; i < nameFile.length(); i++) {
			while (hf.hasNext()) {
				String toadds = hf.nextLine();
				String[] n = toadds.split(",");
				String first = n[0].split(" ")[0];
				String last = n[0].split(" ")[1];
				String insert = last.concat("," + n[1]).concat("," + n[2]).concat("," + n[3]).concat("," + n[4]);
				// String to=new
				// Contact(n[0],n[1],Double.parseDouble(n[2]),n[3],n[4],n[5]);
				phonebook.put(first, insert);
				l = first;
			}
		}
		System.out.println(l.toString() + " " + phonebook.get(l));
		System.out.println(search.concat("," + phonebook.get(search)));
		System.out.println(phonebook.get("Jane"));
		System.out.println(phonebook.get(todelete));
		phonebook.delete(todelete);
		System.out.println(phonebook.get(todelete));
		phonebook.display(todisplay);
		ArrayList find = phonebook.findAll("Z");
		for (int i = 0; i < find.size();i ++){
			System.out.println(find.get(i));
		}
	}
}