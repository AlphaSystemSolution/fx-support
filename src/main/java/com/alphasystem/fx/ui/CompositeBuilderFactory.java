package com.alphasystem.fx.ui;

import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import static com.alphasystem.util.AppUtil.readAllLines;
import static java.lang.String.format;
import static org.apache.commons.lang3.ArrayUtils.add;
import static org.apache.commons.lang3.ArrayUtils.isEmpty;

/**
 * @author sali
 */
public class CompositeBuilderFactory implements BuilderFactory {

    public static CompositeBuilderFactory instance;
    private final List<BuilderFactory> builderFactories = new ArrayList<>();

    private CompositeBuilderFactory(BuilderFactory... factories) {
        if (!isEmpty(factories)) {
            for (BuilderFactory factory : factories) {
                builderFactories.add(factory);
            }
        }
        builderFactories.add(new JavaFXBuilderFactory());
    }

    public static CompositeBuilderFactory getInstance() {
        if (instance == null) {
            BuilderFactory[] builderFactories = new BuilderFactory[0];
            final Class<CompositeBuilderFactory> thisClass = CompositeBuilderFactory.class;
            final ClassLoader classLoader = thisClass.getClassLoader();
            try {
                final Enumeration<URL> resources = classLoader.getResources(format("META-INF/%s", thisClass.getName()));
                if (resources != null) {
                    while (resources.hasMoreElements()) {
                        final URL url = resources.nextElement();
                        try {
                            final List<String> lines = readAllLines(url);
                            if (lines != null && !lines.isEmpty()) {
                                for (String line : lines) {
                                    try {
                                        final Class<?> aClass = Class.forName(line);
                                        builderFactories = add(builderFactories,
                                                ((BuilderFactory) aClass.newInstance()));
                                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            instance = new CompositeBuilderFactory(builderFactories);
        }
        return instance;
    }

    @Override
    public Builder<?> getBuilder(Class<?> type) {
        Builder<?> builder = null;
        for (BuilderFactory builderFactory : builderFactories) {
            builder = builderFactory.getBuilder(type);
            if (builder != null) {
                break;
            }
        }
        return builder;
    }
}
