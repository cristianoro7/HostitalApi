package desperado.common.domain;

import desperado.common.helper.GsonHelper;

/**
 * Created by desperado on 18-1-12.
 */

public class Result {

    private int code;

    private String reason;

    private boolean success;

    public Result(int code, String reason, boolean success) {
        this.code = code;
        this.reason = reason;
        this.success = success;
    }

    public Result() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static Result buildResult(int code, String reason, boolean success) {
        return new Result(code, reason, success);
    }

    public String toJson() {
        return GsonHelper.toJson(this);
    }
}
