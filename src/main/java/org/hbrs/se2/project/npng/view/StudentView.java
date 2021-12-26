package org.hbrs.se2.project.npng.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.view.layoutview.StudentLayoutview;

@Route(value = "StudentView",layout = StudentLayoutview.class)
@PageTitle("No-Pain_No-Gain")

public class StudentView extends VerticalLayout {
    public StudentView(){
    }
}