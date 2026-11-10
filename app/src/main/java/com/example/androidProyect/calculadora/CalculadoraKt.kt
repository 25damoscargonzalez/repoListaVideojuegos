package com.example.calculadora

class CalculadoraKt {

    //Atributos (Suelen ser publicos, no se suelen hacer getters y setters, se hacen automaticamente)
    var num1: String = ""
    var num2: String = ""
    var operacion: Char = 0.toChar() //Entero 0, los numeros tambien tienen metodos

    //Constructor no hace falta, el valor por defecto se pone en los atributos

    fun meterNumero(num: Int) {
        num2 += num
    }

    fun meterComa() {
        if (!num2.contains(".")) {
            num2 += "."
        }
    }

    fun operacion(op: Char) {
        num1 = num2
        num2 = ""
        operacion = op
    }

    fun igual() {
        val num1 = this.num1.toDouble()
        val num2 = this.num2.toDouble()

        when (operacion) {
            '+' -> this.num2 = (num1 + num2).toString()
            '-' -> this.num2 = (num1 - num2).toString()
            '*' -> this.num2 = (num1 * num2).toString()
            '/' -> this.num2 = (num1 / num2).toString()
            else -> this.num2 = "0"
        }

    }

    fun borrar() {
        num1 = ""
        num2 = ""
        operacion = 0.toChar()
    }



}