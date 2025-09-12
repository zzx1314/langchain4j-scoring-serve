package org.hz;

import dev.langchain4j.model.scoring.onnx.OnnxScoringModel;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import dev.langchain4j.model.output.Response;

@Path("/score")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ScoringModelController {

    @Inject
    OnnxScoringModel model;

    @POST
    public Double getScore(ScoringModeDto dto) {
        Response<Double> response = model.score(dto.getAnswer(), dto.getQuestion());
        Double score = response.content();
        return score;
    }

    @POST
    @Path("/all")
    public List<Double> getScoreAll(ScoringModeDto dto) {
        Response<List<Double>> response = model.scoreAll(dto.getTextSegments(), dto.getQuestion());
        List<Double> scores = response.content();
        return scores;
    }
}
