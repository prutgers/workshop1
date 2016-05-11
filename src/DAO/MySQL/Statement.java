/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MySQL;

/**
 *
 * @author lucas
 */
import ConnectionPools.ConnectionPool;
import POJO.Klant;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Statement {
    static Logger logger = LoggerFactory.getLogger(Statement.class);

    
    public static void main(String[] args){
        Klant klant = new Klant();
        //klant.setKlant_id(1);
        klant.setVoornaam("Herman");
        klant.setAchternaam("deJonge");
        klant.setTussenvoegsel("de");
        klant.setEmail("test");
        
        
        String sqlTableName = klant.getClass().getSimpleName().toLowerCase();
        System.out.println(sqlTableName);
        try{
        KlantDAOMySQL dao = new KlantDAOMySQL();
        dao.createKlant(klant);

        }
        catch(Exception e){
            System.out.println("\nProbeer opnieuw.\n");
            e.printStackTrace();
        }
    }
    public static String buildInsertStatement(Object object) {
        int variableToInsert = 0;
        String sqlTableName = object.getClass().getSimpleName().toLowerCase();
        String buildSqlStatement = "INSERT INTO " + sqlTableName + "(";
        String valueFieldEnd = "values (";
        Field[] declaredFields = object.getClass().getDeclaredFields();

        for (int i = 0; i < declaredFields.length; i++){
            try {
                declaredFields[i].setAccessible(true);
                if (!isPrimitiveZero(declaredFields[i].get(object))) {
                    if (declaredFields[i].get(object) == null) {
                        declaredFields[i].set(object, "");
                    }
                        variableToInsert++;
                        if (variableToInsert > 1) {
                            buildSqlStatement += ", ";
                            valueFieldEnd += ", ";
                        }
                        buildSqlStatement += declaredFields[i].getName();
                        if (declaredFields[i].get(object) instanceof String) {
                            valueFieldEnd += "\'";
                        }
                        valueFieldEnd += declaredFields[i].get(object);
                        if (declaredFields[i].get(object) instanceof String) {
                            valueFieldEnd += "\'";
                        }
                }
            }
            catch (IllegalArgumentException | IllegalAccessException | SecurityException e) {
                System.out.println("\nProbeer opnieuw.\n");
                e.printStackTrace();
            }
        }
        System.out.println(buildSqlStatement + ") " + valueFieldEnd + ")");
        return buildSqlStatement + ") " + valueFieldEnd + ")";
    }


    private static boolean isPrimitiveZero(Object object) {
        boolean isPrimitiveZero = false;
        if (object instanceof Long) {
            if ((Long) object == 0) {
                isPrimitiveZero = true;
            }
        }
        else if (object instanceof Integer) {
            if ((Integer) object == 0) {
                isPrimitiveZero = true;
            }
        }
        else if (object instanceof Float) {
            if ((Float) object == 0.0) {
                isPrimitiveZero = true;
            }
        }
        else if (object instanceof Double) {
            if ((Double) object == 0.0) {
                isPrimitiveZero = true;
            }
        }
        return isPrimitiveZero;
    }
    
//    public E buildReadStatementCursist(E objectWithID) {
//        int variableToInsert = 0;
//        String sqlTableName = objectWithID.getClass().getSimpleName().toUpperCase();
//        String buildSqlStatement = "INSERT INTO " + sqlTableName + "(";
//        String valueFieldEnd = "values (";
//        Field[] declaredFields = objectWithID.getClass().getDeclaredFields();
//
//        try (
//            Connection connection = ConnectionPool.getConnection();
//                ) {
//
//            
//            PreparedStatement readKlant = connection.prepareStatement(
//                    "select * from klant where Klant_id = ?");
//            readKlant.setString(1, Integer.toString(klant_id) );
//                logger.info("Statement prepared.");
//
//            ResultSet readKlantResult = readKlant.executeQuery();
//                logger.info("Statement executed.");
//            
//            readKlantResult.next();
//            objectWithID.setKlant_id(readKlantResult.getInt("klant_id"));
//            objectWithID.setVoornaam(readKlantResult.getString("voornaam"));
//            objectWithID.setAchternaam(readKlantResult.getString("achternaam"));
//            objectWithID.setTussenvoegsel(readKlantResult.getString("tussenvoegsel"));
//            objectWithID.setEmail(readKlantResult.getString("email"));
//            
//                logger.info("POJO made.");
//            
//        }
//        catch(Exception ex){
//            ex.printStackTrace();
//            return null;
//        }
//        return objectWithID;
//    }
    
}
