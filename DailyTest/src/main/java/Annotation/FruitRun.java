package Annotation;

public class FruitRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple apple=new Apple();
		apple.setAppleColor("pink");
		apple.setAppleName("small apple");
		apple.setAppleProvider("Bin");
		apple.setTree("tree");
		
	    try {
			FruitInfoUtil.getFruitInfo(apple);
		} catch (RuleExecption e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
//			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
