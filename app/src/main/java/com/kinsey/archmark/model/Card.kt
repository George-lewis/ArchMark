package com.kinsey.archmark.model

import java.util.*

class Card {
    var ends: MutableList<End> = mutableListOf<End>()
    val time: Date = Calendar.getInstance().time
    init{
        newEnd()
    }

    fun cumulativeScore(): Float = cumulativeScore(ends.size-1)

    fun cumulativeScore(upTo: Int): Float = ends.subList(0, upTo).map { it.endTotal() }.sum()
    
    fun allArrows(): List<Arrow> {
        val lst: MutableList<Arrow> = mutableListOf()
        for (end in ends) {
            lst += end.arrows
        }
        return lst
    }
    
    fun currentEnd(): End {
        return this.ends.last()
    }

    fun newEnd() {
        this.ends.add(End())
    }

    fun addArrow(arrow: Arrow) {
        currentEnd().addArrow(arrow)
    }

    fun getMostArrows(): Int {
        return Collections.max(ends.map { it.arrows.size })
    }
}