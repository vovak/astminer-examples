/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package me.vovak.astminer.examples

import astminer.common.model.Node
import astminer.parse.java.GumTreeJavaParser
import java.io.File

const val INPUT_PATH = "input.java"

data class ParameterDefinition(val TypeLabel: String, val name: String)
data class MethodMetadata(val comment: String, 
                          val identifier: String, 
                          val parameters: List<ParameterDefinition>, 
                          val returnStatements: List<String>)

fun Node.getComment(): String = "Not Implemented"
fun Node.getName(): String = "Not Implemented"
fun Node.getParameters(): List<ParameterDefinition> = emptyList() // not implemented
fun Node.getReturnStatements(): List<String> = emptyList() // not implemented

fun getMetadata(methodNode: Node): MethodMetadata {
    return MethodMetadata(
            methodNode.getComment(),
            methodNode.getName(),
            methodNode.getParameters(),
            methodNode.getReturnStatements()
    )
}

fun main(args: Array<String>) {
    val tree = GumTreeJavaParser().parseFile(File(INPUT_PATH)).root

    println(getMetadata(tree!!))
}
