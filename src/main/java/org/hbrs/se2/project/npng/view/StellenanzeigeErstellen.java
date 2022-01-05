package org.hbrs.se2.project.npng.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.entity.Company;
import org.hbrs.se2.project.npng.entity.JobAdvertisement;
import org.hbrs.se2.project.npng.entity.User;
import org.hbrs.se2.project.npng.repository.CompanyRepository;
import org.hbrs.se2.project.npng.repository.JobAdvertisementRepository;
import org.hbrs.se2.project.npng.util.Globals;
import org.hbrs.se2.project.npng.view.layoutview.CompanyLayoutView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Route(value = "StellenanzeigeErstellen",layout = CompanyLayoutView.class)
@PageTitle("No-Pain_No-Gain")
@CssImport("./themes/nopainnogain/components/ProfilBearbeiten.css")

public class StellenanzeigeErstellen extends VerticalLayout {

    private TextField title = new TextField("Titel");
    private TextField sector = new TextField("Branche");
    private TextField art = new TextField("Art der Anzeige");
    DatePicker datum = new DatePicker("Startdatum");
    TextArea textArea = new TextArea("Beschreibeung");

    private Button cancel = new Button("Zurück");
    private Button save = new Button("Online erstellen");

    private User user = (User) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
    private Company company = user.getCompany();
    private JobAdvertisement jobAdvertisement = new JobAdvertisement();
    private JobAdvertisementRepository jobAdvertisementRepository;
    private CompanyRepository companyRepository;
    private Dialog dialog5 = new Dialog();
    private Dialog dialog4 = new Dialog();

    public StellenanzeigeErstellen(JobAdvertisementRepository jobAdvertisementRepository, CompanyRepository companyRepository){
        this.jobAdvertisementRepository = jobAdvertisementRepository;
        this.companyRepository = companyRepository;

        Paragraph text4 = new Paragraph("Geben Sie bitte alle Angaben Ihrer Anzeige an.");
        Button closeButton4 = new Button("OK");
        closeButton4.addClickListener(e -> dialog4.close());
        VerticalLayout layout_dialog4 = new VerticalLayout();
        layout_dialog4.add(text4, closeButton4);
        dialog4.add(layout_dialog4);

        Paragraph text5 = new Paragraph("Glückwunsch, Ihre Anzeige ist jetzt online :)");
        Button closeButton5_1 = new Button("Zurück zur Startseite");
        closeButton5_1.addClickListener(e -> dialo_5());
        VerticalLayout layout_dialog5 = new VerticalLayout();

        layout_dialog5.add(text5, closeButton5_1);
        dialog5.add(layout_dialog5);

        FormLayout layout_1 = new FormLayout();
        layout_1.getStyle().set("margin-left", "25vw");
        layout_1.getStyle().set("margin-right", "25vw");
        textArea.getStyle().set("minHeight", "200px");

        layout_1.add(title, sector);
        layout_1.add(art, 2);
        layout_1.add(datum, 2);
        layout_1.add(textArea, 4);
        HorizontalLayout buttonLayout = new HorizontalLayout(cancel,save);
        layout_1.add(buttonLayout);
        cancel.setId("cancel_save");
        save.setId("cancel_save");
        save.addClickListener(e -> dialogs());
        cancel.addClickListener(e -> UI.getCurrent().navigate(CompanyView.class));
        add(layout_1);
    }

    private void speichern() {
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

    public void dialogs(){
        if(title.getValue() == null || sector.getValue() == null || art.getValue() == null || datum.getValue() == null || textArea == null){
            dialog4.open();
        }
        else{
            speichern();
            dialog5.open();
        }
    }

    public void dialo_5(){
        UI.getCurrent().navigate(CompanyView.class);
        dialog5.close();
    }

}