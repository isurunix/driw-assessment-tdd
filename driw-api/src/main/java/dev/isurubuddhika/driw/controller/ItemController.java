package dev.isurubuddhika.driw.controller;

import dev.isurubuddhika.driw.dto.ItemDTO;
import dev.isurubuddhika.driw.dto.ItemPrice;
import dev.isurubuddhika.driw.exception.ItemNotFountException;
import dev.isurubuddhika.driw.service.ItemService;
import dev.isurubuddhika.driw.service.PriceCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final PriceCalculatorService priceCalculatorService;
    private final ItemService itemService;

    @Autowired
    public ItemController(PriceCalculatorService priceCalculatorService, ItemService itemService){
        this.priceCalculatorService = priceCalculatorService;
        this.itemService = itemService;
    }

    @GetMapping("")
    ResponseEntity<List<ItemDTO>> getAllItems() {
        return ResponseEntity.ok(this.itemService.getAll());
    }

    @GetMapping(value = "/{itemId}/price", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ItemPrice> getPrice(@PathVariable int itemId, @RequestParam("qty") int qty) throws ItemNotFountException {
        ItemPrice itemPrice = priceCalculatorService.calculatePrice(itemId, qty);
        return ResponseEntity.ok(itemPrice);
    }

    @GetMapping(value = "/{itemId}/price-list", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<ItemPrice>> getPriceList(@PathVariable int itemId) {
        return ResponseEntity.ok(priceCalculatorService.getPriceList(itemId));
    }
}
