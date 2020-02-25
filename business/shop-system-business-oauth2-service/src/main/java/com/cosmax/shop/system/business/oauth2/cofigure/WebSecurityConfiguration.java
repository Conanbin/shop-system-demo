package com.cosmax.shop.system.business.oauth2.cofigure;

import com.cosmax.shop.system.business.oauth2.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

/**
 * @program: shop-system
 * @description: 全局安全配置
 * @author: Cosmax
 * @create: 2020/02/14 13:12
 */

@Configuration
@EnableWebSecurity
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * 配置密码加密 （使用spring默认）
     *
     * @return org.springframework.security.crypto.password.PasswordEncoder
     */
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }


    /**
     * 认证管理(授权服务配置需要用到这个)
     *
     * @return 认证管理对象
     * @throws Exception 认证异常信息
     **/
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 用户自定义信息
     * @return 调用自定义方法返回用户信息
     */
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new UserDetailServiceImpl();
    }


    /**
     * Spring Security中HttpSecurity配置程序允许的受保护资源的其他定制
     *
     * <p>注意:如果您的授权服务器也是一个资源服务器，那么还有另一个安全过滤器链，
     * 它的优先级较低，控制了API资源。 对于那些需要通过访问令牌来保护的请求，您需要它们的路径不能与主用户所面对的过滤器链中的那些相匹配，
     * 所以一定要包含一个请求matcher，它只挑选出下面的WebSecurityConfigurer中的非Api资源。
     *
     * @param http HttpSecurity
     **/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        /* 开启授权认证 */
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin();

    }

    /**
     * 全局用户信息
     * @param auth 用户认证
     * @throws Exception 用户认证异常信息
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(encoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/oauth/check_token")
        .antMatchers("/user/login")
        .antMatchers("/user/logout");

    }
}
