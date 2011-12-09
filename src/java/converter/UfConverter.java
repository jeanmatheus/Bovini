/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import br.com.jean.faculdade.projeto.model.Uf;
import br.com.jean.faculdade.projeto.repositorio.UfRP;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Jean Matheus
 */
@FacesConverter(forClass = Uf.class, value = "UfConverter")
public class UfConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Uf uf = new Uf();
        UfRP rp = new UfRP();
        uf = rp.getPorNome(value);
        
        return uf; 
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
    
}
