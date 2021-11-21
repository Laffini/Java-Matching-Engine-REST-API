package net.laffyco.javamatchingengine.restapi.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.laffyco.javamatchingengine.core.api.SpreadInterface;

/**
 * Spread controller.
 *
 * @author Laffini
 *
 */
@RestController
@RequestMapping("/spread")
public class SpreadController {

    /**
     * Spread interface.
     */
    @Autowired
    private SpreadInterface spreadInterface;

    /**
     * Retrieve the order book spread.
     *
     * @return spread
     */
    @GetMapping("/")
    public Map<String, Double> getSpread() {
        return this.spreadInterface.getSpread();
    }
}
