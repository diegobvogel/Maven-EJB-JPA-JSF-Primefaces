package br.com.converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.entities.TStatusIntegracao;

/**
 * Converter utilizado na combo de Status para poder passar como parâmetro um objeto ao invés de somente uma string.
 * @author diego.vogel
 */
@FacesConverter(forClass = TStatusIntegracao.class)
public class StatusConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (TStatusIntegracao) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof TStatusIntegracao) {
        	TStatusIntegracao entity= (TStatusIntegracao) value;
            if (entity != null && entity instanceof TStatusIntegracao && entity.getStatusintegracao() != null) {
                uiComponent.getAttributes().put( entity.getStatusintegracao().toString(), entity);
                return entity.getStatusintegracao().toString();
            }
        }
        return "";
    }
}