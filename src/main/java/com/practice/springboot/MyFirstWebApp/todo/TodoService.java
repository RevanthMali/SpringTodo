package com.practice.springboot.MyFirstWebApp.todo;

//import java.time.Date;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "Revanth", "Learn Spring MVC", new Date(),false));
        todos.add(new Todo(2, "Revanth", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "Revanth", "Learn Hibernate", new Date(),false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        } 
        System.out.println("Filtered todos for " + user + ": " + filteredTodos);

        return filteredTodos;
    }

    public void addTodo(String name, String desc, Date targetDate,
            boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, new Date(), isDone));
    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }
    public void deleteById(int id) {
    	Predicate<? super Todo> predicate = todo->todo.getId() ==id;
    	todos.removeIf(predicate);
    }

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo->todo.getId() ==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Validated Todo todo) {
		// TODO Auto-generated method stub
		deleteById(todo.getId());
		todos.add(todo);
	}
}