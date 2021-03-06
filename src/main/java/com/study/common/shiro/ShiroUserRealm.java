package com.study.common.shiro;



import com.study.index.bean.User;
import com.study.index.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class ShiroUserRealm extends AuthorizingRealm {
    private static final Logger logger = Logger.getLogger(ShiroUserRealm.class.getName());
    @Autowired
    private UserService userService;

    // 权限认证
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    // 身份认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String userName = token.getUsername();
        try {
            User user = userService.getByAccount(userName);
            if (user != null) {
                ShiroUser shiroUser = new ShiroUser();
                shiroUser.setUserAccount(user.getUserAccount());
                shiroUser.setUserName(user.getUserName());
                shiroUser.setUserPhone(user.getUserPhone());
                AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(shiroUser, token.getPassword(), getName());
                return authcInfo;
            }
        } catch (Exception e) {
            throw new AuthenticationException(e.getMessage(), e);
        }
        return null;
    }


}
