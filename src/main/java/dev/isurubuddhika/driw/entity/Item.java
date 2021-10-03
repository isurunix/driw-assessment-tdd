package dev.isurubuddhika.driw.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "item")
@Table(name = "item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Item {

    @Id
    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @Column(name = "item_name", nullable = false)
    private String name;

    @Column(name = "carton_price", nullable = false)
    private Double pricePerCarton;

    @Column(name = "carton_size", nullable = false)
    private Integer itemsPerCarton;
}
