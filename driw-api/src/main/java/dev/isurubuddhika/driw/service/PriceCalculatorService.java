package dev.isurubuddhika.driw.service;

import dev.isurubuddhika.driw.dto.ItemDTO;
import dev.isurubuddhika.driw.dto.ItemPrice;
import dev.isurubuddhika.driw.exception.ItemNotFountException;

import java.util.List;

/**
 * The price structures are as follows:
 * - The rare product "Penguin-ears" is 20 units per carton. A carton is 175,-
 * - The product "Horseshoe" is 5 units per carton, a carton is 825,-
 * - If you purchase single units, the price is acquired using the carton price multiplied by an increase of
 *   30% (1.3). (to compensate for manual labor)
 * - If you purchase 3 cartons or more, you will receive a 10% discount off the carton price
 *
 * - The price engine is to optimize the price, meaning if you order 25 units and you have 20 units per
 *   carton, the price will be set at 1 carton and 5 single units
 */

public interface PriceCalculatorService {
    ItemPrice calculatePrice(int itemId, int qty) throws ItemNotFountException;

    List<ItemPrice> getPriceList(int itemId);
}
