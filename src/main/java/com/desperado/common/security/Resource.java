package desperado.common.security;

/**
 * Created by desperado on 18-1-16.
 */

public class Resource {

    private final String resourcePath;

    public Resource(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getResourcePath() {
        return resourcePath;
    }
}
