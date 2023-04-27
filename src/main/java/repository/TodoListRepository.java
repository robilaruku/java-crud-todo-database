package repository;

import entity.TodoList;

public interface TodoListRepository {
    
    TodoList[] getAll();

    void add(TodoList todoList);

    Boolean remove(Integer number);

}