import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    //2
    /*
        Дана строка. Вывести первый, последний и средний(если он есть) символы.
     */

    private static void l2e1() {
        System.out.println("Введите строку");
        String s = scanner.nextLine();
        System.out.println("Первый символ - " + s.charAt(0) +
                ". Последний символ - " + (s.charAt(s.length() - 1)) +
                (s.length() % 2 == 0 ? "." : ". Средний символ - " + s.charAt(s.length() / 2)));
    }

    /*
        В данной строке найти количество цифр.
     */
    private static void l2e2() {
        System.out.println("Введите строку");
        String s = scanner.nextLine();
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                k++;
            }
        }
        System.out.println(k);
    }

    /*
        Даны 2 слова. Найдите только те символы слов, которые встречаются в обоих словах только один раз.
     */
    private static void l2e3() {
        System.out.println("Введите 2 слова");
        String[] s = scanner.nextLine().split(" ");
        for (int i = 0; i < s[0].length(); i++) {
            if (s[1].indexOf(s[0].charAt(i)) == s[1].lastIndexOf(s[0].charAt(i)) && s[1].indexOf(s[0].charAt(i)) != -1) System.out.print(s[0].charAt(i) + " ");
        }
        System.out.println();
    }

    //3
    /*
        Дана строка, состоязая из слов, разделенных пробелами. Сформировать новую строку со следующими свойствами:
            а) все слова в нижнем регистре, кроме первой буквы первого слова;
            б) все ссылки в словах заменяются на "[ссылка запрещена]";
            в) все email заменяются на "[контакты запрещены]"
            г) все слова длины более 3х символов, содержащие только цифры удаляются.
     */
    private static void l3e1() {
        System.out.println("Введите строку");
        String s = scanner.nextLine();
        String[] ars = s.toLowerCase().trim().split(" ");
        for (int i = 0; i < ars.length; i++) {
            if(ars[i].contains("@")) { ars[i] = ars[i].replace(ars[i], "[контакты запрещены]"); continue; }
            if(ars[i].contains(".")) { ars[i] = ars[i].replace(ars[i], "[ссылки запрещены]"); continue; }
            int k = 0;
            for (int j = 0; j < ars[i].length(); j++) {
                if (Character.isDigit(ars[i].charAt(j))) {
                    k++;
                }
            }
            if (k == ars[i].length() && k > 3) ars[i] = ars[i].replace(ars[i], "");
        }
        ars[0] = Character.toUpperCase(ars[0].charAt(0)) + ars[0].substring(1);
        s = String.join(" ", ars);
        System.out.println(s);
    }

    /*
        Написать программу, реализующую процедуру удаления k символов с позиции номер n из строки S.
     */
    private static void l3e2() {
        System.out.println("Введите строку");
        String s = scanner.nextLine();
        System.out.println("Введите количество символов k");
        int k = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите номер позиции n");
        int n = Integer.parseInt(scanner.nextLine());
        s = s.replace(s.substring(n - 1, n + k - 1), "");
        System.out.println(s);
    }

    /*
        Даны два предложения. Для каждого слова первого предложения определите количество его вхождений во второе предложение.
     */
    private static void l3e3() {
        System.out.println("Введите 2 предложения");
        String[] s = scanner.nextLine().trim().split("\\.");
        String[] words1 = s[0].trim().split(" ");
        String[] words2 = s[1].trim().split(" ");
        for (String s1 : words1) {
            int k = 0;
            for (String s2 : words2) {
                if (s1.equals(s2)) k++;
            }
            System.out.println(s1 + " - " + k);
        }
    }

    //4
    /*
        В данном массиве найдите наибольшую серию подряд идущих элементов, расположенных по возрастанию.
     */
    private static void l4e1() {
        System.out.println("Введите длину массива");
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        System.out.println("Введите элементы массива");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int k = 0;
        int beginIndOfSequence = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                k++;
                beginIndOfSequence = i - k;
            } else {
                k = 0;
                beginIndOfSequence = 0;
            }
        }
        System.out.println("Наибольшая серия подряд идущих элементов, расположенных по возрастанию:");
        for (int i = beginIndOfSequence; i < k + beginIndOfSequence + 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        scanner.nextLine();
    }

    /*
        Переставить элементы массива в обратном порядке.
     */
    private static void l4e2() {
        System.out.println("Введите длину массива");
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        System.out.println("Введите элементы массива");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = arr.length - 1; i != -1; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        scanner.nextLine();
    }

    /*
        Даны два упорядоченных по возрастанию массива. Образовать из этих двух массивов единый упорядоченный по возрастанию массив.
     */
    private static void l4e3() {
        System.out.println("Введите длину первого массива");
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Введите элементы первого массива");
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = scanner.nextInt();
        }
        System.out.println("Введите длину второго массива");
        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Введите элементы второго массива");
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = scanner.nextInt();
        }
        int[] arr = new int[n1 + n2];
        int k = 0, j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (j == arr2.length) {
                arr[i] = arr1[k];
                k++;
                continue;
            }
            if (k == arr1.length) {
                arr[i] = arr1[j];
                j++;
                continue;
            }
            if (arr1[k] <= arr2[j]) {
                arr[i] = arr1[k];
                k++;
            } else{
                arr[i] = arr2[j];
                j++;
            }
        }
        for (int i1 : arr) System.out.print(i1 + " ");
        System.out.println();
        scanner.nextLine();
    }


    public static void main(String[] args) {
        boolean f;
        do {
            System.out.println("Выберите задание:\n" +
                    "Лабораторная работа 2:\n" +
                    "   1.Дана строка. Вывести первый, последний и средний(если он есть) символы.\n" +
                    "   2.В данной строке найти количество цифр.\n" +
                    "   3.Даны 2 слова. Найдите только те символы слов, которые встречаются в обоих словах только один раз.\n\n" +
                    "Лабораторная работа 3:\n" +
                    "   4.Дана строка, состоязая из слов, разделенных пробелами. Сформировать новую строку со следующими свойствами:\n" +
                    "            а) все слова в нижнем регистре, кроме первой буквы первого слова;\n" +
                    "            б) все ссылки в словах заменяются на \"[ссылка запрещена]\";\n" +
                    "            в) все email заменяются на \"[контакты запрещены]\"\n" +
                    "            г) все слова длины более 3х символов, содержащие только цифры удаляются.\n" +
                    "   5.Написать программу, реализующую процедуру удаления k символов с позиции номер n из строки S.\n" +
                    "   6.Даны два предложения. Для каждого слова первого предложения определите количество его вхождений во второе предложение.\n\n" +
                    "Лабораторная работа 4:\n" +
                    "   7.В данном массиве найдите наибольшую серию подряд идущих элементов, расположенных по возрастанию.\n" +
                    "   8.Переставить элементы массива в обратном порядке.\n" +
                    "   9.Даны два упорядоченных по возрастанию массива. Образовать из этих двух массивов единый упорядоченный по возрастанию массив.\n" +
                    "0.Выход");

            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    l2e1();
                    f = false;
                    System.out.println("Для продолжения нажмите Enter");
                    scanner.nextLine();
                    break;
                case 2:
                    l2e2();
                    f = false;
                    System.out.println("Для продолжения нажмите Enter");
                    scanner.nextLine();
                    break;
                case 3:
                    l2e3();
                    f = false;
                    System.out.println("Для продолжения нажмите Enter");
                    scanner.nextLine();
                    break;
                case 4:
                    l3e1();
                    f = false;
                    System.out.println("Для продолжения нажмите Enter");
                    scanner.nextLine();
                    break;
                case 5:
                    l3e2();
                    f = false;
                    System.out.println("Для продолжения нажмите Enter");
                    scanner.nextLine();
                    break;
                case 6:
                    l3e3();
                    f = false;
                    System.out.println("Для продолжения нажмите Enter");
                    scanner.nextLine();
                    break;
                case 7:
                    l4e1();
                    f = false;
                    System.out.println("Для продолжения нажмите Enter");
                    scanner.nextLine();
                    break;
                case 8:
                    l4e2();
                    f = false;
                    System.out.println("Для продолжения нажмите Enter");
                    scanner.nextLine();
                    break;
                case 9:
                    l4e3();
                    f = false;
                    System.out.println("Для продолжения нажмите Enter");
                    scanner.nextLine();
                    break;
                case 0:
                    System.exit(0);
                default:
                    f = true;
            }
        } while (!f);
    }
}
