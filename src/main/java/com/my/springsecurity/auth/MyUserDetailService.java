/**
 * Created on 2015-12-23
 */
package com.my.springsecurity.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author zhuyl<a href="mailto:zhuyl@chsi.com.cn">zhu Youliang</a>
 * @version $Id$
 */
public class MyUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> auths=new ArrayList<GrantedAuthority>();
        GrantedAuthorityImpl auth2=new GrantedAuthorityImpl("ROLE_ADMIN");
        auths.add(auth2);
        if(username.equals("robin1")){
            auths=new ArrayList<GrantedAuthority>();
            GrantedAuthorityImpl auth1=new GrantedAuthorityImpl("ROLE_ROBIN");
            auths.add(auth1);
        }
        
//        User(String username, String password, boolean enabled, boolean accountNonExpired,
//                    boolean credentialsNonExpired, boolean accountNonLocked, Collection<GrantedAuthority> authorities) {
        User user = new User(username,
                "robin", true, true, true, true, auths);
        return user;
    }
}
