package test;

import main.Mars;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class MarsTest {

    @org.junit.jupiter.api.Test
    void mars_init_goodInputs() {
        Mars mars = Mars.getInstance(1,1);
        assertNotNull(mars, () -> "Mars should not be null after valid init");
    }

    @org.junit.jupiter.api.Test
    void mars_init_badNullInputs() {
        try {
            Mars mars = Mars.getInstance(1, null);
            fail("Mars should fail to be created if northEdge is null");
        } catch (Exception e) {
            assertNotNull(e);
        }

        try {
            Mars mars = Mars.getInstance(null, 1);
            fail("Mars should fail to be created if northEdge is null");
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

    @org.junit.jupiter.api.Test
    void mars_init_badSmallInputs() {
        try {
            Mars mars = Mars.getInstance(0, 1);
            fail("Mars should fail to be created if eastEdge is less than 1");
        } catch (Exception e) {
            assertNotNull(e);
        }

        try {
            Mars mars = Mars.getInstance(1, 0);
            fail("Mars should fail to be created if northEdge is less than 1");
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

    @org.junit.jupiter.api.Test
    void mars_init_badLargeInputs() {
        try {
            Mars mars = Mars.getInstance(51, 0);
            fail("Mars should fail to be created if eastEdge is more than 50");
        } catch (Exception e) {
            assertNotNull(e);
        }

        try {
            Mars mars = Mars.getInstance(0, 51);
            fail("Mars should fail to be created if northEdge is more than 50");
        } catch (Exception e) {
            assertNotNull(e);
        }
    }
}
