package dev.isurubuddhika.driw.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item {
    private String name;
    private double cartonPrice;
    private int unitsPerCarton;
}
