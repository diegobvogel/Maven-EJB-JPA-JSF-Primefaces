package br.com.converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.entities.TTipoArqIntegracao;

/**
 * Converter utilizado na combo de Tipo para poder passar como parâmetro um objeto ao invés de somente uma string.
 * @author diego.vogel
 */
@FacesConverter(forClass = TTipoArqIntegracao.class)
public class TipoConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (TTipoArqIntegracao) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof TTipoArqIntegracao) {
        	TTipoArqIntegracao entity= (TTipoArqIntegracao) value;
            if (entity != null && entity instanceof TTipoArqIntegracao && entity.getIdtipoarqintegracao() != null) {
                uiComponent.getAttributes().put( entity.getIdtipoarqintegracao().toString(), entity);
                return entity.getIdtipoarqintegracao().toString();
            }
        }
        return "";
    }
}