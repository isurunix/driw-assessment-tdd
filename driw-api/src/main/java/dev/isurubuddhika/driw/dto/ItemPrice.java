package dev.isurubuddhika.driw.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemPrice {
    private int itemId;
    private int quantity;
    private double price;
}
