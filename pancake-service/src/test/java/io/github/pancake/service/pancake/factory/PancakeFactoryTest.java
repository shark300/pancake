package io.github.pancake.service.pancake.factory;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.pancake.persistence.base.Pancake;

/**
 * Test class for {@link PancakeFactory}.
 *
 * @author Adorjan Nagy
 */
public class PancakeFactoryTest {
    private PancakeFactory underTest;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
        underTest = new PancakeFactory();
    }

    @Test
    public void testGetObjectShouldReturnTheListOfPancakesWhenPancakesAreSet() {
        // GIVEN
        List<Pancake> testPancakes = Arrays.asList(Pancake.values());
        // WHEN
        List<Pancake> pancakes = underTest.getObject();
        // THEN
        assertEquals(pancakes, testPancakes);
    }
}