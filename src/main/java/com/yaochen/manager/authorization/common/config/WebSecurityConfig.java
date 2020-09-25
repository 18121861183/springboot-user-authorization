package com.yaochen.manager.authorization.common.config;

import com.yaochen.manager.authorization.common.security.SecurityUser;
import com.yaochen.manager.authorization.manager.bean.CommonUser;
import com.yaochen.manager.authorization.manager.dao.CommonUserRepository;
import com.yaochen.manager.authorization.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {

            //用户加密配置
            @Override
            public String encode(CharSequence charSequence) {
                return MD5Util.encode((String)charSequence);
            }
            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(MD5Util.encode((String)charSequence));
            }
        });
    }

    /**
     *  通过 authorizeRequests() 定义哪些URL需要被保护、哪些不需要被保护
     *  通过 formLogin() 定义当需要用户登录时候，转到的登录页面。
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //设置静态资源均可以访问
                .antMatchers("/css/**", "/js/**","/images/**", "/static/**", "**/favicon.ico").permitAll()
                .anyRequest().authenticated()
                .and()
                //指定登录认证的Controller
                .formLogin().loginPage("/login").permitAll().successHandler(loginSuccessHandler())
                .and().logout().permitAll()
                .invalidateHttpSession(true)
                // 删除缓存
                .deleteCookies("JSESSIONID").logoutSuccessHandler(logoutSuccessHandler())
                // 记住登录
                .and().rememberMe()
                // 同时登录数量限制
                .and().sessionManagement().maximumSessions(10).expiredUrl("/login");
    }


    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() { //登出处理
        return new LogoutSuccessHandler() {
            @Override
            public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                try {
                    SecurityUser user = (SecurityUser) authentication.getPrincipal();
                    logger.info("USER : {} LOGOUT SUCCESS ! ", user.getUsername());
                } catch (Exception e) {
                    logger.error("printStackTrace", e);
                }
                httpServletResponse.sendRedirect("/login");
            }
        };
    }

    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler loginSuccessHandler() { //登入处理
        return new SavedRequestAwareAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                CommonUser userDetails = (CommonUser) authentication.getPrincipal();
                logger.info("USER : " + userDetails.getUsername() + " LOGIN SUCCESS !  ");
                super.onAuthenticationSuccess(request, response, authentication);
                response.sendRedirect("/index");
            }
        };
    }

}
