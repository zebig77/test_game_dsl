package dsl

import game.GameLevel
import game.GameMap
import game.GameObject
import game.GameState
import game.GameTrigger

/* define a game */
static void game(Closure c) {
    GameState.current = new GameState()
    c.resolveStrategy = Closure.DELEGATE_ONLY
    c.delegate = GameState.current
    c.call()
}

/* reference (and create if it doesn't exist) a GameObject */
static GameObject object(String objectName) {
    return GameObject.getInstance(objectName)
}

static GameTrigger when(String eventName) {
    return GameTrigger.getInstance(eventName)
}

static GameLevel level( String levelName, Closure c) {
    return GameLevel.getInstance(levelName)
}

static GameMap map( String mapName, Closure c) {
    return GameMap.getInstance(mapName)
}

static String random(String... list) {
    list.each {}
}

