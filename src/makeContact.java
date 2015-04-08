import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// uses csv files from http://introcs.cs.princeton.edu/java/data/
public class makeContact {
	private static String [][] contact, postal;
	private static File nameFile, phoneFile, surnameFile, streetFile, contactFile, phoneNumFile;
	private static Scanner nf, pf, sf, stf, pnf;
	private static String [] first, last, street, temp, phone, pnumbers;
	
	public static void contactToFile() throws FileNotFoundException{
		PrintWriter out = new PrintWriter("data/contact.txt");
		String [][] contact = readFiles();
		for(int i = 0; i < contact.length; i ++){
			out.write("\n" + contact[i][0] + " " + contact[i][1] + ", " + contact[i][2]+ ", " + contact[i][3] + ", " + contact[i][4] +  ", " + contact[i][5]);
		}
		out.close();
	}

	private static String[][] readFiles() throws FileNotFoundException{
		nameFile = new File("data/names.csv");	
		phoneFile = new File("data/phone-na.csv");	
		surnameFile = new File("data/surnames.csv");	
		streetFile = new File("data/street.txt");	
		contactFile = new File("data/contact.txt");
		phoneNumFile = new File("data/phonenumbers.txt");			
	
		// scanner to read in files
		nf = new Scanner(nameFile);
		pf = new Scanner(phoneFile);
		sf = new Scanner(surnameFile);
		stf = new Scanner(streetFile);
		pnf = new Scanner(phoneNumFile);
		
		// arrays to read in files
		first = new String [260];
		last = new String [88799];
		street = new String[400];
		postal = new String [1084][2];
		temp = new String [3];
		phone = new String [1084];
		contact = new String[259][6];
		pnumbers =  new String[60];
		
		
		int count = 0;
		
		// place the first names into an array
		while(count < 260){
			String line = nf.nextLine();
			first[count] = line;
			count ++;			
		}
		
		// place the last names into an array
		count = 0;
		while(sf.hasNextLine()){
			String line = sf.nextLine();
			last[count] = line;
			count ++;			
		}
		
		// place the street into an array
		count = 0;
		while(stf.hasNextLine()){
			String line = stf.nextLine();
			street[count] = line;
			count ++;			
		}
		
		// place the postal info into an array
		count = 0;
		while(pf.hasNextLine()){
			String line = pf.nextLine();
			temp = line.split(",");
			phone [count] =temp[0];
			postal[count][0] = temp[1];
			postal[count][1] = temp[2];
			count ++;			
		}
		
		// place numbers into an array
		count = 0;
		while(pnf.hasNextLine()){
			String line = pnf.nextLine();
			pnumbers[count] = line;
			count ++;			
		}
		String l;
		for (int i = 0; i < contact.length; i ++){
			l =  last[(int) Math.round(Math.random() * (last.length-1))];;
			contact[i][0] = first[i];	// generates first name
			contact[i][1] =l.charAt(0) + l.substring(1, l.length()-1).toLowerCase();// generates last name
			contact[i][2] = "(" + phone[(int) Math.round(Math.random() * 1083)] + ")" + pnumbers[(int) Math.round(Math.random() * 59)];// generates phone number
			contact[i][3] = (int) Math.round(Math.random() * 9999) + " " + street[(int) Math.round(Math.random() * 399)];// generates street address
			int x = (int) Math.round(Math.random() * 1083);
			contact[i][4] = postal[x][0];	// generates city
			contact[i][5] = postal[x][1];	// generates state
		}
		return contact;
	}
	
	public static String [][] returnContact(){
		return contact;
	}
	private static void main(String[] args) throws FileNotFoundException {
		contactToFile();

	}

}
