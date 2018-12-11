package com.mmall.filter;


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
        httpRes.setHeader("Access-Contro-Allow-Origin","*");
        httpRes.setHeader("Access-Contro-Allow-Headers","Origin,No-Cache,x-Requested-with," +
            "If-Modified-Since,request type,Pragma,Last-Modified,"+
            "Cache-Control,Expires,Content-Type,X-E4M-With,userId,X-ACCESS_TOKEN");
        httpRes.setHeader("Access-Control-Allow-Methods","OPTIONS,GET,POST,PUT,DELETE");
        httpRes.setCharacterEncoding("UTF-8");
        httpRes.setHeader("Content-type","text/html;charset=UTF-8");//响应头，浏览器解码为UTF-8
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
