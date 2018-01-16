package pl.aszul.patronage.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class StorageH2SelectedConfig implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // as requested, H2 mode is be forced if H2_STORAGE_ENABLED env var is set to true or not set at all
        System.out.println("StorageH2SelectedConfig = " + (System.getenv("H2_STORAGE_ENABLED").isEmpty() || System.getenv("H2_STORAGE_ENABLED").equals("true")));
        return System.getenv("H2_STORAGE_ENABLED").isEmpty() || System.getenv("H2_STORAGE_ENABLED").equals("true");
    }
}