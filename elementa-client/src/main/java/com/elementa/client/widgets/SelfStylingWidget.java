package com.elementa.client.widgets;

/**
 * Interface used to simplify widget styling.
 * 
 * @author Jake Shilling
 * @version 0.1
 *
 */
public interface SelfStylingWidget {
	
	public WidgetStyler getStyler();
	
	/**
	 * Add a style to this widget's list
	 * of styles.
	 * 
	 * @param name			Name of the style to add
	 */
	default public void addStyle(String name) {
		this.getStyler().addStyle(name);
		this.getStyler().setStyles();
	}
	
	/**
	 * Add multiple styles to this widget's list
	 * of styles
	 * 
	 * @param names
	 */
	default public void addStyle(String... names) {
		this.getStyler().addStyle(names);
		this.getStyler().setStyles();
	}
	
	/**
	 * Remove a style from this widget's list.
	 * 
	 * @param name		Style to remove
	 */
	default public void delStyle(String name) {
		this.getStyler().delStyle(name);
		this.getStyler().setStyles();
	}
}
