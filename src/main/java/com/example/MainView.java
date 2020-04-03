package org.vaadin.johannes;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.johannes.components.dialogs.MyDialog;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean. Use the @PWA
 * annotation make the application installable on phones, tablets and some
 * desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 */
@Route
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
@CssImport(value = "./styles/dialog-overlay.css", themeFor = "vaadin-dialog-overlay")
public class MainView extends VerticalLayout {

    MyDialog myDialog;

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     */
    public MainView() {

        // Button click listeners can be defined as lambda expressions
        Button button = new Button("Open demo dialog", event -> openTheDialog());
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(button);
    }

    private void openTheDialog() {
        if (myDialog != null) {
            myDialog.close();
        }
        myDialog = new MyDialog();
        myDialog.open();
    }

}
