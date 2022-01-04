package org.hbrs.se2.project.npng.view.layoutview;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hbrs.se2.project.npng.view.UnternehmerProfilView;



public class CompanyLayoutView extends AppLayout {
    MenuBar menuBar = new MenuBar();


    public CompanyLayoutView(){
        addToNavbar(createHeaderContent(),createHeaderContent_1());
    }

    private Component createHeaderContent(){
        //Image erstellen:
        HorizontalLayout layout = new HorizontalLayout();
        Image img = new Image();
        img.setSrc("images/NpNg.png");
        img.setId("imgNpNg_Layout");
        img.setHeight("60px");
        layout.add(img);

        return layout;
    }

    private Component createHeaderContent_1(){
        //MenuBar erstellen:
        MenuBar menuBar = new MenuBar();
        MenuItem project = menuBar.addItem(new Icon(VaadinIcon.LINES));
        SubMenu projectSubMenu = project.getSubMenu();
        MenuItem home = projectSubMenu.addItem(new Button("Home",new Icon(VaadinIcon.HOME)));
        MenuItem einstellungen = projectSubMenu.addItem(new Button("Einstellung",new Icon(VaadinIcon.COG)));
        MenuItem anzeigen = projectSubMenu.addItem(new Button("Meine Anzeigen",new Icon(VaadinIcon.CLIPBOARD_TEXT)));
        MenuItem bewerbungen = projectSubMenu.addItem(new Button("Bewerbungen",new Icon(VaadinIcon.ENVELOPES)));
        MenuItem logout = projectSubMenu.addItem(new Button("Logout",new Icon(VaadinIcon.SIGN_OUT)),e -> logoutUser());
        Button meinProfil = new Button("Unternehmer Profil",new Icon(VaadinIcon.USER));

        meinProfil.addClickListener(e -> navigateToUnternehmerProfilView());
        // Layout:
        HorizontalLayout layout = new HorizontalLayout();
        layout.add(meinProfil,menuBar);
        layout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(layout);
        verticalLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.END);
        return verticalLayout;
    }

    private void logoutUser() {
        UI ui = this.getUI().get();
        ui.getSession().close();
        ui.getPage().setLocation("/");
    }
    private void navigateToUnternehmerProfilView(){
        UI.getCurrent().navigate(UnternehmerProfilView.class);
    }
}