package com.yerali.clothingstore.database;

import com.yerali.clothingstore.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClothingItemDAO {

    //insert
    public void insertItem(ClothingItem item) {

        String sql = """
                INSERT INTO clothing_item
                (id, name, size, price, brand_name, item_type)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, item.getId());
            stmt.setString(2, item.getName());
            stmt.setString(3, item.getSize());
            stmt.setDouble(4, item.getPrice());
            stmt.setString(5, item.getBrand().getName());
            stmt.setString(6, item.getItemType());

            stmt.executeUpdate();
            System.out.println("✅ Clothing item inserted into DB");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(connection);
        }
    }


    //select
    public List<ClothingItem> getAllItems() {

        List<ClothingItem> items = new ArrayList<>();
        String sql = "SELECT * FROM clothing_item";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return items;

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

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

    //helper
    private ClothingItem mapRowToItem(ResultSet rs) throws SQLException {

        int id = rs.getInt("id");
        String name = rs.getString("name");
        String size = rs.getString("size");
        double price = rs.getDouble("price");
        String brandName = rs.getString("brand_name");
        String type = rs.getString("item_type");

        Brand brand = new Brand(1, brandName, "Unknown", 4.0);

        return switch (type) {
            case "Jacket" ->
                    new Jacket(id, name, size, price, brand, false);
            default ->
                    new TShirt(id, name, size, price, brand, "Short");
        };
    }

    //update
    public boolean updateItem(int id, double newPrice, String newSize) {

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

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("✅ Item updated successfully");
                return true;
            } else {
                System.out.println("⚠️ Item with ID " + id + " not found");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseConnection.close(connection);
        }
    }

    //delete
    public boolean deleteItem(int id) {

        String sql = "DELETE FROM clothing_item WHERE id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("🗑️ Item deleted successfully");
                return true;
            } else {
                System.out.println("⚠️ Item with ID " + id + " not found");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseConnection.close(connection);
        }
    }


}
