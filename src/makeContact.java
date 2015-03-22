import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class makeContact {
	
	public static void contactToFile() throws FileNotFoundException{
		PrintWriter out = new PrintWriter("data/contact.txt");
		String [][] contact = readFiles();
		for(int i = 0; i < contact.length; i ++){
			out.write("\n" + contact[i][0] + " " + contact[i][1] + ", " + contact[i][2]+ ", " + contact[i][3] + ", " + contact[i][4] +  ", " + contact[i][5]);
		}
		out.close();
	}

	public static String[][] readFiles() throws FileNotFoundException{
		File nameFile = new File("data/names.csv");	
		File phoneFile = new File("data/phone-na.csv");	
		File surnameFile = new File("data/surnames.csv");	
		File streetFile = new File("data/street.txt");	
		File contactFile = new File("data/contact.txt");			
	
		Scanner nf = new Scanner(nameFile);
		Scanner pf = new Scanner(phoneFile);
		Scanner sf = new Scanner(surnameFile);
		Scanner stf = new Scanner(streetFile);
		
		String [] first = new String [4535];
		String [] last = new String [88799];
		String [] street = new String[400];
		String [][] postal = new String [1084][2];
		String [] temp = new String [3];
		String [] phone = new String [1084];
		String [][] contact =  new String[20000][6];
		
		
		int count = 0;
		
		// place the first names into an array
		while(nf.hasNextLine()){
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
			phone [count] =temp[0];//(int) Math.round(Math.random() * 999999);	// generates the phone number
			postal[count][0] = temp[1];
			postal[count][1] = temp[2];
			count ++;			
		}
		
		for (int i = 0; i < contact.length; i ++){
			contact[i][0] = first[(int) Math.round(Math.random() * (first.length-1))];	// generates first name
			contact[i][1] = last[(int) Math.round(Math.random() * (last.length-1))];// generates last name
			contact[i][2] = phone[(int) Math.round(Math.random() * 1083)] + (int) Math.round(Math.random() * 9999999);// generates phone number
			contact[i][3] = (int) Math.round(Math.random() * 9999) + " " + street[(int) Math.round(Math.random() * 399)];// generates street address
			int x = (int) Math.round(Math.random() * 1083);
			contact[i][4] = postal[x][0];	// generates city
			contact[i][5] = postal[x][1];	// generates state
		}
		return contact;
	}
	public static void main(String[] args) throws FileNotFoundException {
		contactToFile();

	}

}
