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
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.theme.lumo.Lumo;

@CssImport("./styles/my-dialog.css")
public class MyDialog extends Dialog {

	public String DOCK = "dock";
	public String FULLSCREEN = "fullscreen";

	private boolean isDocked = false;
	private boolean isFullScreen = false;

	private Header header;
	private Button min;
	private Button max;

	private Div content;
	private Footer footer;

	public MyDialog() {
		setDraggable(true);
		setModal(false);
		setResizable(true);

		// Dialog theming
		getElement().getThemeList().add("my-dialog");
		setWidth("600px");

		// Accessibility
		getElement().setAttribute("aria-labelledby", "dialog-title");

		// Header
		H2 title = new H2("New message");
		title.addClassName("dialog-title");

		min = new Button(VaadinIcon.DOWNLOAD_ALT.create());
		min.addClickListener(event -> minimise());

		max = new Button(VaadinIcon.EXPAND_SQUARE.create());
		max.addClickListener(event -> maximise());

		Button close = new Button(VaadinIcon.CLOSE_SMALL.create());
		close.addClickListener(event -> close());

		header = new Header(title, min, max, close);
		header.getElement().getThemeList().add(Lumo.DARK);
		add(header);

		// Content
		TextField recipients = new TextField("Recipients");
		TextField subject = new TextField("Subject");
		TextArea message = new TextArea();
		message.setMinHeight("200px");

		content = new Div(recipients, subject, message);
		content.addClassName("dialog-content");
		add(content);

		// Footer
		Button send = new Button("Send");
		send.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		Button attachFiles = new Button(VaadinIcon.PAPERCLIP.create());
		Button discardDraft = new Button(VaadinIcon.TRASH.create());

		footer = new Footer(send, attachFiles, discardDraft);
		add(footer);

		// Button theming
		for (Button button : new Button[] {min, max, close, attachFiles, discardDraft}) {
			button.addThemeVariants(ButtonVariant.LUMO_CONTRAST, ButtonVariant.LUMO_TERTIARY);
		}
	}

	private void minimise() {
		isDocked = !isDocked;
		if (isDocked) {
			min.setIcon(VaadinIcon.UPLOAD_ALT.create());
			getElement().getThemeList().add(DOCK);
			setWidth("320px");
		} else {
			min.setIcon(VaadinIcon.DOWNLOAD_ALT.create());
			getElement().getThemeList().remove(DOCK);
			setWidth("600px");
		}
		content.setVisible(!isDocked);
		footer.setVisible(!isDocked);
	}

	private void maximise() {
		isFullScreen = !isFullScreen;
		if (isFullScreen) {
			max.setIcon(VaadinIcon.COMPRESS_SQUARE.create());
			getElement().getThemeList().add(FULLSCREEN);
			setSizeFull();
		} else {
			max.setIcon(VaadinIcon.EXPAND_SQUARE.create());
			getElement().getThemeList().remove(FULLSCREEN);
			setHeight("auto");
			setWidth("600px");
		}
	}
}
