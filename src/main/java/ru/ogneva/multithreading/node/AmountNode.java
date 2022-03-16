package ru.ogneva.multithreading.node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AmountNode implements Node {
    private Long value;
    private final Collection<Node> children;

    public AmountNode(Long value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public AmountNode(Long value, List<Node> children) {
        this.value = value;
        this.children = children;
    }

    @Override
    public Collection<Node> getChildren() {
        return children;
    }

    @Override
    public Long getValue() {
        return value;
    }

    @Override
    public void setValue(Long value) {
        this.value = value;
    }

}
