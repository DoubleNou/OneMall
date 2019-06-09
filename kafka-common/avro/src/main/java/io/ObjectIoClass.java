package io;

import java.io.*;

/**
 * @program: kafka-common
 * @description:
 * @author: Nou
 * @create: 2019-06-09 18:13
 **/
public class ObjectIoClass {

    public static void main(String[] args) {

        try (ByteArrayOutputStream os = new ByteArrayOutputStream(); ObjectOutputStream obs = new ObjectOutputStream(new BufferedOutputStream(os))) {

            obs.write(1);
            obs.write(2);
            obs.write(3);
            obs.write(4);

            obs.writeObject(new Employee("马云", "4000000"));
            obs.flush();
            byte[] datas = os.toByteArray();

            System.out.println(datas.length);

            BufferedInputStream is = new BufferedInputStream(new ByteArrayInputStream(datas));

            ObjectInputStream objectInputStream = new ObjectInputStream(is);

            System.out.println(objectInputStream.read());
            System.out.println(objectInputStream.read());
            System.out.println(objectInputStream.read());
            System.out.println(objectInputStream.read());
            System.out.println(objectInputStream.read());

            Object employee = objectInputStream.readObject();

            if(employee instanceof Employee){
                Employee employee2 = (Employee) employee;
                System.out.println(employee2.getName() + employee2.getSalary());

            }

        } catch ( IOException e ) {
            e.printStackTrace();
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }


}

class Employee implements Serializable{
    String  name;
    String salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Employee(String name, String salary) {
        this.name = name;
        this.salary = salary;
    }
}