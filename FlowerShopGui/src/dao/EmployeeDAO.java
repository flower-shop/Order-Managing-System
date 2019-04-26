package dao;
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.ResultSetMetaData;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.Vector;
//
// import javax.swing.JOptionPane;
// import javax.swing.table.DefaultTableModel;
//
// public class EmployeeDAO {
// Connection con = null;
// PreparedStatement pstmt = null;
// Statement stmt = null;
// ResultSet rs = null;
//
// public EmployeeDAO() {
// try {
// con = new ConnectionFactory().getConnection();
// stmt = con.createStatement();
// } catch (Exception e) {
// e.printStackTrace();
// }
// }
//
// public void addEmployeeDAO(EmployeeDTO employeeDTO) {
// try {
// String query = "SELECT * FROM Employee WHERE lastName='" +
// employeeDTO.getLastName()
// + "' AND firstName='" + employeeDTO.getLastName() + "' AND employeeId='"
// + employeeDTO.getEmployeeId() + "' AND password='" +
// employeeDTO.getPassword()
// + "' AND isAdmin='" + employeeDTO.isAdmin() + "'";
// rs = stmt.executeQuery(query);
// if (rs.next()) {
// JOptionPane.showMessageDialog(null, "Same Customer has already been added!");
// } else {
// addFunction(employeeDTO);
// }
// } catch (Exception e) {
// e.printStackTrace();
// }
// }// end of method addCustomerDTO
//
// public void addFunction(EmployeeDTO employeeDTO) {
// try {
// String customerCode = null;
// String oldCustomerCode = null;
// String query1 = "SELECT * FROM Employee";
// rs = stmt.executeQuery(query1);
// if (!rs.next()) {
// customerCode = "cus" + "1";
// } else {
// String query2 = "SELECT * FROM Employee ORDER by cid DESC";
// rs = stmt.executeQuery(query2);
// if (rs.next()) {
// oldCustomerCode = rs.getString("customercode");
// Integer scode = Integer.parseInt(oldCustomerCode.substring(3));
// scode++;
// customerCode = "cus" + scode;
// }
// }
// String q = "INSERT INTO Employee VALUES(null,?,?,?,?)";
// pstmt = (PreparedStatement) con.prepareStatement(q);
// pstmt.setString(1, customerCode);
// pstmt.setString(2, employeeDTO.getFullName());
// pstmt.setString(3, employeeDTO.getLocation());
// pstmt.setString(4, employeeDTO.getPhone());
// pstmt.executeUpdate();
// JOptionPane.showMessageDialog(null, "Inserted Successfully");
// } catch (Exception e) {
// e.printStackTrace();
// }
// }
//
// public void editCustomerDAO(EmployeeDTO employeeDTO) {
// try {
// String query = "UPDATE Employee SET fullname=?,location=?,phone=? WHERE
// customercode=?";
// pstmt = (PreparedStatement) con.prepareStatement(query);
// pstmt.setString(1, employeeDTO.getFullName());
// pstmt.setString(2, employeeDTO.getLocation());
// pstmt.setString(3, employeeDTO.getPhone());
// pstmt.setString(4, employeeDTO.getCustomerCode());
// pstmt.executeUpdate();
// JOptionPane.showMessageDialog(null, "Updated Successfully!");
//
// } catch (Exception e) {
// e.printStackTrace();
// }
// }
//
// public void deleteCustomerDAO(String value) {
// try {
// System.out.println(value);
// String query = "delete from Employee where customercode=?";
// pstmt = con.prepareStatement(query);
// pstmt.setString(1, value);
// pstmt.executeUpdate();
// JOptionPane.showMessageDialog(null, "Deleted..");
// } catch (SQLException e) {
// e.printStackTrace();
// }
// }
//
// public ResultSet getQueryResult() {
// try {
// String query = "SELECT customercode AS CustomerCode, fullname AS Name,
// location AS Location, phone AS Phone FROM customers";
// rs = stmt.executeQuery(query);
// } catch (SQLException e) {
// e.printStackTrace();
// }
// return rs;
// }// end of method getQueryResult
//
// public ResultSet getCreditCustomersQueryResult() {
// try {
// String query = "SELECT * FROM Employee WHERE credit>0";
// rs = stmt.executeQuery(query);
// } catch (SQLException e) {
// e.printStackTrace();
// }
// return rs;
// }
//
// public ResultSet getDebitCustomersQueryResult() {
// try {
// String query = "SELECT * FROM Employee WHERE credit=0";
// rs = stmt.executeQuery(query);
// } catch (SQLException e) {
// e.printStackTrace();
// }
// return rs;
// }
//
// public ResultSet getSearchCustomersQueryResult(String searchTxt) {
// try {
// String query = "SELECT * FROM Employee WHERE fullname LIKE '%" + searchTxt
// + "%' OR location LIKE '%" + searchTxt + "%' OR customercode LIKE '%" +
// searchTxt
// + "%' OR phone LIKE '%" + searchTxt + "%'";
// rs = stmt.executeQuery(query);
// } catch (SQLException e) {
// e.printStackTrace();
// }
// return rs;
// }
//
// public ResultSet getCustomersName(String customerCode) {
// try {
// String query = "SELECT * FROM customers WHERE customercode='" + customerCode
// + "'";
// rs = stmt.executeQuery(query);
// } catch (Exception e) {
// e.printStackTrace();
// }
// return rs;
// }
//
// public ResultSet getProductsName(String productCode) {
// try {
// String query = "SELECT productname, currentstocks.quantity FROM products
// INNER JOIN currentstocks ON products.productcode=currentstocks.productcode
// WHERE currentstocks.productcode='"
// + productCode + "'";
// rs = stmt.executeQuery(query);
// } catch (Exception e) {
// e.printStackTrace();
// }
// return rs;
// }
//
// // start of method DefaultTableModel
// public DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
// ResultSetMetaData metaData = rs.getMetaData(); // resultset ko metadata
// Vector<String> columnNames = new Vector<String>();
// int columnCount = metaData.getColumnCount();
//
// for (int column = 1; column <= columnCount; column++) {
// columnNames.add(metaData.getColumnName(column));
// }
//
// Vector<Vector<Object>> data = new Vector<Vector<Object>>();
// while (rs.next()) {
// Vector<Object> vector = new Vector<Object>();
// for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
// vector.add(rs.getObject(columnIndex));
// }
// data.add(vector);
// }
// return new DefaultTableModel(data, columnNames);
// }// end of method DefaultTableModel
// }
