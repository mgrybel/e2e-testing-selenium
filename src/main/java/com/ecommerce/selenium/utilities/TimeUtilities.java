package com.ecommerce.selenium.utilities;

public class TimeUtilities {
    /**
     * Return the implicit wait
     * @return
     */
    public static long getImplicitWait() {
        return Long.parseLong(PropertyReader.getInstance().getProperty(PropKey.IMPLICIT_WAIT.getPropVal()));
    }
}
