package Store.support;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.AbstractMatcher;
import com.google.inject.name.Names;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by shubham.srivastava on 05/06/15.
 */
public class StoreMod extends AbstractModule {

    private List<String> mongoHosts;
    private String mongoHost;
    private String dbName;

    public void setMongoHosts(List<String> value) {
        mongoHosts = value;
    }

    public void setMongoHost(String value) {
        mongoHost = value;
    }

    public void setDbName(String value) {
        dbName = value;
    }

    @Override
    protected void configure() {

        bindListener(HasInitMethod.INSTANCE, new TypeListener() {
            public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {
                encounter.register(InitInvoker.INSTANCE);
            }
        });

        if (mongoHosts == null || mongoHosts.size() == 0) {
            mongoHosts.add("localhost");
        }

        if (StringUtils.isBlank(dbName)) {
            dbName = "KnowStore";
        }

        bind(new TypeLiteral<List<String>>() {
        }).annotatedWith(Names.named("morphia.hosts")).toInstance(mongoHosts);
        bind(String.class).annotatedWith(Names.named("morphia.dbname")).toInstance(dbName);

    }

    static class HasInitMethod extends AbstractMatcher<TypeLiteral<?>> {

        public boolean matches(TypeLiteral<?> tpe) {
            try {
                return tpe.getRawType().getMethod("initialize") != null;
            } catch (Exception e) {
                return false;
            }
        }

        public static final HasInitMethod INSTANCE = new HasInitMethod();
    }

    static class InitInvoker implements InjectionListener<Object> {

        public void afterInjection(Object injectee) {
            try {
                injectee.getClass().getMethod("initialize").invoke(injectee);
            } catch (Exception e) {
                /* do something to handle errors here */
            }
        }

        public static final InitInvoker INSTANCE = new InitInvoker();
    }
}
