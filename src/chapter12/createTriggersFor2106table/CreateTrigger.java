package chapter12.createTriggersFor2106table;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class CreateTrigger {

    public static void main(String[] args)  {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","roma","r");
            Statement stmt  = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT OBJECT_NAME FROM USER_OBJECTS WHERE OBJECT_TYPE ='TABLE'");
            ArrayList<String> tables = new ArrayList<>();
            while(rs.next()) {
                tables.add(rs.getString(1));
            }


            File myFile = new File("E:\\work\\Toad Scripts\\createTriggers.sql");

            StringBuilder triggers = new StringBuilder();
            triggers.append("CREATE TABLE audits (\n" +
                    "      audit_id         NUMBER PRIMARY KEY,\n" +
                    "      table_name       VARCHAR2(255),\n" +
                    "      transaction_name VARCHAR2(10),\n" +
                    "      by_user          VARCHAR2(30),\n" +
                    "      transaction_date DATE\n" +
                    ");\n" +
                    "\n" +
                    "CREATE SEQUENCE audits_sequence;\n" +
                    "\n" +
                    "CREATE OR REPLACE TRIGGER audits_on_insert\n" +
                    "  BEFORE INSERT ON audits\n" +
                    "  FOR EACH ROW\n" +
                    "BEGIN\n" +
                    "  SELECT audits_sequence.nextval\n" +
                    "  INTO :new.audit_id\n" +
                    "  FROM dual;\n" +
                    "END;\n\n");

            for (int i = 0; i < tables.size(); i++) {
                String trigger =
                        "CREATE OR REPLACE TRIGGER \"TRIGGER_" + i + "\"\n" +
                                "AFTER INSERT OR UPDATE OR DELETE\n" +
                                "ON " + tables.get(i) + "\n" +
                                "\n" +
                                "FOR EACH ROW    \n" +
                                "DECLARE\n" +
                                "   l_transaction VARCHAR2(10);\n" +
                                "BEGIN\n" +
                                "   -- determine the transaction type\n" +
                                "   l_transaction := CASE  \n" +
                                "         WHEN UPDATING THEN 'UPDATE'\n" +
                                "         WHEN DELETING THEN 'DELETE'\n" +
                                "         WHEN INSERTING THEN 'INSERT'\n" +
                                "   END;\n" +
                                "\n" +
                                "   -- insert a row into the audit table   \n" +
                                "   INSERT INTO audits (table_name, transaction_name, by_user, transaction_date)\n" +
                                "   VALUES('" + tables.get(i) + "', l_transaction, USER, SYSDATE);\n" +
                                "END;\n\n";

                triggers.append(trigger);

            }

            try (PrintWriter output = new PrintWriter(myFile);) {
                output.println(triggers);

                System.out.print("File created success!");
            }

        } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
