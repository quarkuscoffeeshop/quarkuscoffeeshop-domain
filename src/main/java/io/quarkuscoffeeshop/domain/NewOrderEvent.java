package io.quarkuscoffeeshop.domain;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.math.BigDecimal;
import java.util.*;

@RegisterForReflection
public class NewOrderEvent {

    private final String id = UUID.randomUUID().toString();

    private OrderSource orderSource;

    private final EventType eventType = EventType.NEW_ORDER;

    Optional<HashMap<String, MenuItem>> baristaItems = Optional.empty();

    Optional<HashMap<String, MenuItem>> kitchenItems = Optional.empty();

    BigDecimal total;

    public NewOrderEvent() {
    }

    public NewOrderEvent(OrderSource orderSource, HashMap<String, MenuItem> baristaItems, HashMap<String, MenuItem> kitchenItems) {
        this.orderSource = orderSource;
        this.baristaItems = Optional.of(baristaItems);
        this.kitchenItems = Optional.of(kitchenItems);
    }

    public void setBaristaItems(HashMap<String, MenuItem> baristaItems) {
        this.baristaItems = Optional.of(baristaItems);
    }


    public void setKitchenItems(HashMap<String, MenuItem> kitchenItems) {
        this.kitchenItems = Optional.of(kitchenItems);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NewOrderEvent.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("orderSource=" + orderSource)
                .add("eventType=" + eventType)
                .add("baristaItems=" + baristaItems)
                .add("kitchenItems=" + kitchenItems)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewOrderEvent that = (NewOrderEvent) o;
        return Objects.equals(id, that.id) &&
                orderSource == that.orderSource &&
                eventType == that.eventType &&
                Objects.equals(baristaItems, that.baristaItems) &&
                Objects.equals(kitchenItems, that.kitchenItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderSource, eventType, baristaItems, kitchenItems);
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

    public EventType getEventType() {
        return eventType;
    }

    public Optional<HashMap<String, MenuItem>> getBaristaItems() {
        return baristaItems;
    }

    public Optional<HashMap<String, MenuItem>> getKitchenItems() {
        return kitchenItems;
    }
}
