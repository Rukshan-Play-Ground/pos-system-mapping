package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.entity.Contact;
import lk.ijse.dep12.jpa.relationship.entity.Customer;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
            EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            try {

                Contact contact1 = new Contact("011-1234567", null);
                Contact contact2 = new Contact("022-1234567", null);
                Contact contact3 = new Contact("033-1234567", null);
//                Customer c001 = new Customer("C001", "Kasun",
//                        "Galle", List.of(contact1,contact2,contact3));
//                em.persist(c001);
                em.getTransaction().commit();
            }catch (Throwable t){
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
