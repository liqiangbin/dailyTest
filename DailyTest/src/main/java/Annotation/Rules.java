package Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Rules {
	public boolean notEmpty() default false;
	public String notEmptyMessage() default "不能为空";
	
	public int minLength() default 0;
	public String minLengthMessage() default "最小长度为";
	
	

}
