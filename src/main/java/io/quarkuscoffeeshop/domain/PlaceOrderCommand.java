package io.quarkuscoffeeshop.domain;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.math.BigDecimal;
import java.util.*;

@RegisterForReflection
public class PlaceOrderCommand {

    private String id = UUID.randomUUID().toString();

    private OrderSource orderSource;

    private String rewardsId;

    private final CommandType commandType = CommandType.PLACE_ORDER;

    Optional<List<OrderLineItem>> baristaItems = Optional.empty();

    Optional<List<OrderLineItem>> kitchenItems = Optional.empty();

    private BigDecimal total;

    public PlaceOrderCommand() {
    }

    public PlaceOrderCommand(String id, OrderSource orderSource, String rewardsId, List<OrderLineItem> baristaItems, List<OrderLineItem> kitchenItems, BigDecimal total) {
        this.id = id;
        this.orderSource = orderSource;
        this.rewardsId = rewardsId;
        this.baristaItems = Optional.ofNullable(baristaItems);
        this.kitchenItems = Optional.ofNullable(kitchenItems);
        this.total = total;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PlaceOrderCommand.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("orderSource=" + orderSource)
                .add("rewardsId=" + rewardsId)
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
                rewardsId == that.rewardsId &&
                Objects.equals(baristaItems, that.baristaItems) &&
                Objects.equals(kitchenItems, that.kitchenItems) &&
                Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderSource, rewardsId, commandType, baristaItems, kitchenItems, total);
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

    public String getRewardsId() {
        return rewardsId;
    }

    public void setRewardsId(String rewardsId) { this.rewardsId = rewardsId; }

    public Optional<List<OrderLineItem>> getBaristaItems() {
        return baristaItems;
    }

    public void setBaristaItems(Optional<List<OrderLineItem>> baristaItems) {
        this.baristaItems = baristaItems;
    }

    public Optional<List<OrderLineItem>> getKitchenItems() {
        return kitchenItems;
    }

    public void setKitchenItems(Optional<List<OrderLineItem>> kitchenItems) {
        this.kitchenItems = kitchenItems;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
