package org.example;

public class App {
    public static void main(String[] args) {
        CityDaoJDBC cityDaoJDBC = new CityDaoJDBC();
        City testCity = new City(
                6666,
                "TestTown",
                "SWE",
                "TestDistrict",
                1337);

        //Testing findById
        System.out.println("Testing findById:");
        System.out.println(cityDaoJDBC.findById(1));
        System.out.println(cityDaoJDBC.findById(500));
        System.out.println(cityDaoJDBC.findById(Integer.MAX_VALUE));

        System.out.println();

        //Testing findByCode
        System.out.println("Testing findByCode:");
        cityDaoJDBC.findByCode("AGO").forEach(System.out::println);
        cityDaoJDBC.findByCode("KUK").forEach(System.out::println); // Blank

        System.out.println();

        //Testing findByName
        System.out.println("Testing findByName:");
        cityDaoJDBC.findByName("stoc").forEach(System.out::println);
        cityDaoJDBC.findByName("bokachoda").forEach(System.out::println); // Blank

        System.out.println();

        //Testing findAll
        System.out.println("Testing findAll:");
        cityDaoJDBC.findAll() // Does this send the ENTIRE database as a return?
                .stream()
                .limit(5)
                .forEach(System.out::println);

        System.out.println();

        //Testing add
        System.out.println("Testing add (ID 6666):");
        cityDaoJDBC.add(testCity);
        System.out.println(cityDaoJDBC.findById(6666));

        System.out.println();

        //Testing delete from the previous example
        System.out.println("Testing delete (ID 6666 from previous example):");
        int result = cityDaoJDBC.delete(testCity);
        System.out.println(result == 1 ? "City was successfully deleted" : "City was NOT deleted");
        System.out.println(cityDaoJDBC.findById(6666));

        System.out.println();

        //Testing deleting city that does not exist
        System.out.println("Testing delete (ID 6666 was already deleted):");
        int result2 = cityDaoJDBC.delete(testCity);
        System.out.println(result2 == 1 ? "City was successfully deleted" : "City was NOT deleted");

        System.out.println();

        //Testing update
        System.out.println("Testing update: ");
        cityDaoJDBC.add(testCity);
        System.out.println("Old data: " + cityDaoJDBC.findById(6666));
        cityDaoJDBC.update(new City( // Updating city
                6666,
                "UpdateTown",
                "NOR", // Doesn't allow a new country code?
                "UpdateDistrict",
                1337));
        System.out.println("Update data: " + cityDaoJDBC.findById(6666));
        cityDaoJDBC.delete(testCity); // Delete city after test
    }


}
