package si.inspirited.system;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
//import javax.cache.configuration.Configuration;
//import javax.cache.configuration.MutableConfiguration;

/**
 * @author Jesus Lord Almighty
 * at 23.01.2018
 */
@org.springframework.context.annotation.Configuration
@EnableCaching
@Profile("development")
class CacheConfig {

 /*   @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            Configuration<Object, Object> cacheConfiguration = createCacheConfiguration();
            cm.createCache("pages", cacheConfiguration);
        };
    }

    private Configuration<Object, Object> createCacheConfiguration() {
        // Create a cache using infinite heap. A real application will want to use an
        // implementation dependent configuration that will better fit your needs
        return new MutableConfiguration<>().setStatisticsEnabled(true);
    }*/
}