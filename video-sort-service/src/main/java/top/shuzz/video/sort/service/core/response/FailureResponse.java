package top.shuzz.video.sort.service.core.response;

public enum FailureResponse implements BaseResponse {

    BAD_REQUEST(400, "BAD_REQUEST"),

    PERMISSION_DENIED(401, "PERMISSION_DENIED"),

    SYS_ERROR(500, "SERVER_INTERNAL_ERROR")

    ;

    final private Integer code;
    final private String msg;

    FailureResponse(final Integer code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
