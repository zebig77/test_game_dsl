package game

class GameObject extends Expando {

    static allObjects = [:]
    static GameObject current

    String objectName
    int x
    int y
    def contains = []

    private GameObject(String objectName) {
        this.objectName = objectName
        allObjects[objectName] = this
        current = this
    }

    static GameObject getInstance(String objectName) {
        current = allObjects[objectName]
        if (current == null) {
            current = new GameObject(objectName)
        }
        return current
    }

    GameObject at(int x, int y) {
        this.x = x
        this.y = y
        return this
    }

    GameObject contains(String objectName) {
        this.contains << getInstance(objectName)
        return this
    }
}
