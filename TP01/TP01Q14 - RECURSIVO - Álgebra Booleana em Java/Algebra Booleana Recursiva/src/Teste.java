public class Teste {
    public static void main(String[] args){
        String str = MyIO.readLine();
        boolean valor = evaluateExpression(str, 0, str.length());
    }

    public static boolean evaluateExpression(String expression, int startIndex, int endIndex) {
        if (startIndex == endIndex) { // caso base: expressão tem apenas um valor
            return expression.charAt(startIndex) == '1';
        }

        int i = startIndex;
        while (i <= endIndex && expression.charAt(i) != '(') {
            i++; // encontra o índice do primeiro parêntese aberto
        }

        if (i > endIndex) { // caso base: expressão é apenas um valor
            return expression.charAt(startIndex) == '1';
        }

        char op = expression.charAt(i - 1); // operador
        int j = i + 1; // índice do parêntese correspondente ao primeiro encontrado
        int count = 1;
        while (count > 0) { // encontra o índice do parêntese fechado correspondente
            if (expression.charAt(j) == '(') {
                count++;
            } else if (expression.charAt(j) == ')') {
                count--;
            }
            j++;
        }
        j--; // ajusta o índice para o parêntese fechado correspondente

        boolean result = evaluateExpression(expression, i, j - 1);
        int k = j + 1; // índice do início da próxima operação, caso exista

        while (k <= endIndex && expression.charAt(k) != ')') {
            i = k + 1;
            while (i <= endIndex && expression.charAt(i) != '(') {
                i++; // encontra o índice do próximo parêntese aberto
            }
            if (i > endIndex) { // caso base: não há mais operações
                break;
            }
            op = expression.charAt(i - 1);
            j = i + 1;
            count = 1;
            while (count > 0) {
                if (expression.charAt(j) == '(') {
                    count++;
                } else if (expression.charAt(j) == ')') {
                    count--;
                }
                j++;
            }
            j--;
            boolean subResult = evaluateExpression(expression, i, j - 1);
            if (op == 'a') { // operação AND
                result &= subResult;
            } else if (op == 'o') { // operação OR
                result |= subResult;
            } else if (op == 'n') { // operação NOT
                result &= !subResult;
            }
            k = j + 1; // ajusta o índice para o início da próxima operação, caso exista
        }

        return result;
    }

}
