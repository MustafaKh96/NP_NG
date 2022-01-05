package org.hbrs.se2.project.npng.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.apache.commons.lang3.StringUtils;
import org.hbrs.se2.project.npng.entity.JobAdvertisement;
import org.hbrs.se2.project.npng.repository.JobAdvertisementRepository;
import org.hbrs.se2.project.npng.view.layoutview.StudentLayoutview;

import java.util.List;

@Route(value = "StudentView",layout = StudentLayoutview.class)
@PageTitle("No-Pain_No-Gain")

public class StudentView extends VerticalLayout {
    private JobAdvertisementRepository jobAdvertisementRepository;
    public StudentView(JobAdvertisementRepository jobAdvertisementRepository){

        this.jobAdvertisementRepository = jobAdvertisementRepository;
        HorizontalLayout h_layout = new HorizontalLayout();
        VerticalLayout v_layout = new VerticalLayout();

        List<JobAdvertisement> liste = jobAdvertisementRepository.findAll();
        ListDataProvider<JobAdvertisement> dataProvider = new ListDataProvider<>(liste);

        // Überschriften:
        H1 h4_1 = new H1("Finden Sie Ihren Traumjob ! ");
        h4_1.setId("h4_1");
        setHorizontalComponentAlignment(Alignment.CENTER, h4_1);
        //Titel
        TextField comboNachWas = new TextField();
        comboNachWas.setPlaceholder("Titel");
        TextField comboNachWas2 = new TextField();
        comboNachWas2.setPlaceholder("Art der Suche");
        TextField comboNachWas3 = new TextField();
        comboNachWas3.setPlaceholder("Branche");

        Grid<JobAdvertisement> grid = new Grid<>(JobAdvertisement.class, false);
        grid.addColumn(JobAdvertisement::getTitle).setHeader("Titel").setSortable(true);
        grid.addColumn(JobAdvertisement::getTypeOfJobHiring).setHeader("Art dre Anzeige").setSortable(true);
        grid.addColumn(JobAdvertisement::getSector).setHeader("Branche").setSortable(true);
        grid.addColumn(JobAdvertisement::getStartDate).setHeader("Anfangsdatum").setSortable(true);
        grid.addColumn(JobAdvertisement::getDescription).setHeader("Beschreibung").setSortable(true);
        grid.setDataProvider(dataProvider);

        comboNachWas.addValueChangeListener(event -> dataProvider.addFilter(
                c -> StringUtils.containsIgnoreCase(c.getTitle(), comboNachWas.getValue())));
        comboNachWas.setValueChangeMode(ValueChangeMode.EAGER);
        comboNachWas.setSizeFull();

        comboNachWas2.addValueChangeListener(event -> dataProvider.addFilter(
                c -> StringUtils.containsIgnoreCase(c.getTypeOfJobHiring(), comboNachWas2.getValue())));
        comboNachWas2.setValueChangeMode(ValueChangeMode.EAGER);
        comboNachWas2.setSizeFull();

        comboNachWas3.addValueChangeListener(event -> dataProvider.addFilter(
                c -> StringUtils.containsIgnoreCase(c.getSector(), comboNachWas3.getValue())));
        comboNachWas3.setValueChangeMode(ValueChangeMode.EAGER);
        comboNachWas3.setSizeFull();


        add(h4_1);
        h_layout.add(comboNachWas ,comboNachWas2 ,comboNachWas3);
        setHorizontalComponentAlignment(Alignment.CENTER, h_layout);
        add(h_layout);
        add(grid);


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




}