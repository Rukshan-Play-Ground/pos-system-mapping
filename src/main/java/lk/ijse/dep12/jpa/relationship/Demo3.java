package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.entity.*;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Demo3 {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
            EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            try {

                Customer c001 = em.find(Customer.class, "C001");
                Item i001 = new Item("I001", "Milo Packet", 20, new BigDecimal("850.00"));
                User u001 = new User("U001", "123456", "Tharindu");

                Order od001 = new Order("OD001", Date.valueOf(LocalDate.now()),u001,c001);

                OrderItem orderItems = new OrderItem(new BigDecimal("250.00"), 20, od001, i001);

                List.of(i001,u001,orderItems).forEach(em::persist);


                em.getTransaction().commit();
            }catch (Throwable t){
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
