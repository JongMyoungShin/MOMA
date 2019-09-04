package kr.co.moma.aop;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MomaAspect {
	public static Logger logger = Logger.getLogger(MomaAspect.class.getName());
	   public static final String logMsg = "LogMsg---------------------";
	   
	   @Around(value = "within(kr.co.moma..*)")
	   public Object advice(ProceedingJoinPoint joinPoint)
	   {
	      Object obj=null;
	      
	      try 
	      {
	         logger.info(logMsg+joinPoint.getTarget().getClass().getName());
	         logger.info(logMsg+joinPoint.getSignature().getName());
	         
	         obj=joinPoint.proceed();
	         
	      } catch (Throwable e) 
	      {
	         e.printStackTrace();
	      }
	      
	      return obj;
	   }
}
