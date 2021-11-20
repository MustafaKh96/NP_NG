package org.hbrs.se2.project.npng.views;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.views.layoutview.StudentLayoutview;

import java.util.HashMap;
import java.util.Map;

@Route(value = "StudentProfilBearbeiten", layout = StudentLayoutview.class)
@CssImport("./themes/nopainnogain/components/ProfilBearbeiten.css")
@PageTitle("No-Pain_No-Gain")

public class StudentProfilBearbeitenView extends VerticalLayout {

    private H4 title = new H4("Persönliche Angaben:");
    private H4 it_kenntnisse = new H4("IT_Kenntnisse:");
    private H4 berufstaetigkeiten = new H4("Berufstätigkeiten:");
    private H4 sprach_kenntnisse = new H4("Sprach_Kenntnisse:");
    private H4 ihr_Dateien = new H4("Ihre Unterlagen hochladen:");
    private TextField vorname = new TextField("Vorname");
    private TextField nachname = new TextField("Nachname");
    private ComboBox<String> geschlicht = new ComboBox<>("Geschlicht");
    private DatePicker Geburtsdatum = new DatePicker("Geburtsdatum");
    private EmailField email = new EmailField("E-Mail Adresse");
    private PhoneNumberField phone = new PhoneNumberField("Telefonnummer");
    private TextField mobile = new TextField("Mobilenummer");
    private TextField studium = new TextField("Studium");
    private TextField hoechster_abschluss = new TextField("Höchster Abschluss");
    private TextField adresse = new TextField("Straße und Hausnummer");
    private NumberField postleitzahl = new NumberField("Postleitzahl");
    private TextField ort = new TextField("Ort");
    private ComboBox<String> vorwahl = new ComboBox<>("Vorwahl");
    private TextField it_kenntnis = new TextField("IT_Kenntnis");
    private Button cancel = new Button("Abbrechen");
    private Button save = new Button("Speichern");


    public StudentProfilBearbeitenView() {
        //persoenliche_Angaben();
        //IT_Kenntnis();
        //Sprach_Kenntnisse();
        //Berufstätigkeiten();
        //Datein_hochladen();
        //Buttons();
        SeiteView();
    }
    private void SeiteView() {

        Tab tab1 = new Tab("Persönlische Angaben");
        Div page1 = new Div();
        page1.add(persoenliche_Angaben());


        Tab tab2 = new Tab("IT&Sprach-kenntnisse");
        Div page2 = new Div();
        page2.add(IT_Kenntnis(), Sprach_Kenntnisse());
        page2.setVisible(false);


        Tab tab3 = new Tab("Berufstätigkeiten");
        Div page3 = new Div();
        page3.add(Berufstätigkeiten());
        page3.setVisible(false);

        Tab tab4 = new Tab("Unterlagen");
        Div page4 = new Div();
        page4.add(Datein_hochladen());
        page4.setVisible(false);


        Map<Tab, Component> tabsToPages = new HashMap<>();
        tabsToPages.put(tab1, page1);
        tabsToPages.put(tab2, page2);
        tabsToPages.put(tab3, page3);
        tabsToPages.put(tab4, page4);
        Tabs tabs = new Tabs(tab1, tab2, tab3, tab4);
        Div pages = new Div(page1, page2, page3, page4);

        tabs.addSelectedChangeListener(event -> {
            tabsToPages.values().forEach(page -> page.setVisible(false));
            Component selectedPage = tabsToPages.get(tabs.getSelectedTab());
            selectedPage.setVisible(true);
        });
        add(tabs, pages);
    }

    private Component persoenliche_Angaben() {
        FormLayout layout_1 = new FormLayout();
        // Persönlische Angaben:
        geschlicht.setItems("Mann","Frau");
        layout_1.add(vorname, nachname, geschlicht, Geburtsdatum, email, phone);
        layout_1.add(mobile, 2);
        layout_1.add(adresse, 2);
        layout_1.add(postleitzahl, ort);
        layout_1.add(studium,2);
        layout_1.add(hoechster_abschluss,2);
        layout_1.setResponsiveSteps(
                new FormLayout.ResponsiveStep("1px", 1),
                new FormLayout.ResponsiveStep("600px", 2),
                new FormLayout.ResponsiveStep("700px", 3),
                new FormLayout.ResponsiveStep("700px", 4));
        // Button:
        Button cancel = new Button("Abbrechen");
        Button save = new Button("Speichern");
        HorizontalLayout layout_B = new HorizontalLayout();
        cancel.setId("cancel_save");
        save.setId("cancel_save");
        layout_B.add(cancel,save);
        cancel.getStyle().set("minWidth", "200px");
        save.getStyle().set("minWidth", "200px");
        layout_1.add(layout_B);
        return layout_1;
    }

    private Component IT_Kenntnis() {

        // Überschriften:
        VerticalLayout layout_1 = new VerticalLayout();
        TextField textField1 = new TextField();
        textField1.getStyle().set("minWidth", "1300px");
        layout_1.add(textField1);


        // ICONS FÜR it_kenntnisse:
        HorizontalLayout layout_2 = new HorizontalLayout();
        Icon add_it_kenntnis = new Icon(VaadinIcon.PLUS_CIRCLE_O);
        Icon entferne_it_kenntnis = new Icon(VaadinIcon.MINUS_CIRCLE_O);
        // add_it_kenntnis:
        add_it_kenntnis.addClickListener(iconClickEvent -> {
            TextField textField = new TextField();
            textField.getStyle().set("minWidth", "1300px");
            layout_1.add(textField);
        });
        entferne_it_kenntnis.addClickListener(e -> {
        });


        // ADD:
        layout_2.add(add_it_kenntnis,entferne_it_kenntnis);
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(it_kenntnisse,layout_1,layout_2);

        return verticalLayout;
    }
    private Component Sprach_Kenntnisse(){

        VerticalLayout layout_1 = new VerticalLayout();
        TextField textField1 = new TextField();
        textField1.getStyle().set("minWidth", "1300px");
        layout_1.add(textField1);

        // ICONS FÜR it_kenntnisse:
        HorizontalLayout layout_2 = new HorizontalLayout();
        Icon add_sprach_kenntnis = new Icon(VaadinIcon.PLUS_CIRCLE_O);
        Icon entferne_sprach_kenntnis = new Icon(VaadinIcon.MINUS_CIRCLE_O);
        layout_2.add(add_sprach_kenntnis,entferne_sprach_kenntnis);

        //add_sprach_kenntnis;
        add_sprach_kenntnis.addClickListener(iconClickEvent -> {
            TextField textField = new TextField();
            textField.getStyle().set("minWidth", "1300px");
            layout_1.add(textField);
        });

        // ADD:
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(sprach_kenntnisse,layout_1,layout_2);
        Button cancel = new Button("Abbrechen");
        Button save = new Button("Speichern");
        HorizontalLayout layout_B = new HorizontalLayout();
        cancel.setId("cancel_save");
        save.setId("cancel_save");
        cancel.getStyle().set("minWidth", "200px");
        save.getStyle().set("minWidth", "200px");
        layout_B.add(cancel,save);
        verticalLayout.add(layout_B);
        return verticalLayout;

    }
    private Component Berufstätigkeiten(){

        VerticalLayout verticalLayout = new VerticalLayout();
        VerticalLayout verticalLayout_2 = new VerticalLayout();

        HorizontalLayout layout_1 = new HorizontalLayout();
        // erster Eingabebereich:
        TextField textField1 = new TextField();
        textField1.getStyle().set("minWidth", "700px");
        DatePicker von1 = new DatePicker("Von");
        von1.getStyle().set("minWidth", "200px");
        DatePicker bis1 = new DatePicker("Bis");
        bis1.getStyle().set("minWidth", "200px");
        layout_1.add(textField1,von1,bis1);
        layout_1.setDefaultVerticalComponentAlignment(Alignment.END);
        verticalLayout_2.add(layout_1);

        // ICONS FÜR it_kenntnisse:
        HorizontalLayout layout_2 = new HorizontalLayout();
        Icon add_berufstaetigkeiten = new Icon(VaadinIcon.PLUS_CIRCLE_O);
        Icon entferne_berufstaetigkeiten = new Icon(VaadinIcon.MINUS_CIRCLE_O);
        layout_2.add(add_berufstaetigkeiten,entferne_berufstaetigkeiten);

        //layout_1.add(it_kenntnis);
        add_berufstaetigkeiten.addClickListener(iconClickEvent -> {
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            TextField textField = new TextField();
            textField.getStyle().set("minWidth", "700px");
            DatePicker von = new DatePicker("Von");
            von.getStyle().set("minWidth", "200px");
            DatePicker bis = new DatePicker("Bis");
            bis.getStyle().set("minWidth", "200px");
            horizontalLayout.add(textField,von,bis);
            horizontalLayout.setDefaultVerticalComponentAlignment(Alignment.END);
            verticalLayout_2.add(horizontalLayout);
        });

        // Buttons:
        Button cancel = new Button("Abbrechen");
        Button save = new Button("Speichern");
        HorizontalLayout layout_B = new HorizontalLayout();
        cancel.setId("cancel_save");
        save.setId("cancel_save");
        cancel.getStyle().set("minWidth", "200px");
        save.getStyle().set("minWidth", "200px");
        layout_B.add(cancel,save);
        verticalLayout.add(verticalLayout_2,layout_2);
        verticalLayout.add(layout_B);
        return verticalLayout;
    }

    private Component Datein_hochladen(){
        VerticalLayout verticalLayout = new VerticalLayout();
        //title:
        verticalLayout.add(ihr_Dateien);
        MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
        Upload upload = new Upload(buffer);
        FormLayout formLayout = new FormLayout();
        formLayout.add(upload);
        formLayout.getStyle().set("minWidth", "1300px");
        verticalLayout.add(formLayout);
        Button cancel = new Button("Abbrechen");
        Button save = new Button("Speichern");
        HorizontalLayout layout_B = new HorizontalLayout();
        cancel.setId("cancel_save");
        save.setId("cancel_save");
        cancel.getStyle().set("minWidth", "200px");
        save.getStyle().set("minWidth", "200px");
        layout_B.add(cancel,save);
        verticalLayout.add(layout_B);
        return verticalLayout;
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
            countryCode.setItems("+49" ,"+30","+31", "+32","+33","+350","+351","+352","+353","+354","+355","+359");
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
