package br.com.coontrol.ctrl.view.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import br.com.coontrol.ctrl.view.scope.ScopeName;
import br.com.coontrol.ctrl.view.scope.ViewScope;

/**
 * BeanPostProcessor that registeres the view scope.
 * 
 * @author MIS
 *
 */
@Component
public class CustomScopeRegisteringBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerScope(ScopeName.VIEW, new ViewScope());
    }
}
