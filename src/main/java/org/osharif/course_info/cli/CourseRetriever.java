package org.osharif.course_info.cli;

import org.osharif.course_info.cli.service.CourseRetrieverService;
import org.osharif.course_info.cli.service.PluralsightCourse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CourseRetriever {
    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);
    public static void main(String[] args) {
        LOG.info("Test Starting!");
        if (args.length == 0){
            LOG.warn("No arguments provided!");
            return;
        }

        try {
            retrieveCourses(args[0]);
        }  catch (Exception e){
            LOG.error("Error retrieving courses!", e);
        }
    }

    private static void retrieveCourses(String arg) {
        LOG.info("Retrieving courses for author '{}'!", arg);

        CourseRetrieverService courseRetrieverService = new CourseRetrieverService();
        List<PluralsightCourse> courses = courseRetrieverService.getCourses(arg);

        LOG.info("Retrieved courses: {}", courses);
    }
}
