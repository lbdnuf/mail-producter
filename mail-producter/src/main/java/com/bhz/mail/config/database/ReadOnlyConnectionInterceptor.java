package com.bhz.mail.config.database;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReadOnlyConnectionInterceptor implements Ordered{

	public static final Logger LOFFER = LoggerFactory.getLogger(ReadOnlyConnectionInterceptor.class);
	
	
	@Around("@annotation(readOnlyConnection)")
	public Object proceed(ProceedingJoinPoint proceedingJoinPoint,ReadOnlyConnection readOnlyConnection) throws Throwable{
		try {
			LOFFER.info("-------set database connection 2 read only ----------------");
			DataBaseContextHolder.setDataBaseType(DataBaseContextHolder.DataBaseType.SLAVE);
			
			//复习此方法
			Object result = proceedingJoinPoint.proceed();
			return result;
		}finally {
			DataBaseContextHolder.clearDataBaseType();
			LOFFER.info("-------clear database connection ----------------");
		}
	}
	
	
	@Override
	public int getOrder() {
		return 0;
	}

}
