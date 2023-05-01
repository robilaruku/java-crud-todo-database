package repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariDataSource;

import entity.TodoList;
import util.DatabaseUtil;

public class TodolistRepositoryImplTest {

    private HikariDataSource dataSource;

    private TodoListRepository todoListRepository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        todoListRepository = new TodoListRepositoryImpl(dataSource);
    }

    @Test
    void testAdd() {
        TodoList todolist = new TodoList();
        todolist.setTodo("Dream");
        todoListRepository.add(todolist);
    }

    @Test
    void testRemove() {
        System.out.println(todoListRepository.remove(1));
        System.out.println(todoListRepository.remove(2));
        System.out.println(todoListRepository.remove(3));
        System.out.println(todoListRepository.remove(4));
    }

    @Test
    void testGetAll() {
        todoListRepository.add(new TodoList("Robi"));
        todoListRepository.add(new TodoList("Dream"));
        todoListRepository.add(new TodoList("Laruku"));

        TodoList[] todolists = todoListRepository.getAll();

        for (TodoList todoList : todolists) {
            System.out.println(todoList.getId() + " : " + todoList.getTodo());
        }
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }

}
