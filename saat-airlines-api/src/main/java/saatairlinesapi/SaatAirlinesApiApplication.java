package saatairlinesapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SaatAirlinesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaatAirlinesApiApplication.class, args);
    }

    @Bean // Bu şekilde,Diğer bileşenler tarafından enjekte edilebilir ve nesne dönüşümlerinde kullanılabilir.
    // Böylece, ModelMapper'ı her seferinde yeni bir örneğini oluşturmak zorunda kalmayız.
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

}
