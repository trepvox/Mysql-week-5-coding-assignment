package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.IceCreamDao;
import entities.IceCream;

public class Menu {

	private IceCreamDao iceCreamDao = new IceCreamDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList("Display Flavors", "Display a single Flavor", "Create a new Flavor", "Delete a Flavor", "Update a Flavor");
	
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
	
			try {
				if (selection.equals("1")) {
					displayFlavors();
				} else if (selection.equals("2")) {
					displayFlavor();
				}  else if (selection.equals("3")) {
					createFlavor();
				}  else if (selection.equals("4")) {
					deleteFlavor(); 
				}  else if (selection.equals("5")) {
					updateFlavor();
				}  
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Press enter to continue...");
			scanner.nextLine();
		} while (!selection.equals("-1"));
		System.out.println("Enjoy your ice cream ♥");
	}
	
	
		private void printMenu() {
			System.out.println("Select an Option:\n--------------------------");
			for (int i = 0; i < options.size(); i++) {
				System.out.println(" " + (i + 1) + ") " + options.get(i));
			}
			System.out.println("-1) Abort Ice Cream Mission");
		}
		
		private void displayFlavors() throws SQLException {
			List<IceCream> flavors = iceCreamDao.getIceCreams();
			for (IceCream flavor : flavors) {
				System.out.println(flavor.getId() + ": " + flavor.getFlavor());
			}
		}
		
		private void displayFlavor() throws SQLException {
			System.out.print("Enter flavor number: ");
			int id = Integer.parseInt(scanner.nextLine());
			IceCream flavor = iceCreamDao.getIceCreamById(id);
			System.out.println(flavor.getFlavor());
			}
		
		private void createFlavor() throws SQLException {
			System.out.print("Enter new flavor: ");
			String newIceCream = scanner.nextLine();
												//add lactose and nut free
			iceCreamDao.createNewIceCream(newIceCream);
			System.out.println("New Ice Cream added, enjoy ♥");
	}
		
		private void deleteFlavor() throws SQLException {
			System.out.println("Enter Ice Cream number to remove: ");
			int id = Integer.parseInt(scanner.nextLine());
			iceCreamDao.deleteIceCreamById(id);
			System.out.println("Poof: successfully removed");
			
		}
		
		private void updateFlavor() throws SQLException {
			System.out.println("Enter Ice Cream number to update: ");
			int id = Integer.parseInt(scanner.nextLine());
			IceCream flavor = iceCreamDao.getIceCreamById(id);
			System.out.println("Enter what number this Ice Cream is changing to: ");
			sqlString = "UPDATE_FLAVOR_SET WHERE id = ?"
			//iceCreamDao.updateIceCreamById(id);
			System.out.println("Ice Cream has been updated, and now 10% creamier");
			
			
		}
}