package dev.isurubuddhika.driw.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemDTO {
    private long id;
    private String name;
    private double cartonPrice;
    private int unitsPerCarton;
}
