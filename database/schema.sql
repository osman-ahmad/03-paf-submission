CREATE TABLE user(
    user_id char(8) Not Null,
    username varchar(64) Not Null,
    name varchar(64),
    CONSTRAINT PK_userId PRIMARY KEY (user_id)
    );
    
CREATE TABLE task(
    task_id int Not Null auto_increment,
    description varchar(255) Not Null,
    priority tinyint Not Null,
    due_date Date Not Null,
    user_id char(8) Not Null,
    CONSTRAINT PK_taskId PRIMARY KEY (task_id),
    CONSTRAINT FK_userId FOREIGN KEY (user_id) REFERENCES user(user_id)
    );


