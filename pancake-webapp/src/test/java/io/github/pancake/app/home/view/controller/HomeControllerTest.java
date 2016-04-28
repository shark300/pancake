package io.github.pancake.app.home.view.controller;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for {@link HomeController}.
 * @author Bence_Kornis
 */
public class HomeControllerTest {
    private static final String HOMEPAGE = "homepage";
    private HomeController underTest;

    @BeforeMethod
    public void setUp() {
        underTest = new HomeController();
    }

    @Test
    public void testHomepageShouldRedirectToHomepageWhenInvoked() {
        // GIVEN in setUp
        // WHEN
        String result = underTest.homepage();
        // THEN
        assertEquals(result, HOMEPAGE);
    }
}
