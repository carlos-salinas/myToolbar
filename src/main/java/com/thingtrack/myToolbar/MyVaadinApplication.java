/*
 * Copyright 2009 IT Mill Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.thingtrack.myToolbar;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends Application
{
    private Window mainWindow;
    
    
    private CssLayout toolbarLayout;     
    
    @Override
    public void init()
    {
    	setTheme("konekti");
    	
        mainWindow = new Window("My dynamic toolbar");
        mainWindow.setStyleName("background");

        
       
       toolbarLayout = new CssLayout() {
    	   
    	   int brickCounter = 0;
    	   
    	   @Override
            protected String getCss(Component c) {

    		   // colorize every third rendered brick
               if (c instanceof Brick) {
                   brickCounter++;
                   if (brickCounter % 3 == 0) {
                       // make every third brick colored and italic
                       return "color: #ff6611; font-style: italic;";
                   }
               }
               return null;
            }
    	   
    	   public void removeComponent(Component c) {
    		   
    		   brickCounter--;
    		   super.removeComponent(c);
    	   };
        };

        toolbarLayout.setStyleName("toolbar_layout");
        toolbarLayout.setWidth("100%");

        mainWindow.addComponent(toolbarLayout);
        
        setMainWindow(mainWindow);
        
        //Buttons
        HorizontalLayout buttonLayout = new HorizontalLayout();
        mainWindow.addComponent(buttonLayout);
        
        Button btnAddToolbar = new Button("Add Toolbar");
        btnAddToolbar.addListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {           

//            	toolbarLayout.addComponent(new NavigationToolbar());
//            	toolbarLayout.addComponent(new Brick());
//            	toolbarLayout.addComponent(new SimplifiedNavigationToolbar());
            	CssLayout layout = new CssLayout();
            	layout.setStyleName("toolbar");
            	layout.addComponent(new Button("Bot—n 1"));
            	layout.addComponent(new Button("Bot—n 2"));
            	layout.addComponent(new Button("Bot—n 3"));
            	toolbarLayout.addComponent(layout);
            	
            }
        });
        
        buttonLayout.addComponent(btnAddToolbar);
        
        Button btnBoxToolbar = new Button("Box Toolbar");
        btnBoxToolbar.addListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {     
            	//toolbarLayout2.addToolbar(new BoxToolbar());
            	toolbarLayout.addComponent(new BoxToolbar());
            	
            }
        });
        
        buttonLayout.addComponent(btnBoxToolbar);
        
        Button btnRemoveToolbar = new Button("Remove Toolbar");
        btnRemoveToolbar.addListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) { 
//            	if (toolBarPanel.getToolbarLayout().getToolbars().length == 0)
//            		return;
//            	
//            	Component toolbar = toolBarPanel.getToolbarLayout().getToolbars()[toolBarPanel.getToolbarLayout().getToolbars().length - 1];
//            	
//            	toolbarLayout.removeComponent((CustomComponent) toolbar);
            	
            	if(toolbarLayout.getComponentCount() == 0)
            		return;
            	
            	 toolbarLayout.removeComponent(toolbarLayout.getComponent(toolbarLayout.getComponentCount()-1));
//            	
            }
        });
        
        buttonLayout.addComponent(btnRemoveToolbar);     
    }
    
    /**
     * A simple label containing text "Brick" and themed black square.
     */
    static class Brick extends Label {
        public Brick() {
            super("Brick");
            // disable 100% width that label has by default
            setSizeUndefined();
            setStyleName("brick");
        }
    }
    
}
