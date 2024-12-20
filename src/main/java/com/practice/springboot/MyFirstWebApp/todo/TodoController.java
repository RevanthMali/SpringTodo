package com.practice.springboot.MyFirstWebApp.todo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
    
    @Autowired
    TodoService service;

    // Display list of todos
    @RequestMapping(value="/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model){
        String name = (String) model.get("name");
        System.out.println("name: " + name);
        model.put("todos", service.retrieveTodos(name));
        return "list-todos";
    }
    
    // Display add todo form
    @RequestMapping(value="/add-todo", method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap model){
        model.addAttribute("todo", new Todo()); // Initialize Todo object
        return "todo";
    }

    // Handle add todo form submission
    @RequestMapping(value="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Validated @ModelAttribute("todo") Todo todo, BindingResult result){
        if(result.hasErrors()) {
            return "todo";
        }
        service.addTodo((String) model.get("name"), todo.getDesc(), todo.getTargetDate(), false);
        return "redirect:/list-todos";
    }

    // Handle delete todo request
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        service.deleteById(id);
        return "redirect:list-todos";
    }
    
    // Display update todo form
    @RequestMapping(value="update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model){
        Todo todo = service.findById(id);
        model.addAttribute("todo", todo);
        return "todo";
    }

    // Handle update todo form submission
    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Validated @ModelAttribute("todo") Todo todo, BindingResult result){
        if(result.hasErrors()) {
            return "todo";
        }
        String username = (String) model.get("name");
        todo.setUser(username);
        service.updateTodo(todo);
        return "redirect:list-todos";
    }
}
