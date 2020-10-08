package io.quarkuscoffeeshop.domain;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.math.BigDecimal;
import java.util.*;

@RegisterForReflection
public class PlaceOrderCommand {

    private final String id = UUID.randomUUID().toString();

    private OrderSource orderSource;

    private final CommandType commandType = CommandType.PLACE_ORDER;

    Optional<ArrayList<OrderLineItem>> baristaItems = Optional.empty();

    Optional<ArrayList<OrderLineItem>> kitchenItems = Optional.empty();

    private BigDecimal total;

    public PlaceOrderCommand() {
    }

    public PlaceOrderCommand(OrderSource orderSource, Optional<ArrayList<OrderLineItem>> baristaItems, Optional<ArrayList<OrderLineItem>> kitchenItems, BigDecimal total) {
        this.orderSource = orderSource;
        this.baristaItems = baristaItems;
        this.kitchenItems = kitchenItems;
        this.total = total;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PlaceOrderCommand.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("orderSource=" + orderSource)
                .add("commandType=" + commandType)
                .add("baristaItems=" + baristaItems)
                .add("kitchenItems=" + kitchenItems)
                .add("total=" + total)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceOrderCommand that = (PlaceOrderCommand) o;
        return Objects.equals(id, that.id) &&
                orderSource == that.orderSource &&
                commandType == that.commandType &&
                Objects.equals(baristaItems, that.baristaItems) &&
                Objects.equals(kitchenItems, that.kitchenItems) &&
                Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderSource, commandType, baristaItems, kitchenItems, total);
    }

    public String getId() {
        return id;
    }

    public OrderSource getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(OrderSource orderSource) {
        this.orderSource = orderSource;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public Optional<ArrayList<OrderLineItem>> getBaristaItems() {
        return baristaItems;
    }

    public void setBaristaItems(Optional<ArrayList<OrderLineItem>> baristaItems) {
        this.baristaItems = baristaItems;
    }

    public Optional<ArrayList<OrderLineItem>> getKitchenItems() {
        return kitchenItems;
    }

    public void setKitchenItems(Optional<ArrayList<OrderLineItem>> kitchenItems) {
        this.kitchenItems = kitchenItems;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
