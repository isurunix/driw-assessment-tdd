package dev.isurubuddhika.driw.controller;

import dev.isurubuddhika.driw.dto.ItemPrice;
import dev.isurubuddhika.driw.exception.ItemNotFountException;
import dev.isurubuddhika.driw.service.PriceCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ItemController {

    private PriceCalculatorService priceCalculatorService;

    @Autowired
    public ItemController(PriceCalculatorService priceCalculatorService){
        this.priceCalculatorService = priceCalculatorService;
    }

    @GetMapping(value = "item/{itemId}/price", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ItemPrice> getPrice(@PathVariable int itemId, @RequestParam("qty") int qty) throws ItemNotFountException {
        ItemPrice itemPrice = priceCalculatorService.calculatePrice(itemId, qty);
        return ResponseEntity.ok(itemPrice);
    }

    @GetMapping(value = "item/{itemId}/price-list", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<ItemPrice>> getPriceList(@PathVariable int itemId) {
        return ResponseEntity.ok(priceCalculatorService.getPriceList(itemId));
    }
}
