package com.kodecamp.services.course;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/course")
public class CourseResource {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getAll() {

    return "All Courses";
  }
}
