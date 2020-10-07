package io.quarkuscoffeeshop.domain;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.math.BigDecimal;
import java.util.*;

@RegisterForReflection
public class PlaceOrderCommand {

    private final String id = UUID.randomUUID().toString();

    private OrderSource orderSource;

    private final CommandType commandType = CommandType.PLACE_ORDER;

    Optional<Collection<OrderLineItem>> baristaItems = Optional.empty();

    Optional<Collection<OrderLineItem>> kitchenItems = Optional.empty();

    private BigDecimal total;

    public PlaceOrderCommand() {
    }

    public PlaceOrderCommand(OrderSource orderSource, Collection<OrderLineItem> baristaItems, Collection<OrderLineItem> kitchenItems) {
        this.orderSource = orderSource;
        this.baristaItems = Optional.ofNullable(baristaItems);
        this.kitchenItems = Optional.ofNullable(kitchenItems);
    }

    public void setBaristaItems(Collection<OrderLineItem> baristaItems) {
        this.baristaItems = Optional.of(baristaItems);
    }


    public void setKitchenItems(Collection<OrderLineItem> kitchenItems) {
        this.kitchenItems = Optional.of(kitchenItems);
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

    public Optional<Collection<OrderLineItem>> getBaristaItems() {
        return baristaItems;
    }

    public void setBaristaItems(Optional<Collection<OrderLineItem>> baristaItems) {
        this.baristaItems = baristaItems;
    }

    public Optional<Collection<OrderLineItem>> getKitchenItems() {
        return kitchenItems;
    }

    public void setKitchenItems(Optional<Collection<OrderLineItem>> kitchenItems) {
        this.kitchenItems = kitchenItems;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
