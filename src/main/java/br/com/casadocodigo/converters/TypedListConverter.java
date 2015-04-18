package br.com.casadocodigo.converters;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.picketbox.util.StringUtil;

import br.com.casadocodigo.models.EntityClass;

@FacesConverter("genericListConverter")
@RequestScoped
public class TypedListConverter implements Converter {

	@PersistenceContext
	private EntityManager manager;

	@Override
	@SuppressWarnings("unchecked")
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		
		if(StringUtil.isNullOrEmpty(value)){
			return null;
		}
		
		Integer selectedId = Integer.parseInt(value);
		// Object object = SelectItemsUtils.findValueByStringConversion(context,component, value, this);
		
		UISelectItems uiComponent = (UISelectItems) component.getChildren()
				.get(0);
		
		Collection<? extends EntityClass> objects = (Collection<? extends EntityClass>) uiComponent
				.getValue();
		
		EntityClass foundEntity = objects.stream().filter((entity) -> entity.getId().equals(selectedId))
				.findFirst().get();
		
		return foundEntity;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		EntityClass entityClass = (EntityClass) value;
		return entityClass.getId().toString();
	}

}
