package boj

import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val stack = ArrayDeque<Char>()
    val sc = Scanner(System.`in`)
    val original = sc.nextLine()
    val sb = java.lang.StringBuilder()
    for (c in original) {
        when (c) {
            '(' -> stack.add(c)
            ')' -> {
                while (stack.isNotEmpty() && stack.last() != '(') {
                    sb.append(stack.removeLast())
                }
                stack.removeLast()
            }
            '*', '/' -> {
                if (stack.isNotEmpty() && (stack.last() == '*' || stack.last() == '/')) {
                    sb.append(stack.removeLast())
                }
                stack.add(c)
            }
            '+', '-' -> {
                while (stack.isNotEmpty() && stack.last() != '(')
                    sb.append(stack.removeLast())
                stack.add(c)
            }
            else -> sb.append(c)
        }
    }
    while (stack.isNotEmpty())
        sb.append(stack.removeLast())
    println(sb.toString())
}
