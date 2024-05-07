package tes.sis.testsisi.constant;

import tes.sis.testsisi.exception.AppException;

public final class Constant {

    private Constant() {
        throw new AppException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }

    public static final String ERROR = "Error : ";
}
