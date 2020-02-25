package com.cosmax.shop.system.business.oauth2.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cosmax.shop.system.business.oauth2.dto.OAuth2Response;
import com.cosmax.shop.system.business.oauth2.dto.UserDto;
import com.cosmax.shop.system.business.profile.feign.ProfileFeign;
import com.cosmax.shop.system.commons.dto.BaseResult;
import com.cosmax.shop.system.provider.domain.User;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: shop-system
 * @description: 登录控制器
 * @author: Cosmax
 * @create: 2020/02/17 11:42
 */

@RestController
public class LoginController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @Autowired
    private ProfileFeign profileFeign;

    @PostMapping("/user/login")
    public BaseResult login(@RequestBody UserDto userDto){

        OAuth2Response oAuthInfo = getOAuthInfo(userDto.getUsername(), userDto.getPassword());
        if (oAuthInfo == null){
            return BaseResult.fail("用户名或密码错误！");
        }
        if (StringUtils.isBlank(oAuthInfo.getAccess_token())){
            return BaseResult.fail("获取token失败！");
        }
        Map<String, String> map = new HashMap<>();
        map.put("token", oAuthInfo.getAccess_token());
        return BaseResult.success(BaseResult.STATECODE.OK, "登录成功！", map);

    }

//    @PreAuthorize("hasAuthority('ROLE_USER_READ')")
    @GetMapping("/user/info")
    public BaseResult getUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String info = profileFeign.info(authentication.getName());
        JSONObject jsonObject = JSON.parseObject(info);
        if (!jsonObject.containsKey("code")){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "token异常！", null);
        }
        if (jsonObject.getInteger("code") != BaseResult.STATECODE.OK){
            return BaseResult.fail(jsonObject.getInteger("code"), jsonObject.getString("message"), null);
        }
        User data = jsonObject.getJSONObject("data").toJavaObject(User.class);

        if (data == null){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "转换实体失败", null);
        }

        List<String> roles = Lists.newArrayList();
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            roles.add(authority.getAuthority()+";");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", data.getId());
        map.put("roles", roles);
        map.put("name", authentication.getName());
        map.put("email", data.getEmail());
        map.put("avatar", data.getIcon());
        return BaseResult.success(BaseResult.STATECODE.OK, "获取成功！", map);
    }

    @PostMapping("/user/logout")
    public BaseResult logout(@RequestParam("access_token") String accessToken){
        if (consumerTokenServices.revokeToken(accessToken)) {
            return BaseResult.success(BaseResult.STATECODE.OK, "登出成功！", null);
        }
        return BaseResult.success(BaseResult.STATECODE.ERROR, "登出失败！", null);
    }

    /**
     * 密码认证获取token
     * @param username 用户名
     * @param password 密码
     * @return {@link OAuth2Response}
     */
    private OAuth2Response getOAuthInfo(String username, String password){
        MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
        String url = "http://127.0.0.1:" + port + "/oauth/token";
        requestBody.add("username", username);
        requestBody.add("password", password);
        requestBody.add("grant_type", "password");
        requestBody.add("client_id", "shop_client");
        requestBody.add("client_secret", "shop_secret");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(requestBody, httpHeaders);
        ResponseEntity<OAuth2Response> exchange = null;
        RestTemplate restTemplate = new RestTemplate();
        try {
            exchange = restTemplate.exchange(url, HttpMethod.POST, httpEntity, OAuth2Response.class, new Object[]{});
        }catch (HttpClientErrorException ignored){
            return null;
        }
        return exchange.getBody();
    }

}
