package desperado.base;

import desperado.common.domain.Result;
import desperado.common.helper.ResultCodeHelper;

/**
 * Created by desperado on 18-1-13.
 * 标记接口
 */

public interface Service {

    default void setSuccess(Result result) {
        result.setSuccess(true);
        result.setCode(ResultCodeHelper.CODE_SUCCESS);
        result.setReason("success");
    }
}
