/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import br.com.jean.faculdade.projeto.model.Animal;
import br.com.jean.faculdade.projeto.repositorio.AnimalRP;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(forClass= Animal.class, value="AnimalConverter")
public class AnimalConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String nome) {
        Animal ani = new Animal();
        
        AnimalRP rp = new AnimalRP();
        
        ani = rp.getPorNome(nome);
        
        return ani;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
    
}
