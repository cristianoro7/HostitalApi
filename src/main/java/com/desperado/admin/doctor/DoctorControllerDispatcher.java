package desperado.admin.doctor;

import desperado.base.BaseControllerDispatcher;

/**
 * Created by desperado on 18-1-13.
 */
public class DoctorControllerDispatcher extends BaseControllerDispatcher {

    @Override
    public String parseDestination(String url) {
        String[] paths = url.split("/");
        return "/" + paths[2];
    }
}
