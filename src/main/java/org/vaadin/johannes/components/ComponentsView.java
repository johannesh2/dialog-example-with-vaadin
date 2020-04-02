
package org.vaadin.johannes.components;

import java.time.Duration;
import java.time.LocalDateTime;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller.ScrollDirection;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;

@Route
public class ComponentsView extends VerticalLayout {

    public ComponentsView() {
        DateTimePicker dateTimePicker = new DateTimePicker();
        dateTimePicker.setMin(LocalDateTime.now());
        dateTimePicker.setStep(Duration.ofMinutes(30));
        dateTimePicker.setDatePlaceholder("Pick a date");
        dateTimePicker.setTimePlaceholder("Pick a time");

        add(dateTimePicker);

        Dialog dialog = new Dialog();
        dialog.setResizable(true);
        dialog.setModal(false);
        dialog.setDraggable(true);

        HorizontalLayout header = new HorizontalLayout();
        Label caption = new Label("My dialog");
        caption.setClassName("draggable");
        header.setFlexGrow(1, caption);
        header.setAlignItems(Alignment.CENTER);
        Button close = new Button(new Icon(VaadinIcon.CLOSE), event -> {
            dialog.close();
        });
        close.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_TERTIARY);
        header.add(caption, close);

        VerticalLayout content = new VerticalLayout();
        content.setPadding(false);
        content.setMinWidth("320px");
        content.setMinHeight("200px");
        content.add(new Span("My dialog content"));

        dialog.add(header, content);

        Button openButton = new Button("Click", event -> dialog.open());
        add(openButton);
        setSizeFull();

    }
}