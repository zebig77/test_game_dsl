package game

class GameLevel extends Expando {
    static GameLevel current
    static allLevels = [:]

    String levelName

    private GameLevel(String levelName) {
        this.levelName = levelName
        allLevels[levelName] = this
        current = this
    }

    public static GameLevel getInstance(String levelName) {
        current = allLevels[levelName]
        if (current == null) {
            current = new GameLevel(levelName)
        }
        return current
    }

}

