package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Employee extends Model {

// Properties
@Id
private Long id;

@ManyToOne
private Department department;

@OneToOne(cascade=CascadeType.ALL)
private Address address;

@Constraints.Required
private String name;

@ManyToMany(cascade = CascadeType.ALL,mappedBy="employees")
public List<Project> projects;


private List<Long> projSelect = new ArrayList<Long>();


public Employee() {

}



// Constructor to initialise object

public Employee(Long id, String name) {

this.id = id;

this.name = name;
}
// Accessor methods



public static List<Employee> findAll(String filter) {
    return Employee.find.query().where()
                    .ilike("name", "%" + filter + "%")
                    .orderBy("name asc")
                    .findList();
}    


public static List<Project> findFilter(Long projID, String filter) {
        return Project.find.query().where()
                           .eq("projects.id", projID)
                       .ilike("name", "%" + filter + "%")
                        .orderBy("name asc")
                        .findList();
 }

 public Long getId() {
    
    return id;
    
    }

public void setId(Long id) {

this.id = id;

}

public String getName() {

return name;

}
public Department getDepartment() {
    return department;
}

public void setDepartment(Department department) {
    this.department = department;
}

public List<Project> getProject() {
    return projects;
}

public void setProject(List<Project> projects) {
    this.projects = projects;
}


public void setName(String name) {

this.name = name;

}


public List<Long> getProjselect(){
    return projSelect;
}

public void setprojSelect(List<Long> projSelect){
    this.projSelect = projSelect;
}

public Address getAddress() {
    return address;
}

public void setAddress(Address address) {
    this.address = address;
}



public static Finder<Long, Employee> find = new Finder<Long, Employee>(Employee.class);

public static List<Employee> findAll() {
    return Employee.find.all();
}

public List<String> getEmpsProjsNames(){
    List<String> projNames = new ArrayList<>();
      if(getProject().size() > 0){
          for(int i = 0; i < getProject().size(); i++){
            projNames.add(getProject().get(i).getProjectName());
          }
      } else {
        projNames.add("not currently placed on a proj");
      }
         return projNames;
  }



}