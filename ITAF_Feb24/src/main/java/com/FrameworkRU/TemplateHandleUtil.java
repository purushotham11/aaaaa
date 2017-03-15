package com.FrameworkRU;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.runtime.resource.util.StringResourceRepository;

/**
 * This Utility Class Creates String Object with Velocity Template Using the
 * StringResourceLoader and merges with provided Http Encoded String
 * 
 * @author Praveen Gaddam
 */
public class TemplateHandleUtil {
	private static TemplateHandleUtil instance = new TemplateHandleUtil();
	private static VelocityEngine engine = null;
	
	/**
	 * Instantiates a new template handle util.
	 */
	private TemplateHandleUtil() {
	}

	/**
	 *  Return instance of this object.
	 *
	 * @return single instance of TemplateHandleUtil
	 */
	public static TemplateHandleUtil getInstance() {
		return instance;
	}

	/**
	 * Handle Http Template.
	 *
	 * @param templateBody the template body
	 * @param mapObj the map obj
	 * @return the string
	 */
	public String handleTemplate(String templateBody, Map<String, String> mapObj) {
		VelocityContext context = null;
		StringResourceRepository repository = null;
		Template template = null;
		StringWriter writer = null;

		try {
			engine = getVelocityEngine();
			repository = StringResourceLoader.getRepository();
			repository.putStringResource("template", templateBody);
			// Getting the context with placeholder values
			context = new VelocityContext();
			context.put("cirrus", mapObj);
			// Fetch Template to a StringWriter
			template = engine.getTemplate("template");
			writer = new StringWriter();
			template.merge(context, writer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writer.toString().trim();
	}

	/**
	 * Getting Velocity Engine and Initialize properties.
	 *
	 * @return the velocity engine
	 * @throws Exception the exception
	 */
	private static VelocityEngine getVelocityEngine() throws Exception {
		if (engine == null) {
			synchronized (TemplateHandleUtil.class) {
				if (engine == null) {
					// Velocity engine and resource loader class from
					// "autoload.velocity" NB Module.
					engine = new VelocityEngine();
					Properties velProp = new Properties();
					velProp.setProperty("resource.loader", "string");
					velProp.setProperty("string.resource.loader.description",
							"Velocity StringResource loader");
					velProp.setProperty(
							"string.resource.loader.repository.name",
							"StringRepository");
					velProp.setProperty("string.resource.loader.class",
							"org.apache.velocity.runtime.resource.loader.StringResourceLoader");
					try {
						engine.init(velProp);
					} catch (Exception e) {
						throw new RuntimeException(
								"Could not initialize velocity engine: " + e);
					}
				}
			}
		}
		return engine;
	}

}
