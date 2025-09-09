package org.hz;

import dev.langchain4j.model.scoring.onnx.OnnxScoringModel;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.stream.Collectors;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.output.Response;

@Path("/score")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ScoringModelController {

    @Inject
    ScoringConfig config;

    @POST
    public Double getScore(ScoringModeDto dto) {
        String pathToModel = config.path();
        String pathToTokenizer = config.tokenizer();
        OnnxScoringModel scoringModel = new OnnxScoringModel(pathToModel, pathToTokenizer);

        Response<Double> response = scoringModel.score(dto.getAnswer(), dto.getQuestion());
        Double score = response.content();
        return score;
    }

    @POST
    @Path("/all")
    public List<Double> getScoreAll(ScoringModeDto dto) {
        String pathToModel = config.path();
        String pathToTokenizer = config.tokenizer();
        OnnxScoringModel scoringModel = new OnnxScoringModel(pathToModel, pathToTokenizer);

        List<TextSegment> segments = dto.getAnswers().stream()
                .map(TextSegment::from)
                .collect(Collectors.toList());
        Response<List<Double>> response = scoringModel.scoreAll(segments, dto.getQuestion());
        List<Double> scores = response.content();
        return scores;
    }
}
