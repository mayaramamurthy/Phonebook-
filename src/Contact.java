// this code used the Algorithms textbook code for the base of the BST implementation
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Contact implements Comparable<Contact> {
	private String first; // declares the first name
	private String last; //declares the last name
	private double phonenumber; // declares the phone number
	private String address; //declares the address
	private String city;  //declares the city
	private String state; //declares the state
	
	public Contact (){}//creates an empty contact
    //creates the contact with the given information
	public Contact(String first, String last, double phonenumber,String address, String city, String state) {
		this.first = first; // sets the first name to the parameter
		this.last = last; //sets the last name
		this.phonenumber = phonenumber; //sets the phone number
		this.address = address; //sets the address
		this.city = city; //sets the city
		this.state = state; //sets the state
	}

	public String getfirst() {
		return this.first; // return the first name of the contact
	}

	public String getlast() {
		return this.last; // return the last name of the contact
	}

	public double getphone() {
		return this.phonenumber; // return the phone number of the contact
	}

	public String getaddress() {
		return this.address; // return the address of the contact
	}

	public String getcity() {
		return this.city; // return the city of the contact
	}

	public String getstate() {
		return this.state; // return the state of the contact
	}

	public void setfirst(String first) {
		this.first = first; // sets the first name of the contact
						
	}

	public void setlast(String last) {
		this.last = last; // sets the last name of the contact
	}

	public void setphone(double phonenumber) {
		this.phonenumber = phonenumber; // sets the phone number of the contact
										
	}

	public void setaddress(String address) {
		this.address = address; // sets the address of the contact
						
	}

	public void setcity(String city) {
		this.city = city; // sets the city of the contact
	}

	public void setstate(String state) {
		this.state = state; // sets the state of the contact
							
	}

	//@Override
	public int compareTo(Contact w) {
		int result = this.getfirst().compareToIgnoreCase(w.getfirst()); // compares the first name of two contacts
		return result; // returns the result as int (-1,0,1)
	}
 //displays the contact (first name, last name, phone number, address, city and state)
	public String toString() {
		return "{" + this.first + "," + this.last + "," + this.phonenumber
				+ "," + this.address + "," + this.city + "," + this.state + "}";
	}

	public static class Modifications<Key extends Comparable<Key>, Value> { // modifying contacts
		private Node root,r; // the root is the first node
		public String findN; //declares the String
		public ArrayList find = new ArrayList (); //initiates the arraylist
		private class Node {
			private Key key; // declares the key
			private Value val;// declares the value
			private Node left, right;// declares the left and right nodes
			private int N;// declares the size

			public Node(Key key, Value val, int N) {
				this.key = key; //sets the key as given by parameter
				this.val = val; //sets the value as given by parameter
				this.N = N; //sets the N as given by parameter
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

		public boolean contains(Key key) { //checks if the first name is in the phonebook
			return get(key) != null; //returns false if it is not
		}

		public Value get(Key key) { //gets the info of the contact wen you serch by first name
			return get(root, key); //calls the get method
		} // returns the value associated with a specific key

		private Value get(Node x, Key key) { // takes a node and key to get the value associated

			if (x == null){
				System.out.println("Contact " + key + " does not exist");
				return null; // returns null if nothing found
			}
			int compare = key.compareTo(x.key); // it compares if it is greater or less (key-first name)
												
			if (compare < 0)
				return get(x.left, key); // if it is less it goes to the left side of the tree
											
			else if (compare > 0)
				return get(x.right, key);// if it is greater it goes to the right side of the tree
			
			else
				return x.val; //returns the value associated with the key(the info of the first name)
		}

		public void delete(Key key) { //deletes the contact by the first name
			root = delete(root, key);
		}

		private Node delete(Node x, Key key) {
			if (x == null){  //if name not here then null
				System.out.println("Contact does not exist!");
				return null;
			}
			int compare = key.compareTo(x.key); //compares the alphabet of the first name
			if (compare < 0) //if it is less then it searches in the left side of the tree
				x.left = delete(x.left, key); //calls the delete (recursive) 
			else if (compare > 0) //if it is greater it searches in the right side of the tree
				x.right = delete(x.right, key); //calls the delete (recursive)
			else {
				if (x.right == null) //return the left side if the right is null
					return x.left;
				if (x.left == null) //return the right side if the left is null
					return x.right;
				Node t = x; //sets the node t to x
				x = min(t.right); //x is the minimum of the right side
				x.right = deleteMin(t.right); //deletes the minimum from the right side
				x.left = t.left; //the left of x becomes the left side of t
			}
			x.N = size(x.left) + size(x.right) + 1; //recalculates the size of the tree
			return x; //return x
		}

		public Key min() { //finds the minimum
			if (isEmpty()) //returns null if it is empty
				return null;
			return min(root).key; //calls the function
		}

		public boolean isEmpty() { //if the size of the tree is 0 then it is true(empty)
			return size() == 0;
		}

		private Node min(Node x) { //return the minimum node
			if (x.left == null) //if the left is null it returns x
				return x;
			else
				return min(x.left); //else it calls it again on the left side
		}

		private Node deleteMin(Node x) { //deletes the minimum 
			if (x.left == null) //if the left is null then it returns the right
				return x.right;
			x.left = deleteMin(x.left); //the new left side after deleting the minimum
			x.N = size(x.left) + size(x.right) + 1; //recalculates the size of the tree
			return x; //return x
		}

		public Node put(Key key, Value val) {// puts a value at a specific key
			root = sort(root, key, val); //calls the sorting to put the new contact in its right location
			return root;
		}

		public Node sort(Node x, Key key, Value val) { //sorts the nodes of the tree
			if (x == null){
				return new Node(key, val, 1);// if it is the first node it creates a new node as a root
			}
			int compare = key.compareTo(x.key);// compares the keys
			if (compare < 0) 
				if (x.left == null){x.left = new Node (key, val, x.N);} //if it is less then it creates a left node if null or adds it to the left and sorts it
				else{x.left = sort(x.left, key, val);}
			else if (compare > 0)
				if (x.right == null){x.right = new Node (key, val, x.N);} //if it is greater then it creates a right node if null or adds it to the right and sorts it
				else{x.right = sort(x.right, key, val);}
													
			else
				x.val = val; //else it is the value of x
			x.N = size(x.left) + size(x.right) + 1; // recalculates the size of the tree 										
			return x;
		} // returns the node
        
		//displays the information of the contact
		public String display(Key key) {
			Value info = get(key); //gets the info by searching by the first name of the contact
			String contact;
			if (info == null){
				contact = "";				
			}
			else{
				 contact = "The contact information is " + key + "," + info;
			}
			return contact; //displays all the info of the contact
		}
		
		// finds corresponding contact to given number
		public String findNum (String y){
			findN = "";
			String x = findNumber (root, y);
			if (x == ""){
				System.out.print("The contact " + y + " does not exist");
				x = null;
			}
			return x;
		}
		
		// returns the corresponding contact
		public String findNumber (Node x, String y){
			if (x == null){;
				System.out.println(1);
				findN = null;
			}
			if (((String) x.val).contains(y)){			// if found contact
					findN = x.key + " " + get(x.key);	 // sets the value
			}
			if (x.left != null){findNumber(x.left, y);} 	// go left if not null
			if (x.right != null){findNumber(x.right, y);}	// go right if not null
			return findN;
		}
        // the modify method
		public void Modify(Key key, Value value) {
			if (contains(key)){
				delete(key); //deletes the old contact
				put(key, value); //inserts the new info as if it is a new contact and sorts it alphabetically
			}
		}
		
		// returns all keys starting with certain letter
		public ArrayList findAll (Key y){
			find.clear();
			return searchAll(root, y);
			
		}
		
		// recursively calls on node to find all contacts starting with letter
		public ArrayList searchAll (Node x, Key key){
			if (x == null){
				System.out.println("Contact does not exist!");				
			}
			if (((String) x.key).contains((CharSequence) key)){
				find.add(x.key + " " + get(x.key)); // add contact to list
			}
			if (x.left != null){searchAll(x.left, key);}	// if not null go left
			if (x.right != null){searchAll(x.right, key);}	// if not null go right
			return find;
			
		}
	}
    
	// we used this to test the different methods of the class
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
		String a = "";
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
				a = n[1];
			}
		}
		
		// display all contacts by letter
		System.out.println("Show all contacts starting with 'A'");
		phonebook.display(todisplay);
		ArrayList find = phonebook.findAll("A");
		for (int i = 0; i < find.size(); i++) {
			System.out.println(find.get(i));
		}
		System.out.println("");

		// finds a contact by number
		System.out.println("Display Contact By Number");
		System.out.print("Get contact " + a + " :");
		System.out.println(phonebook.findNum(a));
		System.out.print("Get contact " + a + " :");
		phonebook.findNum("(100)100-1000");
		System.out.println("");
		
		
		// finds a contact by name
		System.out.println("Display Contact By Name");
		System.out.print("Get contact:" + search);
		System.out.println(" " + phonebook.get(search));
		System.out.print("Get contact " + a + " :");
		phonebook.get("Zoe");
		System.out.println("");
		
		// add a contact
		System.out.println("Add Contact");
		String first = "Zoe";
		String insert = ("Ceasar").concat("," + "(100)100-1000").concat("," + "111 anywhere street").concat("," + "Hamilton").concat("," + "Ontario");
		phonebook.put(first, insert);
		System.out.println(first + " " + phonebook.get(first));
		System.out.println("");
		
		// modify a contact
		System.out.println("Modify Contact");
		first = "Zoe";
		insert = ("Bane").concat("," + "(100)100-1000").concat("," + "111 anywhere street").concat("," + "Hamilton").concat("," + "Ontario");
		phonebook.Modify(first, insert);
		System.out.println(first + " " + phonebook.get(first));
		System.out.println("");
		// try and modify a contact that does not exist
		first = "Julia";
		phonebook.Modify(first, insert);
		System.out.println("");
		
		
		// delete a contact
		System.out.println("Delete Contact");
		System.out.println(phonebook.display(todelete));
		phonebook.delete(todelete);						// deletes the contact
		phonebook.get(todelete); 						// shows the contact is gone
		phonebook.delete(todelete);						// try and delete already deleted contact
		
	}
}