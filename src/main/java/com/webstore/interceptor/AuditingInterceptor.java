package com.webstore.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by yubraj on 7/20/16.
 */
public class AuditingInterceptor extends HandlerInterceptorAdapter {

    String user;
    String productId;
    Logger logger = Logger.getLogger("auditLogger");

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getRequestURI().endsWith("products/add") && request.getMethod().equals("POST")) {
            user = request.getRemoteUser();
            productId = request.getParameterValues("productId")[0];
        }
        return true;
    }

    public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler,Exception arg3) throws Exception{
    if(request.getRequestURI().endsWith("products/add")
                &&response.getStatus()==302){
            logger.info(String.format("A New product[%s] Added by %s on %s",productId, user, getCurrentTime()));
        }
    }

    private String getCurrentTime() {
        DateFormat dateFormatter = new SimpleDateFormat("dd/mm/yy 'at' hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return dateFormatter.format(calendar.getTime());
    }
}
