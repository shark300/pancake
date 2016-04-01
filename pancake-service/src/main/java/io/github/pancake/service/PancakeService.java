package io.github.pancake.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.github.pancake.persistence.base.Pancake;

/**
 * Service to get pancake types
 *
 * @author Bence_Kornis
 */
@Service
public class PancakeService {
    /**
     * Get all accesible pancake types
     * @return list of {@link Pancake}.
     */
    public List<Pancake> getAccessiblePancakeTypes() {
        return Arrays.asList(Pancake.values());
    }
}
