package javadb;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name="STUDENT")
public class Student  implements java.io.Serializable {

     @Id
     @Column(name="S_id")
     private int id;
     @Column(name="F_Name")
     private String firstName;
     @Column(name="L_Name")
     private String lastName;

    public Student() {
    }


    public Student(String fname, String lname) {
       
       this.firstName = fname;
       this.lastName = lname;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
   



}


