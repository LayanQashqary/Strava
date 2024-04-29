package javadb;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author randah and bushra
 */
import java.io.Serializable;
import java.util.List;
import org.hibernate.*;
  
public class JavaDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student st1 = new Student();
        st1.setId(1);
        st1.setFirstName("Khaled");
        st1.setLastName("Abdullah");

        Student st2 = new Student();
        st2.setId(2);
        st2.setFirstName("Rami");
        st2.setLastName("Ahmad");

        Student st3 = new Student();
        st3.setId(3);
        st3.setFirstName("Sami");
        st3.setLastName("Imran");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        int sId = (Integer) session.save(st1);
        tx.commit();
        session.close();
        System.out.println("inserted Student: "+st1.getFirstName());
        
        //insert new student
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
       
        int sId2 = (Integer) session.save(st2);
        tx.commit();
        session.close();
        System.out.println("inserted Student: "+st2.getFirstName());
        
        //insert new student
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        int sId3 = (Integer) session.save(st3);
        tx.commit();
        session.close();
        System.out.println("inserted Student: "+st3.getFirstName());
        
        
        //retrive student list
        session = HibernateUtil.getSessionFactory().openSession();
        List<Student> sList = null;
        String queryStr = "from Student";
        Query query = session.createQuery(queryStr);
        sList = query.list();
        session.close();
        System.out.println("student list size: "+sList.size());
        for(Student s: sList)
        {
            System.out.println(s.getFirstName()+" "+s.getLastName());
        }
       
        //get student by ID and update thier name   
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        Student Supdate = null;
        int sid=1;
        Supdate = (Student)session.get(Student.class, sid);
        Supdate.setFirstName("Mohammad");
        session.update(Supdate);
        
        tx.commit();
        session.close();
        System.out.println("Student "+ sid +" was updated by: "+Supdate.getFirstName());
       
        //Another way to update student first name using HQL
        
        /*String hqlUpdate = "update from Student s set s.firstName =‘Mohammad' where s.id=1";
        Query queryUpdate = session.createQuery(hqlUpdate);
        int resultU = queryUpdate.executeUpdate();
        System.out.println("Rows affected: " + resultU);*/
        
        
 
        //Delete student
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx3 = null;
            tx3 = session.beginTransaction();
            session.delete(st3);
            tx3.commit();
            System.out.println("deleted Student: "+st3.getFirstName());
        session.close();
        
        //Another way to delete student using HQL
        
        /*session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx2 = null;
        tx2 = session.beginTransaction();
        String hqlDel = "delete from Student s where s.id=1";
        Query queryDel = session.createQuery(hqlDel);
        int resultD = queryDel.executeUpdate();
        System.out.println("Rows affected: " + resultD);
        tx2.commit();
        session.close();*/
        
        
        
    }
    
}

 
  
 
