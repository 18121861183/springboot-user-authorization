package com.yaochen.manager.authorization.common.security;

import com.yaochen.manager.authorization.manager.bean.CommonRole;
import com.yaochen.manager.authorization.manager.bean.CommonUser;
import com.yaochen.manager.authorization.manager.bean.CommonUserRole;
import com.yaochen.manager.authorization.manager.dao.CommonRoleRepository;
import com.yaochen.manager.authorization.manager.dao.CommonUserRepository;
import com.yaochen.manager.authorization.manager.dao.CommonUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private CommonUserRepository commonUserRepository;

    @Resource
    private CommonRoleRepository commonRoleRepository;

    @Resource
    private CommonUserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CommonUser user = commonUserRepository.findByUsernameOrAlias(username, username);
        if (user == null) throw new UsernameNotFoundException("用户： " + username + " 找不到");


        // [ROLE_USER, ROLE_ADMIN,..]
        List<CommonUserRole> userRoles = userRoleRepository.findCommonUserRolesByUserId(user.getId());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        assert userRoles!=null;
        for (CommonUserRole userRole: userRoles) {
            String roleId = userRole.getRoleId();
            CommonRole commonRole = commonRoleRepository.findCommonRoleById(roleId);
            GrantedAuthority authority = new SimpleGrantedAuthority(commonRole.getRoleName());
            grantList.add(authority);
        }

        UserDetails userDetails = (UserDetails) new CommonUser(user.getUsername(), user.getPassword(), grantList);

        return new SecurityUser(user);
    }
}
