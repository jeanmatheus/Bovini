/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jean.faculdade.projeto.view;

import javax.faces.bean.ManagedBean;
import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudModel;

/**
 *
 * @author adml01
 */
@ManagedBean
public class TagCloudMB {

    private TagCloudModel model;

    public TagCloudMB() {
        model = new DefaultTagCloudModel();
        model.addTag(new DefaultTagCloudItem("Cloud", "#", 1));
        model.addTag(new DefaultTagCloudItem("JSF 2", "#", 2));
        model.addTag(new DefaultTagCloudItem("Primefaces", "#", 3));
        model.addTag(new DefaultTagCloudItem("Java", "#", 4));
        model.addTag(new DefaultTagCloudItem("Bovinocultura", "#", 5));
        model.addTag(new DefaultTagCloudItem("JElastic", "#", 6));
        model.addTag(new DefaultTagCloudItem("UI", "#", 7));
    }
    
    public TagCloudModel getModel() {
        return model;
    }
    
}
