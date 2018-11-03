package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

public class Engine implements Runnable {

    private Connection connection;

    public Engine(Connection connection) {
        this.connection = connection;
    }

    public void run() {
        try {
            //this.getVillainsNames();
            //System.out.println(checkIdExist(2));
            // getMinionNames();
            // addMinions();
            // changeТownNamesCasing();
            //removeVillain();
            //printAllMinionNames();
            increaseMinionsAge();
        } catch (SQLException e) {
            e.printStackTrace();
        }//При някои задачи се изисква IOException, а при други не.
        //Коментрирайте го когато е ненужен, за да не Ви гърми.
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Problem 2 Get Villain's names
     */
    private void getVillainsNames() throws SQLException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String query = "SELECT v.name, COUNT(mv.minion_id) AS 'count' FROM villains AS v JOIN minions_villains AS mv ON v.id = mv.villain_id GROUP BY v.name HAVING `count` > ? ORDER BY `count` DESC";

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setInt(1, Integer.parseInt(br.readLine()));

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(String.format("%s %d",
                    resultSet.getString(1),
                    resultSet.getInt(2)));
        }
    }

    /**
     * Problem 3 3.	Get Minion Names
     */

    private void getMinionNames() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int index = Integer.parseInt(br.readLine());

        if (!checkIdExist(index)) {
            System.out.printf("No villain with ID %d exists in the database.", index);
        } else {
            String query = "SELECT  m.name, m.age FROM minions AS m\n" +
                    "JOIN minions_villains AS mv\n" +
                    "ON m.id = mv.minion_id\n" +
                    "WHERE mv.villain_id = ?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);

            preparedStatement.setInt(1, index);

            ResultSet resultSet = preparedStatement.executeQuery();
            int counter = 1;
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                int age = resultSet.getInt(2);
                System.out.printf("%d. %s %d%n", counter, name, age);
                counter++;
            }
        }


    }

    private boolean checkIdExist(int index) throws SQLException {
        String query = "SELECT COUNT(*) FROM villains AS v WHERE v.id = ?";

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.setInt(1, index);

        ResultSet resultSet = preparedStatement.executeQuery();
        int result;
        if (resultSet.next()) {
            result = resultSet.getInt(1);
            return result != 0;
        }
        return false;
    }

    /**
     * Problem 4.Add Minion
     */

    private void addMinions() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] minionParams = br.readLine().split("\\s+");
        String[] villainParams = br.readLine().split("\\s+");

        String minionName = minionParams[1];
        int minionAge = Integer.parseInt(minionParams[2]);
        String townName = minionParams[3];
        String villainName = villainParams[1];

        if (!this.checkIfEntityExists(townName, "towns")) {
            insertTown(townName);
        }

        if (!this.checkIfEntityExists(villainName, "villains")) {
            insertVillain(villainName);
        }

        int townId = this.getEntityId(townName, "towns");

        this.insertMinion(minionName, minionAge, townId);

        int minionId = this.getEntityId(minionName, "minions");
        int villainId = this.getEntityId(villainName, "villains");

        this.hireMinion(minionId, villainId);

        System.out.printf("Successfully added %s to be minion of %s.", minionName, villainName);

    }

    private boolean checkIfEntityExists(String name, String tableName) throws SQLException {
        String query = "SELECT * FROM " + tableName + " WHERE name = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.setString(1, name);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return true;
        }
        return false;
    }

    private void insertTown(String townName) throws SQLException {
        String query = "INSERT INTO towns(name, country) VALUES('" + townName + "', NULL)";
        PreparedStatement statement = this.connection.prepareStatement(query);

        statement.execute();

        System.out.printf("Town %s was added to the database.%n", townName);
    }

    private void insertVillain(String villainName) throws SQLException {
        String query = String.format("INSERT INTO villains(name, evilness_factor) " +
                "VALUES('%s','evil')", villainName);

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.execute();

        System.out.printf("Villain %s was added to the database.%n", villainName);
    }

    private int getEntityId(String name, String tableName) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name = '%s'", tableName, name);
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    private void insertMinion(String minionName, int age, int town_id) throws SQLException {
        String query = String.format("INSERT INTO minions(name, age, town_id) " +
                "VALUES('%s','%d','%d')", minionName, age, town_id);
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.execute();
    }

    private void hireMinion(int minionId, int villainId) throws SQLException {
        String query = String.format("INSERT INTO minions_villains(minion_id, villain_id) " +
                "VALUES (%d,%d)", minionId, villainId);

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.execute();

    }

    /**
     * 5
     */
    private void changeТownNamesCasing() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String countryName = br.readLine();

        if (checkTownsNumberInCountry(countryName) == 0) {
            System.out.print("No town names were affected.");
        } else {
            changeCassingInTowns(countryName);
        }
    }

    private void changeCassingInTowns(String countryName) throws SQLException {
        String query = "SELECT * FROM towns WHERE country = ?";

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setString(1, countryName);

        ResultSet resultSet = preparedStatement.executeQuery();
        Set<String> towns = new HashSet<String>();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String townName = resultSet.getString(2);
            String countName = resultSet.getString(3);
            towns.add(townName.toUpperCase());
            updateTown(id, townName.toUpperCase());
        }

        System.out.printf("[%s]", String.join(", ", towns));
    }

    private void updateTown(int id, String townName) throws SQLException {
        String query = "UPDATE towns SET `name` = ? WHERE id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setString(1, townName);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();

    }

    private int checkTownsNumberInCountry(String countryName) throws SQLException {
        String query = "SELECT COUNT(*) FROM towns WHERE country = ?";

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.setString(1, countryName);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return resultSet.getInt(1);
    }

    /**
     * 6 Remove Villain
     */
    private void removeVillain() throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int villainId = Integer.parseInt(reader.readLine());

        PreparedStatement statement = connection.prepareStatement("SELECT v.id, v.name FROM villains AS v WHERE v.id = ?;");

        statement.setInt(1, villainId);
        ResultSet rs = statement.executeQuery();
        if (!rs.next()) {
            System.out.println("No such villain was found");
            return;
        }

        String villainName = rs.getString("name");

        statement = connection.prepareStatement("DELETE FROM minions_villains WHERE villain_id = ?;");

        statement.setInt(1, villainId);
        int deletedMinionCounts = statement.executeUpdate();

        statement = connection.prepareStatement("DELETE FROM villains WHERE id = ?;");

        statement.setInt(1, villainId);
        statement.executeUpdate();

        System.out.printf("%s was deleted%n%d minions released", villainName, deletedMinionCounts);
    }

    /**
     * 7. Print All Minion Names
     */
    private void printAllMinionNames() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("" +
                "SELECT name FROM minions;");

        ResultSet rs = statement.executeQuery();

        List<String> minionNames = new ArrayList<>();
        while (rs.next()) {
            minionNames.add(rs.getString(1));
        }

        for (int i = 0; i < minionNames.size() / 2; i++) {
            System.out.println(minionNames.get(i));
            System.out.println(minionNames.get(minionNames.size() - 1 - i));
        }

        if (minionNames.size() % 2 != 0) {
            System.out.println(minionNames.get(minionNames.size() / 2));
        }
    }

    /**
     * 8.	Increase Minions Age
     */

    private void increaseMinionsAge() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int num : nums) {
            updateMinionNameAndAge(num);
        }

        printMinions();
    }

    private void printMinions() throws SQLException {
        String query = "SELECT name, age FROM minions";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString(1),
                    resultSet.getInt(2));
        }
    }

    private void updateMinionNameAndAge(int num) throws SQLException {
        String query = "UPDATE minions\n" +
                "SET name =  CONCAT(UPPER(LEFT(name,1)), SUBSTRING(name, 2)),\n" +
                "age = age+1\n" +
                "WHERE id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setInt(1, num);

        preparedStatement.execute();
    }

    /**
     * 9. Increase Age Stored Procedure
     */
    private void increaseAgeStoredProcedure() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int id = Integer.parseInt(br.readLine());

        if(!checkIsThereMinionWithId(id)){
            System.out.printf("No minion with id %d%n", id);
            return;
        }

        CallableStatement clStmt = connection.prepareCall("{CALL usp_add_years(?)}");

        clStmt.setInt(1, id);
        clStmt.execute();

        printMinions();

    }

    private boolean checkIsThereMinionWithId(int id) throws SQLException {
        String query = "SELECT COUNT(*) from minions WHERE id = ?";

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1) > 0;
    }
}
