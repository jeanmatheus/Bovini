/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import br.com.jean.faculdade.projeto.model.Cidade;
import br.com.jean.faculdade.projeto.repositorio.CidadeRP;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Jean Matheus
 */
@FacesConverter(forClass = Cidade.class, value = "CidadeConverter")
public class CidadeConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Cidade cid = new Cidade();
        CidadeRP rp = new CidadeRP();
        
        cid = rp.getPorNome(value);
        
        return cid;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
    
}
