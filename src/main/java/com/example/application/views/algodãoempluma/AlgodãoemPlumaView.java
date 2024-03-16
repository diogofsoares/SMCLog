package com.example.application.views.algodãoempluma;

import com.example.application.data.SamplePerson;
import com.example.application.services.SamplePersonService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import jakarta.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("Algodão em Pluma")
@Route(value = "my-view", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@RolesAllowed("USER")
@Uses(Icon.class)
public class AlgodãoemPlumaView extends Composite<VerticalLayout> {

    public AlgodãoemPlumaView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        Select select = new Select();
        TextField textField = new TextField();
        ComboBox comboBox = new ComboBox();
        ComboBox comboBox2 = new ComboBox();
        ComboBox comboBox3 = new ComboBox();
        ComboBox comboBox4 = new ComboBox();
        ComboBox comboBox5 = new ComboBox();
        Details details = new Details();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        Grid minimalistGrid = new Grid(SamplePerson.class);
        VerticalLayout layoutColumn3 = new VerticalLayout();
        getContent().addClassName(Gap.XSMALL);
        getContent().addClassName(Padding.XSMALL);
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.START);
        getContent().setAlignItems(Alignment.START);
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("80px");
        select.setLabel("Status");
        layoutRow.setAlignSelf(FlexComponent.Alignment.START, select);
        select.setWidth("min-content");
        setSelectSampleData(select);
        textField.setLabel("Instrução de Embarque");
        textField.setWidth("min-content");
        comboBox.setLabel("Transportadora");
        comboBox.setWidth("min-content");
        setComboBoxSampleData(comboBox);
        comboBox2.setLabel("Armazém");
        comboBox2.setWidth("min-content");
        setComboBoxSampleData(comboBox2);
        comboBox3.setLabel("Cliente");
        comboBox3.setWidth("min-content");
        setComboBoxSampleData(comboBox3);
        comboBox4.setLabel("Analista");
        comboBox4.setWidth("min-content");
        setComboBoxSampleData(comboBox4);
        comboBox5.setLabel("Fazenda");
        comboBox5.setWidth("min-content");
        setComboBoxSampleData(comboBox5);
        details.setWidth("100%");
        setDetailsSampleData(details);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        minimalistGrid.addThemeVariants(GridVariant.LUMO_COMPACT, GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS);
        minimalistGrid.setWidth("100%");
        minimalistGrid.getStyle().set("flex-grow", "0");
        setGridSampleData(minimalistGrid);
        layoutColumn3.getStyle().set("flex-grow", "1");
        getContent().add(layoutRow);
        layoutRow.add(select);
        layoutRow.add(textField);
        layoutRow.add(comboBox);
        layoutRow.add(comboBox2);
        layoutRow.add(comboBox3);
        layoutRow.add(comboBox4);
        getContent().add(comboBox5);
        getContent().add(details);
        getContent().add(layoutRow2);
        layoutRow2.add(layoutColumn2);
        layoutColumn2.add(minimalistGrid);
        layoutRow2.add(layoutColumn3);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setSelectSampleData(Select select) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        select.setItems(sampleItems);
        select.setItemLabelGenerator(item -> ((SampleItem) item).label());
        select.setItemEnabledProvider(item -> !Boolean.TRUE.equals(((SampleItem) item).disabled()));
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

    private void setDetailsSampleData(Details details) {
        Span name = new Span("Sophia Williams");
        Span email = new Span("sophia.williams@company.com");
        Span phone = new Span("(501) 555-9128");
        VerticalLayout content = new VerticalLayout(name, email, phone);
        content.setSpacing(false);
        content.setPadding(false);
        details.setSummaryText("Contact information");
        details.setOpened(true);
        details.setContent(content);
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;
}
