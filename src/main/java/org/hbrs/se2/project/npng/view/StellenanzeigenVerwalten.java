package org.hbrs.se2.project.npng.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.controller.exception.DatabaseLayerException;
import org.hbrs.se2.project.npng.entity.Company;
import org.hbrs.se2.project.npng.entity.JobAdvertisement;
import org.hbrs.se2.project.npng.entity.User;
import org.hbrs.se2.project.npng.repository.JobAdvertisementRepository;
import org.hbrs.se2.project.npng.util.Globals;
import org.hbrs.se2.project.npng.view.layoutview.CompanyLayoutView;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Route(value = "StellenanzeigenVerwalten",layout = CompanyLayoutView.class)


public class StellenanzeigenVerwalten extends VerticalLayout {

    private User user = (User) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
    private Company company = user.getCompany();
    JobAdvertisement anzeigeAuswahl = new JobAdvertisement();
    private JobAdvertisementRepository jobAdvertisementRepository;


    public StellenanzeigenVerwalten(JobAdvertisementRepository jobAdvertisementRepository) throws DatabaseLayerException {
        this.jobAdvertisementRepository = jobAdvertisementRepository;
        Grid<JobAdvertisement> grid = new Grid<>(JobAdvertisement.class);
        List<JobAdvertisement> liste = jobAdvertisementRepository.findJobAdvertisementsByCompany_id(company.getId());
        ListDataProvider<JobAdvertisement> dataProvider = new ListDataProvider<>(liste);
        grid.setDataProvider(dataProvider);
        TextField textField = new TextField();
        String str = liste.toString();

        add(str);
    }
    private JobAdvertisement getCurrentAnzeige() {
        UI.getCurrent().getSession().setAttribute( Globals.CURRENT_ANZEIGE, anzeigeAuswahl );
        return (JobAdvertisement) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_ANZEIGE);
    }

}