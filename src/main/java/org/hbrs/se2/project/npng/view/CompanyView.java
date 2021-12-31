package org.hbrs.se2.project.npng.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.hbrs.se2.project.npng.view.layoutview.CompanyLayoutView;
import org.hbrs.se2.project.npng.view.layoutview.StartSeiteLayout;

@Route(value = "UnternehmerView",layout = CompanyLayoutView.class)
//@RouteAlias(value ="", layout = CompanyLayoutView.class)
@PageTitle("No-Pain_No-Gain")

public class CompanyView extends VerticalLayout {
    public CompanyView(){


        // Überschriften:
        H3 h4_1 = new H3("Finden Sie den passenden Mitarbeiter ! ");
        h4_1.setId("h4_1");
        add(h4_1);


        Button stellenAnz = new Button("Stellenanzeige Erstellen",new Icon(VaadinIcon.CLIPBOARD_TEXT));
        stellenAnz.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        stellenAnz.addClickListener(e -> navigateToStellenanzeigeErstellen());
        add(stellenAnz);



        String Bew = "Meine Stellenanzeigen";
        String Bewcont = "Donec id elit non mi porta gravida at eget"
                + " metus. Fusce dapibus, tellus ac cursus commodo, tortor"
                + " mauris condimentum nibh, ut fermentum massa justo sit amet "
                + "risus. Etiam porta sem malesuada magna mollis  euismod. "
                + "Donec sed odio dui.";


        Component card2 = createCard(Bew, Bewcont);

        HorizontalLayout h_layout1 = new HorizontalLayout();
        h_layout1.add( card2);
        add(h_layout1);
    }
    private Component createCard(String cardHeader, String cardContent) {
        VerticalLayout layout = new VerticalLayout();
        layout.setWidth("30%");
        layout.setMinWidth("250px");

        H2 header = new H2(cardHeader);
        Div content = new Div();
        content.setText(cardContent);

        Button button = new Button("View details",
                new Icon(VaadinIcon.ANGLE_DOUBLE_RIGHT));
        button.addThemeVariants(ButtonVariant.LUMO_SMALL);

        layout.getElement().getStyle().set("flex-grow", "1");
        layout.add(header, content, button);
        return layout;
    }

    private void navigateToStellenanzeigeErstellen(){
        UI.getCurrent().navigate(StellenanzeigeErstellen.class);
    }
}