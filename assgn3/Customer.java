import java.io.*;

class Customer implements Serializable {
    int age;
    String name;
    long Aadhar;
    Customer() {
        age = 0;
        name = "none";
        Aadhar = 0;
    }

    Customer(int age,String name,long Aadhar) {
        this.age = age;
        this.name = name;
        this.Aadhar = Aadhar;
    }
}
