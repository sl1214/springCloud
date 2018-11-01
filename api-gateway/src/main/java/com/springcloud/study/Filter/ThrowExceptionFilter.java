package com.springcloud.study.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;

/**
 * @author chao.shen01@hand-china.com
 * @description
 * @Data 2018/11/1 15:32
 */
public class ThrowExceptionFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(ThrowExceptionFilter.class);


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("this is a pre filter,it will throw a RuntimeException");
        RequestContext ctx = RequestContext.getCurrentContext();
        doSomething();
        /*try{
            doSomething();
        }*/
        /*catch (Exception e){
            Throwable throwable = new Throwable();
            ctx.setThrowable(throwable);
            ctx.set("error.status_code",HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            ctx.set("error.exception",e);
        }*/
        return null;
    }

    private void doSomething() {
            throw new RuntimeException("exist some errors...");
    }
}
