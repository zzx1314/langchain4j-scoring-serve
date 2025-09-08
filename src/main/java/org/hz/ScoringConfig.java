package org.hz;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "score")
public interface ScoringConfig {
    String path();
    String tokenizer();
}
