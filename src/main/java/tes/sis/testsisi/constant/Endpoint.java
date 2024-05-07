package tes.sis.testsisi.constant;

import tes.sis.testsisi.exception.AppException;

public final class Endpoint {

    private Endpoint() {
        throw new AppException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }

    public static final String REPORT = "/report";
}
