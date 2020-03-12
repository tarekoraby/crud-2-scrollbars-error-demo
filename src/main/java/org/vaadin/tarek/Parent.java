package org.vaadin.tarek;

public class Parent {
	private Integer id;
	private String name;

	public Parent() {
	}

	public Parent(final Integer id, final String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

}
