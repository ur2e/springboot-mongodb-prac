package com.probono.web.service;

import com.probono.web.exception.ToDoCollectionException;
import com.probono.web.model.TodoDTO;
import com.probono.web.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public void createTodo(TodoDTO todo) throws ConstraintViolationException, ToDoCollectionException{
        Optional<TodoDTO> todoOptional = todoRepository.findByTodo(todo.getTodo());
        if (todoOptional.isPresent()) {
            throw new ToDoCollectionException(ToDoCollectionException.TodoAlreadyExists());
        } else {
            todo.setCreatedAt(new Date(System.currentTimeMillis()));
            todoRepository.save(todo);
        }
    }
}