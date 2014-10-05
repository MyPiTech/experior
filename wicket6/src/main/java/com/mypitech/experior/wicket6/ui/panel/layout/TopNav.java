package com.mypitech.experior.wicket6.ui.panel.layout;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Created by Shawn Wheeler on 10/1/2014.
 */
public class TopNav extends Panel {
    protected WebMarkupContainer homeItem = new WebMarkupContainer("homeItem");
    protected WebMarkupContainer helloItem = new WebMarkupContainer("helloItem");
    protected WebMarkupContainer crudItem = new WebMarkupContainer("crudItem");

    /**
     * @param id
     * @see org.apache.wicket.Component#Component(String)
     */
    public TopNav(String id) {
        super(id);
        addComponents();
    }

    private void addComponents() {

        add(homeItem);
        add(helloItem);
        add(crudItem);

        /*if(currentPage == "home"){
            homeItem.add(AttributeModifier.replace("class", "start selected"));
            helloItem.add(AttributeModifier.replace("class", ""));
            crudItem.add(AttributeModifier.replace("class", "end"));
        } else if (currentPage == "hello"){
            homeItem.add(AttributeModifier.replace("class", "start"));
            helloItem.add(AttributeModifier.replace("class", "selected"));
            crudItem.add(AttributeModifier.replace("class", "end"));
        }else{
            homeItem.add(AttributeModifier.replace("class", "start"));
            helloItem.add(AttributeModifier.replace("class", ""));
            crudItem.add(AttributeModifier.replace("class", "end selected"));
        };*/

        homeItem.add(new Link<Void>("homeLink") {
            @Override
            public void onClick() {

                //setResponsePage(new ClientEditPage(pageParameters, breadCrumbModel));
            }
        });
        helloItem.add(new Link<Void>("helloLink") {
            @Override
            public void onClick() {

                //setResponsePage(new ClientEditPage(pageParameters, breadCrumbModel));
            }
        });
        crudItem.add(new Link<Void>("crudLink") {
            @Override
            public void onClick() {

                //setResponsePage(new ClientEditPage(pageParameters, breadCrumbModel));
            }
        });

    }

    public void setHomeItemActive(){
        homeItem.add(AttributeModifier.replace("class", "start selected"));
        helloItem.add(AttributeModifier.replace("class", ""));
        crudItem.add(AttributeModifier.replace("class", "end"));
    }

    public void setHelloItemActive(){
        homeItem.add(AttributeModifier.replace("class", "start"));
        helloItem.add(AttributeModifier.replace("class", "selected"));
        crudItem.add(AttributeModifier.replace("class", "end"));
    }

    public void setCrudItemActive(){
        homeItem.add(AttributeModifier.replace("class", "start"));
        helloItem.add(AttributeModifier.replace("class", ""));
        crudItem.add(AttributeModifier.replace("class", "end selected"));
    }
}
