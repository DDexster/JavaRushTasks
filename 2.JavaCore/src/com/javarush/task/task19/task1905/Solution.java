package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        Customer customer = new CustomerImpl();
        Contact contact = new ContactImpl();
        DataAdapter dataAdapter = new DataAdapter(customer, contact);
        System.out.println(dataAdapter.getCountryCode());
        System.out.println(dataAdapter.getCompany());
        System.out.println(dataAdapter.getContactFirstName());
        System.out.println(dataAdapter.getContactLastName());
        System.out.println(dataAdapter.getDialString());
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            for (Map.Entry<String, String> set : countries.entrySet()) {
                if (set.getValue().equals(customer.getCountryName())) {
                    return set.getKey();
                }
            }
            return null;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] fullName = contact.getName().split(", ");

            return fullName[1];
        }

        @Override
        public String getContactLastName() {
            String[] fullName = contact.getName().split(", ");

            return fullName[0];
        }

        @Override
        public String getDialString() {
            String dialString = "callto://+";
            String number = contact.getPhoneNumber();
            for (char c : number.toCharArray()) {
                if (Character.isDigit(c)) {
                    dialString += c;
                }
            }

            return dialString;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }

    private static class CustomerImpl implements Customer {
        @Override
        public String getCompanyName() {
            return "JavaRush Ltd.";
        }

        @Override
        public String getCountryName() {
            return "Ukraine";
        }
    }

    private static class ContactImpl implements Contact {
        @Override
        public String getName() {
            return "Ivanov, Ivan";
        }

        @Override
        public String getPhoneNumber() {
            return "+38(050)123-45-66";
        }
    }
}