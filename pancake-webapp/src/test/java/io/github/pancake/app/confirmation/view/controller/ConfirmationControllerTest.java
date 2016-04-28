package io.github.pancake.app.confirmation.view.controller;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.Assert.assertEquals;

import org.mockito.Mock;
import org.springframework.validation.BindingResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.pancake.app.order.view.model.OrderRequest;

/**
 * Test class for {@link ConfirmationController}.
 * @author Bence_Kornis
 */
public class ConfirmationControllerTest {
    private static final String CONFIRMATION = "confirmation";
    private static final String REDIRECT = "redirect:";
    private ConfirmationController underTest;
    @Mock
    private BindingResult mockBindingResult;
    @Mock
    private OrderRequest mockOrderRequest;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
        underTest = new ConfirmationController();
    }

    @Test
    public void testConfirmationShouldRedirectToHomeWhenBindingResultsHasErrors() {
        // GIVEN
        when(mockBindingResult.hasErrors()).thenReturn(true);
        // WHEN
        String result = underTest.confirmation(mockOrderRequest, mockBindingResult);
        // THEN
        assertEquals(result, REDIRECT);
    }

    @Test
    public void testConfirmationShouldRedirectToConfirmationWhenBindingResultsHasNoErrors() {
     // GIVEN
        when(mockBindingResult.hasErrors()).thenReturn(false);
        // WHEN
        String result = underTest.confirmation(mockOrderRequest, mockBindingResult);
        // THEN
        assertEquals(result, CONFIRMATION);
    }
}
