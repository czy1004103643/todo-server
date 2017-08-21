package com.tms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.tms.utils.Utils;
/**
 * 避免重复提交
 * @author ljt
 *
 */
public class AvoidRepeatSubmitInterceptor implements HandlerInterceptor{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		if(Utils.isRequestMethodPost(request) && !validate(request)){
			return false;
		}
		generateServerToken(request);
		return true;
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		if(Utils.isRequestMethodPost(request)){
			generateServerToken(request);
		}
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {}

	
	/**
	 * 验证(重复提交，是否是自己的网页请求)
	 * @param request
	 * @return
	 */
	private boolean validate(HttpServletRequest request) {
		
		String serverToken = (String) WebUtils.getSessionAttribute(request,"token");
		if(serverToken == null){
			return true;
		}
        String clientToken = request.getParameter("token");
        if (clientToken == null) {
            return false;
        }
        if (!clientToken.equals(serverToken)) {
            return false;
        }
        return true;
    }
	
	private void generateServerToken(HttpServletRequest request){
		String token = RandomStringUtils.randomAlphanumeric(16);
    	WebUtils.setSessionAttribute(request,"token", token);
	}
}
