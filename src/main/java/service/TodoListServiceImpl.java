package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {

        TodoList[] model = todoListRepository.getAll();

        System.out.println("TODOLIST");

        for (Integer i = 0; i < model.length; i++) {

            Object todolist = model[i];

            Integer no = i + 1;

            if (todolist != null) {
                System.out.println(no + ". " + ((TodoList) todolist).getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todolist = new TodoList(todo);
        todoListRepository.add(todolist);
        System.out.println("Sukses menambah todo : " + todo);
    }

    @Override
    public void removeTodoList(Integer number) {
        Boolean success = todoListRepository.remove(number);
        if (success) {
            System.out.println("Sukses menghapus todo : " + number);
        }else{
            System.out.println("Gagal menghapus todo : " + number);
        }
    }

}