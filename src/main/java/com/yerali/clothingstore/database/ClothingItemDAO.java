package com.yerali.clothingstore.database;

import com.yerali.clothingstore.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClothingItemDAO {

    // insert
    public void insertItem(ClothingItem item){

        String sql = """
                INSERT INTO clothing_item
                (id, name, size, price, brand_name, item_type)
                VALUES(?,?,?,?,?,?)
                """;

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return;

        try (PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setInt(1, item.getId());
            stmt.setString(2, item.getName());
            stmt.setString(3, item.getSize());
            stmt.setDouble(4, item.getPrice());
            stmt.setString(5, item.getBrand().getName());
            stmt.setString(6, item.getItemType());

            stmt.executeUpdate();
            System.out.println("Clothing item inserted");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(connection);
        }
    }

    // select

    public List<ClothingItem> getAllItems(){
        return executeSelect(
                "SELECT * FROM clothing_item ORDER BY id",
                null
        );
    }

    // update
    public boolean updateItem(int id, double newPrice, String newSize){
        String sql = """
               UPDATE clothing_item 
               SET price = ?, size = ?
               WHERE id = ?
               """;

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setDouble(1, newPrice);
            stmt.setString(2, newSize);
            stmt.setInt(3, id);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseConnection.close(connection);
        }
    }

    // delete
    public boolean deleteItem (int id){

        String sql = """
               DELETE FROM clothing_item 
               WHERE id = ?
               """;


        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseConnection.close(connection);
        }
    }

    // search by name
    public List<ClothingItem> searchByName(String keyword){
        return executeSelect(
                "SELECT * FROM clothing_item WHERE name ILIKE ORDER BY id",
                stmt -> stmt.setString(1, "%" + keyword + "%")
        );
    }

    // search by min price
    public List<ClothingItem> searchByMinPrice(double min) {
        return executeSelect(
                "SELECT * FROM clothing_item WHERE price >= ? ORDER BY price",
                stmt -> stmt.setDouble(1, min)
        );
    }

    // search by brand
    public List<ClothingItem> searchByBrand(String brandName) {
        return executeSelect(
                "SELECT * FROM clothing_item WHERE brand_name ILIKE ? ORDER BY id",
                stmt -> stmt.setString(1, "%" + brandName + "%")
        );
    }

    // search by type
    public List<ClothingItem> searchByType(String type) {
        return executeSelect(
                "SELECT * FROM clothing_item WHERE item_type = ? ORDER BY id",
                stmt -> stmt.setString(1, type)
        );
    }

    // search by price range
    public List<ClothingItem> searchByPriceRange(double min, double max) {
        return executeSelect(
                "SELECT * FROM clothing_item WHERE price BETWEEN ? AND ? ORDER BY price",
                stmt -> {
                    stmt.setDouble(1, min);
                    stmt.setDouble(2, max);
                }
        );
    }



    // select t-shirts
    public List<ClothingItem> getTShirts() {
        return executeSelect(
                "SELECT * FROM clothing_item WHERE item_type = 'T-Shirt' ORDER BY id",
                null
        );
    }

    // select helper
    private List<ClothingItem> executeSelect(
            String sql,
            StatementPreparer preparer
    ) {
        List<ClothingItem> items = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return items;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            if (preparer != null) {
                preparer.prepare(stmt);
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                items.add(mapRowToItem(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(connection);
        }

        return items;
    }

    // row to object
    private ClothingItem mapRowToItem(ResultSet rs) throws SQLException {

        int id = rs.getInt("id");
        String name = rs.getString("name");
        String size = rs.getString("size");
        double price = rs.getDouble("price");
        String brandName = rs.getString("brand_name");
        String type = rs.getString("item_type");

        Brand brand = new Brand(
                Math.abs(id) + 1,   // always positive
                brandName,
                "Unknown",
                4.0
        );

        return switch (type) {
            case "Jacket" -> new Jacket(id, name, size, price, brand, false);
            default -> new TShirt(id, name, size, price, brand, "Short");
        };
    }

    // interface
    @FunctionalInterface
    private interface StatementPreparer {
        void prepare(PreparedStatement stmt) throws SQLException;
    }
}
