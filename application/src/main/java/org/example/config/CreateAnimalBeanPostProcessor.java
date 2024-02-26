package org.example.config;

import org.example.model.AnimalType;
import org.example.service.CreateAnimalServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class CreateAnimalBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass() == CreateAnimalServiceImpl.class) {
            CreateAnimalServiceImpl service = (CreateAnimalServiceImpl) bean;
            Random random = new Random();
            AnimalType randomAnimalType = AnimalType.values()[random.nextInt(AnimalType.values().length)];
            service.setAnimalType(randomAnimalType);
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
