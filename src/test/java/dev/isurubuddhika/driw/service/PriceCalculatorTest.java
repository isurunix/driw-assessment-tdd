package dev.isurubuddhika.driw.service;

import dev.isurubuddhika.driw.entity.Item;
import dev.isurubuddhika.driw.repository.ItemRepository;
import dev.isurubuddhika.driw.service.impl.PriceCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PriceCalculatorTest {

    @Autowired
    private ItemRepository itemRepository;

    private PriceCalculatorService priceCalculatorService;

    @BeforeEach
    public void before(){
        priceCalculatorService = new PriceCalculator(itemRepository);
    }

    @Test
    @DisplayName("test_price_calculation_for_single_unit")
    public void calculatePriceForSingleUnit() {
        Item penguinEars = new Item(1L,"Penguin-Ears",175d, 20);
        Item horseshoe = new Item(2L,"Horseshoe",825d, 5);
        itemRepository.save(penguinEars);
        itemRepository.save(horseshoe);

        // one item
        assertEquals(175*1.3,priceCalculatorService.calculatePrice(1, 1).getPrice());
        assertEquals(825*1.3,priceCalculatorService.calculatePrice(2, 1).getPrice());

        // multiple single items less than carton size
        assertEquals(3*175*1.3,priceCalculatorService.calculatePrice(1, 3).getPrice());
        assertEquals(2*825*1.3,priceCalculatorService.calculatePrice(2, 2).getPrice());
    }

    @Test
    @DisplayName("test_price_calculation_for_carton")
    public void calculatePriceForCarton() {
        Item penguinEars = new Item(1L,"Penguin-Ears",175d, 20);
        Item horseshoe = new Item(2L,"Horseshoe",825d, 5);
        itemRepository.save(penguinEars);
        itemRepository.save(horseshoe);

        assertEquals(175,priceCalculatorService.calculatePrice(1, 20).getPrice());
        assertEquals(825,priceCalculatorService.calculatePrice(2, 5).getPrice());
    }

    @Test
    @DisplayName("test_price_calculation_for_carton_plus_single_units")
    public void calculatePriceForCartonAndSingleUnits() {
        Item penguinEars = new Item(1L,"Penguin-Ears",175d, 20);
        Item horseshoe = new Item(2L,"Horseshoe",825d, 5);
        itemRepository.save(penguinEars);
        itemRepository.save(horseshoe);

        assertEquals(175 + (5*175*1.3),priceCalculatorService.calculatePrice(1, 25).getPrice());
        assertEquals(825 + (3*825*1.3),priceCalculatorService.calculatePrice(2, 8).getPrice());
    }

    @Test
    @DisplayName("test_get_price_list_for_item")
    public void getPriceList() {
        Item penguinEars = new Item(1L,"Penguin-Ears",175d, 20);
        Item horseshoe = new Item(2L,"Horseshoe",825d, 5);
        itemRepository.save(penguinEars);
        itemRepository.save(horseshoe);

        assertEquals(50, priceCalculatorService.getPriceList(1).size());
    }

    @AfterEach
    public void tearDown() {
        itemRepository.deleteAll();
    }
}
