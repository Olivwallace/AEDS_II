public class Teste {
    public static void main(String[] args){
        String str = MyIO.readLine();
        boolean valor = evaluateExpression(str, 0, str.length());
    }

    public static boolean evaluateExpression(String expression, int startIndex, int endIndex) {
        if (startIndex == endIndex) { // caso base: express�o tem apenas um valor
            return expression.charAt(startIndex) == '1';
        }

        int i = startIndex;
        while (i <= endIndex && expression.charAt(i) != '(') {
            i++; // encontra o �ndice do primeiro par�ntese aberto
        }

        if (i > endIndex) { // caso base: express�o � apenas um valor
            return expression.charAt(startIndex) == '1';
        }

        char op = expression.charAt(i - 1); // operador
        int j = i + 1; // �ndice do par�ntese correspondente ao primeiro encontrado
        int count = 1;
        while (count > 0) { // encontra o �ndice do par�ntese fechado correspondente
            if (expression.charAt(j) == '(') {
                count++;
            } else if (expression.charAt(j) == ')') {
                count--;
            }
            j++;
        }
        j--; // ajusta o �ndice para o par�ntese fechado correspondente

        boolean result = evaluateExpression(expression, i, j - 1);
        int k = j + 1; // �ndice do in�cio da pr�xima opera��o, caso exista

        while (k <= endIndex && expression.charAt(k) != ')') {
            i = k + 1;
            while (i <= endIndex && expression.charAt(i) != '(') {
                i++; // encontra o �ndice do pr�ximo par�ntese aberto
            }
            if (i > endIndex) { // caso base: n�o h� mais opera��es
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
            if (op == 'a') { // opera��o AND
                result &= subResult;
            } else if (op == 'o') { // opera��o OR
                result |= subResult;
            } else if (op == 'n') { // opera��o NOT
                result &= !subResult;
            }
            k = j + 1; // ajusta o �ndice para o in�cio da pr�xima opera��o, caso exista
        }

        return result;
    }

}
