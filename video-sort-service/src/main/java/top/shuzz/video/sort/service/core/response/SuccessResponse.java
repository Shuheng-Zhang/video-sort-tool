package top.shuzz.video.sort.service.core.response;

public enum SuccessResponse implements BaseResponse {

    OK(0, "OK")

    ;

    final private Integer code;
    final private String msg;

    SuccessResponse(final Integer code, final String msg) {
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
