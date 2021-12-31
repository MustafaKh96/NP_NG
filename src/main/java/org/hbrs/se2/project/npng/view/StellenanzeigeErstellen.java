package org.hbrs.se2.project.npng.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.controller.LoginController;
import org.hbrs.se2.project.npng.controller.exception.DatabaseUserException;
import org.hbrs.se2.project.npng.dto.UserDTO;
import org.hbrs.se2.project.npng.entity.User;
import org.hbrs.se2.project.npng.util.Globals;
import org.hbrs.se2.project.npng.view.layoutview.CompanyLayoutView;
import org.springframework.beans.factory.annotation.Autowired;


@Route(value = "StellenanzeigeErstellen",layout = CompanyLayoutView.class)
@PageTitle("No-Pain_No-Gain")


public class StellenanzeigeErstellen extends VerticalLayout {

    private TextField title = new TextField("Title");
    private TextField sector = new TextField("Branche");
    private TextField art = new TextField("Art der Anzeige");
    DatePicker datum = new DatePicker("Start date");
    TextArea textArea = new TextArea("Description");

    private Button cancel = new Button("Abbrechen");
    private Button save = new Button("Stellenanzeige Erstellen");

    public StellenanzeigeErstellen(){
        FormLayout layout_1 = new FormLayout();
        layout_1.getStyle().set("margin-left", "25vw");
        layout_1.getStyle().set("margin-right", "25vw");

        layout_1.add(title, sector);
        layout_1.add(art, 2);
        layout_1.add(datum, 2);
        layout_1.add(textArea, 4);


        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        HorizontalLayout buttonLayout = new HorizontalLayout(cancel,save);
        buttonLayout.getStyle().set("flex-wrap", "wrap");
        buttonLayout.setJustifyContentMode(JustifyContentMode.CENTER);


        layout_1.add(buttonLayout);
        add(layout_1);
    }
}
