module edu.seabattle.logic {
    requires lombok;
//    requires com.google.common;

    exports edu.seabattle.game.entity;
    exports edu.seabattle.game.field.cell;
    exports edu.seabattle.game.player;
    exports edu.seabattle.game.field;
    exports edu.seabattle.game.field.ship;
}