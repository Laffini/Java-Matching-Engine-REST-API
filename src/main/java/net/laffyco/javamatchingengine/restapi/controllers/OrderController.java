package net.laffyco.javamatchingengine.restapi.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.laffyco.javamatchingengine.core.api.OrderInterface;
import net.laffyco.javamatchingengine.core.engine.Order;
import net.laffyco.javamatchingengine.core.engine.Side;

/**
 * Controller for orders.
 *
 * @author Laffini
 *
 */
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    /**
     * Order interface.
     */
    @Autowired
    private OrderInterface orderInterface;

    /**
     * Retrieve orders.
     *
     * @return orders
     */
    @GetMapping("/")
    public Map<String, List<Order>> getOrders() {
        return this.orderInterface.getOrders();
    }

    /**
     * Retrieve an order by ID.
     *
     * @param id
     * @param side
     * @return order (or null if not found)
     */
    @GetMapping("/{id}")
    public Map<String, Order> getOrder(@PathVariable final String id,
            @RequestParam("side") final Side side) {
        return this.orderInterface.getOrder(id, side);
    }

    /**
     * Add an order.
     *
     * @param side
     * @param amount
     * @param price
     * @return order id
     */
    @PostMapping("/")
    public Map<String, Object> addOrder(@RequestParam("side") final Side side,
            @RequestParam("amount") final double amount,
            @RequestParam("price") final double price) {
        return this.orderInterface.addOrder(side, amount, price);
    }

    /**
     * Delete an order.
     *
     * @param id
     * @param side
     * @return whether an order was deleted or not
     */
    @DeleteMapping("/{id}")
    public Map<String, Object> deleteOrder(@PathVariable final String id,
            @RequestParam("side") final Side side) {
        return this.orderInterface.deleteOrder(id, side);
    }

    /**
     * Update an order.
     *
     * @param id
     * @param side
     * @param newAmount
     * @param newPrice
     * @param newSide
     * @return whether an order has been updated or not
     */
    @PutMapping("/{id}")
    public Map<String, Object> updateOrder(@PathVariable final String id,
            @RequestParam("side") final Side side,
            @RequestParam("newAmount") final Optional<Double> newAmount,
            @RequestParam("newPrice") final Optional<Double> newPrice,
            @RequestParam("newSide") final Optional<Side> newSide) {
        return this.orderInterface.updateOrder(id, side, newAmount, newPrice,
                newSide);
    }
}
