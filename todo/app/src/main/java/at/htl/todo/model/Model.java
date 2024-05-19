package at.htl.todo.model;

import java.util.List;

public class Model {
    public Todo[] todos = {
            new Todo(1L, 1L, "Buy milk", true),
            new Todo(2L, 2L, "Buy eggs", false),
            new Todo(2L, 3L, "Buy bread", false)
    };
}