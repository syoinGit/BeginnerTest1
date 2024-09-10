package org.example;

import java.util.Scanner;

public class Input {

  public static String UserInput() {
    Scanner scanner = new Scanner(System.in);

    int number, number2;
    String operator;

    while (true) {
      System.out.println("一番目の数値を入力してください");
      if (scanner.hasNextInt()) {
        number = scanner.nextInt();
        break;
      } else {
        System.out.println("無効な入力です。数値を入力してください。");
        scanner.nextLine();
      }
    }

    scanner.nextLine(); // 改行文字を消費

    while (true) {
      System.out.println("演算子を入力してください");
      if (scanner.hasNextLine()) {
        operator = scanner.nextLine();
        if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals(
            "/")) {
          break;
        } else {
          System.out.println("無効な演算子です。有効な演算子を入力してください。");
        }
      }
    }

    while (true) {
      System.out.println("二番目の数値を入力してください");
      if (scanner.hasNextInt()) {
        number2 = scanner.nextInt();
        break;
      } else {
        System.out.println("無効な入力です。数値を入力してください。");
        scanner.nextLine();
      }
    }

    int answer = switch (operator) {
      case "+" -> number + number2;
      case "-" -> number - number2;
      case "*" -> number * number2;
      case "/" -> {
        if (number2 == 0) {
          System.out.println("0 で割ることはできません。");
          yield 0;
        } else {
          yield number / number2;
        }
      }
      default -> {
        System.out.println("無効な演算子です。");
        yield 0;
      }
    };

    return number + operator + number2 + "=" + answer;
  }
}