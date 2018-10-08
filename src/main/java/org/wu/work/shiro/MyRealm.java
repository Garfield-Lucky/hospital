package org.wu.work.shiro;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.wu.work.entity.User;
import org.wu.work.service.UserService;

/**
 * Created with IDEA
 * Created by ${jie.chen} on 2016/7/14.
 * Shiro自定义域
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * 用于的权限的认证。
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString() ;
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo() ;
        List<Map<String,String>> listRoleName = userService.findRoles(username) ;
        List<Map<String,String>> ListPermissions = userService.findPermissions(username) ;
        Set<String> roleName = new HashSet<String>(listRoleName.size());
        Set<String> permissions = new HashSet<String>(ListPermissions.size());
       
        //角色
        for(Map<String,String> map:listRoleName)
        {
        	roleName.add(map.get("roleName"));
        }
        
        //权限
        for(Map<String,String> map:ListPermissions)
        {
        	permissions.add(map.get("permissionName"));
        }
       
        info.setRoles(roleName);
        info.setStringPermissions(permissions);
        return info;
    }

    /**
     * 首先执行这个登录验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        //获取用户账号
        String username = token.getPrincipal().toString() ;
        User user = userService.queryUserByName(username) ;
        if (user != null){
            //将查询到的用户账号和密码存放到 authenticationInfo用于后面的权限判断。第三个参数随便放一个就行了。
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(),user.getPassWord(),
                    "MyRealm") ;
            return authenticationInfo ;
        }else{
            return  null ;
        }
    }
}
