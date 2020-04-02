package org.vaadin.johannes.components;

import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.Route;
import org.vaadin.johannes.components.dialogs.MyDialog;

@Route("my-view")
public class MyView extends Main {

	public MyView() {
		new MyDialog().open();
	}
}
