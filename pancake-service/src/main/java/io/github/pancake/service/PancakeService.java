package io.github.pancake.service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Adorjan Nagy
 *
 */
public class PancakeService {
    private final Set<String> PANCAKES = new HashSet<String>();

    public PancakeService() {
        setPancakes();
    }

    public Set<String> retrievePancakes() {
        return getPancakes();
    }

    private Set<String> getPancakes() {
        return PANCAKES;
    }

    private void setPancakes() {
        PANCAKES.add("nutellas");
        PANCAKES.add("lekvaros");
        PANCAKES.add("turos");
    }
}
