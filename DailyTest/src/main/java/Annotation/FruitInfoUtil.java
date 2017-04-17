package Annotation;

import java.lang.reflect.Field;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.util.StringUtil;

public class FruitInfoUtil {
	  public static void getFruitInfo(Object object) throws RuleExecption, IllegalArgumentException, IllegalAccessException{
	        
		    Class clazz=object.getClass();
	        String strFruitName=" 水果名称：";
	        String strFruitColor=" 水果颜色：";
	        String strFruitProvicer="供应商信息：";
	        String strRule="规则校验结果：";
	        
	        Field[] fields = clazz.getDeclaredFields();
	        
	        for(Field field :fields){
	        	field.setAccessible(true);
	            if(field.isAnnotationPresent(FruitName.class)){
	                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
	                strFruitName=strFruitName+fruitName.value();
	                System.out.println(strFruitName);
	            }
	            else if(field.isAnnotationPresent(FruitColor.class)){
	                FruitColor fruitColor= (FruitColor) field.getAnnotation(FruitColor.class);
	                strFruitColor=strFruitColor+fruitColor.fruitColor().toString();
	                System.out.println(strFruitColor);
	            }
	            else if(field.isAnnotationPresent(FruitProvider.class)){
	                FruitProvider fruitProvider= (FruitProvider) field.getAnnotation(FruitProvider.class);
	                strFruitProvicer=" 供应商编号："+fruitProvider.id()+" 供应商名称："+fruitProvider.name()+" 供应商地址："+fruitProvider.address();
	                System.out.println(strFruitProvicer);
	            }else if(field.isAnnotationPresent(Rules.class)){
	            	//无聊校验下字段
	            	Rules rule= (Rules) field.getAnnotation(Rules.class);
	            	String param = "";
	            	try {
						Object p = field.get(object);
						if(p != null){
							param = p.toString();
						}
						} catch (Exception e) {
						throw new  RuleExecption("系統解异常！");
					}
	            	
	            	if(org.apache.commons.lang.StringUtils.isEmpty(param)){
	            		if(rule.notEmpty()){
	            			throw new RuleExecption(field.getName()+rule.notEmptyMessage());
	            		}else{
	            			System.out.println("判空通过！");
	            			continue;
	            		}
	            	}
	            	if(param.length()<rule.minLength()){
	            		throw new RuleExecption(field.getName()+"要求"+rule.minLengthMessage()+rule.minLength());
	            	}
	            	
	            	strRule=strRule+"校验通过！"+field.getName()+"="+param;
	            	System.out.println(strRule);
	            	
	            }
	            
	            
	        }
	    }

}
