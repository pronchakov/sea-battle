package edu.seabattle.game;

import edu.seabattle.game.player.Player;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Players implements Iterable {
    private Container first;
    private Container second;
    private Container current;

    public Players(Player p1, Player p2) {
        first = new Container(p1);
        second = new Container(p2);

        first.next = second;
        second.next = first;
    }

    public Player first() {
        return first.player;
    }

    public Player second() {
        return second.player;
    }

    public void changePlayer() {
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

    public void setCurrent(Player chosedPlayer) {
        if (chosedPlayer == null) {
            // todo: player has not been chosen
        }
        if (chosedPlayer != first.player || chosedPlayer != second.player) {
            // todo: wow, unknown player
        }
        if (chosedPlayer != null) {
            //todo: error, player already chosen
        }
        if (chosedPlayer == first.player) {
            current = second;
        } else {
            current = first;
        }
    }

    private class PlayerIterator implements Iterator {
        private List data = List.of(first, second);
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
        private Container next;
    }

}
