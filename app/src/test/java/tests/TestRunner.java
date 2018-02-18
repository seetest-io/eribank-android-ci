package tests;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.IOException;
import java.util.List;

import static java.lang.System.exit;

public class TestRunner {

    @Test
    public void test() throws IOException {

        Class[] cls = {
                EriBankPaymentTest.class,
                EriBankPaymentTest.class,
                EriBankPaymentTest.class,
                EriBankPaymentTest.class,
                EriBankPaymentTest.class,
        };

        //Parallel among classes
        Result result = JUnitCore.runClasses(ParallelComputer.classes(), cls);
        List<Failure> failures = result.getFailures();
        if (!failures.isEmpty()) {
            for (Failure failure : failures) {
                System.out.println(failure);
            }
            exit(1);

        }
    }
}