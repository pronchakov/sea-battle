package edu.seabattle.game;

import edu.seabattle.game.entity.Player;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class PlayerSequence implements Iterable {
    private Container first;
    private Container last;
    private Container current;

    public PlayerSequence(Player p1, Player p2) {
        first = new Container(p1);
        last = new Container(p2);

        first.next = last;
        first.previous = last;
        last.next = first;
        last.previous = first;
        current = first;
    }

    public Player first() {
        return first.player;
    }

    public Player last() {
        return last.player;
    }

    public void useNextPlayer() {
        current = current.next;
    }

    public Player getCurrent() {
        return current.player;
    }

    public Player getNext() {
        return current.next.player;
    }

    public Stream<Player> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    @Override
    public Iterator iterator() {
        return new PlayerIterator();
    }

    private class PlayerIterator implements Iterator {
        private List data = List.of(first, last);
        private int index = -1;

        @Override
        public boolean hasNext() {
            return index != 1;
        }

        @Override
        public Object next() {
            index++;
            return data.get(index);
        }
    }

    @RequiredArgsConstructor
    private class Container {
        @NonNull
        private Player player;
        private Container previous;
        private Container next;
    }

}
