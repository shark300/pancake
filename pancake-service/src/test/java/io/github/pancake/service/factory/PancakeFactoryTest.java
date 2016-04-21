package io.github.pancake.service.factory;

import java.util.Arrays;
import java.util.List;

import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.pancake.persistence.base.Pancake;
import io.github.pancake.service.factory.PancakeFactory;

/**
 * Test class for {@link PancakeFactory}.
 *
 * @author Adorjan Nagy
 */
public class PancakeFactoryTest {
    private PancakeFactory underTest;
    private List<Pancake> pancakes;
    private List<Pancake> testPancakes;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        testPancakes = Arrays.asList(Pancake.values());
        underTest = new PancakeFactory();
    }

    @Test
    public void testGetObjectShouldReturnTheListOfPancakesWhenPancakesAreSet() {
        // GIVEN in setUp
        // WHEN
        pancakes = underTest.getObject();
        // THEN
        Assert.assertEquals(pancakes, testPancakes);
    }
}