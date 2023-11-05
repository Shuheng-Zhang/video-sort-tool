package top.shuzz.video.sort.service.core.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult implements Serializable {

    private Integer code;
    private String msg;
    private Object data;



    public static ResponseResult success() {
        return success(SuccessResponse.OK, null);
    }

    public static ResponseResult success(final Object data) {
        return success(SuccessResponse.OK, data);
    }

    public static ResponseResult success(final SuccessResponse successResponse, final Object data) {
        return ResponseResult.builder()
                .code(successResponse.getCode())
                .msg(successResponse.getMsg())
                .data(data)
                .build();
    }

    public static ResponseResult fail(final FailureResponse failureResponse) {
        return fail(failureResponse, null);
    }

    public static ResponseResult fail(final FailureResponse failureResponse, final Object errInfo) {
        return ResponseResult.builder()
                .code(failureResponse.getCode())
                .msg(failureResponse.getMsg())
                .data(errInfo)
                .build();
    }
}
