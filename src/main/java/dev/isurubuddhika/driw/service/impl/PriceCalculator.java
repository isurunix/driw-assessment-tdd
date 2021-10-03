package dev.isurubuddhika.driw.service.impl;

import dev.isurubuddhika.driw.dto.ItemDTO;
import dev.isurubuddhika.driw.dto.ItemPrice;
import dev.isurubuddhika.driw.entity.Item;
import dev.isurubuddhika.driw.exception.ItemNotFountException;
import dev.isurubuddhika.driw.repository.ItemRepository;
import dev.isurubuddhika.driw.service.PriceCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceCalculator implements PriceCalculatorService {

    private ItemRepository itemRepository;

    @Autowired
    public PriceCalculator(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemPrice calculatePrice(int itemId, int qty) throws ItemNotFountException {
        Item item = itemRepository.findById((long) itemId)
                .orElseThrow(() -> new ItemNotFountException(itemId));

        double price = 0;
        if (qty < item.getItemsPerCarton()) {
            price = 1.3 * item.getPricePerCarton() * qty;
        } else if (qty == item.getItemsPerCarton()) {
            price = item.getPricePerCarton();
        } else if (qty > item.getItemsPerCarton()) {
            int noOfCartons = qty / item.getItemsPerCarton();
            int noOfSingleUnits = qty % item.getItemsPerCarton();

            if (noOfCartons > 3) {
                price = (noOfCartons * item.getPricePerCarton()) * 0.9;
            } else {
                price = noOfCartons * item.getPricePerCarton();
            }

            if (noOfSingleUnits > 0) {
                price += noOfSingleUnits * item.getPricePerCarton() * 1.3;
            }
        }
        return new ItemPrice(itemId, qty, price);
    }

    @Override
    public List<ItemPrice> getPriceList(int itemId) {
        List<ItemPrice> priceList = new ArrayList<>();
        Item item = itemRepository.findById((long) itemId).orElseThrow(() -> new ItemNotFountException(itemId));
        for (int i=1; i<=50; i++) {
            priceList.add(new ItemPrice(itemId, i, calculatePrice(itemId, i).getPrice()));
        }
        return priceList;
    }
}
