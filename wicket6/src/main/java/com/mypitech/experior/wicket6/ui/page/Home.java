package com.mypitech.experior.wicket6.ui.page;

import com.mypitech.experior.wicket6.ui.panel.HomePanel;
import com.mypitech.experior.wicket6.ui.panel.layout.Template;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Created by Shawn Wheeler on 10/1/2014.
 */
public class Home extends Template {
    /**
     * Constructor which receives wrapped query string parameters for a request. Having this
     * constructor public means that your page is 'bookmarkable' and hence can be called/ created
     * from anywhere. For bookmarkable pages (as opposed to when you construct page instances
     * yourself, this constructor will be used in preference to a no-arg constructor, if both exist.
     * Note that nothing is done with the page parameters argument. This constructor is provided so
     * that tools such as IDEs will include it their list of suggested constructors for derived
     * classes.
     * <p/>
     * Please call this constructor if you want to remember the pageparameters
     * {@link #getPageParameters()}. So that they are reused for stateless links.
     *
     * @param parameters Wrapped query string parameters.
     */
    public Home(PageParameters parameters) {
        super(parameters);
        replace(new HomePanel(CONTENT_ID));
    }
}
