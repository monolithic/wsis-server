package com.hele.commons.spring;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.AbstractView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

public class MappingFastJsonJsonView extends AbstractView {

	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
	/**
	 * Default content type. Overridable as bean property.
	 */
	public static final String DEFAULT_CONTENT_TYPE = "application/json";
	
	private static SerializeConfig mapping = new SerializeConfig();
    
	static {
        mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
    }
    
	
	private Set<String> renderedAttributes;
	
	
	public MappingFastJsonJsonView() {
		setContentType(DEFAULT_CONTENT_TYPE);
	}
	
	/**
	 * Returns the attributes in the model that should be rendered by this view.
	 */
	public Set<String> getRenderedAttributes() {
		return renderedAttributes;
	}

	/**
	 * Sets the attributes in the model that should be rendered by this view. When set, all other model attributes will be
	 * ignored.
	 */
	public void setRenderedAttributes(Set<String> renderedAttributes) {
		this.renderedAttributes = renderedAttributes;
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Object value = filterModel(model);
		String jsonString = JSON.toJSONString(value, mapping);
		OutputStream out = response.getOutputStream();
		out.write(jsonString.getBytes("UTF-8"));
		out.flush();
	}
	
	/**
	 * Filters out undesired attributes from the given model. The return value can be either another {@link java.util.Map}, or a
	 * single value object.
	 *
	 * <p>Default implementation removes {@link org.springframework.validation.BindingResult} instances and entries not included in the {@link
	 * #setRenderedAttributes(java.util.Set) renderedAttributes} property.
	 *
	 * @param model the model, as passed on to {@link #renderMergedOutputModel}
	 * @return the object to be rendered
	 */
	protected Object filterModel(Map<String, Object> model) {
		Map<String, Object> result = new HashMap<String, Object>(model.size());
		Set<String> renderedAttributes =
				!CollectionUtils.isEmpty(this.renderedAttributes) ? this.renderedAttributes : model.keySet();
		for (Map.Entry<String, Object> entry : model.entrySet()) {
			if (!(entry.getValue() instanceof BindingResult) && renderedAttributes.contains(entry.getKey())) {
				result.put(entry.getKey(), entry.getValue());
			}
		}
		return result;
	}

}
