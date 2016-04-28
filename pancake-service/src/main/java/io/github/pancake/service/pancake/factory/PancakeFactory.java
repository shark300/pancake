package io.github.pancake.service.pancake.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import io.github.pancake.persistence.base.Pancake;

/**
 * A list of pancakes provider Pancake factory bean class.
 *
 * @author Adorjan Nagy
 */
@Component
public class PancakeFactory implements FactoryBean<List<Pancake>> {
    private final List<Pancake> pancakes;

    public PancakeFactory() {
        pancakes = Collections.unmodifiableList(Arrays.asList(Pancake.values()));
    }

    @Override
    public List<Pancake> getObject() {
        return getPancakesCopy();
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class<List> getObjectType() {
        return List.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    private List<Pancake> getPancakesCopy() {
        return new ArrayList<Pancake>(pancakes);
    }
}
