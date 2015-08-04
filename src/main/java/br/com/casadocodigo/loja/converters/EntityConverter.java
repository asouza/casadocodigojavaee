package br.com.casadocodigo.loja.converters;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.Id;

import org.picketbox.util.StringUtil;

@FacesConverter("entityConverter")
public class EntityConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		if (StringUtil.isNullOrEmpty(value)) {
			return null;
		}

		System.out.println(value+"===="+component.getClass());
		UISelectItems uiComponent = (UISelectItems) component.getChildren()
				.get(0);

		Collection<?> objects = (Collection<?>) uiComponent.getValue();

		Object foundEntity = objects.stream().filter((entity) -> {
			return getAsString(context, uiComponent, entity).equals(value);
		}).findFirst().get();

		return foundEntity;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		Field idField = findIdField(value);
		return getIdValue(value, idField);
	}

	private String getIdValue(Object value, Field idField) {
		try {
			Field field = value.getClass().getDeclaredField(idField.getName());
			field.setAccessible(true);
			return field.get(value)
					.toString();
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	private Field findIdField(Object value) {
		Field idField = Arrays.stream(value.getClass().getDeclaredFields())
				.filter((field) -> field.getAnnotation(Id.class) != null)
				.findFirst().get();
		return idField;
	}

}
