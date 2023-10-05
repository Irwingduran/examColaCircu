public class EvaluadorRPN {
public static double evaluarExpresionRPN(String expresion) {
String[] tokens = expresion.split("\\s+"); // Divide la expresión en tokens
Pila<Double> pila = new Pila<>();

for (String token : tokens) {
try {
double numero = Double.parseDouble(token);
pila.push(numero);
} catch (NumberFormatException e) {
// Si no es un número, es un operador
if (token.equals("+")) {
double segundoNumero = pila.pop();
double primerNumero = pila.pop();
double resultado = primerNumero + segundoNumero;
pila.push(resultado);
} else if (token.equals("-")) {
double segundoNumero = pila.pop();
double primerNumero = pila.pop();
double resultado = primerNumero - segundoNumero;
pila.push(resultado);
} else if (token.equals("*")) {
double segundoNumero = pila.pop();
double primerNumero = pila.pop();
double resultado = primerNumero * segundoNumero;
pila.push(resultado);
} else if (token.equals("/")) {
double segundoNumero = pila.pop();
double primerNumero = pila.pop();
double resultado = primerNumero / segundoNumero;
pila.push(resultado);
} else {
throw new IllegalArgumentException("Operador no válido: " + token);
}
}
}

if (pila.size() != 1) {
throw new IllegalArgumentException("Expresión RPN no válida");
}

return pila.peek();
}

public static void main(String[] args) {
String expresionRPN = "3 4 + 2 * 7 /"; // Ejemplo de expresión RPN
double resultado = evaluarExpresionRPN(expresionRPN);
System.out.println("Resultado: " + resultado);
}
}
