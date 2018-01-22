package com.cavus.shlist.view;

import com.cavus.shlist.presenter.ProductPresenter;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path="/")
public class MainUI extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6061522224708617549L;
	
	private HeaderDesign header = new HeaderDesign();
	private ProductViewImpl grid = new ProductViewImpl();
	private ProductFormImpl form = new ProductFormImpl();
	private ProductPresenter presenter = new ProductPresenter(grid, form);
	
    private final VerticalLayout layout = new VerticalLayout();
    
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        HorizontalLayout main = new HorizontalLayout(grid, form);
        main.setSizeFull();
        grid.setSizeFull();
        main.setExpandRatio(grid, 1);

        layout.addComponents(header, main);

        setContent(layout);
    }
    
}
