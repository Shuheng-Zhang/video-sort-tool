package top.shuzz.video.sort.service.core.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;
import top.shuzz.video.sort.service.core.response.FailureResponse;

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {

    final private FailureResponse failureResponse;
    final private Object errInfo;

    public BusinessException(final FailureResponse failureResponse, final Object errInfo) {
        this.failureResponse = failureResponse;
        this.errInfo = errInfo;
    }
}
