package io.github.pancake.service;

import java.util.Arrays;
import java.util.List;

import io.github.pancake.persistence.base.Pancake;

/**
 * A service which provides the list of orderable pancakes.
 * 
 * @author Adorjan Nagy
 */
public class PancakeService {
    public List<Pancake> getOrderablePancakes() {
        return Arrays.asList(Pancake.values());
    }
}
