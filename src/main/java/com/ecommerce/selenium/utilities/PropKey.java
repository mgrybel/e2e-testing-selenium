package com.ecommerce.selenium.utilities;

public enum PropKey {
    URL("url"),
    PORT("port"),
    BROWSER("browser"),

    // Timeouts
    IMPLICIT_WAIT("implicitWait"),
    EXPLICIT_WAIT("explicitWait"),

    // Screenshots
    SCREENSHOT("screenshot"),
    ELEMENT_SCREENSHOT("elementScreenshot"),

    // Allure
    ALLURE_REPORT_STEP_LOG("allureReportStepLog");

    private String propVal;

    PropKey(String propVal) {
        this.propVal = propVal;
    }

    public String getPropVal() {
        return propVal;
    }
}
