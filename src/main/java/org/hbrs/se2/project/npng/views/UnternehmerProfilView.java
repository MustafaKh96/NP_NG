package org.hbrs.se2.project.npng.views;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.views.layoutview.UnternehmerLayoutView;

@Route(value = "UnternehmerProfilView",layout = UnternehmerLayoutView.class)
@PageTitle("No-Pain_No-Gain")

public class UnternehmerProfilView extends VerticalLayout {
    public UnternehmerProfilView(){
        Button profil_bearbeiten = new Button("Profil bearbeiten");
        profil_bearbeiten.addClickListener(e -> navigateToUnternehmerProfilBearbeitenView());
        add(profil_bearbeiten);

    }
    private void navigateToUnternehmerProfilBearbeitenView(){
        UI.getCurrent().navigate(UnternehmerProfilBearbeitenView.class);
    }
}
