package org.osharif.course_info.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    }
}
