package dev.isurubuddhika.driw.exception;

import java.util.function.Supplier;

public class ItemNotFountException extends RuntimeException {
    private long itemId;

    public ItemNotFountException(long itemId){
        super();
        this.itemId = itemId;
    }
}
