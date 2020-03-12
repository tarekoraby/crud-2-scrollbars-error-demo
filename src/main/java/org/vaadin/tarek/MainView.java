package org.vaadin.tarek;

import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.crud.Crud;
import com.vaadin.flow.component.crud.CrudEditor;
import com.vaadin.flow.component.crud.CrudEditorPosition;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

	public MainView() {

		final ParentDataProvider dataProvider = new ParentDataProvider();

		final Crud<Parent> crud = new Crud<>(Parent.class, createParentEditor());

		crud.setDataProvider(dataProvider);

		crud.setEditorPosition(CrudEditorPosition.OVERLAY);
		crud.setEditOnClick(true);
		crud.setOpened(true);
		crud.setSizeFull();
		crud.getGrid().setColumns("name");
		setSizeFull();
		add(crud);
	}

	private CrudEditor<Parent> createParentEditor() {
		final TextField nameField = new TextField("Parent name");

		VerticalLayout form = new VerticalLayout(nameField);
		for (int i=0; i<40; i++)
			form.add(new Span("Another element"));

		final Binder<Parent> binder = new Binder<>(Parent.class);
		binder.bind(nameField, Parent::getName, Parent::setName);
	
		return new BinderCrudEditor<>(binder, form);
	}
}
