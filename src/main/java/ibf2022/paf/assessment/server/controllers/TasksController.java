package ibf2022.paf.assessment.server.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ibf2022.paf.assessment.server.services.TodoService;
import ibf2022.paf.assessment.server.models.Task;


@RestController
@RequestMapping
public class TasksController {
      
    @Autowired
    private TodoService todoService;

    @PostMapping(path={ "/task" }, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> saveTask(@RequestBody MultiValueMap<String, String> payload) {
		
        String userName = payload.getFirst("username");
        int priority = Integer.parseInt(payload.getFirst("priority"));
        String decription = payload.getFirst("description");
        String dueDate = payload.getFirst("dueDate");


        LocalDate date = LocalDate.parse(dueDate);

        Task task = new Task();
        task.setDescription(decription);
        task.setPriority(priority);
        task.setDueDate(date);
                     
        todoService.upsertTask(task, userName);

        return ResponseEntity.ok("Task saved");

        
    }

   
    
}
