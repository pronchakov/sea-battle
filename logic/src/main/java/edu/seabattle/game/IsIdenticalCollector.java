package edu.seabattle.game;

import com.google.common.collect.ImmutableSet;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class IsIdenticalCollector implements Collector<Integer, ImmutableSet.Builder, Boolean> {
    @Override
    public Supplier<ImmutableSet.Builder> supplier() {
        return ImmutableSet::builder;
    }

    @Override
    public BiConsumer<ImmutableSet.Builder, Integer> accumulator() {
        return ImmutableSet.Builder::add;
    }

    @Override
    public BinaryOperator<ImmutableSet.Builder> combiner() {
        return (left, right) -> left.addAll(right.build());
    }

    @Override
    public Function<ImmutableSet.Builder, Boolean> finisher() {
        return builder -> builder.build().size() == 1;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
