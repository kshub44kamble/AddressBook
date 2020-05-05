pakage com.bridgelabz.codinclub.Main;
import com.bridgelabz.codinclub.Controller.AddressBookController;
import java.util.Scanner;
/**
  *class Address Book Main
  *main method
  *@author: shubhamkamble
*/
public class AddressBookMain {
	/**
	  *@param args args
	*/
	public static void main(String[] agrs) {
		AddressBookController addressBookController = new AddressBookController();
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("1.create newAddressBook \n2 :addPerson \n3 :sortByName \n4 :sortByZip \n5 :Delete \n6 :Edit \n7 :showDetails");
			choice = scanner.nextInt();
			switch(choice) {
			case 1:
					addressBookController.createNewAddressBook();
					break;
			case 2:
					addressBookController.addPerson();
					break;
			case 3:
					addressBookController.sortByName();
					break;
			case 4:
					addressBookController.sortByZip();
					break;
			case 5:
					addressBookController.delete();
					break;
			case 6:
					addressBookController.Edit();
					break;
			case 7:
					addressBookController.display();
					break;
			default:
			}
		} while (choice != 8);
	}
}
