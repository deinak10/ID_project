package app.model;

import app.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


 public class model {
    private static app.model.model instance = new model();

    private List<User> model;

    public static app.model.model getInstance() {
        return instance;
    }

    private model() {
        model = new ArrayList<>();
    }

    public void add(User user) {
        model.add(user);
    }

    public List<String> list() {
        return model.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }
    
}