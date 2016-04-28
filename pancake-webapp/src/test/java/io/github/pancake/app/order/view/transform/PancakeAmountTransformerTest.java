package io.github.pancake.app.order.view.transform;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.pancake.service.pancake.domain.PancakeAmount;

/**
 * Test class for {@link PancakeAmountTransformer}.
 * @author Bence_Kornis
 */
public class PancakeAmountTransformerTest {
    private PancakeAmountTransformer underTest;

    @BeforeMethod
    public void setUp() {
        underTest = new PancakeAmountTransformer();
    }

    @Test
    public void testTransformShouldReturnTransformedObjectWhenInvoked() {
        // GIVEN
        io.github.pancake.app.domain.PancakeAmount pancakeAmount =
                io.github.pancake.app.domain.PancakeAmount.builder()
                        .withType(any())
                        .withAmount(anyInt())
                        .build();
        // WHEN
        PancakeAmount result = underTest.transform(pancakeAmount);
        // THEN
        assertEquals(result.getType(), pancakeAmount.getType());
        assertEquals(result.getAmount(), pancakeAmount.getAmount());
    }
}
