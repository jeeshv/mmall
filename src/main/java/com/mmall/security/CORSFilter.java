package com.mmall.security;


import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/12/12.
 */
public class CORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpRes = (HttpServletResponse) servletResponse;
        httpRes.setHeader("Access-Control-Allow-Origin","*");
        httpRes.setHeader("Access-Control-Allow-Methods","OPTIONS,GET,POST,PUT,DELETE");
        httpRes.setHeader("Access-Control-Expose-Headers","Origin,Accept,Content-Type,Date,token");//设置允许返回的响应头
        httpRes.setHeader("Access-Control-Max-Age", "3600");
        httpRes.setHeader("Access-Control-Allow-Headers", "x-requested-with," +   //设置允许请求传达的请求头
                        "Content-Type,X-Amz-Date,Authorization,X-Api-Key," +
                        "X-Amz-Security-Token,X-XSRF-TOKEN,token");
        httpRes.setCharacterEncoding("UTF-8");
        httpRes.setHeader("Content-type","text/html;charset=UTF-8");//响应头，浏览器解码为UTF-8
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
