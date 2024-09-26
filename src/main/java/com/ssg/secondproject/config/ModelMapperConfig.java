package com.ssg.secondproject.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
            .setFieldMatchingEnabled(true)
            .setFieldAccessLevel(AccessLevel.PRIVATE)
            .setMatchingStrategy(MatchingStrategies.LOOSE);

        Converter<LocalDateTime, String> toStringConverter =
            new Converter<LocalDateTime, String>() {
                public String convert(MappingContext<LocalDateTime, String> context) {
                    if (context.getSource() == null) {
                        return null;
                    }
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                        "yyyy-MM-dd HH:mm:ss");
                    return context.getSource().format(formatter);
                }
            };

        modelMapper.addConverter(toStringConverter);

        return modelMapper;
    }
}
