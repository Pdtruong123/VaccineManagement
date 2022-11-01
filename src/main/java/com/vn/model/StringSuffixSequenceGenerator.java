package com.vn.model;


import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;


import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;


public class StringSuffixSequenceGenerator extends SequenceStyleGenerator {
    public static final String VALUE_SUFFIX_PARAMETER = "codeNumberSeparator";
    public static final String VALUE_PREFIX_DEFAULT = "-";
    private String valueSuffix;

    public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
    public static final String NUMBER_FORMAT_DEFAULT = "%05d";
    private String format;

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(LongType.INSTANCE, params, serviceRegistry);
        String codeNumberSeparator = ConfigurationHelper.getString(VALUE_SUFFIX_PARAMETER,params,VALUE_PREFIX_DEFAULT);
        String numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params, NUMBER_FORMAT_DEFAULT);
        this.format = numberFormat + numberFormat;
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return String.format(format, ((InjectionResult)object).getCustomer().getFullName() + "-" +
                ((InjectionResult)object).getCustomer().getDateOfBirth(), super.generate(session,object));
    }
}
