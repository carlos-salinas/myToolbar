package com.thingtrack.myToolbar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.vaadin.csstools.RenderInfo;
import org.vaadin.csstools.RenderInfo.Callback;
import org.vaadin.csstools.client.VRenderInfoFetcher.CssProperty;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ToolbarLayout extends CustomComponent implements IToolbarLayout {

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout dockHorizontalLayout;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	private float toolbarWidth = 0f; 
	private float totalWidth = 0f;
	
	private List<HorizontalLayout> dockHorizontalLayouts = new ArrayList<HorizontalLayout>();
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public ToolbarLayout() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
	}	

	@Override
	public void addToolbar(final CustomComponent toolbar) {
		RenderInfo.get(this, new Callback() {
	        public void infoReceived(RenderInfo info) {
                // Use the info. All the properties are returned as Strings, e.g. "123px"
        		String width = info.getProperty(CssProperty.width);
                width = width.replaceAll("[a-z]", "");
                
                toolbarWidth = Float.parseFloat(width);
                @SuppressWarnings("unused")
				String xxx = "";
	        }
		});
		
		totalWidth = totalWidth + toolbar.getWidth();
		
		// add a new dock layout is the number excede the maximun size
		if (toolbarWidth != 0 && toolbarWidth < totalWidth) {
			HorizontalLayout dockHorizontalLayout = new HorizontalLayout();
			dockHorizontalLayout.setImmediate(true);
			dockHorizontalLayout.setWidth("100.0%");
			dockHorizontalLayout.setHeight("100.0%");
			dockHorizontalLayout.setMargin(false);
			
			mainLayout.addComponent(dockHorizontalLayout);
			
			dockHorizontalLayouts.add(dockHorizontalLayout);
			
			// reset values
			toolbarWidth = 0;
			totalWidth = toolbar.getWidth();
			
		}
			
		// add toolbars to the last dock component
		HorizontalLayout lastDockLayout = dockHorizontalLayouts.get(dockHorizontalLayouts.size() - 1);		
		lastDockLayout.addComponent(toolbar);
		
	}
		
	@Override
	public void addToolbar(CustomComponent toolbar, int index) {
		dockHorizontalLayout.addComponent(toolbar, index);
		
	}
	
	@Override
	public void removeToolbar(CustomComponent toolbar) {
		dockHorizontalLayout.removeComponent(toolbar);
		
	}
	
	@Override
	public CustomComponent[] getToolbars() {
		List<CustomComponent> result = new ArrayList<CustomComponent>();
		@SuppressWarnings("rawtypes")
		Iterator iterator = dockHorizontalLayout.getComponentIterator();
		
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
		return dockHorizontalLayout;
		
	}
	
	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("-1px");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("-1px");
		setHeight("30px");
		
		// dockHorizontalLayout
		dockHorizontalLayout = new HorizontalLayout();
		dockHorizontalLayout.setImmediate(true);
		dockHorizontalLayout.setWidth("100.0%");
		dockHorizontalLayout.setHeight("100.0%");
		dockHorizontalLayout.setMargin(false);
				
		mainLayout.addComponent(dockHorizontalLayout);
		
		dockHorizontalLayouts.add(dockHorizontalLayout);
		
		return mainLayout;
	}

}
