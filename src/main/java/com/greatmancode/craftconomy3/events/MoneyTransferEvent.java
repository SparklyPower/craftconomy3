package com.greatmancode.craftconomy3.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MoneyTransferEvent extends Event {
    private static final HandlerList handlerList = new HandlerList();

    private final String payer;
    private final String receiver;
    private final double amount;

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public MoneyTransferEvent(String payer, String receiver, double amount) {
        this.payer = payer;
        this.receiver = receiver;
        this.amount = amount;
    }

    public String getPayer() {
        return this.payer;
    }

    public String getReceiver() {
        return this.receiver;
    }

    public double getAmount() {
        return this.amount;
    }
}
