package desperado.base;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by desperado on 18-1-13.
 */

public class ServiceContainer {

    private static volatile ServiceContainer INSTANCE;

    private ConcurrentHashMap<String, Service> serviceContainer;

    private ServiceContainer() {
        serviceContainer = new ConcurrentHashMap<>();
    }

    public static ServiceContainer getInstance() {
        if (INSTANCE == null) {
            synchronized (ServiceContainer.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ServiceContainer();
                }
            }
        }
        return INSTANCE;
    }

    public <T extends Service> T getService(String name) {
        if (name != null) {
            return (T) serviceContainer.get(name);
        }
        throw new IllegalArgumentException("service name can not be null");
    }

    public void addService(String name, Service service) {
        if (name != null && service != null) {
            serviceContainer.put(name, service);
        } else {
            throw new IllegalArgumentException("service name or instance can not be null");
        }
    }
}
