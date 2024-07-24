package lk.ijse.dep12.jpa.relationship.entity;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderItem")
@IdClass(OrderItemPK.class)
public class OrderItem implements Serializable {
    private BigDecimal price;
    private int discount;
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "item_code", referencedColumnName = "code")
    private Item item;
}
