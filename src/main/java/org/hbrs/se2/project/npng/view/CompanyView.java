package org.hbrs.se2.project.npng.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
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


@Route(value = "UnternehmerView",layout = CompanyLayoutView.class)
@PageTitle("No-Pain_No-Gain")
@CssImport("./themes/nopainnogain/components/ProfilBearbeiten.css")

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
        setHorizontalComponentAlignment(Alignment.CENTER, stellenAnz);
        add(stellenAnz);

        H2 mienStellenanzeigen = new H2("Meine Stellenanzeigen");
        H2 bewerbungen =  new H2("Bewerbungen");

        bewerbungen.setWidth("100%");
        mienStellenanzeigen.setWidth("100%");
        String Bewcont = "<div>Sie Können Sie Ihre Stellenanzeigen anschauen und<br>bearbeiten (ändern, löschen usw.).</div>";
        String Bewcont2 = "<div>Sie Können Ihre erhaltenen Bewerbungen<br>anschauen und den pas  senden Studenten finden.</div>";
        Html html = new Html(Bewcont);
        Html html2 = new Html(Bewcont2);
        VerticalLayout layout11 = new VerticalLayout();
        layout11.add(mienStellenanzeigen);
        //layout11.setHorizontalComponentAlignment(Alignment.CENTER, mienStellenanzeigen);
        layout11.add(html);
        Button b1 = new Button("Details anzeigen");
        b1.setId("cancel_save");
        //layout11.setHorizontalComponentAlignment(Alignment.CENTER, b1);
        b1.addClickListener(e -> UI.getCurrent().navigate(StellenanzeigenVerwalten.class));
        layout11.add(b1);

        VerticalLayout layout12 = new VerticalLayout();
        layout12.add(bewerbungen);
        //layout12.setHorizontalComponentAlignment(Alignment.CENTER, bewerbungen);
        layout12.add(html2);
        Button b2 = new Button("Details anzeigen");
        b2.setId("cancel_save");
        //layout12.setHorizontalComponentAlignment(Alignment.CENTER, b2);
        //b2.addClickListener(e -> UI.getCurrent().navigate(  ));
        layout12.add(b2);
        HorizontalLayout h_layout1 = new HorizontalLayout();
        h_layout1.add(layout11, layout12);
        //setHorizontalComponentAlignment(Alignment.CENTER, h_layout1);
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