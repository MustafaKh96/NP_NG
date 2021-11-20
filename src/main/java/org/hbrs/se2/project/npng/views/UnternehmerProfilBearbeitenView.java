package org.hbrs.se2.project.npng.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.views.layoutview.UnternehmerLayoutView;

import java.util.HashMap;
import java.util.Map;

@Route(value = "UnternehmerProfilBearbeitenView",layout = UnternehmerLayoutView.class)
@CssImport("./themes/nopainnogain/components/ProfilBearbeiten.css")
@PageTitle("No-Pain_No-Gain")
public class UnternehmerProfilBearbeitenView extends VerticalLayout {

    private TextField unternehmername = new TextField("Unternehmensname");
    private EmailField email = new EmailField("E-Mail Adresse");
    private PhoneNumberField phone = new PhoneNumberField("Telefonnummer");
    private TextField adresse = new TextField("Straße und Hausnummer");
    private NumberField postleitzahl = new NumberField("Postleitzahl");
    private TextField ort = new TextField("Ort");
    private TextField branche = new TextField("Branche");
    private Button cancel = new Button("Abbrechen");
    private Button save = new Button("Speichern");
    private Button cancel1 = new Button("Abbrechen");
    private Button save1 = new Button("Speichern");

    public UnternehmerProfilBearbeitenView(){
        SeiteView();
    }
    private void SeiteView() {

        Tab tab1 = new Tab("Unternehmensangaben");
        Div page1 = new Div();
        page1.add(Unternehmen_Angaben(),Buttons_1());

        Tab tab2 = new Tab("Unternehmensbeschreibung");
        Div page2 = new Div();
        page2.add(unternehmensbeschreibung(), Buttons_2());
        page2.setVisible(false);

        Map<Tab, Component> tabsToPages = new HashMap<>();
        tabsToPages.put(tab1, page1);
        tabsToPages.put(tab2, page2);
        Tabs tabs = new Tabs(tab1, tab2);
        Div pages = new Div(page1, page2);

        tabs.addSelectedChangeListener(event -> {
            tabsToPages.values().forEach(page -> page.setVisible(false));
            Component selectedPage = tabsToPages.get(tabs.getSelectedTab());
            selectedPage.setVisible(true);
        });

        add(tabs, pages);
    }

    private Component Unternehmen_Angaben() {
        FormLayout layout_1 = new FormLayout();
        layout_1.add(unternehmername, email, phone, adresse, postleitzahl, ort);
        layout_1.add(branche, 2);
        return layout_1;
    }

    private Component unternehmensbeschreibung(){
        TextArea textArea = new TextArea("Beschreibung");
        textArea.setPlaceholder("Schreiben Sie hier ... ");
        textArea.getStyle().set("minWidth", "1400px");
        textArea.getStyle().set("minHeight", "400px");
        return textArea;
    }

    private Component Buttons_1(){
        HorizontalLayout layout_1 = new HorizontalLayout();
        cancel.setId("cancel_save");
        save.setId("cancel_save");
        layout_1.add(cancel,save);
        return layout_1;
    }
    private Component Buttons_2(){
        HorizontalLayout layout_1 = new HorizontalLayout();
        cancel1.setId("cancel_save");
        save1.setId("cancel_save");
        layout_1.add(cancel1,save1);
        return layout_1;
    }


    private static class PhoneNumberField extends CustomField<String> {
        private ComboBox<String> countryCode = new ComboBox<>();
        private TextField number = new TextField();


        public PhoneNumberField(String label) {
            setLabel(label);
            countryCode.setWidth("120px");
            countryCode.setPlaceholder("Country");
            countryCode.setPattern("\\+\\d*");
            countryCode.setPreventInvalidInput(true);
            countryCode.setItems("+49", "+30", "+31", "+32", "+33", "+350", "+351", "+352", "+353", "+354", "+355", "+359");
            countryCode.addCustomValueSetListener(e -> countryCode.setValue(e.getDetail()));
            number.setPattern("\\d*");
            number.setPreventInvalidInput(true);
            HorizontalLayout layout = new HorizontalLayout(countryCode, number);
            layout.setFlexGrow(1.0, number);
            add(layout);
        }


        @Override
        protected String generateModelValue() {
            if (countryCode.getValue() != null && number.getValue() != null) {
                String s = countryCode.getValue() + " " + number.getValue();
                return s;
            }
            return "";
        }

        @Override
        protected void setPresentationValue(String phoneNumber) {
            String[] parts = phoneNumber != null ? phoneNumber.split(" ", 2) : new String[0];
            if (parts.length == 1) {
                countryCode.clear();
                number.setValue(parts[0]);
            } else if (parts.length == 2) {
                countryCode.setValue(parts[0]);
                number.setValue(parts[1]);
            } else {
                countryCode.clear();
                number.clear();
            }
        }
    }
}