package com.cosmax.shop.system.cofiguration.feign.interceptor;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.Enumeration;

/**
 * @program: shop-system
 * @description:
 * @author: Cosmax
 * @create: 2020/02/19 12:24
 */
public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        HttpServletRequest request = requestAttributes.getRequest();

        // 获取请求头
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            requestTemplate.header(name, value);
        }

        // 获取请求体
        Enumeration<String> parameterNames = request.getParameterNames();
        StringBuilder body = new StringBuilder(); // 拼接请求体
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = request.getParameter(name);

            if ("access_token".equals(name)){
                // access_token 放在请求头
                requestTemplate.header("authorization", "Bearer" + value);
            }
            else {
                // 其他参数拼接
                body.append(name).append("=").append(value).append("&");
            }
        }
        if(body.length() > 0){
            body.deleteCharAt(body.length()-1);
            requestTemplate.body(Request.Body.bodyTemplate(body.toString(), Charset.defaultCharset()));
        }

    }
}
