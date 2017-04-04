package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("JR_USERS", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            User user2 = new User();
            User user3 = new User();

            user1.setFirstName("dex");
            user1.setLastName("bond");
            user1.setMale(true);
            user1.setBirthDate(new Date(1985, 9, 10));
            user1.setCountry(User.Country.UKRAINE);

            user2.setFirstName("halyna");
            user2.setLastName("bond");
            user2.setCountry(User.Country.RUSSIA);

            user3.setFirstName("fsdfs");
            user3.setLastName("werwer");
            user3.setMale(true);
            user3.setBirthDate(new Date(1990, 2, 10));

            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.users.add(user3);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (loadedObject.equals(javaRush)){
                System.out.println("TRUE");
            } else {
                System.out.println("FALSE");
            }
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);

            String hasUsers = !this.users.isEmpty() ? "yes" : "no";
            writer.println(hasUsers);
            if (!this.users.isEmpty()) {
                for (User user : this.users) {
                    writer.println(user.getFirstName() != null ? user.getFirstName() : "none");
                    writer.println(user.getLastName() != null ? user.getLastName() : "none");
                    writer.println(user.getBirthDate() != null ? user.getBirthDate().getTime() : "none");
                    writer.println(user.isMale() ? "male" : "female");
                    writer.println(user.getCountry() != null ? user.getCountry().getDisplayedName() : "none");
                }
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String hasUsers = reader.readLine();
            if (hasUsers.equals("yes")) {
                while (reader.ready()) {
                    User user = new User();
                    String firstName = reader.readLine();
                    if (!firstName.equals("none")) user.setFirstName(firstName);
                    String lastName = reader.readLine();
                    if (!lastName.equals("none")) user.setLastName(lastName);
                    String birthDate = reader.readLine();
                    if (!birthDate.equals("none")) user.setBirthDate(new Date(Long.parseLong(birthDate)));
                    String gender = reader.readLine();
                    if (gender.equals("male")) user.setMale(true);
                    String country = reader.readLine();
                    if (!country.equals("none")){
                        switch (country){
                            case "Ukraine":
                                user.setCountry(User.Country.UKRAINE);
                                break;
                            case  "Russia":
                                user.setCountry(User.Country.RUSSIA);
                                break;
                            default:
                                user.setCountry(User.Country.OTHER);
                                break;
                        }
                    }
                    this.users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
