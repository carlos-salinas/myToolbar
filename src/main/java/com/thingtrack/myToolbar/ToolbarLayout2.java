package com.thingtrack.myToolbar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;

@SuppressWarnings("serial")
public class ToolbarLayout2 extends CssLayout implements IToolbarLayout {

	@Override
	public void addToolbar(CustomComponent toolbar) {
		toolbar.addStyleName("toolbar");
		addComponent(toolbar);
		
	}

	@Override
	public void addToolbar(CustomComponent toolbar, int index) {
		toolbar.addStyleName("toolbar");
		addComponent(toolbar, index);
		
	}

	@Override
	public void removeToolbar(CustomComponent toolbar) {
		removeComponent(toolbar);
		
	}

	@Override
	public CustomComponent[] getToolbars() {
		List<CustomComponent> result = new ArrayList<CustomComponent>();
		@SuppressWarnings("rawtypes")
		Iterator iterator = getComponentIterator();
		
		while(iterator.hasNext()){
			
			Component component = (Component) iterator.next();
			if(component instanceof CustomComponent){
				result.add((CustomComponent) component);
			}
		}
		
		CustomComponent[] resultToArray = new CustomComponent[result.size()];
		return result.toArray(resultToArray);
	}

	@Override
	public ComponentContainer getContent() {
		return this;
	}

}
