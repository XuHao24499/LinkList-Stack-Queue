package ASM2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class OperationToProduct {
    public static Scanner sc = new Scanner(System.in);

    public static Product createProduct() {
        Product addProduct = new Product();
        System.out.print("Nhap ID: ");
        addProduct.setId(sc.next());
        System.out.print("Nhap ten san pham: ");
        addProduct.setTitle(sc.next());
        System.out.print("Nhap so luong: ");
        addProduct.setQuantity(sc.nextInt());
        System.out.print("Nhap gia: ");
        addProduct.setPrice(sc.nextDouble());

        return addProduct;
    }

    public static void addProduct(MyList<Product> list) {
        while (true) {
            Product addProduct = createProduct();
            list.addTail(addProduct);
            System.out.println("Ban co muon tiep tuc them nhan vien: chon Y/N");
            if (sc.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public static MyList<Product> readToList() {
        MyList<Product> list = new MyList<>();
        try {
            Path path = Paths.get("data.txt");
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] elements = line.split(" ");
                Product product = new Product(elements[0], elements[1], Integer.parseInt(elements[2]), Double.parseDouble(elements[3]));
                list.addTail(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static MyStack<Product> readToStack() {
        MyStack<Product> stack = new MyStack<>();
        try {
            Path path = Paths.get("data.txt");
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] elements = line.split(" ");
                Product product = new Product(elements[0], elements[1], Integer.parseInt(elements[2]), Double.parseDouble(elements[3]));
                stack.push(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stack;
    }

    public static MyQueue<Product> readToQueue() {
        MyQueue<Product> queue = new MyQueue<>();
        try {
            Path path = Paths.get("data.txt");
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] elements = line.split(" ");
                Product product = new Product(elements[0], elements[1], Integer.parseInt(elements[2]), Double.parseDouble(elements[3]));
                queue.push(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queue;
    }

    //    ham ghi vao file
    public static void writeToFile(String filename, MyList<Product> list) {
        try {
            FileWriter fw = new FileWriter("data.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            Node current = list.getHead();
            while (current != null) {
                bw.write(current.toString());
                current = current.getNextNode();
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Node findProduct(MyList<Product> list, String inputID) {
        for (Node cur = list.getHead(); cur != null; cur = cur.getNextNode()) {
            if (cur.getData().getId().equalsIgnoreCase(inputID)) {
                return cur;
            }
        }
        return null;
    }

    public static void convertToBinary(int number) {
        int remainder;
        if (number <= 1) {
            System.out.print(number);
            return;//thoat ra
        }

        remainder = number % 2;
        convertToBinary(number >> 1);
        System.out.print(remainder);
    }
}
