package game

class GameMap {

    static allMaps = [:]
    static GameMap current

    String mapName
    boolean loaded = false

    private GameMap(String mapName) {
        this.mapName = mapName
        allMaps[mapName] = this
        current = this
    }

    static public GameMap getInstance(String mapName) {
        current = allMaps[mapName]
        if (current == null) {
            current = new GameMap(mapName)
        }
        if (current.loaded == false)
            AssetManager.loadMap(mapName)
    }
}
