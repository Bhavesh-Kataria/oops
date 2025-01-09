package OOPS;

class Contact{
    String firstName;
    String lastName;
    long phoneNumber;
    String emailId;
    Contact(String firstName,String lastName,long phoneNumber,String emailId){
        this.firstName=firstName;
        this.lastName=lastName;
        this.phoneNumber=phoneNumber;
        this.emailId=emailId;
    }
}

class AddressBook extends Contact{
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

}
public class AddressBookMain{
    public static void main(String[] args) {
        System.out.println("Welcome new User");
    }
}

