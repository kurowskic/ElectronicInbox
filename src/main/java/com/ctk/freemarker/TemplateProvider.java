package com.ctk.freemarker;

import com.ctk.App;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@ApplicationScoped
public class TemplateProvider {

    private static final String TEMPLATE_DIRECTORY_PATH = "WEB-INF/fm-templates";
    private static final String TEMPLATE_EXTENSION = ".ftlh";

    public Template getTemplate(ServletContext servletContext, String templateName)
            throws IOException {
        final Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(true);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setServletContextForTemplateLoading(servletContext, TEMPLATE_DIRECTORY_PATH);

        return cfg.getTemplate(templateName + TEMPLATE_EXTENSION);
    }

    public Template getTemplate1(String templateName)
            throws IOException {
        final Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setClassForTemplateLoading(App.class, TEMPLATE_DIRECTORY_PATH);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(true);
        cfg.setWrapUncheckedExceptions(true);

        cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_DIRECTORY_PATH));

        return cfg.getTemplate(templateName + TEMPLATE_EXTENSION);
    }
}
