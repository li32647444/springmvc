package com.lb.springmvc.controller.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
	
	@SuppressWarnings("unused")
	private final static Logger logger = LoggerFactory.getLogger(BaseController.class);

	/*private void PrintWriterJson(HttpServletResponse response,Object object){
		try {
	        //设置页面不缓存
	        response.setContentType("application/json");
	        response.setHeader("Pragma", "No-cache");
	        response.setHeader("Cache-Control", "no-cache");
	        response.setCharacterEncoding("UTF-8");
	        PrintWriter out= null;
	        out = response.getWriter();
	        out.print(JSONUtil.toJSONString(object));
	        out.flush();
	        out.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}*/
}
