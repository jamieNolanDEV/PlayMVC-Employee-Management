package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Project extends Model {


@Constraints.Required
private String projectName;

@Id
private Long id;

@ManyToMany(cascade = CascadeType.ALL)
private List<Employee> employees;


public Project (){

}

public Project(String projectName, Long id, List<Employee> employees) {
    this.projectName = projectName;
    this.id = id;
}



public Long getId(){
    return id;
}

public void setId(){
    this.id = id;
}


public List<Employee> getEmployees() {
    return employees;
}

public void setEmployees(List<Employee> employees) {
    this.employees = employees;
}


public String getProjectName(){
    return projectName;
}

public void setProjectName(String projectName){
    this.projectName = projectName;
}


public static final Finder<Long, Project> find = new Finder<>(Project.class);

public static final List<Project> findAll() {
    return Project.find.all();
}
public static Map<String,String> options(){
    LinkedHashMap<String,String> options = new LinkedHashMap<>();
    
    for(Project p: Project.findAll()){
        options.put(p.getId().toString(),p.getProjectName());
    }
    return options;
    
    
    }
    public static boolean inProject(Long project, Long employee) {
        return find.query().where()
            .eq("employee.id", project)
            .eq("id", project)
            .findCount() > 0;
    }

}

 

