package com.thingtrack.myToolbar;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

public class ToolBarPanel extends CustomComponent {

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private ToolbarLayout toolbarLayout_1;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public ToolBarPanel() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
	}

	public ToolbarLayout getToolbarLayout() {
		return toolbarLayout_1;
		
	}
	
	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100px");
		mainLayout.setMargin(false);
		mainLayout.setStyleName("toolbar_layout");
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100px");
		
		// toolbarLayout_1
		toolbarLayout_1 = new ToolbarLayout();
		toolbarLayout_1.setImmediate(false);
		toolbarLayout_1.setWidth("100.0%");
		toolbarLayout_1.setHeight("-1px");
		mainLayout.addComponent(toolbarLayout_1);
		
		return mainLayout;
	}

}