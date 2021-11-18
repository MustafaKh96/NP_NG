package org.hbrs.se2.project.npng.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.views.layoutview.StudentLayoutview;
import org.hbrs.se2.project.npng.views.layoutview.UnternehmerLayoutView;

@Route(value = "UnternehmerView",layout = UnternehmerLayoutView.class)
@PageTitle("No-Pain_No-Gain")

public class UnternehmerView extends VerticalLayout {
    public UnternehmerView(){
    }
}