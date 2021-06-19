package com.probono.web.service;

import com.probono.web.exception.ToDoCollectionException;
import com.probono.web.model.TodoDTO;

import javax.validation.ConstraintViolationException;
import java.util.List;

public interface TodoService {

    public void createTodo(TodoDTO todo) throws ConstraintViolationException, ToDoCollectionException ;

    public List<TodoDTO> getALlTodos();
}
