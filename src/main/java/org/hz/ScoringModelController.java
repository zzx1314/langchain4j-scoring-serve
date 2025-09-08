package org.hz;

import dev.langchain4j.model.scoring.onnx.OnnxScoringModel;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import dev.langchain4j.model.output.Response;

@Path("/score")
public class ScoringModelController {

    @Inject
    ScoringConfig config;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Double getScore(ScoringModeDto dto) {
        String pathToModel = config.path();
        String pathToTokenizer = config.tokenizer();
        OnnxScoringModel scoringModel = new OnnxScoringModel(pathToModel, pathToTokenizer);

        Response<Double> response = scoringModel.score(dto.getAnswer(), dto.getQuestion());
        Double score = response.content();
        return score;
    }
}
