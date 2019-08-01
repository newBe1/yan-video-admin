package com.yr.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 程序鬼才
 * @version 1.0
 * @date 2019/7/16 9:51
 *
 * 登陆拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    private List<String> unCheckUrls;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestUrl = request.getRequestURI();
        requestUrl=requestUrl.replaceAll(request.getContextPath(), "");
        // 判断是否针对匿名路径需要拦截，如果包含，则表示匿名路径，需要拦截，否则通过拦截器
        if (unCheckUrls.contains(requestUrl)){
            // 包含公开url，直接跳过
            return true;
        }

        if(null == request.getSession().getAttribute("sessionUser")){
            response.sendRedirect(request.getContextPath()+"/users/login.action");

            return false;
        }

        // 放行
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub
    }

    public List<String> getUnCheckUrls() {
        return unCheckUrls;
    }

    public void setUnCheckUrls(List<String> unCheckUrls) {
        this.unCheckUrls = unCheckUrls;
    }
}
