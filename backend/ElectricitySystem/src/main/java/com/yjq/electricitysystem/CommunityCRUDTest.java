package com.yjq.electricitysystem;

import org.hibernate.Version;
import java.sql.*;

public class CommunityCRUDTest {
    // DM JDBC 驱动字符串
    private static final String DRIVER = "dm.jdbc.driver.DmDriver";
    // DM URL 连接串，请根据你的 VM IP & 端口调整
    private static final String URL = "jdbc:dm://192.168.10.135:5236";
    // 连接用户名 & 密码
    private static final String USER  = "SYSDBA";
    private static final String PASS  = "Qin@780413";

    public static void main(String[] args) {
        System.out.println("Hibernate version: " + Version.getVersionString());
        try {
            // 1. 加载 JDBC 驱动
            Class.forName(DRIVER);
            System.out.println("Driver loaded.");
        } catch (ClassNotFoundException e) {
            System.err.println("加载驱动失败，请检查 dmjdbc.jar 是否在 classpath");
            e.printStackTrace();
            return;
        }

        // 2. 建立连接
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("Connected to DM8.");

            // 3. 插入一条记录
            insertCommunity(conn, 1001, 2001, "测试社区");
            // 4. 查询所有
            queryAllCommunities(conn);

            // 5. 修改刚才插入的记录
            updateCommunityName(conn, 1001, "更新后社区");
            queryAllCommunities(conn);

            // 6. 删除测试记录
            deleteCommunity(conn, 1001);
            queryAllCommunities(conn);

        } catch (SQLException e) {
            System.err.println("数据库操作异常：");
            e.printStackTrace();
        }
    }

    // 插入
    private static void insertCommunity(Connection conn,
                                        int areaCode,
                                        int communityCode,
                                        String name) throws SQLException {
        String sql = "INSERT INTO OMS.t_community(area_code, community_code, community_name) VALUES(?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, areaCode);
            ps.setInt(2, communityCode);
            ps.setString(3, name);
            int rows = ps.executeUpdate();
            System.out.println("Inserted rows: " + rows);
        }
    }

    // 查询所有
    private static void queryAllCommunities(Connection conn) throws SQLException {
        String sql = "SELECT area_code, community_code, community_name FROM OMS.t_community";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("---- t_community 全表数据 ----");
            while (rs.next()) {
                int areaCode      = rs.getInt("area_code");
                int communityCode = rs.getInt("community_code");
                String name       = rs.getString("community_name");
                System.out.printf("area_code=%d, community_code=%d, community_name=%s%n",
                        areaCode, communityCode, name);
            }
            System.out.println("-----------------------------");
        }
    }

    // 更新
    private static void updateCommunityName(Connection conn,
                                            int areaCode,
                                            String newName) throws SQLException {
        String sql = "UPDATE OMS.t_community SET community_name = ? WHERE area_code = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newName);
            ps.setInt(2, areaCode);
            int rows = ps.executeUpdate();
            System.out.println("Updated rows: " + rows);
        }
    }

    // 删除
    private static void deleteCommunity(Connection conn, int areaCode) throws SQLException {
        String sql = "DELETE FROM OMS.t_community WHERE area_code = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, areaCode);
            int rows = ps.executeUpdate();
            System.out.println("Deleted rows: " + rows);
        }
    }
}
