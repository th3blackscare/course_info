package org.osharif.course_info.cli.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class CourseRetrieverService {
    private static final String BASE_URI = "https://app.pluralsight.com/profile/data/author/%s/all-content";

    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public List<PluralsightCourse> getCourses(String authorId){
        HttpRequest request = HttpRequest.newBuilder(URI.create(BASE_URI.formatted(authorId)))
                .GET().build();
        try {
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            return switch(response.statusCode()){
                case 200 -> getPluralsightCourses(response);
                case 404 -> List.of();
                default -> null;
            };
        }catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    private static List<PluralsightCourse> getPluralsightCourses(HttpResponse<String> response) throws JsonProcessingException {
        JavaType returnType = OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, PluralsightCourse.class);
        return OBJECT_MAPPER.readValue(response.body(), returnType);
    }
}
