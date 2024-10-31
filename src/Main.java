import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

            students.add(new Student(1,"夏木昴", "東京"));
            students.add(new Student(2,"えみぃあ", "神戸"));
            students.add(new Student(3,"レインは", "鬼島"));
            students.add(new Student(4,"レム", "北海道"));
            
        String path = "input.txt";
        writeDatforStudenta(path, students );
        List<Student> result = readDataForStudent(path);
        System.out.println(result.toString());
        
    }

    public static void writeDatforStudenta(String path, List<Student> students ) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
               oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> readDataForStudent(String path) {
        List<Student> studentList = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
             studentList = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}