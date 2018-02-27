package com.elementa.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface AppResources extends ClientBundle {
    interface Normalize extends CssResource {
    }

    interface Style extends CssResource {
    }

    public interface Theme extends CssResource {
		@ClassName("theme-l1")
		String Light1();
		
		@ClassName("theme-l2")
		String Light2();
		
		@ClassName("theme-l3")
		String Light3();
		
		@ClassName("theme-l4")
		String Light4();
		
		@ClassName("theme-l5")
		String Light5();
		
		@ClassName("theme-d1")
		String Dark1();
		
		@ClassName("theme-d2")
		String Dark2();
		
		@ClassName("theme-d3")
		String Dark3();
		
		@ClassName("theme-d4")
		String Dark4();
		
		@ClassName("theme-d5")
		String Dark5();
		
		@ClassName("theme-light")
		String Light();
		
		@ClassName("theme-dark")
		String Dark();
		
		@ClassName("theme-action")
		String Action();
		
		@ClassName("theme")
		String Base();
		
		@ClassName("text-theme")
		String TextTheme();
		
		@ClassName("theme-border")
		String ThemeBorder();
		
		@ClassName("hover-theme")
		String HoverTheme();
	}
    
    
    @Source("css/normalize.gss")
    Normalize normalize();

    @Source("css/style.gss")
    Style style();
    
    @Source("css/w3.gss")
    W3 w3();
    
    @Source("css/theme.gss")
    Theme theme();
}
