package desperado.common.security;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by desperado on 18-1-16.
 */

public class ResourcesMapper {

    private AccessConfig accessConfig;

    private Map<String, Set<String>> accessMap;

    public ResourcesMapper(AccessConfig accessConfig) {
        this.accessConfig = accessConfig;
        accessMap = new HashMap<>();
        init();
    }

    private void init() {
        Set<String> p = new HashSet<>();
        p.addAll(Arrays.asList(accessConfig.ADMIN_ACCESS_PATTERN));
        accessMap.put(accessConfig.ADMIN, p);
    }

    public boolean canAccess(String userName, String servletPath) {
        Set<String> set = accessMap.get(userName);
        if (set != null) { //登录的是管理员
            for (String s : set) {
                // 包含 /管理员可以访问开头的url, 可以访问
                return servletPath.contains(s);
            }
        } else { //登录的不是管理员
            for (String s : accessConfig.ADMIN_ACCESS_PATTERN) {
                return !servletPath.contains(s);
            }
        }
        return false;
    }
}
