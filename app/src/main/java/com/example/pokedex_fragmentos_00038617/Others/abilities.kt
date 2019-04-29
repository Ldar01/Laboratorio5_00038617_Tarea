package com.example.pokedex_fragmentos_00038617.Others

class abilities (ability : ability, is_hidden : Boolean, slot : Int){
    var ability: ability?= null
    var is_hidden: Boolean = true
    var slot:Int = 0

    init {
        this.ability = ability
        this.is_hidden = is_hidden
        this.slot = slot
    }
}