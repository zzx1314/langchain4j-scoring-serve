package org.hz.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "score")
public interface ScoringConfig {
    String path();
    String tokenizer();
}
