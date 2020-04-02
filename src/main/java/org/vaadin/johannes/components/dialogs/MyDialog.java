package org.vaadin.johannes.components.dialogs;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.richtexteditor.RichTextEditor;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.theme.lumo.Lumo;

@CssImport("./styles/my-dialog.css")
public class MyDialog extends Dialog {

	public MyDialog() {
		// Dialog theming
		getElement().getThemeList().add("my-dialog");
		setWidth("600px");

		// Accessibility
		getElement().setAttribute("aria-labelledby", "dialog-title");

		// Header
		H2 title = new H2("New message");
		title.addClassName("dialog-title");

		Button min = new Button(VaadinIcon.COMPRESS_SQUARE.create());
		Button max = new Button(VaadinIcon.EXPAND_SQUARE.create());
		max.addClickListener(event -> this.setSizeFull());
		Button close = new Button(VaadinIcon.CLOSE_SMALL.create());

		Header header = new Header(title, min, max, close);
		header.getElement().getThemeList().add(Lumo.DARK);
		add(header);

		// Content
		TextField recipients = new TextField("Recipients");
		TextField subject = new TextField("Subject");
		RichTextEditor message = new RichTextEditor();
		message.setValue("\n\nJohannes Häyry, PMM\nvaadin.com - +358 44 356 4403");

		Div content = new Div(recipients, subject, message);
		content.addClassName("dialog-content");
		add(content);

		// Footer
		Button send = new Button("Send");
		send.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		Button attachFiles = new Button(VaadinIcon.PAPERCLIP.create());
		Button discardDraft = new Button(VaadinIcon.TRASH.create());

		Footer footer = new Footer(send, attachFiles, discardDraft);
		add(footer);

		// Button theming
		for (Button button : new Button[] {min, max, close, attachFiles, discardDraft}) {
			button.addThemeVariants(ButtonVariant.LUMO_CONTRAST, ButtonVariant.LUMO_TERTIARY);
		}
	}
}
