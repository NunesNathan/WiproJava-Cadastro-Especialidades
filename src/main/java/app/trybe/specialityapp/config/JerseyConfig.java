package app.trybe.specialityapp.config;

import app.trybe.specialityapp.SpecialityAppApplication;
import java.util.logging.Logger;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.hibernate.boot.jaxb.internal.AbstractBinder;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

  private Logger logger = LoggerFactory.getLogger(JerseyConfig.class);

  /**
   * Construtor para o JerseyConfig.
   *
   */
  public JerseyConfig() {
    packages(SpecialityAppApplication.class.getPackageName());
    register(new AbstractBinder() {

      @Override
      protected void configure() {
        logger.info("Configurando binder");
      }
    });
  }
}