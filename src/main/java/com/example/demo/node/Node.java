package com.example.demo.node;

import java.util.Collection;

public interface Node {
    Collection<Node> getChildren();

    Long getValue();

    void setValue(Long value);

}