package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {

    private TodoListService todolistService;

    public TodoListView(TodoListService todolistService) {
        this.todolistService = todolistService;
    }

    public void showTodoList() {
        while (true) {

            todolistService.showTodoList();

            System.out.println("Menu");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            String input = InputUtil.input("Pilih");

            if (input.equals("1")) {
                addTodoList();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public void addTodoList() {
        System.out.println("MENAMBAH TODOLIST");

        String todo = InputUtil.input("Todo (x Jika Batal)");

        if (!todo.equals("x")) {
            todolistService.addTodoList(todo);
        }
    }

    public void removeTodoList() {
        System.out.println("MENGHAPUS TODOLIST");

        String number = InputUtil.input("Nomor yang di hapus (x Jika Batal)");

        if (!number.equals("x")) {
            todolistService.removeTodoList(Integer.valueOf(number));
        }
    }
}