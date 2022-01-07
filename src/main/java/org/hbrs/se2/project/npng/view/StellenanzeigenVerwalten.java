package org.hbrs.se2.project.npng.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.controller.exception.DatabaseLayerException;
import org.hbrs.se2.project.npng.entity.Company;
import org.hbrs.se2.project.npng.entity.JobAdvertisement;
import org.hbrs.se2.project.npng.entity.User;
import org.hbrs.se2.project.npng.repository.CompanyRepository;
import org.hbrs.se2.project.npng.repository.JobAdvertisementRepository;
import org.hbrs.se2.project.npng.util.Globals;
import org.hbrs.se2.project.npng.view.layoutview.CompanyLayoutView;


import java.util.ArrayList;
import java.util.List;


@Route(value = "StellenanzeigenVerwalten",layout = CompanyLayoutView.class)
@CssImport("./themes/nopainnogain/components/ProfilBearbeiten.css")

public class StellenanzeigenVerwalten extends VerticalLayout {

    private TextField title = new TextField("Titel");
    private TextField sector = new TextField("Branche");
    private TextField art = new TextField("Art der Anzeige");
    private DatePicker datum = new DatePicker("Startdatum");
    private TextArea textArea = new TextArea("Beschreibeung");
    private Button zuruck = new Button("Zurück");
    private Button speichern = new Button("speichern");
    private Button loschen = new Button("löschen");

    private User user = (User) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
    private Company company = user.getCompany();
    private JobAdvertisement jobAdvertisement = new JobAdvertisement();
    private JobAdvertisementRepository jobAdvertisementRepository;
    private CompanyRepository companyRepository;
    private JobAdvertisement anzeigeAuswahl = new JobAdvertisement();
    private Dialog dialog5 = new Dialog();
    private Dialog dialog4 = new Dialog();
    private Dialog dialog3 = new Dialog();

    public StellenanzeigenVerwalten(JobAdvertisementRepository jobAdvertisementRepository, CompanyRepository companyRepository) throws DatabaseLayerException {
        this.jobAdvertisementRepository = jobAdvertisementRepository;
        this.companyRepository = companyRepository;
        Grid<JobAdvertisement> grid = new Grid<>();

        grid.addColumn(JobAdvertisement::getTitle).setHeader("Titel").setSortable(true);
        grid.addColumn(JobAdvertisement::getTypeOfJobHiring).setHeader("Art dre Anzeige").setSortable(true);
        grid.addColumn(JobAdvertisement::getSector).setHeader("Branche").setSortable(true);
        grid.addColumn(JobAdvertisement::getStartDate).setHeader("Anfangsdatum").setSortable(true);
        grid.addColumn(JobAdvertisement::getDescription).setHeader("Beschreibung").setSortable(true);
        List<JobAdvertisement> liste = jobAdvertisementRepository.findAllByCompany_id(company.getId());
        ListDataProvider<JobAdvertisement> dataProvider = new ListDataProvider<>(liste);
        grid.setDataProvider(dataProvider);

        grid.addItemClickListener(e ->{
            title.setValue(e.getItem().getTitle());
            art.setValue(e.getItem().getTypeOfJobHiring());
            sector.setValue(e.getItem().getSector());
            datum.setValue(e.getItem().getStartDate());
            textArea.setValue(e.getItem().getDescription());
            jobAdvertisement = e.getItem();
        });
        add(grid);
        Paragraph text4 = new Paragraph("Ihre Anzeige wurde gelöscht.");
        Button closeButton4 = new Button("OK");
        closeButton4.addClickListener(e -> {
            dialog4.close();
            UI.getCurrent().navigate(StellenanzeigenVerwalten.class);
        });
        VerticalLayout layout_dialog4 = new VerticalLayout();
        layout_dialog4.add(text4, closeButton4);
        dialog4.add(layout_dialog4);

        Paragraph text3 = new Paragraph("Ihre Änderung wurde erfolgreich gespeichert.");
        Button closeButton3 = new Button("OK");
        closeButton3.addClickListener(e -> {
            dialog3.close();
            UI.getCurrent().navigate(StellenanzeigenVerwalten.class);
        });
        VerticalLayout layout_dialog3 = new VerticalLayout();
        layout_dialog3.add(text3, closeButton3);
        dialog3.add(layout_dialog3);

        Paragraph text5 = new Paragraph("Möchten Sie Ihre Änderung speichern?");
        Button closeButton5_1 = new Button("nein");
        Button loginButton5_2 = new Button("ja");
        closeButton5_1.addClickListener(e -> dialog5.close());
        loginButton5_2.addClickListener(e -> {
            jobAdvertisement.setTitle(title.getValue());
            jobAdvertisement.setStartDate(datum.getValue());
            jobAdvertisement.setDescription(textArea.getValue());
            jobAdvertisement.setTypeOfJobHiring(art.getValue());
            jobAdvertisement.setSector(sector.getValue());
            dialog5.close();
            dialog3.open();
        });
        HorizontalLayout layout_h_dialog5 = new HorizontalLayout();
        layout_h_dialog5.add(closeButton5_1,loginButton5_2);
        VerticalLayout layout_dialog5 = new VerticalLayout();
        layout_dialog5.add(text5, layout_h_dialog5);
        dialog5.add(layout_dialog5);
        speichern.addClickListener(e -> dialog5.open());

        FormLayout layout_1 = new FormLayout();
        textArea.getStyle().set("minHeight", "200px");
        layout_1.add(title, sector);
        layout_1.add(art, datum);
        layout_1.add(textArea, 4);
        HorizontalLayout buttonLayout = new HorizontalLayout(zuruck,speichern,loschen);
        layout_1.add(buttonLayout);
        zuruck.setId("cancel_save");
        speichern.setId("cancel_save");
        loschen.setId("cancel_save");
        zuruck.addClickListener(e -> UI.getCurrent().navigate(CompanyView.class));
        speichern.addClickListener(e -> speichern());
        loschen.addClickListener(e -> {
            dialog4.open();
            jobAdvertisementRepository.delete(jobAdvertisement);
            dataProvider.refreshAll();
        });
        add(layout_1);
    }
    private JobAdvertisement getCurrentAnzeige() {
        UI.getCurrent().getSession().setAttribute( Globals.CURRENT_ANZEIGE, anzeigeAuswahl );
        return (JobAdvertisement) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_ANZEIGE);
    }
    private void speichern() {
        JobAdvertisement advertisement = new JobAdvertisement();
        List<JobAdvertisement> list = new ArrayList<>();
        jobAdvertisement.setTitle(title.getValue());
        jobAdvertisement.setSector(sector.getValue());
        jobAdvertisement.setStartDate(datum.getValue());
        jobAdvertisement.setTypeOfJobHiring(art.getValue());
        jobAdvertisement.setDescription(textArea.getValue());
        jobAdvertisement.setCompany(company);
        list.add(jobAdvertisement);
        company.setJobAdvertisements(list);
        jobAdvertisementRepository.save(jobAdvertisement);
        companyRepository.save(company);
    }

}