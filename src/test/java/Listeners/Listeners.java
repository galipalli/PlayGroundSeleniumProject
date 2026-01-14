package Listeners;

import Base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Utilities.TestUtil;

import java.io.IOException;

public class Listeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Logger log = Logger.getLogger(result.getInstance().getClass());
        log.info("========== STARTING TEST: " + result.getName() + " ==========");

        TestBase testBaseInstance = (TestBase) result.getInstance();
        TestBase.test = testBaseInstance.rep.startTest(
                result.getMethod().getMethodName(),
                "Clase: " + result.getInstanceName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logger log = Logger.getLogger(result.getInstance().getClass());
        log.info("========== TEST PASSED: " + result.getName()+ " ==========");
        TestBase.test.log(LogStatus.PASS, result.getName() + " -- Pass OK");

        // Usar el rep de la instancia actual del test
        TestBase testBaseInstance = (TestBase) result.getInstance();
        testBaseInstance.rep.endTest(TestBase.test);
        testBaseInstance.rep.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logger log = Logger.getLogger(result.getInstance().getClass());
        log.error("========== TEST FAILED: " + result.getName() + " ==========");
        log.error("Exception: ", result.getThrowable());

        try {
            TestBase testBaseInstance = (TestBase) result.getInstance();
            TestUtil.captureScreenshot(testBaseInstance.driver);

            // Primero logueamos el fallo y la captura de pantalla
            TestBase.test.log(LogStatus.FAIL, result.getName() + " -- Failed with exception: " + result.getThrowable());
            TestBase.test.log(LogStatus.INFO, TestBase.test.addScreenCapture("./" + TestUtil.screenshotName));

            // Luego finalizamos y guardamos el reporte
            testBaseInstance.rep.endTest(TestBase.test);
            testBaseInstance.rep.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void onTestSkipped(ITestResult result) {
        Logger log = Logger.getLogger(result.getInstance().getClass());
        log.warn("========== TEST SKIPPED: " + result.getName() + " ==========");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {}

    @Override
    public void onStart(ITestContext context) {
        Logger log = Logger.getLogger(Listeners.class);
        log.info("========== STARTING TEST SUITE: " + context.getName() + " ==========");
    }

    @Override
    public void onFinish(ITestContext context) {
        Logger log = Logger.getLogger(Listeners.class);
        log.info("========== FINISHED TEST SUITE: " + context.getName() + " ==========");
    }
}
