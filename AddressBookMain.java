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
                        case 6 : entry.pinCode = Integer.parseInt(editValues[allocator]);
                                allocator ++;
                                break;
                    }
                }
                System.out.println(entry.firstName+" "+entry.lastName+" "+entry.phoneNumber+" "+entry.emailId+" "+entry.address+" "+entry.state+" "+entry.city+" "+entry.pinCode);
                return true;
            }
        }
        return false;
    }
}
public class AddressBookMain{

    public static void main(String[] args) {
        System.out.println("Welcome User\nEnter number corresponding to operation you want to perform");
        System.out.println("1.Add Details\n2.Edit Details\n3.Delete Records\n4.View My Record");
        Scanner sc =new Scanner(System.in);
        int choice=sc.nextInt();
        switch(choice){
            case 1 :
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
                AddressBook person = new AddressBook(fName,lName,phoneNum,emailId,address,state,city,pinCode);
                if(person.createEntry()){
                    System.out.println("Your record has been created");
                }else{
                    System.out.println("Record creation failed");
                }
            case 2:
                System.out.println("Editing Record");
                System.out.println("Enter your name");
                sc.nextLine();
                String recordHolder = sc.nextLine();
                System.out.println("Enter the serial numbers of fields you want to edit\n1.Phone Number\n2.Email Id\n3.Address\n4.State\5.City\6.Pin Code");
                String fields = sc.nextLine();
                String[] editFieldsIndex = fields.split("\\s");
                StringBuffer fieldValues = new StringBuffer();
                String updatedAddress = "";
                int[] index = new int[editFieldsIndex.length];
                for(int i=0;i<editFieldsIndex.length;i++){
                    int position = Integer.parseInt(editFieldsIndex[i]);
                    index[i] = position;
                    switch (position){
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
                boolean updateStatus = AddressBook.editRecord(recordHolder,index,editFieldValues,updatedAddress);
                if(updateStatus){
                    System.out.println("Record has been updated");
                }else{
                    System.out.println("Record not found / Invalid details entered");
                }
        }
    }
}

