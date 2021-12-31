package org.hbrs.se2.project.npng.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.view.layoutview.StudentLayoutview;

@Route(value = "StudentView",layout = StudentLayoutview.class)
@PageTitle("No-Pain_No-Gain")

public class StudentView extends VerticalLayout {
    public StudentView(){

        HorizontalLayout h_layout = new HorizontalLayout();
        VerticalLayout v_layout = new VerticalLayout();

        // Überschriften:
        H3 h4_1 = new H3("Finden Sie Ihren Traumjob ! ");
        h4_1.setId("h4_1");

        String ganzerOrt = "Ganzer Ort";
        //Titel
        ComboBox<String> comboNachWas = new ComboBox<>();
        comboNachWas.setPlaceholder("Nach was suchen Sie?");


        //Ort
        ComboBox<String> comboOrtBund = new ComboBox<>();
        comboOrtBund.setPlaceholder("Ort");
        comboOrtBund.setItems("Aach", "Aachen", "Aalen", "Abenberg", "Abensberg", "Achern", "Achim", "Adelsheim", "Adenau", "Adorf/Vogtl.", "Ahaus", "Ahlen", "Ahrensburg", "Aichach", "Aichtal", "Aken (Elbe)", "Albstadt", "Alfeld (Leine)", "Allendorf (Lumda)", "Allstedt", "Alpirsbach", "Alsdorf", "Alsfeld", "Alsleben (Saale)",  "Altenburg", "Altenkirchen (Westerwald)",  "Anklam", "Annaberg-Buchholz", "Annaburg", "Annweiler am Trifels", "Arneburg", "Arnstadt", "Artern/Unstrut", "Arzberg", "Aschaffenburg", "Aschersleben", "Asperg", "Aßlar", "Attendorn", "Aub","Auerbach/Vogtl.",  "Augustusburg", "Aulendorf", "Auma-Weidatal", "Aurich", "Babenhausen", "Bacharach", "Backnang","Bonn");


        //Umkreis
        ComboBox<String> comboUmkreis = new ComboBox<>();
        comboUmkreis.setPlaceholder("Umkreis");
        comboUmkreis.setItems(ganzerOrt, "+10 km", "+25 km", "+50 km", "+75 km","+100 km");


        add(h4_1);

        h_layout.add(comboNachWas ,comboOrtBund ,comboUmkreis);

        add(h_layout);

        String Neuigkeiten = "Neuigkeiten";
        String NeuigkeitenCont = "Donec id elit non mi porta gravida at eget"
                + " metus. Fusce dapibus, tellus ac cursus commodo, tortor"
                + " mauris condimentum nibh, ut fermentum massa justo sit amet "
                + "risus. Etiam porta sem malesuada magna mollis  euismod. "
                + "Donec sed odio dui.";


        String Bew = "Meine Bewerbungen";
        String Bewcont = "Donec id elit non mi porta gravida at eget"
                + " metus. Fusce dapibus, tellus ac cursus commodo, tortor"
                + " mauris condimentum nibh, ut fermentum massa justo sit amet "
                + "risus. Etiam porta sem malesuada magna mollis  euismod. "
                + "Donec sed odio dui.";


        Component card1 = createCard(Neuigkeiten, NeuigkeitenCont);
        Component card2 = createCard(Bew, Bewcont);

        HorizontalLayout h_layout1 = new HorizontalLayout();
        h_layout1.add( card1 , card2);
        add(h_layout1);

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