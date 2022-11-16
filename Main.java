import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import static java.lang.System.out;

class Main {

	private static int choice, recordId;
	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException, InterruptedException {

		Pet newRecord = null;
		boolean newRecordCreated, isExisting, isEdited;

		out.printf("%s%n%26s%n%s%n", "=".repeat(30), "PET RECORD MANAGEMENT", "=".repeat(30));

		while (true) {
			out.println("\n+----------------------------+\n" +
						  "|         MAIN MENU          |\n" +
						  "+----------------------------+\n" +
						  "| [1] Record Pet Info        |\n" +
						  "| [2] Manage Pet Records     |\n" +
						  "| [3] EXIT                   |\n" +
						  "+----------------------------+");

			InputUserChoice("Main");

			switch (choice) {
				
				case 1:
					out.println("\n+---------------------------------------------------------+\n" +
								  "|          OPTIONS FOR RECORDING PET INFORMATION          |\n" +
								  "+---------------------------------------------------------+\n" +
								  "| [1] Name and Type                                       |\n" +
								  "| [2] Name, Type, and Breed                               |\n" +
								  "| [3] Name, Type, Breed and Color                         |\n" +
								  "| [4] Name, Type, Breed, Color and Age                    |\n" +
								  "| [5] Name, Type, Breed, Color, Age and Sex               |\n" +
								  "| [6] Name, Type, Breed, Color, Age, Sex and Owner's name |\n" +
								  "+---------------------------------------------------------+");
	
					InputUserChoice("Record");
	
					do
						recordId = (int) (Math.random() * (9999 - 1000 + 1) + 1000);
					while (!Pet.IsUniqueId(recordId));
	
					out.printf("%n%s%n%26s%n%s%n", "=".repeat(30), "INPUT PET INFORMATION", "=".repeat(30));

					newRecordCreated = false;
	
					switch (choice) {

						case 1:
							newRecord = new Pet(InputPetName("4"), InputPetType("3"), recordId);
							break;

						case 2:
							newRecord = new Pet(InputPetName("4"), InputPetType("3"), InputPetBreed("3"), recordId);
							break;

						case 3:
							newRecord = new Pet(InputPetName("4"), InputPetType("3"), InputPetBreed("3"), InputPetColor("3"), recordId);
							break;

						case 4:
							newRecord = new Pet(InputPetName("6"), InputPetType("5"), InputPetBreed("5"), InputPetColor("5"), InputPetAge("3"), recordId);
							break;

						case 5:
							newRecord = new Pet(InputPetName("6"), InputPetType("5"), InputPetBreed("5"), InputPetColor("5"), InputPetAge("3"), InputPetSex("4"), recordId);
							break;

						case 6:
							newRecord = new Pet(InputPetName("7"), InputPetType("6"), InputPetBreed("6"), InputPetColor("6"), InputPetAge("4"), InputPetSex("5"), InputPetOwnerName("3"), recordId);
					}

					if (choice > 0 && choice < 7) 
						newRecordCreated = true;
	
					if (newRecordCreated) {
						Pet.getListOfPetRecords().add(newRecord);
						out.println("\nPet information has been recorded.");
						newRecord.ShowDetails("PET DETAILS");
					}

					break;
	
				case 2:
					if (Pet.getListOfPetRecords().isEmpty()) {
						out.println("\nNo existing pet records.");
						continue;
					}
	
					out.println("\n+----------------------------+\n" +
								  "|     MANAGE PET RECORDS     |\n" +
								  "+----------------------------+\n" +
								  "| [1] Delete a Pet Record    |\n" +
								  "| [2] Edit a Pet Record      |\n" +
								  "| [3] Search a Pet Record    |\n" +
								  "| [4] View All Pet Records   |\n" +
								  "| [5] Return to Main Menu    |\n" +
								  "+----------------------------+");
	
					InputUserChoice("Manage");
	
					isExisting = false;
	
					switch (choice) {

						case 1:
							InputRecordId(); 
		
							for (Pet petRecord : Pet.getListOfPetRecords()) {
								if (petRecord.getRecordID() == recordId) {
									Pet.getListOfPetRecords().remove(petRecord);
									out.println("\nRecord " + recordId + " successfully deleted.");
									isExisting = true;
									break;
								}
							}

						break;

						case 2:
							InputRecordId();
		
							for (Pet petRecord : Pet.getListOfPetRecords()) {
								if (petRecord.getRecordID() == recordId) {
									out.println("\nSelect info you want to edit.\n\n" +
												"+----------------------------+\n" +
												"|      EDIT A PET INFO       |\n" +
												"+----------------------------+\n" +
												"| [1] Name                   |\n" +
												"| [2] Type                   |\n" +
												"| [3] Breed                  |\n" +
												"| [4] Color                  |\n" +
												"| [5] Age                    |\n" +
												"| [6] Gender                 |\n" +
												"| [7] Owner Name             |\n" +
												"+----------------------------+");
		
									InputUserChoice("Edit");
		
									out.print("\n");
		
									isEdited = false;
		
									switch (choice) {

										case 1:
											petRecord.setName(InputPetName("2"));
											isEdited = true;
											break;
											
										case 2:
											petRecord.setType(InputPetType("2"));
											isEdited = true;
											break;

										case 3:
											if (petRecord.getBreed() == null) {
												out.println("Breed has not been filled in.\nDo you want to fill it up?\n\n[1] Yes\t\t[2] No");
												InputUserChoice("Add Info");
		
												if (choice == 2)
													break;

												out.print("\n");
											}
		
											petRecord.setBreed(InputPetBreed("2"));
											isEdited = true;
											break;

										case 4:
											if (petRecord.getColor() == null) {
												out.println("Fur Color has not been filled in.\nDo you want to fill it up?\n\n[1] Yes\t\t[2] No");
												InputUserChoice("Add Info");
		
												if (choice == 2)
													break;
													
												out.print("\n");
											}
		
											petRecord.setColor(InputPetColor("2"));
											isEdited = true;
											break;

										case 5:
											if (petRecord.getAge() == 0) {
												out.println("Age has not been filled in.\nDo you want to fill it up?\n\n[1] Yes\t\t[2] No");
												InputUserChoice("Add Info");
		
												if (choice == 2)
													break;

												out.print("\n");
											}
		
											petRecord.setAge(InputPetAge("2"));
											isEdited = true;
											break;

										case 6:
											if (petRecord.getSex() == null) {
												out.println("Gender has not been filled in.\nDo you want to fill it up?\n\n[1] Yes\t\t[2] No");
												InputUserChoice("Add Info");
		
												if (choice == 2)
													break;

												out.print("\n");
											}
		
											petRecord.setSex(InputPetSex("2"));
											isEdited = true;
											break;

										case 7:
											if (petRecord.getOwnersName() == null) {
												out.println("Owner's name has not been filled in.\nDo you want to fill it up?\n\n[1] Yes\t\t[2] No");
												InputUserChoice("Add Info");
		
												if (choice == 2)
													break;

												out.print("\n");
											}
		
											petRecord.setOwnersName(InputPetOwnerName("2"));
											isEdited = true;
									}
		
									if (isEdited)
										petRecord.ShowDetails("UPDATED RECORD");
		
									isExisting = true;
									break;
								}
							}

							break;

						case 3:
							InputRecordId();
		
							for (Pet petRecord : Pet.getListOfPetRecords()) {
								if (petRecord.getRecordID() == recordId) {
									petRecord.ShowDetails("RECORD ID");
									isExisting = true;
									break;
								}
							}

							break;

						case 4:
							out.printf("%n%s%n%82s%n%s%n%-15s%-15s%-8s%-20s%-20s%-18s%-10s%s%n", 
								"=".repeat(140), "LIST OF ALL PET RECORDS", "=".repeat(140), "RECORD ID", "NAME", "TYPE", "BREED", "FUR COLOR", "AGE", "GENDER", "OWNER NAME");
		
							for (Pet petRecord : Pet.getListOfPetRecords()) {
								Thread.sleep(1000);
								petRecord.ShowDetails("VIEW ALL RECORDS");
							}
		
							out.println("=".repeat(140));
							break;

						case 5:
							continue;
					}
	
					if (!isExisting && (choice > 0 && choice < 4)) 
						out.println("\nRecord ID " + recordId + " doesn't exist.");

					break;

				case 3:
					out.println("\nSystem exit.\n");
					System.exit(0);
			}
		}
	}

	private static void InputUserChoice(String menuName) throws IOException {
		while (true) {
			out.print("\nEnter your choice: ");

			try {
				choice = Integer.parseInt(input.readLine());
	
				if (menuName.contentEquals("Main") && (choice > 0 && choice < 4) ||
					menuName.contentEquals("Record") && (choice > 0 && choice < 7) ||
					menuName.contentEquals("Manage") && (choice > 0 && choice < 6) ||
					menuName.contentEquals("Edit") && (choice > 0 && choice < 8) || 
					menuName.contentEquals("Add Info") && (choice > 0 && choice < 3)) 
					break;

				out.println("\nInvalid choice.");
			} catch (NumberFormatException e) {
				out.println("\nPlease enter a number only.");
			}
		}
	}

	private static void InputRecordId() throws IOException {
		out.print("\nEnter Pet Record ID: ");

		try {
			recordId = Integer.parseInt(input.readLine());
		} catch (NumberFormatException e) {
			out.println("\nPlease enter a number only.");
			InputRecordId();
		}
	}

	private static String UpperFirstLetterLowerSubString(String info) {
		if (info.split("\\s+").length == 1)
			return info.substring(0, 1).toUpperCase() + info.substring(1).toLowerCase();
		else
			return Arrays.stream(info.trim().split("\\s+")).map(s -> s.toUpperCase().charAt(0) + s.substring(1).toLowerCase()).collect(Collectors.joining(" "));
	}

	private static String InputPetName(String space) throws IOException {
		String name;

		while (true) {
			out.printf("Enter Pet Name%" + space + "s", ": ");
			name = input.readLine();
	
			if (!name.isBlank() && name.matches("[a-zA-Z\s]+")) 
				break;

			out.println("\nPlease enter a valid Pet Name.\n");
		}
		
		return UpperFirstLetterLowerSubString(name);
	}

	private static String InputPetType(String space) throws IOException {
		String type;

		while (true) {
			out.printf("Type Dog or Cat%" + space + "s", ": ");
			type = input.readLine().trim();
	
			if (type.equalsIgnoreCase("Dog") || type.equalsIgnoreCase("Cat")) 
				break;

			out.println("\nPlease enter Dog or Cat only.\n");
		}

		return UpperFirstLetterLowerSubString(type);
	}

	private static String InputPetBreed(String space) throws IOException {
		String breed;

		while (true) {
			out.printf("Enter the Breed%" + space + "s", ": ");
			breed = input.readLine().trim();
	
			if (!breed.isBlank() && breed.matches("[a-zA-Z\s]+")) 
				break;

			out.println("\nPlease enter a valid Pet Breed.\n");
		}

		return UpperFirstLetterLowerSubString(breed);
	}

	private static String InputPetColor(String space) throws IOException {
		String color;

		while (true) {
			out.printf("Enter Fur Color%" + space + "s", ": ");
			color = input.readLine().trim();
	
			if (!color.isBlank() && color.matches("[a-zA-Z\s]+")) 
				break;

			out.println("\nPlease enter a valid Pet Fur Color.\n");
		}

		return UpperFirstLetterLowerSubString(color);
	}

	private static int InputPetAge(String space) throws IOException {
		String petAge;

		while (true) {
			out.printf("Enter Age Month/s%" + space + "s", ": ");
			petAge = input.readLine().replaceAll("[a-zA-Z\s]+", "");
	
			if (petAge.matches("[\\d]+") && Integer.valueOf(petAge) > 0) 
				break;

			out.println("\nPlease enter valid Age.\n");
		}

		return Integer.parseInt(petAge);
	}

	private static String InputPetSex(String space) throws IOException {
		String sex;

		while (true) {
			out.printf("Enter the Gender%" + space + "s", ": ");
			sex = input.readLine().trim();
	
			if (sex.equalsIgnoreCase("Male") || sex.equalsIgnoreCase("Female")) 
				break;

			out.println("\nPlease enter Male or Female only.\n");
		}

		return UpperFirstLetterLowerSubString(sex);
	}

	private static String InputPetOwnerName(String space) throws IOException {
		String ownersName;

		while (true) {
			out.printf("Enter Owner's Name%" + space + "s", ": ");
			ownersName = input.readLine();
	
			if (!ownersName.isBlank() && ownersName.matches("[a-zA-Z\s]+")) 
				break;

			out.println("\nPlease enter a valid Name.\n");
		}

		return UpperFirstLetterLowerSubString(ownersName);
	}
}