package desperado.common.helper;

import com.google.gson.Gson;

/**
 * Created by desperado on 17-11-25.
 */

public class GsonHelper {

    private static Gson gson = new Gson();

    public static <T> String toJson(T bean) {
        return gson.toJson(bean);
    }

}
