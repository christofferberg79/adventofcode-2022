package cberg.aoc2022

import java.io.File

class Input(filename: String) {
    private val file = File("input/$filename")

    fun oneLine() = lines().first()
    fun lines() = file.readLines()
    fun intLines() = lines().map { it.toInt() }
}