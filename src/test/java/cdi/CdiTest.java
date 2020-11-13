package cdi;

import org.junit.Test;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import static org.junit.Assert.assertNotNull;

public class CdiTest {

    private String doSomething() {
        return "work!";
    }

    @Test
    public void injection_test() {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            CdiTest appInstance = container.select(CdiTest.class).get();
            String msg = appInstance.doSomething();

            assertNotNull(msg);
        }
    }
}
