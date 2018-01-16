package desperado.common.security;

import desperado.admin.user.domain.UserResult;

/**
 * Created by desperado on 18-1-15.
 */

public class SecurityProtector {

    private static ResourcesMapper mapper;

    static {
        mapper = new ResourcesMapper(new AccessConfig());
    }

    public static boolean canAccessProtectResource(String servletPath, UserResult.User user) {
        return mapper.canAccess(user.getTitle(), servletPath);
    }
}
