package io.github.pancake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.pancake.persistence.base.Pancake;
import io.github.pancake.service.PancakeService;

/**
 * Test class for {@link PancakeService}
 *
 * @author Bence_Kornis
 */
public class PancakeServiceTest {
    private PancakeService underTest;

    @BeforeMethod
    public void setUp() {
        underTest = new PancakeService();
    }

    @Test
    public void testServiceShouldReturnPancakeTypes() {
        // GIVEN
        List<Pancake> pancakeTypes = new ArrayList<>(
                Arrays.asList(Pancake.COCOA, Pancake.COTTAGE_CHEES, Pancake.CINNAMON, Pancake.NUTELLA));

        // WHEN
        List<Pancake> pancakeTypesFromService = underTest.getAccessiblePancakeTypes();

        // THEN
        Assert.assertTrue(pancakeTypes.size() == pancakeTypesFromService.size());
        Assert.assertTrue(pancakeTypesFromService.containsAll(pancakeTypes));
    }
}
