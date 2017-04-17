package Annotation;

import Annotation.FruitColor.Color;

public class Apple {
	@FruitName("Apple")
	private String appleName;
	
	@FruitColor(fruitColor=Color.RED)
	private String appleColor;
	
	@FruitProvider(id=1,name="bin",address="上海")
	private String appleProvider;
	
	@Rules(notEmpty=true,minLength=4)
	private String tree;

	
	public String getTree() {
		return tree;
	}

	public void setTree(String tree) {
		this.tree = tree;
	}

	public String getAppleName() {
		return appleName;
	}

	public String getAppleColor() {
		return appleColor;
	}

	public String getAppleProvider() {
		return appleProvider;
	}

	public void setAppleName(String appleName) {
		this.appleName = appleName;
	}

	public void setAppleColor(String appleColor) {
		this.appleColor = appleColor;
	}

	public void setAppleProvider(String appleProvider) {
		this.appleProvider = appleProvider;
	}
	
	

}
