package com.kodecamp.services.student;

public class StudentDto {
  private String id;
  private String name;
  private String address;
  private String courseCode;

  public StudentDto() {
  }

  public StudentDto(String id, String name, String address, String courseCode) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.courseCode = courseCode;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String newAddress) {
    this.address = newAddress;
  }

  public String getCourseCode() {
    return this.courseCode;
  }

  public void setCourseCode(String newCourseCode) {
    this.courseCode = newCourseCode;
  }

  @Override
  public String toString() {
    return String.format("[ id = %s, name = %s, address = %s ]", this.id,
        this.name, this.address);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    StudentDto other = (StudentDto) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
