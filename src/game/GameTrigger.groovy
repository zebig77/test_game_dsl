package game

class GameTrigger {

    static allTriggers = [:]
    static GameTrigger current

    String eventName
    Closure action

    private GameTrigger(String eventName) {
        this.eventName = eventName
        allTriggers[eventName] = this
        current = this
    }

    static GameTrigger getInstance(String eventName) {
        current = allTriggers[eventName]
        if (current == null) {
            current = new GameTrigger(eventName)
        }
        return current
    }

    void then(Closure action) {
        this.action = action
    }
}

