package ibf2022.paf.assessment.server.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.repositories.TaskRepository;
import ibf2022.paf.assessment.server.repositories.UserRepository;

// TODO: Task 7

@Service
public class TodoService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;


    // public Optional<User> findUserByUsername(String username) {
    //     return userRepository.findUserByUsername(username);
    // }

    // public String insertUser(User user){
    //     return userRepository.insertUser(user);
    // }

        
       
    public void upsertTask(Task task, String username) {
        Optional<User> opt = userRepository.findUserByUsername(username);
        User user;
        if (opt.isPresent()) {
            user = opt.get();
        } else {
            user = new User();
            user.setUsername(username);
            user.setName(username);
            userRepository.insertUser(user);
        }
        task.setUserId(user.getUserId());
        taskRepository.insertTask(task);
    }
}    
