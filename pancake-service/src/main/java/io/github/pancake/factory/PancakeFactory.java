package io.github.pancake.factory;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import io.github.pancake.persistence.base.Pancake;

/**
 * @author Adorjan Nagy
 */
@Component
public class PancakeFactory implements FactoryBean<List<Pancake>> {
    private List<Pancake> pancakes;

    @Override
    public List<Pancake> getObject() {
        if (pancakes == null) {
            initPancakes();
        }
        return pancakes;
    }

    @Override
    public Class<Pancake[]> getObjectType() {
        return Pancake[].class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    private void initPancakes() {
        pancakes = Arrays.asList(Pancake.values());
    }
}
