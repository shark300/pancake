package io.github.pancake.app.order.view.model;

import java.util.List;

import io.github.pancake.persistence.base.Pancake;

public class ListPancakesModel {
    private List<Pancake> pancakes;

    public ListPancakesModel(List<Pancake> pancakes) {
        this.pancakes = pancakes;
    }

    public List<Pancake> getPancakes() {
        return pancakes;
    }
}
