package tes.sis.testsisi.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import tes.sis.testsisi.constant.GlobalMessage;
import tes.sis.testsisi.dto.BaseResponse;

@ControllerAdvice
public abstract class BaseController {

    public static <T> BaseResponse<T> buildSuccessResponse(T object) {
        return BaseResponse.<T>builder()
                .code(GlobalMessage.SUCCESS.httpStatus.value())
                .message(GlobalMessage.SUCCESS.message)
                .data(object)
                .build();
    }
}
