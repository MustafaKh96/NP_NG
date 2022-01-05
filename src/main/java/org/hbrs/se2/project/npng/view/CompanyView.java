package org.hbrs.se2.project.npng.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.entity.Company;
import org.hbrs.se2.project.npng.entity.JobAdvertisement;
import org.hbrs.se2.project.npng.entity.User;
import org.hbrs.se2.project.npng.util.Globals;
import org.hbrs.se2.project.npng.view.layoutview.CompanyLayoutView;

import java.util.List;

@Route(value = "UnternehmerView",layout = CompanyLayoutView.class)
@PageTitle("No-Pain_No-Gain")

public class CompanyView extends VerticalLayout {
    private User user = (User) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
    private Company company = user.getCompany();
    private JobAdvertisement jobAdvertisement = new JobAdvertisement();

    public CompanyView(){
        Button stellenAnz = new Button("Stellenanzeige Erstellen",new Icon(VaadinIcon.CLIPBOARD_TEXT));
        stellenAnz.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        stellenAnz.addClickListener(e -> navigateToStellenanzeigeErstellen());
        stellenAnz.getStyle().set("width","300px");
        stellenAnz.getStyle().set("height","50px");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(stellenAnz);

        String mienStellenanzeigen = "Meine Stellenanzeigen";

        String Bewcont = "Sie Können Sie Ihre Stellenanzeigen anschauen und bearbeiten. \n"
                + "wählen sie v" ;

        String erg_meineAnzeigen = company.getName();
        Component card2 = createCard(mienStellenanzeigen, erg_meineAnzeigen);

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
        button.addClickListener(e -> navigateToStellenanzeigenVerwalten());

        layout.getElement().getStyle().set("flex-grow", "1");
        layout.add(header, content, button);
        return layout;
    }

    private void navigateToStellenanzeigeErstellen(){
        UI.getCurrent().navigate(StellenanzeigeErstellen.class);
    }
    private void navigateToStellenanzeigenVerwalten(){
        UI.getCurrent().navigate(StellenanzeigenVerwalten.class);
    }
    private JobAdvertisement getCurrentAnzeige() {
        UI.getCurrent().getSession().setAttribute(Globals.CURRENT_ANZEIGE, jobAdvertisement);
        return (JobAdvertisement) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_ANZEIGE);
    }
}