/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import br.com.jean.faculdade.projeto.model.Propriedade;
import br.com.jean.faculdade.projeto.repositorio.PropriedadeRP;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Jean Matheus
 */
@FacesConverter(forClass= Propriedade.class, value="PropriedadeConverter")
public class PropriedadeConverter  implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Propriedade p = new Propriedade();
        PropriedadeRP rp = new PropriedadeRP();
        p = rp.getPorNome(value);
        
        return p;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
    
}
