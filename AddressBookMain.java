package OOPS;

import java.util.Scanner;

class Contact{
    String firstName;
    String lastName;
    long phoneNumber;
    String emailId;

    Contact(String firstName,String lastName,long phoneNumber,String emailId){
        this.firstName=firstName.toUpperCase();
        this.lastName=lastName.toUpperCase();
        this.phoneNumber=phoneNumber;
        this.emailId=emailId;
    }
}

class AddressBook extends Contact{
    private static AddressBook[] entries = new AddressBook[10];
    private static int noOfEntries = 0;
    String address;
    String state;
    String city;
    int pinCode;

    AddressBook(String firstName,String lastName,long phoneNumber,String emailId,String address,String state,String city,int pinCode){
        super(firstName,lastName,phoneNumber,emailId);
        this.address=address;
        this.state=state;
        this.city=city;
        this.pinCode=pinCode;
    }

    public boolean createEntry(){
        try {
            entries[noOfEntries]=this;
            noOfEntries ++;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Records are full for now");
            return false;
        }
        return true;
    }

    public static boolean editRecord(String recordHolder,int[] index,String editFieldValues,String updatedAddress){
        String[] fullName = recordHolder.split("\\s");
        String firstName = fullName[0].toUpperCase();
        String lastName = fullName[1].toUpperCase();
        int allocator = 0;
        for(int i =0;i<noOfEntries;i++){
            AddressBook entry = entries[i];
            if(entry.firstName.equals(firstName) && entry.lastName.equals(lastName)){
                String[] editValues = editFieldValues.split("\\s");
                for(int j=0;j<index.length;j++){
                    switch (index[j]){
                        case 1 : entry.phoneNumber = Long.parseLong(editValues[allocator]);
                                allocator ++;
                                break;
                        case 2 : entry.emailId = editValues[allocator];
                                allocator ++;
                                break;
                        case 3 : entry.address = updatedAddress;
                                break;
                        case 4 : entry.state = (editValues[allocator]);
                                allocator ++;
                                break;
                        case 5 : entry.city = editValues[allocator];
                                allocator ++;
                                break;
                        case 6 : entry.pinCode = Integer.parseInt(editValues[allocator]);
                                allocator ++;
                                break;
                    }
                }
                viewMyRecord(firstName+" "+lastName);
                return true;
            }
        }
        return false;
    }

    public static void deleteRecord(String deletedName){
        String[] deletedFullName = deletedName.split("\\s");
        String firstName = deletedFullName[0].toUpperCase();
        String lastName = deletedFullName[1].toUpperCase();
        for(int i=0;i<noOfEntries;i++){
            AddressBook entry = entries[i];
            if(entry.firstName.equals(firstName) && entry.lastName.equals(lastName)){
                for(int j=i;j<noOfEntries;j++){
                    entries[j]=entries[j+1];
                }
                entries[noOfEntries-1]=null;
                noOfEntries --;
            }
        }
    }
    public static void viewMyRecord(String enteredName){
        for(int i=0; i<noOfEntries; i++){
            AddressBook entry = entries[i];
            String[] separatedName = enteredName.split("\\s");
            if(entry.firstName.equals(separatedName[0]) && entry.lastName.equals(separatedName[1])){
                System.out.println("Name is : "+entry.firstName+" "+entry.lastName);
                System.out.println("Phone Number is : "+entry.phoneNumber);
                System.out.println("Email Id is : "+entry.emailId);
                System.out.println("Address is : "+entry.address);
                System.out.println("State is : "+entry.state);
                System.out.println("City is : "+entry.city);
                System.out.println("PinCode is : "+entry.pinCode);
                break;
            }
        }
    }
    public static void viewRecords(){
        int entryNum = 1;
        for(int i =0 ; i<noOfEntries ;i++){
            AddressBook ref = entries[i];
            System.out.println("Entry "+entryNum);
            System.out.println("Name is : "+ref.firstName+" "+ref.lastName);
            System.out.println("Phone Number is : "+ref.phoneNumber);
            System.out.println("Email Id is : "+ref.emailId);
            System.out.println("Address is : "+ref.address);
            System.out.println("State is : "+ref.state);
            System.out.println("City is : "+ref.city);
            System.out.println("PinCode is : "+ref.pinCode);
            entryNum ++;
        }
    }
}
public class AddressBookMain{

    public static void main(String[] args) {
        System.out.println("Welcome User\n");
        while(true) {
            System.out.println("Enter number corresponding to operation you want to perform");
            System.out.println("1.Add Details\n2.Edit Details\n3.Delete Records\n4.View My Record\n5.Exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter details asked below in correct order");
                    System.out.println("Enter first name");
                    String fName = sc.next();
                    System.out.println("Enter last name");
                    String lName = sc.next();
                    System.out.println("Enter phone number");
                    long phoneNum = sc.nextLong();
                    System.out.println("Enter email id");
                    String emailId = sc.next();
                    System.out.println("Enter address");
                    sc.nextLine();
                    String address = sc.nextLine();
                    System.out.println("Enter your state");
                    String state = sc.next();
                    System.out.println("Enter your city");
                    String city = sc.next();
                    System.out.println("Enter your pin code");
                    int pinCode = sc.nextInt();
                    AddressBook person = new AddressBook(fName, lName, phoneNum, emailId, address, state, city, pinCode);
                    if (person.createEntry()) {
                        System.out.println("Your record has been created");
                    } else {
                        System.out.println("Record creation failed");
                    }
                    break;
                case 2:
                    System.out.println("Editing Record");
                    System.out.println("Enter your name");
                    sc.nextLine();
                    String recordHolder = sc.nextLine();
                    System.out.println("Enter the serial numbers of fields you want to edit\n1.Phone Number\n2.Email Id\n3.Address\n4.State\n5.City\n6.Pin Code");
                    String fields = sc.nextLine();
                    String[] editFieldsIndex = fields.split("\\s");
                    StringBuffer fieldValues = new StringBuffer();
                    String updatedAddress = "";
                    int[] index = new int[editFieldsIndex.length];
                    for (int i = 0; i < editFieldsIndex.length; i++) {
                        int position = Integer.parseInt(editFieldsIndex[i]);
                        index[i] = position;
                        switch (position) {
                            case 1:
                                System.out.println("enter new phone number");
                                fieldValues.append(sc.next()).append(" ");
                                break;
                            case 2:
                                System.out.println("enter new email id");
                                fieldValues.append(sc.next()).append(" ");
                                break;
                            case 3:
                                System.out.println("enter new address");
                                sc.nextLine();
                                updatedAddress = sc.nextLine();
                                break;
                            case 4:
                                System.out.println("enter new state");
                                fieldValues.append(sc.next()).append(" ");
                                break;
                            case 5:
                                System.out.println("enter new city");
                                fieldValues.append(sc.next()).append(" ");
                                break;
                            case 6:
                                System.out.println("enter new pin code");
                                fieldValues.append(sc.next()).append(" ");
                                break;
                        }
                    }
                    String editFieldValues = fieldValues.toString().strip();
                    boolean updateStatus = AddressBook.editRecord(recordHolder, index, editFieldValues, updatedAddress);
                    if (updateStatus) {
                        System.out.println("Record has been updated");
                    } else {
                        System.out.println("Record not found / Invalid details entered");
                    }
                    break;
                case 3:
                    System.out.println("record deletion");
                    System.out.println("Enter your name");
                    sc.nextLine();
                    String deletedName = sc.nextLine();
                    AddressBook.deleteRecord(deletedName);
                    break;
                case 4:
                    System.out.println("Enter your full name");
                    sc.nextLine();
                    String enteredName = sc.nextLine();
                    AddressBook.viewMyRecord(enteredName);
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}

