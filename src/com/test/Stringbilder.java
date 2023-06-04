package com.test;

public class Stringbilder {
    public static void main(String[] args) {
        //StringBuilder это как класс String но его лучше использовать когда нужно делать много операций над строками так как он делает строку изменяем типом данных
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" musa ").append(5);//присоеденит к строке musa и 5
        System.out.println(sb);
    }
}
 /*
        char	charAt(int index)
        Возвращает char значение в этой последовательности с указанным индексом.

        StringBuilder	delete(int start, int end)
        Удаляет символы в подстроке этой последовательности.
        StringBuilder	deleteCharAt(int index)
        Удаляет charв указанной позиции в этой последовательности.

        int	indexOf(String str)
        Возвращает индекс в этой строке первого вхождения указанной подстроки.
        int	indexOf(String str, int fromIndex)
        Возвращает индекс в этой строке первого вхождения указанной подстроки, начиная с указанного индекса.
        StringBuilder	insert(int offset, String b)
        Вставляет строковое представление booleanаргумента в эту последовательность.
        int	length()
        Возвращает длину (количество символов).

        String	substring(int start, int end)
        Возвращает newString, который содержит подпоследовательность символов, содержащихся в данный момент в этой последовательности.
и, используемой для последовательности символов.*/