package com.kinsey.archmark.Model

class TargetFace(sizes: List<Float>, scores: List<Float>, val diameter: Float) {
    //TODO change this to take in a dictionary or something, so that sizes and scores are always the same length
    var rings: MutableList<Ring> = mutableListOf()

    init {
        for (i in sizes.indices) {
            rings.add(Ring(sizes[i], scores[i]))
        }
    }

    /**
     * Finds the ring that an arrow landed on
     */
    fun findRing(arrow:Arrow): Ring {

        val distance = arrow.distance

        //Find the smallest ring that has a radius greater than distance
        var smallest = rings.first()
        for (ring in this.rings) {
            if ((ring.radius > distance)&&(ring.radius < smallest.radius)) {
                smallest = ring
            }
        }
        return smallest

    }

}