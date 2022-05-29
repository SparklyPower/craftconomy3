package com.greatmancode.craftconomy3.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MoneyTransferEvent extends Event {
    private static final HandlerList handlerList = new HandlerList();

    private final Player payer;
    private final Player receiver;
    private final double amount;

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public MoneyTransferEvent(Player payer, Player receiver, double amount) {
        this.payer = payer;
        this.receiver = receiver;
        this.amount = amount;
    }

    public Player getPayer() {
        return this.payer;
    }

    public Player getReceiver() {
        return this.receiver;
    }

    public double getAmount() {
        return this.amount;
    }
}
