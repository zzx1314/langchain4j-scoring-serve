package org.hz.producer;

import org.hz.config.ScoringConfig;

import dev.langchain4j.model.scoring.onnx.OnnxScoringModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

@ApplicationScoped
public class ScoringProducer {

    @Inject
    ScoringConfig config;

    @Produces
    @ApplicationScoped
    public OnnxScoringModel model() {
        String pathToModel = config.path();
        String pathToTokenizer = config.tokenizer();
        OnnxScoringModel scoringModel = new OnnxScoringModel(pathToModel, pathToTokenizer);
        return scoringModel;
    }

}
