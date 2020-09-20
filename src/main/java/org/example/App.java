package org.example;

public class App {
    public static void main(String[] args) {
        CityDaoJDBC cityDaoJDBC = new CityDaoJDBC();

        //Testing findById
        System.out.println("Testing findById:");
        System.out.println(cityDaoJDBC.findById(1));
        System.out.println(cityDaoJDBC.findById(500));
        System.out.println(cityDaoJDBC.findById(Integer.MAX_VALUE));

        System.out.println();

        //Testing findByCode
        System.out.println("Testing findByCode:");
        cityDaoJDBC.findByCode("AGO").forEach(System.out::println);
        cityDaoJDBC.findByCode("KUK").forEach(System.out::println);

        System.out.println();

        //Testing findByName
        System.out.println("Testing findByName:");
        cityDaoJDBC.findByName("stoc").forEach(System.out::println);
        cityDaoJDBC.findByName("bokachod").forEach(System.out::println);

        System.out.println();

        //Testing findAll
        System.out.println("Testing findAll:");
        cityDaoJDBC.findAll()
                .stream()
                .limit(5)
                .forEach(System.out::println);

        System.out.println();

        //Testing add
        System.out.println("Testing add:");
        cityDaoJDBC.add(new City(
                6668, // ID is not auto incremented
                "TestTown",
                "SWE",
                "TestDistrict",
                1337));

        System.out.println(cityDaoJDBC.findById(6668));

        //Testing delete
        System.out.println("Testing delete:");
        cityDaoJDBC.delete(new City(
                6668, // ID is not auto incremented
                "TestTown",
                "SWE",
                "TestDistrict",
                1337));

        System.out.println(cityDaoJDBC.findById(6668));



    }




}
