import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

class Pet {

	private String name, type, breed, color, sex, ownersName;
	private int age, recordID;

	private static List<Pet> listOfPetRecords = new ArrayList<Pet>();

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getBreed() {
		return breed;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}

	public void setOwnersName(String ownersName) {
		this.ownersName = ownersName;
	}

	public String getOwnersName() {
		return ownersName;
	}

	private void setRecordID(int recordID) {
		this.recordID = recordID;
	}

	public int getRecordID() {
		return recordID;
	}

	public static List<Pet> getListOfPetRecords() {
		return listOfPetRecords;
	}

	public Pet(String name, String type, int recordId) {
		this.setName(name);
		this.setType(type);
		this.setRecordID(recordId);
	}

	public Pet(String name, String type, String breed, int recordId) {
		this.setName(name);
		this.setType(type);
		this.setBreed(breed);
		this.setRecordID(recordId);
	}

	public Pet(String name, String type, String breed, String color, int recordId) {
		this.setName(name);
		this.setType(type);
		this.setBreed(breed);
		this.setColor(color);
		this.setRecordID(recordId);
	}

	public Pet(String name, String type, String breed, String color, int age, int recordId) {
		this.setName(name);
		this.setType(type);
		this.setBreed(breed);
		this.setColor(color);
		this.setAge(age);
		this.setRecordID(recordId);
	}

	public Pet(String name, String type, String breed, String color, int age, String sex, int recordId) {
		this.setName(name);
		this.setType(type);
		this.setBreed(breed);
		this.setColor(color);
		this.setAge(age);
		this.setSex(sex);
		this.setRecordID(recordId);
	}

	public Pet(String name, String type, String breed, String color, int age, String sex, String ownersName, int recordId) {
		this.setName(name);
		this.setType(type);
		this.setBreed(breed);
		this.setColor(color);
		this.setAge(age);
		this.setSex(sex);
		this.setOwnersName(ownersName);
		this.setRecordID(recordId);
	}

	public static boolean IsUniqueId(int recordID) {
		for (Pet petRecord : listOfPetRecords) {
			if (petRecord.getRecordID() == recordID)
				return false;
		}

		return true;
	}

	public void ShowDetails(String label) {
		String petBreed = this.getBreed(),
			   petColor = this.getColor(),
			   petAge = this.getAge() + " ",
			   petSex = this.getSex(),
			   petOwnerName = this.getOwnersName();

		if (petBreed == null)
			petBreed = "N/A";

		if (petColor == null)
			petColor = "N/A";

		if (this.getAge() != 0) {
			if (this.getAge() == 1)
				petAge += "Month Old";
			else
				petAge += "Months Old";
		} else
			petAge = "N/A";

		if (petSex == null)
			petSex = "N/A";

		if (petOwnerName == null)
			petOwnerName = "N/A";

		if (label.contentEquals("VIEW ALL RECORDS")) {
			out.printf("%s%n%-15d%-15s%-8s%-20s%-20s%-18s%-10s%s%n",
				"-".repeat(140), this.getRecordID(), this.getName(), this.getType(), petBreed, petColor, petAge, petSex, petOwnerName);
			return;
		}

		if (label.contentEquals("RECORD ID")) {
			label = label + " " + this.getRecordID();
			out.printf("%n%s%n%22s%n%s%n", "=".repeat(30), label, "=".repeat(30));
		} else {
			String space = "21";

			if (label == "UPDATED RECORD")
				space = "22";

			out.printf("%n%s%n%" + space + "s%n%s%n%-10s: %d%n", "=".repeat(30), label, "=".repeat(30), "Record ID", this.getRecordID());
		}
		
		out.printf("%-10s: %s%n%-10s: %s%n%-10s: %s%n%-10s: %s%n%-10s: %s%n%-10s: %s%n%-10s: %s%n",
			"Name", this.getName(), "Type", this.getType(), "Breed", petBreed, "Fur Color", petColor, "Age", petAge, "Gender", petSex, "Owner", petOwnerName);
	}
}
