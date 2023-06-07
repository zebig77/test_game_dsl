package dsl

import static DSL.*

// Game definition

game {
    // Player
    player_health = 100

    // Level
    level "start", {
        map "prison", {
            fill_with random("bush", "grass", "small_tree")
            1..8.each { x -> object "wall" at x,1 }
            1..8.each { x -> object "wall" at x,5 }
        }
    }

    // Objects
    object "chest" at 4,9 contains "key"

    // Triggers
    when "player_enters_bed" then { println "good night!" }
    when "player_touches_wall" then { println "blocked!" }
    when "player_touches_fireplace" then { println "it burns!" }
    when "player_enters_secret_passage" then { println "you found a secret passage!" }
    when "player_enters_touches_chest" then { chest -> if (chest.contains("key")) println "you found a key!" }
}
